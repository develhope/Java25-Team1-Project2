import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno", "Via Libica, 91100 TRAPANI (TP)");
        Magazzino magazzinoEsselunga = new Magazzino("Esselunga", "Piazza Gae Aulenti, 20124 Milano (MI)");
        Magazzino magazzinoArmani = new Magazzino("Emporio Armani", "Piazza dei Martiri 61-62, 80121 NAPOLI (NA)");

        Carrello carrelloEuronics1 = new Carrello();
        Carrello carrelloEuronics2 = new Carrello();
        Carrello carrelloEsselunga1 = new Carrello();
        Carrello carrelloEsselunga2 = new Carrello();
        Carrello carrelloArmani1 = new Carrello();
        Carrello carrelloArmani2 = new Carrello();

        // TODO popolare i carrelli con i prodotti e poi aggiungerli al magazzino (carrello.add)
        magazzinoEuronics.aggiungiCarrello(carrelloEuronics1);
        magazzinoEuronics.aggiungiCarrello(carrelloEuronics2);
        magazzinoEsselunga.aggiungiCarrello(carrelloEsselunga1);
        magazzinoEsselunga.aggiungiCarrello(carrelloEsselunga2);

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

        // TODO aggiungi prodotti a carrelli, i prodotti sono già contenuti nel magazzino

        // Aggiunta dei prodotti ai carrelli di euronics.
        carrelloEuronics1.aggiungiProdotto(smartphone1);
        carrelloEuronics1.aggiungiProdotto(smartphone2);
        carrelloEuronics2.aggiungiProdotto(notebook1);
        carrelloEuronics2.aggiungiProdotto(notebook2);
        carrelloEuronics1.aggiungiProdotto(tablet1);
        carrelloEuronics2.aggiungiProdotto(tablet2);

        //da qui aggiungo poi i carrelli ai magazzini di euronics.

        magazzinoEuronics.aggiungiCarrello(carrelloEuronics1);
        magazzinoEuronics.aggiungiCarrello(carrelloEuronics2);

        // Prodotti di tipo ALIMENTARE
        Prodotto cereali = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Cereali Kellogs", "", new BigDecimal("4.995"));
        Prodotto cocaCola = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Coca-Cola", "", new BigDecimal("1.79"));
        Prodotto fanta = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Fanta", "", new BigDecimal("1.7"));
        Prodotto patatine = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Patatine San Carlo", "", new BigDecimal("1.2"));
        Prodotto gelato = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ALIMENTARE, "Maxi-Bon", "", new BigDecimal("2.509"));

        // Aggiunta dei prodotti alimentari ai carrelli Esselunga
        carrelloEsselunga1.aggiungiProdotto(cereali);
        carrelloEsselunga2.aggiungiProdotto(cocaCola);
        carrelloEsselunga2.aggiungiProdotto(fanta);
        carrelloEsselunga2.aggiungiProdotto(patatine);
        carrelloEsselunga1.aggiungiProdotto(gelato);

        // Prodotti di tipo ABBIGLIAMENTO
        Prodotto pantalone = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ABBIGLIAMENTO, "Pantaloni a vita alta", "", new BigDecimal("179.99"));
        Prodotto giacca = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ABBIGLIAMENTO, "Giacca tinta unita in lana cotta", "", new BigDecimal("685.50"));
        Prodotto scarpa = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ABBIGLIAMENTO, "Scarpe decollete col tacco", "", new BigDecimal("450.00"));
        Prodotto calzini = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ABBIGLIAMENTO, "Calzini a taglia unica", "", new BigDecimal("99.99"));
        Prodotto maglietta = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ABBIGLIAMENTO, "t-shirt a taglia unica", "", new BigDecimal("110.99"));
        Prodotto intimo = new Prodotto(UUID.randomUUID(), TipologiaProdottoEnum.ABBIGLIAMENTO, "intimo super fresco ed elegante", "", new BigDecimal("179.99"));

        // Aggiunta dei prodotti abbigliamento ai magazzini Armani
        carrelloArmani1.aggiungiProdotto(pantalone);
        carrelloArmani2.aggiungiProdotto(giacca);
        carrelloArmani1.aggiungiProdotto(scarpa);
        carrelloArmani1.aggiungiProdotto(calzini);
        carrelloArmani2.aggiungiProdotto(maglietta);
        carrelloArmani2.aggiungiProdotto(intimo);





        // Stampa del magazzino Esselunga prima della vendita
        System.out.println("Magazzino Esselunga prima della vendita:");
        magazzinoEsselunga.stampaMagazzino();
        System.out.println();

        // Simulazione dell'acquisto
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga1, cereali);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga1, gelato);

        // Stampa dei prodotti nel carrello Esselunga
        System.out.println("Prodotti nel carrello di Esselunga:");
        carrelloEsselunga1.stampaProdottiCarrello();
        System.out.println();

        // Calcolo del totale del carrello Esselunga
        BigDecimal totaleCarrello = carrelloEsselunga1.calcolaTotaleCarrello();
        System.out.println("Totale da pagare: " + totaleCarrello + " €");

        // Effettuazione del pagamento
        carrelloEsselunga1.effettuaPagamento();
        System.out.println();

        // Stampa del magazzino Esselunga dopo la vendita
        System.out.println("Magazzino Esselunga dopo la vendita:");
        magazzinoEsselunga.stampaMagazzino();
        System.out.println();


        //angolo test magazzinoEuronics .

        // Stampa del magazzino Euronics prima della vendita
        System.out.println("Magazzino Euronics prima della vendita:");
        magazzinoEuronics.stampaMagazzino();
        System.out.println();

        // Simulazione dell'acquisto
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics1, notebook1);
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics1, smartphone1);

        // Stampa dei prodotti nel carrello Esselunga
        System.out.println("Prodotti nel carrello Euronics:");
        carrelloEuronics1.stampaProdottiCarrello();
        System.out.println();

        // Calcolo del totale del carrello Esselunga
        BigDecimal totaleCarrelloEuronics = carrelloEuronics1.calcolaTotaleCarrello();
        System.out.println("Totale da pagare: " + totaleCarrelloEuronics + " €");

        // Effettuazione del pagamento
        carrelloEuronics1.effettuaPagamento();
        System.out.println();

        // Stampa del magazzino Esselunga dopo la vendita
        System.out.println("Magazzino Euronics dopo la vendita:");
        magazzinoEuronics.stampaMagazzino();
        System.out.println();


    }





}