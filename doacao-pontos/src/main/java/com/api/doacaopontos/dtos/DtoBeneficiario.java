package com.api.doacaopontos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoBeneficiario {

    private String nomeBeneficiario;
    private String enderecoBeneficiario;
    private String bairroBeneficiario;
    private String emailBeneficiario;

}
