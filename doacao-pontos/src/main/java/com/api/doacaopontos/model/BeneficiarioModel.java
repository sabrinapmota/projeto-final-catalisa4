package com.api.doacaopontos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Beneficiario")

public class BeneficiarioModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome", length = 50, nullable = false)
        private String nomeBeneficiario;

        @Column(name = "cpf", nullable = false)
        @CPF
        private String cpfBeneficiario;

        @Column
        private LocalDate nascimentoBeneficiario;

        @Column(name = "endereco", length = 50, nullable = false)
        private String enderecoBeneficiario;

        @Column(name = "bairro", length = 50, nullable = false)
        private String bairroBeneficiario;

        @Column(name = "cep", length = 50, nullable = false)
        private String cepBeneficiario;

        @Column(name = "email", length = 50, nullable = false)
        @Email
        private String emailBeneficiario;

        @Column(name = "telefone", length = 15, nullable = false)
        private String telefoneBeneficiario;





}
