package br.unb.tppe.caso3;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TokenizadorSemParticulas {

    private static final List<String> PARTICULAS =
            Arrays.asList("de", "da", "do", "das", "dos", "e");

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