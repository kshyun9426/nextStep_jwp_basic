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

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/login")
public class LoginUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LoginUserServlet.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("POST Method Call 요청 ID: {}", req.getParameter("userId"));
		log.debug("POST Method Call 요청 password: {}", req.getParameter("password"));
		
		User requestUser = DataBase.findUserById((String)req.getParameter("userId"));
		if(requestUser == null) {
			log.debug("ID가 존재하지 않습니다.");
		}
		
		if(!requestUser.getPassword().contentEquals(req.getParameter("password"))) {
			log.debug("Password가 올바르지 않습니다.");
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("user", requestUser);
		
		resp.sendRedirect("/user/list");
	}
}
