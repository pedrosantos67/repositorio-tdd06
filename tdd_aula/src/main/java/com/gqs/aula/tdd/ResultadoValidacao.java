package com.gqs.aula.tdd;

import java.util.List;

public class ResultadoValidacao {

    private final boolean valido;
    private final List<String> erros;

    public ResultadoValidacao(boolean valido, List<String> erros) {
        this.valido = valido;
        this.erros = erros;
    }

    public boolean isValido() {
        return valido;
    }

    public List<String> getErros() {
        return erros;
    }
}