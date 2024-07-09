import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class MagazzinoTest {
    private Magazzino magazzino;
    private Prodotto prodotto1, prodotto2;

    @Before
    public void setUp() {
        magazzino = new Magazzino("Magazzino Centrale", "Via Roma 1");

        prodotto1 = new Prodotto(ProdottoEnum.ELETTRONICA, "Samsung Galaxy S8", "", new BigDecimal("599.99"), 12);
        prodotto2 = new Prodotto(ProdottoEnum.ALIMENTARE, "Cereali", "", new BigDecimal("4.99"), 23);

        magazzino.aggiungiProdotto(prodotto1, 12);
        magazzino.aggiungiProdotto(prodotto2, 23);
    }

    @Test
    public void testAggiungiProdotto() {
        Prodotto prodotto3 = new Prodotto(ProdottoEnum.ELETTRONICA, "iPhone X", "", new BigDecimal("999.99"), 10);
        magazzino.aggiungiProdotto(prodotto3, 10);

        assertTrue(magazzino.getListaProdottiMagazzino().containsKey(prodotto3));
        assertEquals(10, magazzino.getListaProdottiMagazzino().get(prodotto3).intValue());
    }

    @Test
    public void testRimuoviProdotto() {
        magazzino.rimuoviProdotto(prodotto1, 12);

        assertFalse(magazzino.getListaProdottiMagazzino().containsKey(prodotto1));
    }

    @Test
    public void testCercaPerTipoProdotto() {
        List<Prodotto> prodottiElettronica = magazzino.cercaPerTipoProdotto(ProdottoEnum.ELETTRONICA);

        assertEquals(1, prodottiElettronica.size());
        assertTrue(prodottiElettronica.contains(prodotto1));
    }

    @Test
    public void testRicercaPerPrezzoVendita() {
        List<Prodotto> prodottiInRange = magazzino.ricercaPerPrezzoVendita(new BigDecimal("50"));

        assertEquals(1, prodottiInRange.size());
        assertTrue(prodottiInRange.contains(prodotto2));
    }
}
