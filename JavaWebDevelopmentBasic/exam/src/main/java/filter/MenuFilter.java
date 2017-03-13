package filter;


import common.ApplicationUser;
import services.interfaces.AuthorizationService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by cefothe on 05.03.17.
 */

@Stateless
@WebFilter("/*")
public class MenuFilter implements Filter {

    @Inject
    private AuthorizationService authorizationService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        ApplicationUser applicationUser =authorizationService.typeOfUser(session);
        servletRequest.setAttribute("applicationUser", applicationUser);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
