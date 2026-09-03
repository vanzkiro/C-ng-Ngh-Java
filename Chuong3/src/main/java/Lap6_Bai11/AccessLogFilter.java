package Lap6_Bai11;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AccessLogFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("[ACCESS LOG] Filter đã khởi tạo thành công!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();

        // Chỉ log các request trang web (Bỏ qua tài nguyên tĩnh)
        if (!uri.endsWith(".css") && !uri.endsWith(".js") && !uri.endsWith(".png") && !uri.endsWith(".jpg")) {
            String method = httpRequest.getMethod();
            HttpSession session = httpRequest.getSession(false);
            String username = (session != null && session.getAttribute("username") != null) 
                               ? (String) session.getAttribute("username") 
                               : "Guest";

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            String accessTime = sdf.format(new Date());

            // Ghi ra tab Tomcat Log
            String logMsg = String.format("[ACCESS LOG] %s | Method: %s | URI: %s | User: %s", 
                                          accessTime, method, uri, username);
            
            this.context.log(logMsg);
            System.out.println(logMsg); // Ghi ra tab Output chuẩn
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}