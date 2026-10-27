package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    @Test
    public void deveRejeitarSenhaComMenosDe8Caracteres() {
        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("abc123");

        assertFalse(resultado.isValido());
        assertTrue(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    public void deveRejeitarSenhaComMenosDe2Digitos() {
        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("Abcdefgh");

        assertFalse(resultado.isValido());
        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    public void deveRejeitarSenhaSemLetraMaiuscula() {
        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("abcdefgh12!");

        assertFalse(resultado.isValido());
        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    public void deveRejeitarSenhaSemCaractereEspecial() {
        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("Abcdef12");

        assertFalse(resultado.isValido());
        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    public void deveRetornarTodosOsErrosQuandoSenhaForInvalida() {
        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("segredo");

        assertFalse(resultado.isValido());
        assertEquals(4, resultado.getErros().size());

        assertTrue(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"));

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"));

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos uma letra maiuscula"));

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    public void deveAceitarSenhaValida() {
        ValidadorSenha validador = new ValidadorSenha();

        ResultadoValidacao resultado = validador.validar("Segredo12!");

        assertTrue(resultado.isValido());
        assertTrue(resultado.getErros().isEmpty());
    }
}