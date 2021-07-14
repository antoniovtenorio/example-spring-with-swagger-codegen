package br.tenorioprojects.app.cpproject.repositories;

import br.tenorioprojects.app.cpproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
