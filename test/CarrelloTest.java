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
        prodotto1 = new Prodotto(UUID.randomUUID(), ProdottoEnum.CEREALI, "Cereali Kellogs", "Deliziosi cereali", new BigDecimal("4.99"));
        prodotto2 = new Prodotto(UUID.randomUUID(), ProdottoEnum.GELATO, "Maxi-Bon", "Gelato al cioccolato", new BigDecimal("2.50"));
    }

    @Test
    public void testAggiungiProdotto() {
        carrello.aggiungiProdotto(prodotto1);
        assertEquals(1, carrello.getListaProdottiCarrello().size());
        assertEquals(prodotto1, carrello.getListaProdottiCarrello().get(0));
        assertEquals(new BigDecimal("4.99"), carrello.getTotale());
    }

    @Test
    public void testRimuoviProdotto() {
        carrello.aggiungiProdotto(prodotto1);
        carrello.aggiungiProdotto(prodotto2);
        carrello.rimuoviProdotto(prodotto1);
        assertEquals(1, carrello.getListaProdottiCarrello().size());
        assertEquals(prodotto2, carrello.getListaProdottiCarrello().get(0));
        assertEquals(new BigDecimal("2.50"), carrello.getTotale());
    }

    @Test
    public void testStampaProdottiCarrello() {
        carrello.aggiungiProdotto(prodotto1);
        carrello.aggiungiProdotto(prodotto2);
        carrello.stampaProdottiCarrello();
    }

    @Test
    public void testEffettuaPagamentoCarrelloVuoto() {
        assertFalse(carrello.effettuaPagamento());
    }

    @Test
    public void testEffettuaPagamentoCarrelloConProdotti() {
        carrello.aggiungiProdotto(prodotto1);
        carrello.aggiungiProdotto(prodotto2);
        assertTrue(carrello.effettuaPagamento());
        assertEquals(0, carrello.getListaProdottiCarrello().size());
        assertEquals(BigDecimal.ZERO, carrello.getTotale());
    }

    @Test
    public void testConfermaAcquisto() {
        carrello.aggiungiProdotto(prodotto1);
        carrello.aggiungiProdotto(prodotto2);
        carrello.confermaAcquisto();
        assertEquals(0, carrello.getListaProdottiCarrello().size());
        assertEquals(BigDecimal.ZERO, carrello.getTotale());
    }
}