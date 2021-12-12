package vn.techmaster.shopingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.shopingcart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
