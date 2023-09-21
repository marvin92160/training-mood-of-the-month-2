package servlet;

import java.io.IOException;

import dao.EmailTemplateDao;
import dao.MotmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.EmailTemplateService;
import services.MotmService;
import Exception.ServiceException;
@WebServlet("/newsletter.template")
public class NewsletterTemplateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmailTemplateService emailTemplateService;
    private MotmService motmService;

    @Override
    public void init() {
        emailTemplateService = new EmailTemplateService(new EmailTemplateDao());
        motmService = new MotmService(new MotmDao());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute("mail_subject", emailTemplateService.find().get(0));
            request.setAttribute("mail_template", emailTemplateService.find().get(1));
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/newsletter.template.jsp").forward(request, response);
    }
}
