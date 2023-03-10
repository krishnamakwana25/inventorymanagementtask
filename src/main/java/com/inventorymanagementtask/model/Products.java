package com.inventorymanagementtask.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Products {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name="product_name")
    @NotNull @NotBlank
    private String productName;
    @Column(name="product_qty")
    @NotNull
    private int productQuantity;
    @Column(name="product_price")
    @NotNull
    private int productPrice;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="categoryId", referencedColumnName = "categoryId", updatable =  true)
    private Category category;

    @OneToMany(mappedBy = "products")
    private List<Stock> stocks;
}
