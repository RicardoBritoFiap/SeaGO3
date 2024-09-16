package com.fiap.synthia.empresa.token;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AuthController {
    
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Mostrar a página de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Nome da página Thymeleaf para login
    }

    // Processar o login
    @PostMapping("/login")
    public String login(@ModelAttribute Credentials credentials, Model model) {
        try {
            Token token = authService.login(credentials);
            // Adicionar lógica para armazenar token em sessão ou cookies, se necessário
            return "redirect:/home"; // Redirecionar para uma página inicial após login
        } catch (RuntimeException e) {
            model.addAttribute("loginError", true);
            return "login"; // Retornar à página de login se houver erro
        }
    }

    // Exibir a página home
    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Nome da página Thymeleaf para home
    }
}


