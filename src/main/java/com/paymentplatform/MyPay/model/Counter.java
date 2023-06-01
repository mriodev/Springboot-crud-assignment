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
@Table(name = "counter")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long counterId;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="outletId")
    private Outlet outlet;
}
