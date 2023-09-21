package servlet;

import dao.EmailTemplateDao;
import dao.MemberDao;
import dao.MoodDao;
import dao.MotmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Member;
import services.EmailTemplateService;
import services.MemberService;
import services.MoodService;
import services.MotmService;

import java.io.IOException;
import java.time.LocalDate;

import Exception.ServiceException;
@WebServlet("/edit_motm")
public class editMotmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmailTemplateService emailTemplateService;
    private MotmService motmService;

    @Override
    public void init() {
        emailTemplateService = new EmailTemplateService(new EmailTemplateDao());
        motmService = new MotmService(new MotmDao());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email_subject = request.getParameter("email_subject");
            String email_template = request.getParameter("email_template");
            String motm_template = request.getParameter("motm_template");
            this.emailTemplateService.update(email_subject, email_template);
            this.motmService.update(motm_template);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/projet/edit_motm");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("email_subject", emailTemplateService.find().get(0));
            request.setAttribute("email_template", emailTemplateService.find().get(1));
            request.setAttribute("motm_template", motmService.find());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/edit_motm.jsp").forward(request, response);
    }
}
