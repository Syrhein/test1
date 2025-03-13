package com.smhrd.src.controller;

import com.smhrd.src.service.UserInterestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interest")
public class UserInterestController {

    private final UserInterestService userInterestService;

    public UserInterestController(UserInterestService userInterestService) {
        this.userInterestService = userInterestService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addInterest(
            @RequestParam String userId,
            @RequestParam String grantId,
            @RequestParam String applEdDt) {

        userInterestService.addInterest(userId, grantId, applEdDt);
        return ResponseEntity.ok("관심 등록 완료!");
    }
}
