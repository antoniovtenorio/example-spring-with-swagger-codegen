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
@Table(name = "SER_SERVICE_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Client client;


    @ManyToMany
    @JoinTable(name = "SER_ITEM_PRODUCT_ITEM",
            joinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ITEM_ID", referencedColumnName = "ID"))
    private Set<ProductItem> item;


}
