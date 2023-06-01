package com.paymentplatform.MyPay.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column(name = "paymentamount")
    private String paymentAmount;
    @Column(name = "paymentdate")
    private String paymentDate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;
}
