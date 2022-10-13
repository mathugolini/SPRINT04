package br.com.sprint04.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Produto implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	   
	@NotBlank(message = "O nome é obrigatório")
	@Column(unique = true, nullable = false, length = 100)
	private String nome;
	
    @NotBlank(message = "A categoria do produto é obrigatória")
    @Column(nullable = false, length = 255)
    private String categoria;
    
    @NotNull(message = "Insira um valor")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser superior a 0")
    @Digits(integer=3, fraction=2, message = "O valor deve não pode ser superior a 999.99")
    @Column(nullable = false)
    private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

    
    
    
}
