/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap6_Bai5;

/**
 *
 * @author DELL
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppLogListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String msg = "[APP LOG] === ỨNG DỤNG DỰ ÁN (WEB APP) ĐÃ KHỞI ĐỘNG THÀNH CÔNG ===";
        
        context.log(msg);
        System.out.println(msg);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String msg = "[APP LOG] === ỨNG DỤNG DỰ ÁN ĐÃ DỪNG HẠO ĐỘNG ===";
        
        context.log(msg);
        System.out.println(msg);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        String msg = "[SESSION LOG] Một Session mới vừa được khởi tạo! ID: " + sessionId;
        
        se.getSession().getServletContext().log(msg);
        System.out.println(msg);
    }

    // Ghi log khi HỦY SESSION (Đăng xuất hoặc hết timeout)
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        String msg = "[SESSION LOG] Session đã bị hủy! ID: " + sessionId;
        
        se.getSession().getServletContext().log(msg);
        System.out.println(msg);
    }
}
