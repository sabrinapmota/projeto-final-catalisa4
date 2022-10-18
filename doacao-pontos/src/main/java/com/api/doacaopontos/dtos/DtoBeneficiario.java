package com.api.doacaopontos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoBeneficiario implements Serializable {

    @NotEmpty(message="Preechimento Obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 Caracteres")
    private String nomeBeneficiario;

    @NotEmpty(message="Preechimento Obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 Caracteres")
    private String enderecoBeneficiario;

    @NotEmpty(message="Preechimento Obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 Caracteres")
    private String bairroBeneficiario;

    @NotEmpty(message="Preechimento Obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 Caracteres")
    private String emailBeneficiario;

}
