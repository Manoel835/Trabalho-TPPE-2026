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
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        List<String> tokens = tokenizar(nome);

        if (tokens.size() < 2) {
            return tokens.isEmpty() ? "" : tokens.get(0);
        }

        String sobrenome = tokens.get(tokens.size() - 1);
        
        List<String> nomesOuIniciais = tokens.subList(0, tokens.size() - 1);

        StringBuilder iniciais = new StringBuilder();

        if (nomesOuIniciais.size() == 1 && nomesOuIniciais.get(0).length() <= 3) {
            iniciais.append(nomesOuIniciais.get(0));
        } else {
            for (String n : nomesOuIniciais) {
                iniciais.append(n.charAt(0));
            }
        }

        return sobrenome + "|" + iniciais.toString();
    }

    private List<String> tokenizar(String nome) {
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