package org.springprep.classicmodelsapi.modules.productlines.model;

import jakarta.persistence.*;
import lombok.*;
import org.springprep.classicmodelsapi.modules.products.model.Product;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductLine {

    @Id
    @Column(name = "productLine", length = 50)
    private String productLine;

    @Column(name = "textDescription", length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Lob
    private byte[] image;

    @Builder.Default
    @OneToMany(mappedBy = "productLine")
    private Set<Product> products = new HashSet<>();
}
