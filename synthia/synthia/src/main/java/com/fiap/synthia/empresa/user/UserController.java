package com.fiap.synthia.empresa.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    // Mostrar a página de registro
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "register"; // Nome da página Thymeleaf para registro
    }

    // Processar a requisição de cadastro
    @PostMapping
    public String createUser(@ModelAttribute @Valid UserModel user, BindingResult result) {
        if (result.hasErrors()) {
            return "register"; // Voltar para a página de registro se houver erros
        }
        repository.save(user);
        return "redirect:/login"; // Redirecionar para a página de login após o cadastro
    }

    // Exibir um usuário específico pelo ID
    @GetMapping("{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> users = repository.findAll();
        return ResponseEntity.ok(users);
    }

    // Atualizar um usuário existente
    @PutMapping("{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel user) {
        verificarseexisteUser(id);
        user.setId(id);
        repository.save(user);
        return ResponseEntity.ok(user);
    }

    // Deletar um usuário pelo ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        verificarseexisteUser(id);
        repository.deleteById(id);
        return ResponseEntity.ok("User deletado com sucesso");
    }

    // Método auxiliar para verificar se o usuário existe
    private void verificarseexisteUser(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "id do User não encontrado"));
    }
}
