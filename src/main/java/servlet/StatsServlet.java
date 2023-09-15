package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
import Exception.ServiceException;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {
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
            List<String> months = moodService.extractMonths();
            String lastMonthYear = months.get(0);
            try {
                lastMonthYear = request.getParameter("month");
            } catch (Exception e) {}
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            String lastMonth = YearMonth.parse(lastMonthYear, formatter).getMonth().toString();
            int month = YearMonth.parse(lastMonthYear, formatter).getMonth().getValue();
            int year = YearMonth.parse(lastMonthYear, formatter).getYear();
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
            request.setAttribute("month", lastMonth);
            request.setAttribute("months", months);
            request.setAttribute("year", year);
            request.setAttribute("moods", moods);
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/stats.jsp").forward(request, response);
    }
}
