package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ValidadorSenhaTest {

    @Test
    public void deveRejeitarSenhaComMenosDe8Caracteres() {
        ValidadorSenha validador = new ValidadorSenha();

        List<String> resultado = validador.validar("abc123");

        assertFalse(resultado.isEmpty());
        assertTrue(resultado.contains(
                "A senha deve ter pelo menos 8 caracteres"));
    }
}