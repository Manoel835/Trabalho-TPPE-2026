package br.unb.tppe.caso1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalizadorGrafiaTest {

    private final NormalizadorGrafia normalizador = new NormalizadorGrafia();

    @Test
    void deveIdentificarNomesComAcentuacaoDiferenteComoEquivalentes() {
        assertTrue(normalizador.saoEquivalentes(
                "Sergio Henrique Guaraldi",
                "Sérgio Henrique Guaraldi"
        ));
    }

    @Test
    void deveIdentificarApostrofosDiferentesComoEquivalentes() {
        assertTrue(normalizador.saoEquivalentes(
                "Monica Hirata Sant`anna",
                "Mônica Hirata Sant'anna"
        ));
    }

    @Test
    void deveUnificarParaReferenciaCorreta() {
        String resultado = normalizador.unificar(
                "Monica Hirata Sant`anna",
                "Mônica Hirata Sant'anna"
        );

        assertEquals("Mônica Hirata Sant'anna", resultado);
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.saoEquivalentes(null, "Ana")
        );
    }
}