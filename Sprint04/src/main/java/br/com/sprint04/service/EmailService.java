package br.com.sprint04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sprint04.model.Email;
import br.com.sprint04.model.Produto;
import br.com.sprint04.repository.EmailRepository;

@Service
public class EmailService {

    private final EmailRepository repository;

    public EmailService(EmailRepository repository) {
        this.repository = repository;
    }

    public void saveEmail(Email email) {
        repository.save(email);
    }

    public Email findEmailById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Email não encontrado")
        );
    }
    
	public List<Email>findAll() {
		return repository.findAll();
	}
    
}
