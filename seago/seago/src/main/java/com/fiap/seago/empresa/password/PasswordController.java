package com.fiap.seago.empresa.password;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pass")
@RestController
public class PasswordController {
    @Autowired
    private PasswordService service;

    @GetMapping
    public List<PasswordModel> getAll(){
        return service.getAll();
    }
}