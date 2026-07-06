package br.unb.tppe.caso4;

import java.util.List;

class GeradorChaveComparacao {

    private final String nome;
    private final NormalizadorIniciaisAgrupadas normalizador;
    private List<String> tokens;
    private String sobrenome;
    private List<String> nomesOuIniciais;
    private StringBuilder iniciais;

    GeradorChaveComparacao(String nome, NormalizadorIniciaisAgrupadas normalizador) {
        this.nome = nome;
        this.normalizador = normalizador;
    }

    String compute() {
        validarNome();
        tokenizarNome();
        if (tokens.size() < 2) {
            return tokens.isEmpty() ? "" : tokens.get(0);
        }
        extrairSobrenome();
        extrairIniciais();
        return montarChave();
    }

    private void validarNome() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    private void tokenizarNome() {
        tokens = normalizador.tokenizar(nome);
    }

    private void extrairSobrenome() {
        sobrenome = tokens.get(tokens.size() - 1);
        nomesOuIniciais = tokens.subList(0, tokens.size() - 1);
    }

    private void extrairIniciais() {
        iniciais = new StringBuilder();

        if (nomesOuIniciais.size() == 1 && nomesOuIniciais.get(0).length() <= 3) {
            iniciais.append(nomesOuIniciais.get(0));
        } else {
            for (String n : nomesOuIniciais) {
                iniciais.append(n.charAt(0));
            }
        }
    }

    private String montarChave() {
        return sobrenome + "|" + iniciais.toString();
    }
}