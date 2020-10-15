package com.bah.msd.auth;

public interface JWTUtil {
	public boolean verifyToken(String jwt_token);
	public String getScopes(String jwt_token) ;
	public String createToken(String scopes) ;
}