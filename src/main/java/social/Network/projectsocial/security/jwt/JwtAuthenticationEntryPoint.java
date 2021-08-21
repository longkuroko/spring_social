package social.Network.projectsocial.security.jwt;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest Request,
                         HttpServletResponse Response,
                         AuthenticationException e)  throws IOException, ServletException {
            Response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
