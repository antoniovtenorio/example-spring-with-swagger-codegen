package br.tenorioprojects.app.cpproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRD_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_VALUE")
    private Double productValue;
    @Column(name = "QUANTITY")
    private Integer quantity;
}
