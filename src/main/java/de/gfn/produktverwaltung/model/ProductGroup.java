package de.gfn.produktverwaltung.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "product_groups")
public class ProductGroup {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 100, unique = true)
    private String name;

    @OneToMany(mappedBy = "productGroup")
    private Set<Product> products;

}
