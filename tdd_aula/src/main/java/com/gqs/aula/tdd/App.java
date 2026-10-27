package com.gqs.aula.tdd;

public class App {

    public static void main(String[] args) {

        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("segredo");

        System.out.println("Senha: segredo");
        System.out.println();

        if (resultado.isValido()) {
            System.out.println("Senha válida!");
        } else {
            System.out.println("Senha inválida!");
            System.out.println("Erros:");

            for (String erro : resultado.getErros()) {
                System.out.println("- " + erro);
            }
        }
    }
}
