package com.bah.msd.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;




@Component
public class AuthFilter implements Filter {

	
	 JWTHelper jwtUtil = new JWTHelper();
	
	private String api_scope = "com.api.customer.r";
	private String auth_scope = "com.api.customer.r";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		
		if (!uri.startsWith("/api/events") 
			       && !uri.startsWith("/api/registrations")
			       && !uri.startsWith("/api/customers")) 
		{
			System.out.println("AuthFilter Token is being processed.");
			// continue on to get-token endpoint
			chain.doFilter(request, response);
			return;
		} else {
			// check JWT token
			String authheader = req.getHeader("authorization");
			System.out.println("AuthHeader Token is being processed: " + authheader);
			if (authheader != null && authheader.length() > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				
				System.out.println("This is my jwt token: " + jwt_token);
				
				if (jwtUtil.verifyToken(jwt_token)) {
					
				System.out.println("2nd if statement is hit");
				
					String request_scopes = jwtUtil.getScopes(jwt_token);
					
					System.out.println("Print out request scopes: " + request_scopes);
					if (request_scopes.contains(api_scope) || (request_scopes.contains(auth_scope))) {
						
						System.out.println("token hits");
						
						// continue on to api
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}

		System.out.println("Authentication failed");
		
		// reject request and return error instead of data
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");
	}

}
