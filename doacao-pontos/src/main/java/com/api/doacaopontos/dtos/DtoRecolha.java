package com.api.doacaopontos.dtos;

import com.api.doacaopontos.model.enuns.CategoriaItemEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoRecolha implements Serializable {

    @NotEmpty(message = "Preechimento Obrigatório")
    @Length(max = 120)
    private String nomeItem;

    @NotEmpty(message = "Preechimento Obrigatório")
    @Enumerated(EnumType.STRING)
    @Length(max = 30)
    private CategoriaItemEnum categoriaItem;

    @NotEmpty(message = "Preechimento Obrigatório")
    @Length(max = 15)
    private Long pontos;
}