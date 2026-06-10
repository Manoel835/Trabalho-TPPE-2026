package br.unb.tppe.caso4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("caso4")
class NormalizadorIniciaisAgrupadasTest {

    private final NormalizadorIniciaisAgrupadas normalizador = new NormalizadorIniciaisAgrupadas();

    @ParameterizedTest
    @CsvSource({
            "Vanilda Cristina Junior, VC Junior",
            "Sérgio Henrique Guaraldi, SH Guaraldi",
            "Maria Cecília Silva, MC Silva",
            "Luiz Felipe Barbosa, LF Barbosa",
            "Paulo Roberto Costa, PR Costa"
    })
    void deveIdentificarFormaCompletaEIniciaisAgrupadasComoEquivalentes(String completo, String abreviado) {
        assertTrue(normalizador.saoEquivalentes(completo, abreviado));
    }

    @ParameterizedTest
    @CsvSource({
            "VC Junior, Vanilda Cristina Junior, Vanilda Cristina Junior",
            "SH Guaraldi, Sérgio Henrique Guaraldi, Sérgio Henrique Guaraldi",
            "MC Silva, Maria Cecília Silva, Maria Cecília Silva"
    })
    void deveUnificarParaAFormaCompleta(String abreviado, String completo, String esperado) {
        assertEquals(esperado, normalizador.unificar(abreviado, completo));
    }

    @Test
    void deveDiferenciarAutoresDiferentes() {
        assertFalse(normalizador.saoEquivalentes("Vanilda Cristina Junior", "SH Guaraldi"));
        assertFalse(normalizador.saoEquivalentes("MC Silva", "LF Barbosa"));
    }

    @Test
    void deveLancarExcecaoAoUnificarNomesNaoEquivalentes() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.unificar("VC Junior", "Sérgio Henrique Guaraldi")
        );
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.saoEquivalentes(null, "VC Junior")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> normalizador.saoEquivalentes("VC Junior", "")
        );
    }
}