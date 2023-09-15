package servlet;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dao.MemberDao;
import dao.MoodDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Member;
import modele.Mood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MemberService;
import Exception.ServiceException;
import services.MoodService;


@WebServlet("/delete_member")
public class DeleteMemberServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    private static List<Mood> liste;
    MemberDao memberDao = new MemberDao();
    MemberService memberService = new MemberService(memberDao);
    MoodDao moodDao = new MoodDao();
    MoodService moodService = new MoodService(moodDao);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            liste = moodService.findAll();
            if (liste.size()!=0){
                for (Mood m : liste){
                    if (m.getMemberId() == Integer.parseInt(request.getParameter("id"))){
                        moodService.delete(m.getId());
                    }
                }
            }
            memberService.delete(Integer.parseInt(request.getParameter("id").toString()));
        } catch (NumberFormatException | ServiceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
//       request.setAttribute("nbrMembre", 20);
//        request.setAttribute("nbrMood", 15);

        response.sendRedirect("/projet/home");
    }


}
