package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 컨트롤러를 추가하다보니 회원가입화면(/user/form.jsp), 로그인 화면(/user/login.jsp)와 같이 특별한 로직이 필요없이 화면만 띄우면 되는경우
 * 매번 컨트롤러를 만들 필요 없이 ForwardController하나로 공통 처리하게 한다.
 */
public class ForwardController implements Controller {
	
	private String forwardUrl;
	
	public ForwardController(String forwardUrl) {
		this.forwardUrl = forwardUrl;
		if(forwardUrl == null) {
			throw new NullPointerException("forward is null. 이동할 URL을 입력해주세요.");
		}
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return forwardUrl;
	}
}
