package br.unb.tppe.caso5;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AgrupadorIdentificadores {

    public Integer obterIdPrincipal(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return null;
        }
        
        return ids.stream()
                  .filter(Objects::nonNull)
                  .min(Integer::compareTo)
                  .orElse(null);
    }
    
    
    public List<Integer> normalizarIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return ids;
        }
        
        Integer idPrincipal = obterIdPrincipal(ids);
        
        if (idPrincipal == null) {
            return ids;
        }
        
        return ids.stream()
                  .map(id -> id != null ? idPrincipal : null)
                  .collect(Collectors.toList());
    }
}