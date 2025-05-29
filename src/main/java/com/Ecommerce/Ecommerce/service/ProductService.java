package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.dto.ProductRequestDTO;
import com.Ecommerce.Ecommerce.dto.ProductResponseDTO;
import com.Ecommerce.Ecommerce.models.Item;
import com.Ecommerce.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Item convertToEntity(ProductRequestDTO dto){
        Item item=new Item();
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
        Optional<Item> item=productRepository.findById(id);
        if(item.isPresent()){
            productRepository.deleteById(id);
            return "Product deleted";
        }
        return "Product not found";


    }
}
