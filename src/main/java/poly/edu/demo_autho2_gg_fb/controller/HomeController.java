package poly.edu.demo_autho2_gg_fb.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CONTROLLER - XỬ LÝ CÁC REQUEST TỪ NGƯỜI DÙNG
 * 
 * Controller này xử lý 2 endpoint:
 * - GET "/" : Trang chủ (hiển thị nút đăng nhập)
 * - GET "/user" : Trang thông tin người dùng (sau khi đăng nhập)
 */
@Controller
public class HomeController {

    /**
     * TRANG CHỦ - GET "/"
     */
    @GetMapping("/")
    public String trangChu() {
        return "index";
    }

    /**
     * TRANG THÔNG TIN NGƯỜI DÙNG - GET "/user"
     * 
     * @param principal - Thông tin người dùng từ Google
     * @param model - Truyền dữ liệu sang view
     */
    @GetMapping("/user")
    public String trangNguoiDung(@AuthenticationPrincipal OAuth2User principal, Model model) {
        model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("email", principal.getAttribute("email"));
        model.addAttribute("picture", principal.getAttribute("picture"));
        return "user";
    }
}
