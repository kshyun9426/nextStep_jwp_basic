package next.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.model.User;

public class ListUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("users", DataBase.findAll());
        if(!UserSessionUtils.isLogined(request.getSession())) {
        	return "redirect:/users/loginForm";
        }
		return "/user/list.jsp";
	}

	
	
}
