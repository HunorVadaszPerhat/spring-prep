package org.springprep.classicmodelsapi.modules.employees.model;

import jakarta.persistence.*;
import lombok.*;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;
import org.springprep.classicmodelsapi.modules.offices.model.Office;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 10)
    private String extension;

    @Column(nullable = false, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeCode", nullable = false)
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee manager;

    @Builder.Default
    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "salesRepresentative")
    private Set<Customer> customers = new HashSet<>();

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;
}
