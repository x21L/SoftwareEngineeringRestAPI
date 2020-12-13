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
import subsystem.security.impl.SecurityScan;
import subsystem.security.model.Address;
import subsystem.security.model.SecuritySystem;

@WebServlet("/security")
public class SecurityApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Gson gson;

	public SecurityApi() {
		super();
		gson = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");

		switch (action) {
		case "person":
			getPerson(response);
			break;
		case "changemode":
			changeMode(response);
			break;
		case "getstatus":
			getStatus(response);
			break;
		default:
			wrongInput(action, response);
		}

	}

	private void changeMode(HttpServletResponse response) {
		respondSecuritySystem(response, SecurityScan.getInstance().changeMode());
	}

	private void getStatus(HttpServletResponse response) {
		respondSecuritySystem(response, SecurityScan.getInstance().getInformation());
	}

	private void respondSecuritySystem(HttpServletResponse response, Object obj) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(gson.toJson(obj));
			out.flush();
		} catch (IOException e) {
			writePrintError(e.getMessage());
		}
	}

	private void getPerson(HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(gson.toJson(new Programmer("Karl", "Heinz", new Address("a", "b1", 1, "aa"))));
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
