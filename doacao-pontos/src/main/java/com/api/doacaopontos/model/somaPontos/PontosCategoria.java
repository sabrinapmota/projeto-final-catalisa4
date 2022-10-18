package com.api.doacaopontos.model.somaPontos;

public class PontosCategoria implements PegarCategoriaEEstado {
    @Override
    public long categoria(String categoria) {
        if (categoria.equalsIgnoreCase("brinquedo"))
            return 10L;
        else if (categoria.equalsIgnoreCase("lazer")) {
            return 20L;
        } else if (categoria.equalsIgnoreCase("cozinha")){
            return 25L;
        } else if (categoria.equalsIgnoreCase("cama")){
            return 30L;
        } else if (categoria.equalsIgnoreCase("movel")){
            return 40L;
        } else if (categoria.equalsIgnoreCase("roupa")){
            return 25L;
        } else if (categoria.equalsIgnoreCase("eletrodomestico")){
            return 25L;
        }else {
            return 0L;
        }
    }
}


