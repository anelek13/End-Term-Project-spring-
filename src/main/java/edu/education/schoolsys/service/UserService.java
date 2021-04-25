package edu.education.schoolsys.service;

import edu.education.schoolsys.domain.User;
import edu.education.schoolsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.saveAndFlush(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User: " + username + " not found");
        return user;
    }
}
