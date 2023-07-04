package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        try {
            return productRepository.save(
                    new Product(
                            product.getName(),
                            product.getPrice()
                    )
            );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        try
        {
            Optional<Product> productData = productRepository.findById(id);
            if(productData.isPresent())
            {
                return productData;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        try
        {
            //new 안 해도 됨
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent())
            {
                //optional의 메소드임 ㅇㅇ
                Product _product = productData.get();
                _product.setName(product.getName());
                _product.setPrice(product.getPrice());
                productRepository.save(_product);
                return _product;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try
        {
            productRepository.deleteById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
