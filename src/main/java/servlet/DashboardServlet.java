package servlet;
import dao.MoodDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Mood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MoodService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import Exception.ServiceException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MoodService moodService;
    private static final Logger logger = LoggerFactory.getLogger(DashboardServlet.class);

    @Override
    public void init() {
        moodService = new MoodService(new MoodDao());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
    }
}
