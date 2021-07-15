package br.tenorioprojects.app.cpproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SER_SERVICE_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<ProductItem> items = new ArrayList<>();

    public void addItems(ProductItem productItem) {
        this.items.add(productItem);
        productItem.setOrder(this);
    }
    public void setItem(ProductItem productItem) {
        this.items.add(productItem);
        productItem.setOrder(this);
    }
//    public void removeProductItem(ProductItem productItem) {
//        this.orderService.remove(productItem);
//    }
//    public void removeProductItems() {
//        for(ProductItem productItem: new HashSet<>(orderService)) {
//            removeProductItem(productItem);
//        }
//    }

}
