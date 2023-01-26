package com.example.polls.security;

//import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.User;
import com.example.polls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailService implements UserDetailsService {


    UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Let people login with either username or email
        User user;
        if (usernameOrEmail.contains("@")) {
          user=userRepository.findByEmail(usernameOrEmail).orElseThrow(() ->
                    new UsernameNotFoundException("User not found email : " + usernameOrEmail)
            );
        }
        else{
          user=userRepository.findByUsername(usernameOrEmail).orElseThrow(() ->
                    new UsernameNotFoundException("User not found with username : " + usernameOrEmail)
            );
        }

        return UserPrincipal.create(user);
    }
    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }

}
