package com.paymentplatform.MyPay.repository;

import com.paymentplatform.MyPay.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CreditCard, Long> {
    // Additional query methods if needed
}
