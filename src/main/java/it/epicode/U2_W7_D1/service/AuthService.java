package it.epicode.U2_W7_D1.service;



import it.epicode.U2_W7_D1.dto.LoginDto;
import it.epicode.U2_W7_D1.exception.NonTrovatoException;
import it.epicode.U2_W7_D1.model.User;
import it.epicode.U2_W7_D1.repository.UserRepository;
import it.epicode.U2_W7_D1.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //Verifica che esiste un utente
    //Se non esiste lancia eccezione
    //se esiste, genera token e invia al client

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTool jwtTool;


    public String login(LoginDto loginDto) throws NonTrovatoException {
      User user= userRepository.findByEmail(loginDto.getEmail()).
              orElseThrow(()->new NonTrovatoException("Utente con username/password non trovato"));
        if (loginDto.getPassword().equals(user.getPassword())){
            // utente autenticato Creo il token
            return jwtTool.createToken(user);


        }else {
            throw new NonTrovatoException("Utente con username/password non trovato");
        }

    }







}
