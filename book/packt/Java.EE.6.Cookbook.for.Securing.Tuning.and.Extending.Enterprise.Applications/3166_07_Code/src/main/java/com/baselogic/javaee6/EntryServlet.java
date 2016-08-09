package com.baselogic.javaee6;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Entry Servlet
 *
 * @author Mick Knutson
 *         <a href="http://www.baselogic.com>Blog</a>< /br>
 *         <a href="http://linkedin.com/in/mickknutson>LinkedIN</a>< /br>
 *         <a href="http://twitter.com/mickknutson>Twitter</a>< /br>
 *         <a href="http://www.mickknutson.com>Personal</a>< /br>
 * @since 2011
 *        <i>To change this template use File | Settings | File Templates.</i>
 */
@WebServlet(
        value = "/declarative/entry",
        name = "entry-servlet"
)
@ServletSecurity(httpMethodConstraints={ @HttpMethodConstraint("GET"),
    @HttpMethodConstraint(value="POST", rolesAllowed={"patients"}),
    @HttpMethodConstraint(value="TRACE", emptyRoleSemantic=ServletSecurity.EmptyRoleSemantic.DENY) })
public class EntryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/ch03/admins/index.xhtml");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("GET UNPROTECTED SERVLET!");
    }
}
