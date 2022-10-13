package br.com.sprint04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sprint04.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}

