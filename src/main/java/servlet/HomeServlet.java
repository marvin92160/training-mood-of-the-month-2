package servlet;

import Exception.ServiceException;
import Exception.DaoException;
import dao.MemberDao;
import dao.MemberPreferencesDao;
import dao.MoodDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.MemberPreferences;
import modele.Mood;
import modele.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MemberService;
import services.MoodService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
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
    MemberPreferencesDao memberPreferencesDao = new MemberPreferencesDao();

    @Override
    public void init() {
        moodService = new MoodService(new MoodDao());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println(moodService.count());
            request.setAttribute("nbrMood", moodService.count());
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("membres", this.memberService.findAll(page));
        } catch (ServiceException e) {
            logger.error("An error occurred while processing the request.", e);
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            List<String> months = moodService.extractMonths();
            String lastMonthYear = months.get(0);
            String thisMonth = YearMonth.parse(lastMonthYear, formatter).getMonth().toString();
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
            request.setAttribute("month", thisMonth);
            request.setAttribute("year", year);
            request.setAttribute("moods", moods);
            request.setAttribute("lastMonthYear", lastMonthYear);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Récupérez la valeur sélectionnée dans la liste déroulante
        String mailingDateOption = request.getParameter("date");


        // Récupérer la valeur du champ "date" du formulaire
        String date = request.getParameter("date");
        // Récupérer la valeur du champ "time" du formulaire
        String time = request.getParameter("time");

        // Assurez-vous que la valeur n'est pas nulle
        if (mailingDateOption != null) {
            try {
                // Récupérez la liste des membres depuis la base de données (vous devez avoir un DAO pour cela)
                MemberDao memberDao = new MemberDao(); // Supposons que vous instanciez votre DAO ici
                List<Member> members = memberDao.findAll(); // Utilisez le DAO pour obtenir tous les membres

                // Parcourez la liste des membres
                for (Member member : members) {
                    // Enregistrez la préférence de d'envoi de mail pour chaque membre dans la table member_preferences
                    MemberPreferences preferences = new MemberPreferences();
                    preferences.setMemberId(member.getId());
                    preferences.setMailingDateOption(Integer.parseInt(mailingDateOption)); // Afin de convertir la valeur en entier
                    memberPreferencesDao.save(preferences);
                }

                // Redirigez ensuite l'utilisateur vers la page d'accueil ou une autre page appropriée
                response.sendRedirect(request.getContextPath() + "/home");
            } catch (DaoException e) {
                logger.error("An error occurred while forwarding the request.", e);
                // Redirigez l'utilisateur vers une page d'erreur
                response.sendRedirect(request.getContextPath() + "/error");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

}
