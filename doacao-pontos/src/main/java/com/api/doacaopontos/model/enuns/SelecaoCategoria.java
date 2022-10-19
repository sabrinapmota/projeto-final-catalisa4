package com.api.doacaopontos.model.enuns;

public class SelecaoCategoria {

    public String categoria(String categoria) {
        if (categoria.equalsIgnoreCase("lazer")) {
            return String.valueOf(CategoriaItemEnum.LAZER);
        } else if (categoria.equalsIgnoreCase("brinquedo")) {
            return String.valueOf(CategoriaItemEnum.BRINQUEDO);
        } else if (categoria.equalsIgnoreCase("cama")) {
            return String.valueOf(CategoriaItemEnum.CAMA);
        } else if (categoria.equalsIgnoreCase("movel")) {
            return String.valueOf(CategoriaItemEnum.MOVEL);
        } else if (categoria.equalsIgnoreCase("roupa")) {
            return String.valueOf(CategoriaItemEnum.ROUPA);
        } else if (categoria.equalsIgnoreCase("eletrodomestico")) {
            return String.valueOf(CategoriaItemEnum.ELETRODOMESTICO);
        } else if (categoria.equalsIgnoreCase("cozinha")) {
            return String.valueOf(CategoriaItemEnum.COZINHA);
        } else {
            return "OUTROS";
        }
    }
}
