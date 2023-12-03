package kr.easw.lesson06.controller;

import kr.easw.lesson06.service.UserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // 원래대로라면 리스트를 통해 JSON에서 사용할 수 있는 형태로 변환해야 하지만, 이번 실습에서는 건너뜁니다.
    @PostMapping("/remove")
    public ResponseEntity<String> removeUser(@RequestBody Map<String, Object> request) {
        String userId = request.get("userId").toString();
        boolean removed = userDataService.removeUserById(userId);
        if (removed) {
            return ResponseEntity.ok("User successfully removed.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }


}
