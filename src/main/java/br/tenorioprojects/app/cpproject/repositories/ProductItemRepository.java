package br.tenorioprojects.app.cpproject.repositories;

import br.tenorioprojects.app.cpproject.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
