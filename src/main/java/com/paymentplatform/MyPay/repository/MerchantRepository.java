package com.paymentplatform.MyPay.repository;


import com.paymentplatform.MyPay.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository <Merchant, Long> {
    Merchant findByNumber(Long id);
}
