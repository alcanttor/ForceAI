package com.mg.configurationManager.Service.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter{
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String Username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            Username = jwtService.extractUsername(jwt);
        }


        if (Username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails UserDetails = userDetailsService.loadUserByUsername(Username);
            if (jwtService.validateToken(jwt, UserDetails)) {
            	logger.debug("Security token validated");
                UsernamePasswordAuthenticationToken UsernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        UserDetails, null, UserDetails.getAuthorities());
                UsernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(UsernamePasswordAuthenticationToken);
            }
            else
            {
            	logger.warn("User not valid in JWT");
            	
            	System.out.println("User is not valid in jwt......................");
            }
        }
        chain.doFilter(request, response);
    }
}