package servlet;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Member;
import services.MemberService;
import Exception.ServiceException;

@WebServlet("/add_member")
public class AddMemberServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    MemberDao memberDao = new MemberDao();
    MemberService memberService = new MemberService(memberDao);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        request.setAttribute("nbrMembre", 20);
//        request.setAttribute("nbrMood", 15);

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/add_member.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String lastName = request.getParameter("last_name");
            String firstName = request.getParameter("first_name");
            String email = request.getParameter("email");
            //LocalDate birthdate = LocalDate.parse((request.getParameter("birthdate")), DateTimeFormatter.ofPattern("dd/mm/yyyy"));
            LocalDate birthdate = LocalDate.now();
            Member m = new Member(lastName,firstName,email,birthdate );
            this.memberService.create(m);

        } catch (ServiceException e) {
           e.printStackTrace();
        }
        response.sendRedirect("/projet/home");
    }

}
