package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/user/logout")
public class LogoutUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LogoutUserServlet.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("logout call");
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("/");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("/");
	}
}
