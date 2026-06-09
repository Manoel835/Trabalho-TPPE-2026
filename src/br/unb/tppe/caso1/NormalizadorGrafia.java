package br.unb.tppe.caso1;

import java.text.Normalizer;

public class NormalizadorGrafia {

    public boolean saoEquivalentes(String nome1, String nome2) {
        return chaveComparacao(nome1).equals(chaveComparacao(nome2));
    }

    public String unificar(String nome, String referenciaCorreta) {
        if (!saoEquivalentes(nome, referenciaCorreta)) {
            throw new IllegalArgumentException("Os nomes não são equivalentes");
        }

        return normalizarApostrofo(referenciaCorreta);
    }

    private String chaveComparacao(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        String texto = normalizarApostrofo(nome);

        texto = Normalizer
                .normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        return texto.toLowerCase().trim();
    }

    private String normalizarApostrofo(String nome) {
        return nome
                .replace("`", "'")
                .replace("´", "'")
                .replace("’", "'")
                .replace("‘", "'");
    }
}