package org.springprep.classicmodelsapi.modules.orders.model;

import jakarta.persistence.*;
import lombok.*;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;
import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetail;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    @Column(name = "requiredDate", nullable = false)
    private LocalDate requiredDate;

    @Column(name = "shippedDate")
    private LocalDate shippedDate;

    @Column(nullable = false, length = 15)
    private String status;

    @Lob
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customer customer;

    @Builder.Default
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new HashSet<>();
}
