/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap6_Bai9;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {
    "/Lap6_Bai3_student-form.jsp",
    "/Lap6_Bai8_student-edit.jsp",
    "/StudentDeleteServlet",
    "/StudentSaveServlet"
})
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Lấy vai trò (role) từ Session
        String role = (session != null) ? (String) session.getAttribute("role") : null;

        // Nếu không phải ADMIN -> Chuyển hướng sang 403.jsp
        if (role == null || !role.equalsIgnoreCase("ADMIN")) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/403.jsp");
            return;
        }

        // Cho phép đi tiếp nếu đúng là ADMIN
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
