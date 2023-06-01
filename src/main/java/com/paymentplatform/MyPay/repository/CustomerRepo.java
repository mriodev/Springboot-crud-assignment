package com.paymentplatform.MyPay.repository;

import com.paymentplatform.MyPay.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository <Customer, Long> {
    Customer findByPhoneNumber(Integer phoneNumber);
}
