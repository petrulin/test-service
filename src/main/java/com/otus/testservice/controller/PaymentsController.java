package com.otus.testservice.controller;


import com.otus.testservice.domain.response.HealthResponse;
import com.otus.testservice.domain.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/")
@RestController
public class PaymentsController {

    @GetMapping(path = "/health")
    public ResponseEntity<HealthResponse> getConsolidatePayments() {
            return ResponseEntity.ok(new HealthResponse("OK"));
    }

    @GetMapping(path = "/student/{studentName}")
    public ResponseEntity<StudentResponse> getConsolidatePayments(@PathVariable("studentName") String studentName) {
        return ResponseEntity.ok(new StudentResponse(studentName));
    }


}
