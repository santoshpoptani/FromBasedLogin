package com.example.loginsystem.security.SecurityUtil;

import com.example.loginsystem.CustomUserDetail.CustomUserDetailService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authotity->{
            if(authotity.getAuthority().equals("ADMIN")){
                try{
                    redirectStrategy.sendRedirect(request,response,"/users");
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (authotity.getAuthority().equals("USER")) {
                try{
                    redirectStrategy.sendRedirect(request,response,"/user");
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
            else {
                throw new IllegalStateException();
            }
        });


    }
}
