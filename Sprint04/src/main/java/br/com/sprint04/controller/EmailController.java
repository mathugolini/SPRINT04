package br.com.sprint04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sprint04.model.Email;
import br.com.sprint04.service.EmailService;

import javax.validation.Valid;

@Controller
@RequestMapping("/emails")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }
    
	
	@GetMapping("/listar")
    public ModelAndView listarEmail(ModelMap model){
        model.addAttribute("emails", service.findAll());
        return new ModelAndView("listaEmail", model);
	}

    @GetMapping
    public ModelAndView cadastrarEmail(ModelMap model){
        model.addAttribute("email", new Email());
        return new ModelAndView("email", model);
    }

    @PostMapping
    public String salvarEmail(@Valid @ModelAttribute Email email,
                              BindingResult result,
                              RedirectAttributes attr){

        if (result.hasErrors()) {
            return "email";
        }

        if (email.getId() == null) {
            service.saveEmail(email);
            attr.addFlashAttribute("feedback", "Email cadastrado com sucesso.");
        }

        return "redirect:/emails";
    }
}
