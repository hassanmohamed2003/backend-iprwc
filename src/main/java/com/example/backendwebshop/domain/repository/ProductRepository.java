package com.example.backendwebshop.domain.repository;

import com.example.backendwebshop.domain.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {

    @Modifying
    @Query("delete from Product b where b.id = ?1")
    void deleteById(@Nonnull String id);
}
