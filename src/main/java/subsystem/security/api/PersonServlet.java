package subsystem.security.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import subsystem.security.impl.Programmer;
import subsystem.security.model.Address;
import subsystem.security.model.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/getPerson")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Person p;
	private final Gson gson;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonServlet() {
		super();
		p = new Programmer("Karl", "Heinz", new Address("a", "b1", 1, "aa"));
		gson = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(gson.toJson(p));
			out.flush();
		} catch (IOException e) {
			System.out.println("Problem with the PrintWriter " + e.getMessage());
		}
	}

}
