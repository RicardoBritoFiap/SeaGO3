package com.fiap.seago.navios;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NavioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String nome;

    @NotBlank
    @Size(min = 1, max = 15)
    private String capacidade_carga;

    @NotBlank
    @Size(min = 1, max = 15)
    private String comprimento_navio;

    @NotBlank
    @Size(min = 1, max = 15)
    private String largura_navio;

    @NotBlank
    @Size(min = 1, max = 15)
    private String profundidade_navio;

    @NotBlank
    @Size(min = 1, max = 15)
    private String altura_navio;

    
    private LocalDate ultima_manutencao;
}