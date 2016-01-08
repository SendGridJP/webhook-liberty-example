package jp.co.kke.sendgrid;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class EventReceiver
 */
@WebServlet("/EventReceiver")
public class EventReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventReceiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonString = StreamUtil.inputStreamToString(request.getInputStream(), "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		List<Event> events = mapper.readValue(jsonString, new TypeReference<List<Event>>() {});
		
		for (Event event : events) {
			System.out.println("EventReceiver#doPost(): email: " + event.getEmail() + ", event: " + event.getEvent());
		}
	}
}
