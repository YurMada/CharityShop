package se.iths.charity_shop.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.UserEntity;
import se.iths.charity_shop.repository.UserRepository;


@Service
public class CharityUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CharityUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("sorry username " + username + "was not found");
        }
        return new CharityUserPrincipal(userEntity);
    }
}



