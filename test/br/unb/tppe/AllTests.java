package br.unb.tppe;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Deduplicacao de Autores - Todos os Casos")
@SelectPackages({
        "br.unb.tppe.caso1",
        "br.unb.tppe.caso2",
        "br.unb.tppe.caso3",
        "br.unb.tppe.caso4",
        "br.unb.tppe.caso5"
})
public class AllTests {
}
