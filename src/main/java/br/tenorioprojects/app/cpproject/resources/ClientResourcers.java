package br.tenorioprojects.app.cpproject.resources;

import br.tenorioprojects.app.cpproject.entities.Client;
import br.tenorioprojects.app.cpproject.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/client")
@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ClientResourcers {

    private final ClientRepository repository;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Client> postClient(@RequestBody Client body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(body));
    }
}
