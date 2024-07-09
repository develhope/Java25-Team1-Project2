import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;

public class CarrelloTest {

    private Carrello carrello;
    private Prodotto prodotto1;
    private Prodotto prodotto2;

    /**
     * Metodi di Test: Ogni metodo di test è annotato con @Test e verifica una specifica funzionalità della classe Carrello.
     * Setup Pulito: Il metodo setUp assicura che ogni test inizi con uno stato del magazzino ben definito.
     * Assert: Usa i metodi assert per verificare i risultati attesi, assicurando che il comportamento della classe sia conforme alle aspettative.
     */
    @BeforeEach
    public void setUp() {
        carrello = new Carrello();
        prodotto1 = new Prodotto(ProdottoEnum.CEREALI, "Cereali Kellogs", "Deliziosi cereali", new BigDecimal("4.99"),23);
        prodotto2 = new Prodotto(ProdottoEnum.GELATO, "Maxi-Bon", "Gelato al cioccolato", new BigDecimal("2.50"),23);
    }

    @Test
    public void testAggiungiProdotto() {
        carrello.aggiungiProdotto(prodotto1, 1);
        assertEquals(1, carrello.getListaProdottiCarrello().size());
        assertTrue(carrello.getListaProdottiCarrello().containsKey(prodotto1));
        assertEquals(1, carrello.getListaProdottiCarrello().get(prodotto1).intValue());
        assertEquals(new BigDecimal("4.99"), carrello.getTotale());
    }

    @Test
    public void testRimuoviProdotto() {
        carrello.aggiungiProdotto(prodotto1, 2);
        carrello.aggiungiProdotto(prodotto2, 2);
        carrello.rimuoviProdotto(prodotto1, 2);
        assertEquals(1, carrello.getListaProdottiCarrello().size());
        assertFalse(carrello.getListaProdottiCarrello().containsKey(prodotto1));
        assertTrue(carrello.getListaProdottiCarrello().containsKey(prodotto2));
        assertEquals(new BigDecimal("5.00"), carrello.getTotale());
    }

    @Test
    public void testStampaProdottiCarrello() {
        carrello.aggiungiProdotto(prodotto1,2);
        carrello.aggiungiProdotto(prodotto2,2);
        carrello.stampaProdottiCarrello();
    }

    @Test
    public void testEffettuaPagamentoCarrelloVuoto() {
        carrello.effettuaPagamento();
        assertEquals(0, carrello.getListaProdottiCarrello().size());
        assertEquals(BigDecimal.ZERO, carrello.getTotale());
    }

    @Test
    public void testEffettuaPagamentoCarrelloConProdotti() {
        carrello.aggiungiProdotto(prodotto1,1);
        carrello.aggiungiProdotto(prodotto2,1);
        carrello.effettuaPagamento();
        assertEquals(0, carrello.getListaProdottiCarrello().size());
        assertEquals(BigDecimal.ZERO, carrello.getTotale());
    }

    @Test
    public void testConfermaAcquisto() {
        carrello.aggiungiProdotto(prodotto1,2);
        carrello.aggiungiProdotto(prodotto2,3);
        carrello.confermaAcquisto();
        assertEquals(0, carrello.getListaProdottiCarrello().size());
        assertEquals(BigDecimal.ZERO, carrello.getTotale());
    }
}