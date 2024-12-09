package com.example.springboot.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class MainController {
    @GetMapping("/")
    public ResponseEntity<?> returnArray() {
        String[] brands = { "Honda", "Hyundai", "KIA", "BMW", "Mercedes Benz"};
        return ResponseEntity.ok(brands);
    }
}
