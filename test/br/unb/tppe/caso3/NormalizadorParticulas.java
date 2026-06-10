package br.unb.tppe.caso3;



import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalizadorParticulas {

    // Lista padronizada de partículas a serem ignoradas na comparação
    private static final List<String> PARTICULAS =
            Arrays.asList("de", "da", "do", "das", "dos", "e");

    public boolean saoEquivalentes(String nome1, String nome2) {
        return chaveComparacao(nome1).equals(chaveComparacao(nome2));
    }

    public String unificar(String variante, String referenciaCorreta) {
        if (!saoEquivalentes(variante, referenciaCorreta)) {
            throw new IllegalArgumentException("Os nomes não são equivalentes");
        }
        // Retorna a referência que contém as partículas e pontos corretos
        return referenciaCorreta.trim();
    }

    private String chaveComparacao(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        List<String> tokens = tokenizar(nome);
        return String.join(" ", tokens);
    }

    private List<String> tokenizar(String nome) {
        // Remove acentos, transforma em minúsculas e substitui pontos/vírgulas por espaço
        String texto = Normalizer
                .normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .replace(".", " ")
                .replace(",", " ");

        List<String> tokens = new ArrayList<>();
        // Divide pelos espaços e filtra as partículas
        for (String token : texto.trim().split("\\s+")) {
            if (!token.isEmpty() && !PARTICULAS.contains(token)) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}