package com.example.demo.controllers;

import com.example.demo.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/message")
    public ResponseEntity<ResponseDto> getMessage() {
        ResponseDto response = new ResponseDto(true, HttpStatus.OK.value(), "Hello world!");
        return ResponseEntity.ok(response);
    }

}
