package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.Feedback;
import com.cskaoyan.sb.springboot_project.bean.ResponseVo;
import com.cskaoyan.sb.springboot_project.service.FeedbackWxService;
import com.cskaoyan.sb.springboot_project.util.UserToken;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("wx/feedback")
@RestController
public class FeedbackWxController {

    @Autowired
    FeedbackWxService feedbackWxService;

    @RequestMapping("submit")
    public ResponseVo submitFeedback(@RequestBody Feedback feedback, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        String username = UserTokenManager.getUsername(tokenKey);
        feedback.setUserId(userId);
        feedback.setUsername(username);
        return feedbackWxService.submitFeedback(feedback);
    }
}
