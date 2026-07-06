package br.unb.tppe.caso2;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalizadorIniciais {

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
        validarNome(nome);
        List<String> tokens = tokenizar(nome);
        List<String> nomesCompletos = new ArrayList<>();
        List<String> iniciais = new ArrayList<>();
        separarTokensEmNomesEIniciais(tokens, nomesCompletos, iniciais);
        return montarChaveDeComparacao(nomesCompletos, iniciais);
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    private void separarTokensEmNomesEIniciais(
            List<String> tokens,
            List<String> nomesCompletos,
            List<String> iniciais) {
        for (String token : tokens) {
            if (token.length() == 1) {
                iniciais.add(token);
            } else {
                nomesCompletos.add(token);
            }
        }
    }

    private String montarChaveDeComparacao(List<String> nomesCompletos, List<String> iniciais) {
        String sobrenome;
        List<String> iniciaisDosNomes;

        if (!iniciais.isEmpty()) {
            sobrenome = String.join(" ", nomesCompletos);
            iniciaisDosNomes = iniciais;
        } else {
            sobrenome = nomesCompletos.get(nomesCompletos.size() - 1);
            iniciaisDosNomes = extrairIniciaisDosNomesCompletos(nomesCompletos);
        }

        return sobrenome + "|" + String.join("", iniciaisDosNomes);
    }

    private List<String> extrairIniciaisDosNomesCompletos(List<String> nomesCompletos) {
        List<String> iniciaisDosNomes = new ArrayList<>();
        for (int i = 0; i < nomesCompletos.size() - 1; i++) {
            iniciaisDosNomes.add(nomesCompletos.get(i).substring(0, 1));
        }
        return iniciaisDosNomes;
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
