package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.service.ProductServiceImpl;
import com.test.SpringBootApi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//전체 허용 원래는 특정 요청을 제한
@CrossOrigin("*")
//사용자 입력을 HTTP방식에 맞게
//@RestController는 @Controller에 @ResponseBody가 추가된 것입니다.
//당연하게도 RestController의 주용도는 Json 형태로 객체 데이터를 반환하는 것입니다.
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") long id) {
        try
        {
            return ResponseEntity.ok(productService.findById(id));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try
        {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.save(product));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Product product
    ) {
        try
        {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.update(id, product));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  null;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try
        {
            productService.delete(id);
            ResponseEntity.noContent();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
