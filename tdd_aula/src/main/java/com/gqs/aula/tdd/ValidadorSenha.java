package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        int quantidadeDigitos = 0;
        boolean temLetraMaiuscula = false;
        boolean temCaractereEspecial = false;

        for (char caractere : senha.toCharArray()) {

            if (Character.isDigit(caractere)) {
                quantidadeDigitos++;
            }

            if (Character.isUpperCase(caractere)) {
                temLetraMaiuscula = true;
            }

            if (!Character.isLetterOrDigit(caractere)) {
                temCaractereEspecial = true;
            }
        }

        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        if (!temLetraMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        if (!temCaractereEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        boolean valido = erros.isEmpty();

        return new ResultadoValidacao(valido, erros);
    }
}