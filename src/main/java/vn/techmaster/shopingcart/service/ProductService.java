package vn.techmaster.shopingcart.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import vn.techmaster.shopingcart.model.CreateProductReq;
import vn.techmaster.shopingcart.model.Product;


public interface ProductService {
    List<Product> getAll();

    Optional<Product> findById(long id);

    Product createProduct(CreateProductReq product) throws IOException;
}
