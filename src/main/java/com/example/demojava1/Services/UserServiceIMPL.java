package com.example.demojava1.Services;


import com.example.demojava1.Registration.UserRegistration;
import com.example.demojava1.Entities.User;
import com.example.demojava1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceIMPL(UserRepository userRepo) {
        super();
        this.userRepository = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }



    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User save(UserRegistration userRegistrationDto) {
        User user = new User(userRegistrationDto.getUsername(),
                userRegistrationDto.getEmail(),
                passwordEncoder.encode(userRegistrationDto.getPassword()));
        return userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        System.out.println(user.getEmail() + user.getPassword());
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}