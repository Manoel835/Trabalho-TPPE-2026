package br.unb.tppe.caso3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("caso3")
class NormalizadorParticulasTest {

    private final NormalizadorParticulas normalizador = new NormalizadorParticulas();

    @ParameterizedTest
    @CsvSource({
            "Ana de Mattos Seabra, Ana Mattos Seabra",
            "Cassius de Souza, Cassius Souza",
            "Maria das Graças Silva, Maria Graças Silva",
            "Souza C., Souza C",
            "A. M. Seabra, A M Seabra"
    })
    void deveIdentificarNomesComOuSemParticulasEPontosComoEquivalentes(String nomeCompleto, String nomeOmitido) {
        assertTrue(normalizador.saoEquivalentes(nomeCompleto, nomeOmitido));
    }

    @ParameterizedTest
    @CsvSource({
            "Ana Mattos Seabra, Ana de Mattos Seabra, Ana de Mattos Seabra",
            "Cassius Souza, Cassius de Souza, Cassius de Souza",
            "Souza C, Souza C., Souza C."
    })
    void deveUnificarParaAReferenciaCorreta(String variante, String referenciaCorreta, String esperado) {
        assertEquals(esperado, normalizador.unificar(variante, referenciaCorreta));
    }

    @Test
    void deveDiferenciarAutoresDiferentes() {
        assertFalse(normalizador.saoEquivalentes("Ana de Mattos", "Cassius de Souza"));
    }

    @Test
    void deveLancarExcecaoAoUnificarNomesNaoEquivalentes() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.unificar("Ana Mattos", "Cassius de Souza")
        );
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.saoEquivalentes(null, "Ana de Mattos")
        );
    }
}
