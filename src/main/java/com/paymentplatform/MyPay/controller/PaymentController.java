package com.paymentplatform.MyPay.controller;

import com.paymentplatform.MyPay.exception.ResourceNotFound;
import com.paymentplatform.MyPay.model.Transaction;
import com.paymentplatform.MyPay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @PostMapping
    public ResponseEntity<Transaction> makePayment(@RequestBody Transaction payment) {
        Transaction madePayment = paymentRepository.save(payment);
        return ResponseEntity.ok(madePayment);
    }
    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<Transaction>> getPaymentHistoryByCustomerId(@PathVariable Long id){
        List<Transaction> paymentHistory = (List<Transaction>) paymentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Payment History not exist"));
        return ResponseEntity.ok(paymentHistory);

    }
}


