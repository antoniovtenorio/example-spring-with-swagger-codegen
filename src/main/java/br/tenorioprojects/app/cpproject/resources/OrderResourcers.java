package br.tenorioprojects.app.cpproject.resources;

import br.tenorioprojects.app.cpproject.dto.OrderDTORequest;
import br.tenorioprojects.app.cpproject.entities.Client;
import br.tenorioprojects.app.cpproject.entities.Order;
import br.tenorioprojects.app.cpproject.entities.ProductItem;
import br.tenorioprojects.app.cpproject.repositories.ClientRepository;
import br.tenorioprojects.app.cpproject.repositories.OrderRepository;
import br.tenorioprojects.app.cpproject.repositories.ProductItemRepository;
import br.tenorioprojects.app.cpproject.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/api/v1/serviceorder")
@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class OrderResourcers {

    private final OrderRepository repository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ProductItemRepository productItemRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<OrderDTORequest> postOrder(@RequestBody OrderDTORequest body) {
        Order order = new Order();
        Client cli = clientRepository.findById(body.getClient())
                .orElseThrow(() -> new NoSuchElementException("Client not found: " + body.getClient()));
        order.setName(body.getProductName());
        order.setClient(cli);

        for (ProductItem item : body.getProductItems()) {
            order.addItems(item);
        }

        OrderDTORequest preparedDTO = mapToResponse(body, order);

        return ResponseEntity.status(HttpStatus.CREATED).body(preparedDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OrderDTORequest> updateOrder(@PathVariable String id, @RequestBody OrderDTORequest body) {
        Order order = new Order();
        Client cli = clientRepository.findById(body.getClient())
                .orElseThrow(() -> new NoSuchElementException("Client not found: " + body.getClient()));
        order.setName(body.getProductName());
        order.setClient(cli);

        for (ProductItem item : body.getProductItems()) {
            Optional<ProductItem> findProductItem = productItemRepository.findById(item.getId());
            if(findProductItem.isPresent()) {
                order.setItem(item);
            }
            else
            {
                order.addItems(item);
            }
        }

        OrderDTORequest preparedDTO = mapToResponse(body, order);

        return ResponseEntity.status(HttpStatus.CREATED).body(preparedDTO);
    }

    private OrderDTORequest mapToResponse(OrderDTORequest body, Order order) {
        Order orderfetched = repository.save(order);
        body.setId(orderfetched.getId());
        body.getProductItems().clear();
        for (ProductItem item : orderfetched.getItems()) {
            body.getProductItems().add(item);
        }
        return body;
    }
}
