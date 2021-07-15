package br.tenorioprojects.app.cpproject.dto;

import br.tenorioprojects.app.cpproject.entities.ProductItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTORequest {

    private Long id;
    private String productName;
    private Long client;
    private List<ProductItem> productItems = new ArrayList<>();
}
