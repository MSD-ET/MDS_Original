package com.bah.msd.auth;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


public class JWTHelper  {
	/*
	 * https://github.com/auth0/java-jwt
	 */
	
	public static String createToken(String scopes) {
		
	
		
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    long fiveHoursInMillis = 1000 * 60 * 60 * 5;
		    Date expireDate = new Date(System.currentTimeMillis() + fiveHoursInMillis);
		    String token = JWT.create()
		    	.withSubject("apiuser")
		        .withIssuer("me@me.com")
		        .withClaim("scopes", scopes)
		        .withExpiresAt(expireDate)
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
			return null;
		}	
	}
	
	public static boolean verifyToken(String token) {

		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("me@me.com")
		        .build(); 
		    DecodedJWT jwt = verifier.verify(token);
		    return true;
		} catch (JWTVerificationException exception){
			return false;
		}		
		
	}

	public static Map<String, Claim> getClaims(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("me@me.com")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt.getClaims();
		} catch (JWTVerificationException exception){
			return null;
		}
	}
	
	public static String getScopes(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("me@me.com")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt.getClaim("scopes").asString();
		} catch (JWTVerificationException exception){
			return null;
		}
	}
}
