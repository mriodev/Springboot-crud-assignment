package com.paymentplatform.MyPay.controller;

import com.paymentplatform.MyPay.model.Counter;
import com.paymentplatform.MyPay.model.Outlet;
import com.paymentplatform.MyPay.repository.CounterRepository;
import com.paymentplatform.MyPay.repository.OutletRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/counter")
public class CounterController {
  private  CounterRepository counterRepository;
  private OutletRepository outletRepository;

  public CounterController(CounterRepository counterRepository, OutletRepository outletRepository)
  {
      this.counterRepository = counterRepository;
      this.outletRepository = outletRepository;
  }

    @PostMapping
    public ResponseEntity<Counter> createCounter(@RequestBody Counter counter) {
        Counter createdCounter = counterRepository.save(counter);
        return ResponseEntity.ok(createdCounter);
    }
    @GetMapping("/{counterId}")
    public ResponseEntity<Counter> getCounterById(@PathVariable Long counterId) {
        Optional<Counter> counter = counterRepository.findById(counterId);
        return counter.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/outlet/{outletId}")
    public ResponseEntity<List<Counter>> getCountersByOutletId(@PathVariable Long outletId) {
        Optional<Outlet> outlet = outletRepository.findById(outletId);
        if (outlet.isPresent()) {
            List<Counter> counters = counterRepository.findByOutlet(outlet.get());
            return ResponseEntity.ok(counters);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
