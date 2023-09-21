package servlet;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import dao.MemberDao;
import dao.MoodDao;
import dao.MotmDao;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MoodService;
import services.MotmService;

@WebServlet("/add_motm")
public class AddMotmServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
    MoodDao moodDao = new MoodDao();
    MoodService moodService = new MoodService(moodDao);

    MotmService motmService = new MotmService(new MotmDao());
    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int month = YearMonth.now().getMonth().getValue();
            int year = YearMonth.now().getYear();
            List<Mood> moods = moodService.findAllByMonth(month, year);
            request.setAttribute("motm_template", motmService.find());
            long memberId = Integer.parseInt(request.getParameter("member_id"));
            for (Mood mood:moods) {
                if (mood.getMemberId() == memberId) {
                    request.setAttribute("motm_old", mood.getGrade());
                    request.setAttribute("comment_old", mood.getComment());
                    request.setAttribute("isPublic_old", mood.isPublic());
                }
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/add_motm.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int month = YearMonth.now().getMonth().getValue();
            int year = YearMonth.now().getYear();
            long memberId = Integer.parseInt(request.getParameter("member_id"));
            int motm = Integer.parseInt(request.getParameter("motm"));
            String comment = request.getParameter("comment");
            String publicResponse = request.getParameter("isPublic");
            boolean isPublic = Objects.equals(publicResponse, "true");
            long id = 0;
            LocalDateTime date = LocalDateTime.now();
            List<Mood> moods = moodService.findAllByMonth(month, year);
            for (Mood eachMood:moods) {
                if (eachMood.getMemberId() == memberId) {
                    id = eachMood.getId();
                    break;
                }

            }
            if (id == 0) {
                Mood mood = new Mood(motm, comment, isPublic, memberId, date);
                moodService.create(mood);
            } else {
                Mood mood = new Mood(id, motm, comment, isPublic, memberId, date);
                moodService.update(mood);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/projet/add_motm?member_id=1");
    }

}
