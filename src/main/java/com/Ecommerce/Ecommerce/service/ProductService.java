package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.dto.ProductRequestDTO;
import com.Ecommerce.Ecommerce.dto.ProductResponseDTO;

import com.Ecommerce.Ecommerce.models.Product;
import com.Ecommerce.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product convertToEntity(ProductRequestDTO dto){
        Product item=new Product();
        item.setItem_name(dto.getItem_name());
        item.setCategory(dto.getCategory());
      //  item.setId(dto.getId());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());
        item.setDescription(dto.getDescription());
        return item;
    }

    public ProductResponseDTO addProduct(ProductRequestDTO dto){
      productRepository.save(convertToEntity(dto));
      ProductResponseDTO response=new ProductResponseDTO();
      response.setCategory(dto.getCategory());
     // response.setId(dto.getId());
      response.setPrice(dto.getPrice());
      response.setItem_name(dto.getItem_name());
      response.setDescription(dto.getDescription());
      response.setQuantity(dto.getQuantity());
      return response;
    }

    public String deleteProduct(Long id){
        Optional<Product> item=productRepository.findById(id);
        if(item.isPresent()){
            productRepository.deleteById(id);
            return "Product deleted";
        }
        return "Product not found";


    }

    public List<Product> productList(){
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }
}
