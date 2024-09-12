package com.fiap.seago.navios;


import com.fiap.seago.empresa.user.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "NAVIOS")
@AllArgsConstructor
@NoArgsConstructor
public class NavioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "navios_seq_gen")
    @SequenceGenerator(name = "navios_seq_gen", sequenceName = "navios_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @NotBlank
    @Size(min = 1, max = 50)
    private String capacidade_carga;

    @ManyToOne
    private UserModel usermodel;
}