package com.paymentplatform.MyPay.controller;

import com.paymentplatform.MyPay.exception.ResourceNotFound;
import com.paymentplatform.MyPay.model.Customer;
import com.paymentplatform.MyPay.model.Merchant;
import com.paymentplatform.MyPay.repository.CustomerRepo;
import com.paymentplatform.MyPay.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    @Autowired
    private MerchantRepository merchantRepository;

    @GetMapping
    public List<Merchant> getAllMerchant(){

        return merchantRepository.findAll();
    }

    @PostMapping
    public Merchant createMerchant(@RequestBody Merchant merchant){
        return merchantRepository.save(merchant);
    }

    @GetMapping("{id}")

    public ResponseEntity<Merchant> getMerchantById(long id){
        Merchant merchant =merchantRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Merchant not exist"));
        return ResponseEntity.ok(merchant);
    }
    @PutMapping("{id}")
    public ResponseEntity<Merchant> updateMerchant(@PathVariable long id, @RequestBody Merchant merchantDetails){
        Merchant updateMerchant = merchantRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Customer not exist"));
        updateMerchant.setName(merchantDetails.getName());

        merchantRepository.save(updateMerchant);
        return ResponseEntity.ok(updateMerchant);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMerchant(@PathVariable long id){

        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Customer not exist"));
        merchantRepository.delete(merchant);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
