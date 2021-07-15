package br.tenorioprojects.app.cpproject.repositories;

import br.tenorioprojects.app.cpproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
