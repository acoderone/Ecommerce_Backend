package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.dto.UserRequestDTO;
import com.Ecommerce.Ecommerce.dto.UserResponseDTO;
import com.Ecommerce.Ecommerce.models.User;
import com.Ecommerce.Ecommerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserResponseDTO registerUser(UserRequestDTO user){
        Optional<User> find_User=userRepository.findByEmail(user.getEmail());
        if(find_User.isPresent()){
          throw new RuntimeException("Email already in use");
        }
        User saved_user=userRepository.save(ConvertToEntity(user));

        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setId(saved_user.getId());
        userResponseDTO.setName(saved_user.getFirst_name()+" "+saved_user.getLast_name());
        userResponseDTO.setEmail(saved_user.getEmail());

        userResponseDTO.setRole(saved_user.getRole());
        return userResponseDTO;
    }

    public User ConvertToEntity(UserRequestDTO user){
      User user_Entity=new User();
      user_Entity.setId(user.getId());

      user_Entity.setEmail(user.getEmail());

      user_Entity.setPassword(passwordEncoder.encode(user.getPassword()));
      user_Entity.setFirst_name(user.getFirst_name());
      user_Entity.setLast_name(user.getLast_name());

      user_Entity.setRole(user.getRole());
      user_Entity.setPhone_number(user.getPhone_number());
      return user_Entity;

    }
}
