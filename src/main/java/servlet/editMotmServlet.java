package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit_motm")
public class editMotmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//
//        request.setAttribute("nbrMembre", 20);
//        request.setAttribute("nbrMood", 15);

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/edit_motm.jsp").forward(request, response);
    }
}
