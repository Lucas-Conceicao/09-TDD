package br.com.exemplo.calculadora;

import br.com.example.calculadora.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Classe Calculadora")
public class CalculadoraTeste {
    private Calculadora calc;

    // @BeforeEach garante que um novo objeto 'calc' seja criado antes de CADA teste
    @BeforeEach
    void setup(){
        calc = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois números positivos corretamente")
    void somar_numerosPositivos_retornaSomaCorreta() {
        int a = 4;
        int b = 2;
        int esperado = 6;
        int resultado = calc.somar(a, b);
        assertEquals(esperado, resultado, "4 + 2 deveria ser 6");
    }

    @Test
    @DisplayName("Deve somar um número positivo e um negativo")
    void somar_positivoComNegativo_retornaSomaCorreta() {
        int a = 10;
        int b = -3;
        int esperado = 7;
        int resultado = calc.somar(a, b);
        assertEquals(esperado, resultado, "10 + (-3) deveria ser 7");
    }

    @Test
    @DisplayName("Deve somar com zero")
    void somar_comZero_retornaProprioNumero() {
        int a = 5;
        int b = 0;
        int esperado = 5;
        int resultado = calc.somar(a, b);
        assertEquals(esperado, resultado, "5 + 0 deveria ser 5");
    }
    @Test
    @DisplayName("Deve subtrair dois números positivos")
    void subtrair_numerosPositivos_retornaSubtracao() {
        int a = 10;
        int b = 4;
        int esperado = 6;
        int resultado = calc.subtrair(a, b);
        assertEquals(esperado, resultado, "10 - 4 deveria ser 6");
    }

    @Test
    @DisplayName("Deve subtrair resultando em número negativo")
    void subtrair_resultandoEmNegativo_retornaValorNegativo() {
        int a = 5;
        int b = 10;
        int esperado = -5;
        int resultado = calc.subtrair(a, b);
        assertEquals(esperado, resultado, "5 - 10 deveria ser -5");
    }

    @Test
    @DisplayName("Deve subtrair zero")
    void subtrair_zero_retornaProprioNumero() {
        int a = 7;
        int b = 0;
        int esperado = 7;
        int resultado = calc.subtrair(a, b);
        assertEquals(esperado, resultado, "7 - 0 deveria ser 7");
    }

    // --- Testes para o método MULTIPLICAR (conforme README 5.7) ---

    @Test
    @DisplayName("Deve multiplicar dois números positivos")
    void multiplicar_numerosPositivos_retornaProduto() {
        int a = 3;
        int b = 4;
        int esperado = 12;
        int resultado = calc.multiplicar(a, b);
        assertEquals(esperado, resultado, "3 * 4 deveria ser 12");
    }

    @Test
    @DisplayName("Deve multiplicar por zero")
    void multiplicar_porZero_retornaZero() {
        int a = 9;
        int b = 0;
        int esperado = 0;
        int resultado = calc.multiplicar(a, b);
        assertEquals(esperado, resultado, "9 * 0 deveria ser 0");
    }

    @Test
    @DisplayName("Deve multiplicar dois números negativos")
    void multiplicar_doisNumerosNegativos_retornaPositivo() {
        int a = -5;
        int b = -3;
        int esperado = 15;
        int resultado = calc.multiplicar(a, b);
        assertEquals(esperado, resultado, "(-5) * (-3) deveria ser 15");
    }

    @Test
    @DisplayName("Deve fazer divisão exata")
    void dividir_divisaoExata_retornaResultadoCorreto() {
        int a = 10;
        int b = 2;
        double esperado = 5.0;
        double resultado = calc.dividir(a, b);
        assertEquals(esperado, resultado, "10 / 2 deveria ser 5.0");
    }

    @Test
    @DisplayName("Deve fazer divisão com resultado decimal")
    void dividir_divisaoComDecimal_retornaResultadoCorreto() {
        int a = 5;
        int b = 2;
        double esperado = 2.5;
        double resultado = calc.dividir(a, b);
        assertEquals(esperado, resultado, "5 / 2 deveria ser 2.5");
    }

    @Test
    @DisplayName("Dividir por zero deve lançar IllegalArgumentException")
    void dividir_porZero_deveLancarExcecao() {
        int numerador = 10;
        int divisorZero = 0;
        // ACT & ASSERT (Testando exceções)
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calc.dividir(numerador, divisorZero), // A ação é executada aqui dentro
                "Divisão por zero deve lançar IllegalArgumentException"
        );

        // ASSERT adicional: verificar mensagem da exceção
        assertTrue(exception.getMessage().contains("zero"),
                "Mensagem da exceção deve mencionar 'zero'");
    }
}