package br.tenorioprojects.app.cpproject.repositories;

import br.tenorioprojects.app.cpproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
