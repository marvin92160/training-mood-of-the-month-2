package servlet;

import Exception.ServiceException;
import com.sun.source.tree.MemberReferenceTree;
import dao.MemberDao;
import dao.MoodDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Mood;
import modele.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MemberService;
import services.MoodService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(HomeServlet.class);

    private MoodService moodService;
   // private MoodDao moodDao;
    MemberDao memberDao = new MemberDao();
    MemberService memberService = new MemberService(memberDao);

    @Override
    public void init() {
        moodService = new MoodService(new MoodDao());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            System.out.println(moodService.count());
            request.setAttribute("nbrMood", moodService.count());
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }
        try {
            request.setAttribute("membres", this.memberService.findAll());
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }
        try {
            LocalDate today = LocalDate.now();
            String thisMonth = today.getMonth().toString();
            int month = today.getMonth().getValue();
            int year = today.getYear();
            List<Mood> moods = moodService.findAllByMonth(month, year);
            float average;
            float sum = 0;
            int i = 0;
            int[] repartition = {0, 0, 0, 0, 0};
            for (Mood mood:moods) {
                int grade = mood.getGrade();
                logger.error("Grade: " + grade);
                i++;
                switch (grade) {
                    case 1 : repartition[0]++;
                        break;
                    case 2 : repartition[1]++;
                        break;
                    case 3 : repartition[2]++;
                        break;
                    case 4 : repartition[3]++;
                        break;
                    case 5 : repartition[4]++;
                }
                logger.error("Repartition: " + Arrays.toString(repartition));
                sum += grade;
            }
            average = sum/i;
            request.setAttribute("average", average);
            request.setAttribute("repartition", repartition);
            request.setAttribute("count", i);
            request.setAttribute("month", thisMonth);
            request.setAttribute("year", year);
            request.setAttribute("moods", moods);
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }
        try {
             request.setAttribute("nbrMembre", memberService.count());
        } catch (Exception e) {
            logger.error("An error occurred while setting nbrMembre.", e);
        }

        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
        } catch (Exception e) {
            logger.error("An error occurred while forwarding the request.", e);
        }
    }
}
