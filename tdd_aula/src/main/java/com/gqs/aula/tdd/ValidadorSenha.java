package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public List<String> validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        int quantidadeDigitos = 0;

        for (char caractere : senha.toCharArray()) {
            if (Character.isDigit(caractere)) {
                quantidadeDigitos++;
            }
        }

        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        boolean temLetraMaiuscula = false;

        for (char caractere : senha.toCharArray()) {
            if (Character.isUpperCase(caractere)) {
                temLetraMaiuscula = true;
            }
        }

        if (!temLetraMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        return erros;
    }
}