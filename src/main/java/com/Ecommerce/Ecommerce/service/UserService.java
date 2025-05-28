package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.dto.AuthRequestDTO;
import com.Ecommerce.Ecommerce.dto.AuthResponse;
import com.Ecommerce.Ecommerce.dto.UserRequestDTO;
import com.Ecommerce.Ecommerce.dto.UserResponseDTO;
import com.Ecommerce.Ecommerce.models.User;
import com.Ecommerce.Ecommerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


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

    public AuthResponse loginUser(AuthRequestDTO request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }
        System.out.println("email"+ request.getUsername());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        Optional<User> user=userRepository.findByEmail(userDetails.getUsername());
        final String token = jwtService.generateToken(user.get());
        return new AuthResponse(token);
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
