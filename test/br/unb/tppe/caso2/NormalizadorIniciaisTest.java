package br.unb.tppe.caso2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("caso2")
class NormalizadorIniciaisTest {

    private final NormalizadorIniciais normalizador = new NormalizadorIniciais();

    @ParameterizedTest
    @CsvSource({
            "Ana de Mattos Seabra, Seabra A M",
            "Ana de Mattos Seabra, Seabra A. M.",
            "Cassius de Souza, Souza C.",
            "Cassius de Souza, Souza C",
            "Veronica de Oliveira Moreira, Moreira V O"
    })
    void deveIdentificarFormaCompletaEAbreviadaComoEquivalentes(String completo, String abreviado) {
        assertTrue(normalizador.saoEquivalentes(completo, abreviado));
    }

    @ParameterizedTest
    @CsvSource({
            "Souza C., Cassius de Souza, Cassius de Souza",
            "Seabra A M, Ana de Mattos Seabra, Ana de Mattos Seabra"
    })
    void deveUnificarParaAFormaCompleta(String abreviado, String completo, String esperado) {
        assertEquals(esperado, normalizador.unificar(abreviado, completo));
    }

    @Test
    void deveDiferenciarAutoresDiferentes() {
        assertFalse(normalizador.saoEquivalentes("Cassius de Souza", "Seabra A M"));
    }

    @Test
    void deveLancarExcecaoAoUnificarNomesNaoEquivalentes() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.unificar("Souza C.", "Ana de Mattos Seabra")
        );
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.saoEquivalentes(null, "Cassius de Souza")
        );
    }
}
