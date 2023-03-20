package com.relation.relation.config;

import com.relation.relation.service.JwtCustomerDetailService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    JwtCustomerDetailService jwtCustomerDetailService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String username= null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException e){
                System.out.println("Tidak bisa mendapatkan jwt token");//unable to get JWT token
            }catch (ExpiredJwtException e){
                System.out.println("JWT token is Expired");//JWT is expired
            }
        } else if (requestTokenHeader == null) {
            System.out.println("HEADER IS NULL");
        } else {
            logger.warn("JWT tidka mulai dari kata bearer");//JWT is not begin with Bearer String
        }

        //validasi

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails= jwtCustomerDetailService.loadUserByUsername(username);
            if(jwtTokenUtil.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
