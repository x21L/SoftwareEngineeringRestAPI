package subsystem.security.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import subsystem.security.impl.SecurityScan;

/**
 * 
 * Servlet class. Represents the API.
 * @author Lukas Wais
 *
 */
@WebServlet("/security")
public class SecurityApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Gson gson;

	/**
     * @see HttpServlet#HttpServlet()
     */
	public SecurityApi() {
		super();
		gson = new Gson();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");

		switch (action) {
		case "technicians":
			getPersons(response);
			break;
		case "changemode":
			changeMode(response);
			break;
		case "getstatus":
			getStatus(response);
			break;
		case "start":
			startScan(response);
			break;
		case "stop":
			stopScan(response);
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

	private void getPersons(HttpServletResponse response) {
		respondSecuritySystem(response, SecurityScan.getInstance().getTechnicians());
	}

	private void startScan(HttpServletResponse response) {
		respondSecuritySystem(response, SecurityScan.getInstance().startDetection());
	}
	
	private void stopScan(HttpServletResponse response) {
		respondSecuritySystem(response, SecurityScan.getInstance().stopDetection());
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
