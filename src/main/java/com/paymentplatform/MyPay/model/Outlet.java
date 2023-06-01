package com.paymentplatform.MyPay.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "outlet")
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outletId;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

   @ManyToOne
    @JoinColumn(name="merchantId")
    private Merchant merchant;
}
