package com.paymentplatform.MyPay.repository;

import com.paymentplatform.MyPay.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Transaction, Long> {
}
