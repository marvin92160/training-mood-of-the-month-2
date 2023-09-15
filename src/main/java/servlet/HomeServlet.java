package servlet;

import Exception.ServiceException;
import dao.MoodDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Mood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MoodService;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(HomeServlet.class);

    private MoodService moodService;

    @Override
    public void init() {
        moodService = new MoodService(new MoodDao());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
      /*  try {
            System.out.println(moodService.count());
            request.setAttribute("nbrMood", moodService.count());
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }*/

        try {
            List<Mood> moods = moodService.findAll();
            float average;
            float sum = 0;
            int i = 0;
            for (Mood mood:moods) {
                i++;
                sum += mood.getGrade();
            }
            average = sum/i;
            request.setAttribute("moods", moods);
            request.setAttribute("average", average);
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }

        try {
            // ici on mettra le code pour définir "nbrMembre"
             request.setAttribute("nbrMembre", 20);
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
