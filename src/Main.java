
import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno","Via Libica, 91100 TRAPANI (TP)");
        Magazzino magazzinoEsselunga = new Magazzino("Esselunga di Aprilia","Via Misurata 8, 04011 APRILIA (LT)" );
        Magazzino magazzinoArmani = new Magazzino("Emporio Armani", "Piazza dei Martiri 61-62, 80121 NAPOLI (NA)");
        Carrello carrello1 = new Carrello();
        Carrello carrello2 = new Carrello();

        // Prodotti ELETTRONICA
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

        magazzinoEuronics.aggiungiProdotto(smartphone1);
        magazzinoEuronics.aggiungiProdotto(smartphone2);
        magazzinoEuronics.aggiungiProdotto(notebook1);
        magazzinoEuronics.aggiungiProdotto(notebook2);
        magazzinoEuronics.aggiungiProdotto(tablet1);
        magazzinoEuronics.aggiungiProdotto(tablet2);

        magazzinoEuronics.rimuoviProdotto(tablet1);

        // Prodotti Alimentari
        Prodotto cereali = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Cereali Kellogs", "", new BigDecimal("4.995"));
        Prodotto cocaCola = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Coca-Cola", "", new BigDecimal("1.79"));
        Prodotto fanta = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Fanta", "", new BigDecimal("1.7"));
        Prodotto patatine = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Patatine San Carlo", "", new BigDecimal("1.2"));
        Prodotto gelato = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Maxi-Bon", "", new BigDecimal("2.509"));

        magazzinoEsselunga.aggiungiProdotto(cereali);
        magazzinoEsselunga.aggiungiProdotto(cocaCola);
        magazzinoEsselunga.aggiungiProdotto(fanta);
        magazzinoEsselunga.aggiungiProdotto(patatine);
        magazzinoEsselunga.aggiungiProdotto(gelato);

        //satampa magazzino prima della vendita
        magazzinoEsselunga.stampaMagazzino();

        //simulazione acquisto
        magazzinoEsselunga.aggiungiProdottoACarrello(carrello1,cereali);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrello1,gelato);

        carrello1.stampaProdottiCarrello();
        carrello1.calcolaTotaleCarrello();
        carrello1.effettuaPagamento();

        //satampa magazzino dopo la vendita
        magazzinoEsselunga.stampaMagazzino();
        //TODO aggiungere prodotti alimentari e abbigliamento
        // Esempio di utilizzo dei metodi di ricerca

        /*magazzinoEuronics.cercaPerTipoProdotto(TipologiaProdottoEnum.ELETTRONICA);

        magazzinoEuronics.cercaDispositiviPerModello("Galaxy S8");

        //test metodi

        carrello.aggiungiProdottoACarrello(smartphone1);
        carrello.finalizzaAcquistoCarrello();

        magazzinoEuronics.ricercaPerPrezzoVendita(500.00);

         */


    }
}