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

@WebServlet("/security")
public class SecurityApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Gson gson;

	public SecurityApi() {
		super();
		gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "person":
			getPerson(response);
			break;

		default:
			wrongInput(action, response);
		}

	}
	
	private void getPerson(HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(gson.toJson(new Programmer("Karl", "Heinz", new Address("a", "b1", "aa"))));
			out.flush();
		} catch (IOException e) {
			writePrintError(e.getMessage());
		}
	}
	
	private void wrongInput(String parameter, HttpServletResponse response) {
		try {
			response.setContentType("text/plain");
			response.getWriter().write("Error wrong parameter " + parameter);
		} catch (IOException e) {
			writePrintError(e.getMessage());
		}
	}
	
	private void writePrintError(String message) {
		System.out.println("Problem with the PrintWriter " + message);
	}

}
