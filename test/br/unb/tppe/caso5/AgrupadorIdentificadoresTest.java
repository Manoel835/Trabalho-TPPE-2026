package br.unb.tppe.caso5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgrupadorIdentificadoresTest {

    private AgrupadorIdentificadores agrupador;

    @BeforeEach
    public void setup() {
        agrupador = new AgrupadorIdentificadores();
    }

    @Test
    public void testeObterIdPrincipalListaDesordenada() {
        List<Integer> ids = Arrays.asList(31298, 433094, 549243, 608297, 746938);
        assertEquals(Integer.valueOf(31298), agrupador.obterIdPrincipal(ids));
    }

    @Test
    public void testeObterIdPrincipalComValoresNulos() {
        List<Integer> ids = Arrays.asList(500, null, 150, null, 200);
        assertEquals(Integer.valueOf(150), agrupador.obterIdPrincipal(ids));
    }

    @Test
    public void testeObterIdPrincipalListaVazia() {
        List<Integer> ids = Collections.emptyList();
        assertNull(agrupador.obterIdPrincipal(ids));
    }

   
    @Test
    public void testeNormalizarIdsTodosParaOMenor() {
        List<Integer> idsOriginais = Arrays.asList(31298, 433094, 549243, 608297, 746938);
        List<Integer> idsEsperados = Arrays.asList(31298, 31298, 31298, 31298, 31298);
        
        List<Integer> idsNormalizados = agrupador.normalizarIds(idsOriginais);
        
        assertEquals(idsEsperados, idsNormalizados);
    }
    
    @Test
    public void testeNormalizarIdsComNulos() {
        List<Integer> idsOriginais = Arrays.asList(200, null, 150);
   
        List<Integer> idsEsperados = Arrays.asList(150, null, 150);
        
        List<Integer> idsNormalizados = agrupador.normalizarIds(idsOriginais);
        
        assertEquals(idsEsperados, idsNormalizados);
    }
}