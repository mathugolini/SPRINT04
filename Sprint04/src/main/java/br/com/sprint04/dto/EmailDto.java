package br.com.sprint04.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link br.com.sprint04.model.Email} entity
 */
@Data
public class EmailDto implements Serializable {
    @Email(message = "Email inválido, por favor, verifique")
    @NotBlank(message = "O email é obrigatório")
    private String endereco;
    @NotBlank(message = "Escreva um assunto")
    private String assunto;
    private String dataEnvio;
}