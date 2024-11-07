package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edu.entity.Feedback;
import com.edu.service.FeedbackService;

import java.util.List;

@Controller
@RequestMapping("/feedbacks") // Định tuyến đến trang feedbacks trên front-end
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Hiển thị danh sách tất cả các phản hồi trong trang feedbacks.html
    @GetMapping
    public String getAllFeedbacks(Model model) {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        model.addAttribute("feedbacks", feedbacks);
        return "feedbacks"; // Tên file HTML trong thư mục templates (feedbacks.html)
    }

    // Hiển thị chi tiết phản hồi theo ID trong trang feedback-detail.html
    @GetMapping("/{id}")
    public String getFeedbackById(@PathVariable int id, Model model) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            model.addAttribute("feedback", feedback);
            return "feedback-detail"; // Tên file HTML cho chi tiết phản hồi
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Hiển thị form để tạo phản hồi mới
    @GetMapping("/new")
    public String showCreateFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback-form"; // Tên file HTML cho form tạo mới phản hồi (feedback-form.html)
    }

    // Xử lý việc tạo phản hồi mới từ form
    @PostMapping("/add")
    public String createFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedbacks"; // Chuyển hướng về danh sách phản hồi sau khi thêm mới
    }

    // Hiển thị form để chỉnh sửa phản hồi
    @GetMapping("/edit/{id}")
    public String showEditFeedbackForm(@PathVariable int id, Model model) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            model.addAttribute("feedback", feedback);
            return "feedback-form"; // Sử dụng chung form với form tạo mới
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Xử lý cập nhật thông tin phản hồi từ form
    @PostMapping("/update/{id}")
    public String updateFeedback(@PathVariable int id, @ModelAttribute Feedback feedbackDetails) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            feedback.setRating(feedbackDetails.getRating());
            feedback.setComments(feedbackDetails.getComments());
            feedback.setIsResolved(feedbackDetails.getIsResolved());
            feedbackService.saveFeedback(feedback);
            return "redirect:/feedbacks"; // Chuyển hướng về danh sách phản hồi sau khi cập nhật
        }
        return "error/404"; // Trả về trang lỗi nếu không tìm thấy
    }

    // Xử lý xóa phản hồi
    @PostMapping("/delete/{id}")
    public String deleteFeedback(@PathVariable int id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/feedbacks"; // Chuyển hướng về danh sách phản hồi sau khi xóa
    }
}
