package br.unb.tppe.caso4;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalizadorIniciaisAgrupadas {

    private static final List<String> PARTICULAS =
            Arrays.asList("de", "da", "do", "das", "dos", "e");

    public boolean saoEquivalentes(String nome1, String nome2) {
        return chaveComparacao(nome1).equals(chaveComparacao(nome2));
    }

    public String unificar(String nomeAbreviado, String nomeCompleto) {
        if (!saoEquivalentes(nomeAbreviado, nomeCompleto)) {
            throw new IllegalArgumentException("Os nomes não são equivalentes");
        }
        return nomeCompleto.trim();
    }

    private String chaveComparacao(String nome) {
        return new GeradorChaveComparacao(nome, this).compute();
    }

    List<String> tokenizar(String nome) {
        String texto = Normalizer
                .normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .replace(".", " ")
                .replace(",", " ");

        List<String> tokens = new ArrayList<>();
        for (String token : texto.trim().split("\\s+")) {
            if (!token.isEmpty() && !PARTICULAS.contains(token)) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}
