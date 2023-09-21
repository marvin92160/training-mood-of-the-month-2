package servlet;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MemberService;

import java.io.IOException;
import java.time.LocalDate;
import Exception.ServiceException;

@WebServlet("/update_member")
public class UpdateMemberServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    private int id;
    MemberDao memberDao = new MemberDao();
    MemberService memberService = new MemberService(memberDao);

    @Override
    public void init() throws ServletException {
        super.init();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                id = Integer.parseInt(request.getParameter("id"));
                Member memberModif = this.memberService.findById(id);
                //Member memberModif = this.memberService.findById(2);
                request.setAttribute("last_name_old", memberModif.getLastName());
                request.setAttribute("first_name_old", memberModif.getFirstName());
                request.setAttribute("email_old", memberModif.getEmail());
                request.setAttribute("birthdate_old", memberModif.getBirthdate());
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            this.getServletContext().getRequestDispatcher("/WEB-INF/pages/update_member.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String lastName = request.getParameter("last_name");
            String firstName = request.getParameter("first_name");
            String email = request.getParameter("email");
            LocalDate birthdate = LocalDate.parse((request.getParameter("birthdate")));
            Member memberModif = new Member( id,lastName,firstName,email,birthdate );
            logger.error("modifier member" + memberModif);
            this.memberService.update(memberModif);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/projet/home?page=1");
    }
}
