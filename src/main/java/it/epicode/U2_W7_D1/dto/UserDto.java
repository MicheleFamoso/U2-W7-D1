package it.epicode.U2_W7_D1.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {

    @NotEmpty(message = "Questo campo no puo essere vuoto")
    private String nome;
    @NotEmpty(message = "Questo campo no puo essere vuoto")
    private String cognome;
    @NotEmpty(message = "Questo campo no puo essere vuoto")
    private String email;
    @NotEmpty(message = "Questo campo no puo essere vuoto")
    private String password;
}
