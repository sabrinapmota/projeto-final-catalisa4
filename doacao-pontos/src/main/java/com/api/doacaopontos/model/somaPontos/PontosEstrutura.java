package com.api.doacaopontos.model.somaPontos;

public class PontosEstrutura implements PegarCategoriaEEstado {
    @Override
    public long categoria(String categoria) {
        if (categoria.equalsIgnoreCase("ok"))
            return 10L;
        else if (categoria.equalsIgnoreCase("bom")) {
            return 20L;
        }
        else if (categoria.equalsIgnoreCase("excelente")){
            return 30;
        }else {
            return 0L;
        }
    }
}

