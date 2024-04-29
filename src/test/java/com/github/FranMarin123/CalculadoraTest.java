package com.github.FranMarin123;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplicacion")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(0, miCalculadora.multiplica(5, 0));
        assertEquals(16, miCalculadora.multiplica(4, 4));
        assertEquals(-5, miCalculadora.multiplica(-5, 1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws OperacionInvalidaException {
        assertEquals(2, miCalculadora.divide(4, 2));
        assertEquals(2.5, miCalculadora.divide(10, 4));
        assertEquals(4, miCalculadora.divide(10, 2.5));
        assertEquals(3.2, miCalculadora.divide(8, 2.5));
        assertEquals(0.5, miCalculadora.divide(2, 4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws OperacionInvalidaException {
        assertTrue(miCalculadora.divide(4, 2) > 0);
        assertTrue(miCalculadora.divide(4, -2) < 0);
        assertTrue(miCalculadora.divide(-4, 2) < 0);
        assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        OperacionInvalidaException thrown = assertThrows(OperacionInvalidaException.class, () -> {
            miCalculadora.divide(5, 0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Suma dos numeros")
    void testSuma() {
        assertEquals(9, miCalculadora.suma(4, 5));
        assertEquals(7, miCalculadora.suma(5, 2));
        assertEquals(2, miCalculadora.suma(4, -2));
        assertEquals(-3, miCalculadora.suma(-1, -2));
    }

    @Test
    @DisplayName("Resta dos numeros")
    void testResta() {
        assertEquals(5, miCalculadora.resta(10, 5));
        assertEquals(-1, miCalculadora.resta(1, 2));
        assertEquals(6, miCalculadora.resta(4, -2));
        assertEquals(1, miCalculadora.resta(2, 1));
    }

    @Test
    @DisplayName("Potencia")
    void testPotencia() {
        assertEquals(8, miCalculadora.potencia(2, 3));
        assertEquals(1, miCalculadora.potencia(1, 2));
        assertEquals(1, miCalculadora.potencia(4, 0));
        assertEquals(2, miCalculadora.potencia(2, 1));
    }

    @Test
    @DisplayName("Raiz Cuadrada")
    void testRaizCuadrada() throws OperacionInvalidaException {
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
        assertEquals(2, miCalculadora.raizCuadrada(4));
        OperacionInvalidaException thrown = assertThrows(OperacionInvalidaException.class, () -> {
            miCalculadora.raizCuadrada(-1);
        });
        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }
}
