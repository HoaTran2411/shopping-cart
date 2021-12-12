package vn.techmaster.shopingcart.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.shopingcart.model.CreateProductReq;
import vn.techmaster.shopingcart.model.Product;
import vn.techmaster.shopingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;
    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Product createProduct(CreateProductReq product) throws IOException {
        Product newProduct = Product.builder().withImage(product.getImageRequest().getBytes())
        .withName(product.getName()).withManufacturer(product.getManufacturer())
        .withPrice(product.getPrice())
        .build()
        
        ;
        
        return repo.save(newProduct);
    }

}
