package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({ "/IndexServlet", "/index.htm" })
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int vandaag = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		request.setAttribute("openGesloten", 
				vandaag == Calendar.MONDAY || vandaag == Calendar.THURSDAY ? "gesloten" : "open");
		request.getRequestDispatcher(VIEW).forward(request, response);

	}

}
