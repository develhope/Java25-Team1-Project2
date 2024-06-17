import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno", "Via Libica, 91100 TRAPANI (TP)");
        Magazzino magazzinoEsselunga = new Magazzino("Esselunga", "Piazza Gae Aulenti, 20124 Milano (MI)");

        Carrello carrelloEuronics1 = new Carrello();
        Carrello carrelloEuronics2 = new Carrello();
        Carrello carrelloEsselunga = new Carrello();

        magazzinoEuronics.aggiungiCarrello(carrelloEuronics1);
        magazzinoEuronics.aggiungiCarrello(carrelloEuronics2);
        magazzinoEsselunga.aggiungiCarrello(carrelloEsselunga);

        // Prodotti di tipo ELETTRONICA
        Prodotto smartphone1 = new Smartphone(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.SMARTPHONE, "Samsung Galaxy S8", "", new BigDecimal("599.99"), "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto smartphone2 = new Smartphone(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.SMARTPHONE, "Asus Rog Phone 7 Ultimate", "", new BigDecimal("799.99"), "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto notebook1 = new Notebook(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.NOTEBOOK, "Acer Predator Helios 300", "", new BigDecimal("2399.99"), "", "", 15.0,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto notebook2 = new Notebook(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.NOTEBOOK, "MacBook pro", "", new BigDecimal("1599.99"), "", "", 14.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto tablet1 = new Tablet(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.TABLET, "Samsung Galaxy Note 3", "", new BigDecimal("299.99"), "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto tablet2 = new Tablet(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.TABLET, "Samsung Galaxy S12", "", new BigDecimal("699.99"), "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        // Aggiunta dei prodotti ai rispettivi magazzini
        magazzinoEuronics.aggiungiProdotto(smartphone1);
        magazzinoEuronics.aggiungiProdotto(smartphone2);
        magazzinoEuronics.aggiungiProdotto(notebook1);
        magazzinoEuronics.aggiungiProdotto(notebook2);
        magazzinoEuronics.aggiungiProdotto(tablet1);
        magazzinoEuronics.aggiungiProdotto(tablet2);

        // Prodotti di tipo ALIMENTARE
        Prodotto cereali = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Cereali Kellogs", "", new BigDecimal("4.995"));
        Prodotto cocaCola = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Coca-Cola", "", new BigDecimal("1.79"));
        Prodotto fanta = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Fanta", "", new BigDecimal("1.7"));
        Prodotto patatine = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Patatine San Carlo", "", new BigDecimal("1.2"));
        Prodotto gelato = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Maxi-Bon", "", new BigDecimal("2.509"));

        // Aggiunta dei prodotti alimentari al magazzino Esselunga
        magazzinoEsselunga.aggiungiProdotto(cereali);
        magazzinoEsselunga.aggiungiProdotto(cocaCola);
        magazzinoEsselunga.aggiungiProdotto(fanta);
        magazzinoEsselunga.aggiungiProdotto(patatine);
        magazzinoEsselunga.aggiungiProdotto(gelato);

        // Stampa del magazzino Esselunga prima della vendita
        System.out.println("Magazzino Esselunga prima della vendita:");
        magazzinoEsselunga.stampaMagazzino();
        System.out.println();

        // Simulazione dell'acquisto
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga, cereali);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga, gelato);

        // Stampa dei prodotti nel carrello Esselunga
        System.out.println("Prodotti nel carrello di Esselunga:");
        carrelloEsselunga.stampaProdottiCarrello();
        System.out.println();

        // Calcolo del totale del carrello Esselunga
        BigDecimal totaleCarrello = carrelloEsselunga.calcolaTotaleCarrello();
        System.out.println("Totale da pagare: " + totaleCarrello + " €");

        // Effettuazione del pagamento
        carrelloEsselunga.effettuaPagamento();
        System.out.println();

        // Stampa del magazzino Esselunga dopo la vendita
        System.out.println("Magazzino Esselunga dopo la vendita:");
        magazzinoEsselunga.stampaMagazzino();
        System.out.println();
    }
}