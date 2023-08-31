package com.felipe.models.grocery;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("grocery-p-price")
public class Price {
    @Id
    private String id;
    @DBRef
    private GroceryProduct product;

    private Long pricePerUnit;

    private Long pvpRecomendadoPrice;

    private Long price;
}
