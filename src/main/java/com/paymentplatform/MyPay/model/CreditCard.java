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
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardno;
    @Column(name = "cardtype")
    private String cardtype;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "cardvalidity")
    private String cardvalidity;


}
