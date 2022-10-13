package br.com.sprint04.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Email implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @javax.validation.constraints.Email(message = "Email inválido, por favor, verifique")
    @NotBlank(message = "O email é obrigatório")
    @Column(unique = true, nullable = false, length = 100)
    private String endereco;

    @NotBlank(message = "Escreva um assunto")
    @Column(nullable = false, length = 255)
    private String assunto;

    @Column(nullable = false, length = 60)
    private String dataEnvio;

    public Email() {
        Instant diaEHoraAtual = Instant.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataEnvio = LocalDateTime.ofInstant(diaEHoraAtual, java.time.ZoneId.systemDefault()).format(fmt);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
