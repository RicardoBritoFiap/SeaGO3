package com.fiap.synthia.dadosempresa;

import com.fiap.synthia.dadosempresa.DadosModel;
import com.fiap.synthia.dadosempresa.DadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private DadosRepository dadosRepository;

    // Exibir a página de cadastro de dados
    @GetMapping("/form")
    public String showDadosForm(Model model) {
        model.addAttribute("dados", new DadosModel());
        return "dados-form"; // Nome da página Thymeleaf para cadastro de dados
    }

    // Processar o cadastro de dados
    @PostMapping
    public String createDados(@ModelAttribute DadosModel dados, BindingResult result) {
        if (result.hasErrors()) {
            return "dados-form";
        }
        dadosRepository.save(dados);
        return "redirect:/dados"; // Redirecionar para a lista de dados
    }

    // Exibir a lista de dados
    @GetMapping
    public String listDados(Model model) {
        model.addAttribute("dadosList", dadosRepository.findAll());
        return "dados-list"; // Nome da página Thymeleaf para visualização de dados
    }
}
