package com.felipe.models.grocery;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document("grocery-product")
public class GroceryProduct {
    @Id
    private String id;

    private String title;

    private String unit;

    private String quantity;

    private String brand;

    private String href;

}
