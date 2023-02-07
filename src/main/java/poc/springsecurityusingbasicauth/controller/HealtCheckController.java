package poc.springsecurityusingbasicauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealtCheckController {

    @GetMapping
    public ResponseEntity<String> findAllActives() {
        return ResponseEntity.ok("Hi! I'm Spring Security POC using Basic Authentication!");
    }

}
