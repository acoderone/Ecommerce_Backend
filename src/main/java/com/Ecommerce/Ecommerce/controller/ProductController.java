package com.Ecommerce.Ecommerce.controller;


import com.Ecommerce.Ecommerce.dto.ProductRequestDTO;
import com.Ecommerce.Ecommerce.dto.ProductResponseDTO;
import com.Ecommerce.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
   private ProductService productService;
    @PostMapping("/admin/addProduct")
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO request){
        ProductResponseDTO response=productService.addProduct(request);
        return response;
    }

    @DeleteMapping("/admin/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
       String result= productService.deleteProduct(id);
       return ResponseEntity.ok(result);
    }
}
