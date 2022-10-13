package br.com.sprint04.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link br.com.sprint04.model.Produto} entity
 */
@Data
public class ProdutoDto implements Serializable {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "A categoria do produto é obrigatória")
    private String categoria;
    @NotNull(message = "Insira um valor")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser superior a 0")
    @Digits(integer = 3, fraction = 2, message = "O valor deve não pode ser superior a 999.99")
    private BigDecimal preco;
}