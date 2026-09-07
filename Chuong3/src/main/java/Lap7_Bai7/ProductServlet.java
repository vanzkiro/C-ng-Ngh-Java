/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "delete":
                String deleteId = request.getParameter("id");
                ProductStore.delete(deleteId);
                response.sendRedirect("ProductServlet?action=list");
                break;
                
            case "edit":
                String editId = request.getParameter("id");
                Product product = ProductStore.findById(editId);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/Lap7_Bai7_product-form.jsp").forward(request, response);
                break;

            case "add":
                request.getRequestDispatcher("/Lap7_Bai7_product-form.jsp").forward(request, response);
                break;

            case "list":
            default:
                request.setAttribute("products", ProductStore.findAll());
                request.getRequestDispatcher("/Lap7_Bai7_product-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String quantityStr = request.getParameter("quantity");

        String errorMsg = null;
        double price = 0;
        int quantity = 0;

        // Validation kiểm tra giá > 0 và số lượng >= 0
        try {
            price = Double.parseDouble(priceStr);
            quantity = Integer.parseInt(quantityStr);

            if (price <= 0) {
                errorMsg = "Giá sản phẩm phải lớn hơn 0!";
            } else if (quantity < 0) {
                errorMsg = "Số lượng sản phẩm phải lớn hơn hoặc bằng 0!";
            }
        } catch (NumberFormatException e) {
            errorMsg = "Giá và số lượng phải là số hợp lệ!";
        }

        // Báo lỗi nếu dữ liệu không hợp lệ
        if (errorMsg != null) {
            Product currentProduct = new Product(id, name, description, price, quantity);
            request.setAttribute("product", currentProduct);
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/Lap7_Bai7_product-form.jsp").forward(request, response);
            return;
        }

        // Lưu sản phẩm thành công
        Product product = new Product(id, name, description, price, quantity);
        ProductStore.save(product);
        response.sendRedirect("ProductServlet?action=list");
    }
}