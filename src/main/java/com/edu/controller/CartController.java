package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Cart;
import com.edu.service.CartService;

import java.util.List;

@Controller
@RequestMapping("/carts") // Chuyển đổi URL để phù hợp với view front-end
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Endpoint để lấy danh sách tất cả các giỏ hàng và hiển thị trong trang cart.html
    @GetMapping
    public String getAllCarts(Model model) {
        List<Cart> carts = cartService.getAllCarts();
        model.addAttribute("carts", carts);
        return "cart"; // Trả về tên file HTML trong thư mục templates (cart.html)
    }

    // Endpoint để lấy chi tiết giỏ hàng theo ID và hiển thị trong trang cart-detail.html
    @GetMapping("/{id}")
    public String getCartById(@PathVariable int id, Model model) {
        Cart cart = cartService.getCartById(id);
        if (cart != null) {
            model.addAttribute("cart", cart);
            return "cart-detail"; // Trả về file HTML cho chi tiết giỏ hàng (cart-detail.html)
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để tạo mới một giỏ hàng (thường qua form submit từ giao diện)
    @PostMapping("/add")
    public String createCart(@ModelAttribute Cart cart) {
        cartService.saveCart(cart);
        return "redirect:/carts"; // Sau khi thêm mới, chuyển hướng lại danh sách giỏ hàng
    }

    // Endpoint để cập nhật giỏ hàng (thường qua form submit từ giao diện)
    @PostMapping("/update/{id}")
    public String updateCart(@PathVariable int id, @ModelAttribute Cart cartDetails) {
        Cart cart = cartService.getCartById(id);
        if (cart != null) {
            cart.setQuantity(cartDetails.getQuantity());
            cart.setIsActive(cartDetails.getIsActive());
            cartService.saveCart(cart);
            return "redirect:/carts"; // Sau khi cập nhật, chuyển hướng lại danh sách giỏ hàng
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Endpoint để xóa một giỏ hàng (qua form submit hoặc nút delete từ giao diện)
    @PostMapping("/delete/{id}")
    public String deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
        return "redirect:/carts"; // Sau khi xóa, chuyển hướng lại danh sách giỏ hàng
    }
}
