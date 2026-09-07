package Lap7_Bai7;

import java.util.ArrayList;
import java.util.List;

public class ProductStore {
    private static final List<Product> products = new ArrayList<>();

    // Dữ liệu mẫu khởi tạo ban đầu
    static {
        products.add(new Product("SP001", "Laptop Dell XPS 13", "Laptop mỏng nhẹ cao cấp", 25000000, 10));
        products.add(new Product("SP002", "Bàn phím cơ Keychron", "Bàn phím cơ không dây", 1800000, 25));
        products.add(new Product("SP003", "Chuột Logitech MX Master 3S", "Chuột công thái học", 2200000, 15));
    }

    public static List<Product> findAll() {
        return products;
    }

    public static Product findById(String id) {
        if (id == null) return null;
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public static void save(Product product) {
        Product existing = findById(product.getId());
        if (existing != null) {
            // Cập nhật sản phẩm
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
        } else {
            // Thêm mới sản phẩm
            products.add(product);
        }
    }

    public static void delete(String id) {
        products.removeIf(p -> p.getId().equalsIgnoreCase(id));
    }
}