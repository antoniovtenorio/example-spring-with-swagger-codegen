package br.tenorioprojects.app.cpproject.resources;

import br.tenorioprojects.app.cpproject.entities.Product;
import br.tenorioprojects.app.cpproject.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product")
@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ProductResourcers {

    private final ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody Product body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(body));
    }
}
