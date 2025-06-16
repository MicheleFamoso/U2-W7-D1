package it.epicode.U2_W7_D1.service;

import it.epicode.U2_W7_D1.dto.UserDto;
import it.epicode.U2_W7_D1.exception.NonTrovatoException;
import it.epicode.U2_W7_D1.model.User;
import it.epicode.U2_W7_D1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserDto userDto){

        User user= new User();
        user.setNome(userDto.getNome());
        user.setCognome(userDto.getCognome());
       user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());


        return  userRepository.save(user);
    }

    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public User getUser(int id) throws NonTrovatoException {
        return   userRepository.findById(id).orElseThrow(()-> new NonTrovatoException("Università non trovata"));
    }

    public User updateUser(int id,UserDto userDto) throws NonTrovatoException {
        User user = getUser(id);
        user.setNome(userDto.getNome());
        user.setCognome(userDto.getCognome());
       user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(int id) throws NonTrovatoException {

        User user = getUser(id);
        userRepository.delete(user);
    }
}
