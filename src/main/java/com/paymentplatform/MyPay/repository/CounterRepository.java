package com.paymentplatform.MyPay.repository;

import com.paymentplatform.MyPay.model.Counter;
import com.paymentplatform.MyPay.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterRepository extends JpaRepository<Counter, Long> {
    List<Counter> findByOutlet(Outlet outlet);
}
