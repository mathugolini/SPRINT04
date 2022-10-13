package br.com.sprint04.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sprint04.model.Produto;
import br.com.sprint04.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final ProdutoService service;
	
	public ProdutoController(ProdutoService service) {
		this.service = service;
	}
	
	@GetMapping("/listar")
    public ModelAndView listarProduto(ModelMap model){
        model.addAttribute("produtos", service.findAll());
        return new ModelAndView("listaProduto", model);
	}
	
    @GetMapping
    public ModelAndView cadastrarProduto(ModelMap model){
        model.addAttribute("produto", new Produto());
        return new ModelAndView("produto", model);
    }
    

    @PostMapping()
    public String salvarProduto(@Valid @ModelAttribute Produto produto,
                              BindingResult result,
                              RedirectAttributes attr){

        if (result.hasErrors()) {
            return "produto";
        }

        if (produto.getId() == null) {
            service.saveProduto(produto);
            attr.addFlashAttribute("feedback", "Produto cadastrado com sucesso.");
        }

        return "redirect:/produtos";
    }
	

}
