package com.api.doacaopontos.dtos;

import com.api.doacaopontos.model.enuns.CategoriaItemEnum;
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
public class DtoRecolha implements Serializable {

    @NotEmpty(message = "Preechimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 Caracteres")
    private String nomeItem;

    @NotEmpty(message = "Preechimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 Caracteres")
    private CategoriaItemEnum categoria;

    @NotEmpty(message = "Preechimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 Caracteres")
    private Long pontos;
}