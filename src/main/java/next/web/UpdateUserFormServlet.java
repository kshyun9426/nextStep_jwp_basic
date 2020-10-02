package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/update")
public class UpdateUserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UpdateUserFormServlet.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("GET Method Call request ID:{}", req.getParameter("userId"));
		String userId = req.getParameter("userId");
		User user = DataBase.findUserById(userId);
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/user/update.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("POST Method Call");
		log.debug("request userId: {}", req.getAttribute("userId"));
		log.debug("request password: {}", req.getAttribute("password"));
		log.debug("request name: {}", req.getAttribute("name"));
		log.debug("request email: {}", req.getAttribute("email"));
		
		User user = new User(
        		req.getParameter("userId"), 
        		req.getParameter("password"), 
        		req.getParameter("name"),
                req.getParameter("email"));
        log.debug("updated user : {}", user);
        DataBase.addUser(user);
        
        resp.sendRedirect("/user/list");
	}
}
