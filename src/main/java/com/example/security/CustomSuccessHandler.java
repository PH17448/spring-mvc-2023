package com.example.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.util.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	
	//Dùng để đóng gói chuyển hướng
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	//Xử lý
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,Authentication authentication)
			throws IOException, ServletException {
		 
		String targetUrl = determineTargetUrl(authentication);
		
		//Nếu phản hồi cho người dùng ko cần phải thừa nhận thì chuyển tiếp
		if(!response.isCommitted()) { 
			redirectStrategy.sendRedirect(request,response,targetUrl);
		}
	}
	//hàm determineTargetUrl là hàm định tuyến xem là nó sẽ trả về Url nào
	private String determineTargetUrl(Authentication authentication) {
		String url = "" ;
		//if role is ADMIN so redirect to controller : /quan-tri/nguoi-dung
		//if role is USER so redirect to controller : /trang-chu
		List<String> roles = SecurityUtils.getAuthorities();
		if(isAdmin(roles)) {
			url = "/quan-tri/trang-chu";
		}else if(isUser(roles)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	@SuppressWarnings("unused")
	private boolean isAdmin(List<String> roles) {
		if(roles.contains("ADMIN")) {
			return true ;
		}else {
			return false ;
		}
	}
	@SuppressWarnings("unused")
	private boolean isUser(List<String> roles) {
		if(roles.contains("USER")) {
			return true ;
		}else {
			return false ;
		}
	}


	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}


	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	
	
	
}
