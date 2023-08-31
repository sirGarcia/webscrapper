package com.felipe.repository;

import com.felipe.models.grocery.GroceryProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroceryRepository extends MongoRepository<GroceryProduct, UUID> {
    List<GroceryProduct> findByTitle(final String title);
}
