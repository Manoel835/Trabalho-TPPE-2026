package br.unb.tppe.caso3;

import java.util.List;

public class NormalizadorParticulas {

    private final TokenizadorSemParticulas tokenizador = new TokenizadorSemParticulas();

    public boolean saoEquivalentes(String nome1, String nome2) {
        return chaveComparacao(nome1).equals(chaveComparacao(nome2));
    }

    public String unificar(String variante, String referenciaCorreta) {
        if (!saoEquivalentes(variante, referenciaCorreta)) {
            throw new IllegalArgumentException("Os nomes não são equivalentes");
        }
        return referenciaCorreta.trim();
    }

    private String chaveComparacao(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        List<String> tokens = tokenizador.tokenizar(nome);
        return String.join(" ", tokens);
    }
}
