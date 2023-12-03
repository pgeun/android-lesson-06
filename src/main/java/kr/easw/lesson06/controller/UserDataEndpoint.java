package kr.easw.lesson06.controller;

import kr.easw.lesson06.service.UserDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserDataEndpoint {

    private final UserDataService userDataService;

    public UserDataEndpoint(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listUserIds() {
        List<String> userIds = userDataService.getAllUserIds();
        return ResponseEntity.ok(userIds);
    }

}
