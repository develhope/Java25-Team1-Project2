import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Metodi di Test: Ogni metodo di test è annotato con @Test e verifica una specifica funzionalità della classe Magazzino.
 * Setup Pulito: Il metodo setUp assicura che ogni test inizi con uno stato del magazzino ben definito.
 * Assert: Usa i metodi assert per verificare i risultati attesi, assicurando che il comportamento della classe sia conforme alle aspettative.
 */
public class MagazzinoTest {
    private Magazzino magazzino;
    private Prodotto prodotto1, prodotto2;

    /**
     * Metodo setUp: Annotato con @Before, questo metodo viene eseguito prima di ogni test per
     * inizializzare l'oggetto Magazzino e aggiungere alcuni prodotti.
     * Questo garantisce che ogni test inizi con uno stato pulito e prevedibile.
     */
    @Before
    public void setUp() {
        magazzino = new Magazzino("Magazzino Centrale", "Via Roma 1");

        prodotto1 = new Smartphone(ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Samsung Galaxy S8", "", new BigDecimal("599.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB", 12);
        prodotto2 = new Alimentare(ProdottoEnum.ALIMENTARE, "Cereali", "", new BigDecimal("4.99"), false, "2025-12-01", "Kellogs", 23);


        magazzino.aggiungiProdotto(prodotto1);
        magazzino.aggiungiProdotto(prodotto2);
    }

    /**
     * Test testAggiungiProdotto: Crea un nuovo prodotto (prodotto3),
     * lo aggiunge al magazzino e verifica che il magazzino ora contenga prodotto3 usando assertTrue.
     */
    @Test
    public void testAggiungiProdotto() {
        magazzino.aggiungiProdotto(prodotto1);

        assertTrue(magazzino.getListaProdottiMagazzino().containsKey(prodotto1));

        assertEquals(54, magazzino.getListaProdottiMagazzino().get(prodotto1).intValue());
    }

    /**
     * Test testRimuoviProdotto: Rimuove prodotto1 dal magazzino
     * e verifica che non sia più presente usando assertFalse.
     */
    @Test
    public void testRimuoviProdotto() {
        magazzino.aggiungiProdotto(prodotto1);

        magazzino.rimuoviProdotto(prodotto1);

        assertFalse(magazzino.getListaProdottiMagazzino().containsKey(prodotto1));
    }

    /**
     * Test testCercaPerTipoProdotto: Cerca prodotti di tipo ELETTRONICA e verifica che
     * la lista risultante contenga i due prodotti aggiunti inizialmente
     * e che la loro dimensione sia 2 usando assertEquals e assertTrue.
     */
    @Test
    public void testCercaPerTipoProdotto() {
        List<Prodotto> prodottiElettronica = magazzino.cercaPerTipoProdotto(ProdottoEnum.ELETTRONICA);

        assertEquals(2, prodottiElettronica.size());
        assertTrue(prodottiElettronica.contains(prodotto1));
        assertTrue(prodottiElettronica.contains(prodotto2));
    }

    /**
     * Test testRicercaPerPrezzoVendita: Cerca prodotti il
     * cui prezzo di vendita è vicino a 1100 euro e verifica che prodotto2 sia trovato.
     * Usa assertEquals per controllare la dimensione della lista
     * e assertTrue per verificare la presenza di prodotto2.
     */
    @Test
    public void testRicercaPerPrezzoVendita() {
        List<Prodotto> prodottiInRange = magazzino.ricercaPerPrezzoVendita(new BigDecimal("1100"));

        assertEquals(1, prodottiInRange.size());
        assertTrue(prodottiInRange.contains(prodotto2));
    }


}
