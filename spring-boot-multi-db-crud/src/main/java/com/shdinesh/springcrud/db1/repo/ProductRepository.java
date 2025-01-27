package com.shdinesh.springcrud.db1.repo;


import com.shdinesh.springcrud.db1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
