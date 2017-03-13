package filter;

import common.ApplicationUser;
import services.interfaces.AuthorizationService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cefothe on 05.03.17.
 */
@WebFilter("/admin/game/*")
@Stateless
public class GameFilter implements Filter {

    @Inject
    private AuthorizationService authorizationService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        ApplicationUser applicationUser =authorizationService.typeOfUser(session);
        if(!ApplicationUser.ADMIN.equals(applicationUser)){
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
