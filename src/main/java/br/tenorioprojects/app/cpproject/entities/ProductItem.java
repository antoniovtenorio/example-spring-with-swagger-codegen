package br.tenorioprojects.app.cpproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SER_PRODUCT_ITEM")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PURCHASE_PRICE")
    private Double purchaseprice;

    @ManyToOne
    private Product product;

    @ManyToMany(mappedBy = "item")
    private Set<Order> order;
}
