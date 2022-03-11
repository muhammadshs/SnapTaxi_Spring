package com.dwteam.filters;

import com.dwteam.jwt.Token;
import com.dwteam.person.PersonLoginService;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class Filter extends OncePerRequestFilter {
    private PersonLoginService personLoginService;
    private Token token;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url=request.getRequestURI();
        System.out.println(url);
        String requestHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token.validateToken(requestHeader)) {
            Claims body = token.getAllClaimsFromToken(requestHeader);

            personLoginService.setter(Long.parseLong((String) body.get("id")), body.getSubject());
            filterChain.doFilter(request, response);
        }
        System.out.println(response.getStatus());
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        if (path.equals("/driver/login") || path.equals("/driver/register") || path.equals("/passenger/login") || path.equals("/passenger/register"))
            return true;
        return false;
    }
}
