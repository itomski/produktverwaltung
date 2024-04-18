package de.gfn.produktverwaltung.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "products") // Name der Tabelle
public class Product {

    /*
    @Id // Primarykey
    @GeneratedValue
    private long id;
    */

    /* Spring 2.*
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    @NotEmpty
    @Size(max = 100)
    private String name;

    @Column(length = 1000 /*, name="name_der_spalte"*/)
    @Size(max = 1000)
    private String description;

    @Positive(message = "Zahl ungültig")
    private double price;

    @PositiveOrZero
    private int amount;

    @Column(nullable = false)
    @NotNull
    //@PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate availableSince;

    @ManyToOne
    private ProductGroup productGroup;

    public Product() { // Sollte in einer Entity immer enthalten sein
    }

    public Product(String name, String description, double price, int amount, LocalDate availableSince) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.availableSince = availableSince;
    }

    /*
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getAvailableSince() {
        return availableSince;
    }

    public void setAvailableSince(LocalDate availableSince) {
        this.availableSince = availableSince;
    }
    */
}
