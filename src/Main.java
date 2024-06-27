import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args)  {

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno", "Via Libica, 91100 TRAPANI (TP)");
        Magazzino magazzinoEsselunga = new Magazzino("Esselunga", "Piazza Gae Aulenti, 20124 Milano (MI)");
        Magazzino magazzinoArmani = new Magazzino("Emporio Armani", "Piazza dei Martiri 61-62, 80121 NAPOLI (NA)");

        // Prodotti di tipo ELETTRONICA
        Prodotto smartphone1 = new Smartphone(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Samsung Galaxy S8", "", new BigDecimal("599.99"), "", "", 5.6,
                ProdottoEnum.MVME, "512GB", 300.00);

        Prodotto smartphone2 = new Smartphone(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Asus Rog Phone 7 Ultimate", "", new BigDecimal("799.99"), "", "", 5.6,
                ProdottoEnum.MVME, "512GB", 300.00);

        Prodotto notebook1 = new Notebook(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.NOTEBOOK, "Acer Predator Helios 300", "", new BigDecimal("2399.99"), "", "", 15.0,
                ProdottoEnum.SSD, "512GB", 300.00);

        Prodotto notebook2 = new Notebook(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.NOTEBOOK, "MacBook pro", "", new BigDecimal("1599.99"), "", "", 14.6,
                ProdottoEnum.SSD, "512GB", 300.00);

        Prodotto tablet1 = new Tablet(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.TABLET, "Samsung Galaxy Note 3", "", new BigDecimal("299.99"), "", "", 5.6,
                ProdottoEnum.MVME, "512GB", 300.00);

        Prodotto tablet2 = new Tablet(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.TABLET, "Samsung Galaxy S12", "", new BigDecimal("699.99"), "", "", 5.6,
                ProdottoEnum.MVME, "512GB", 300.00);


        // Prodotti di tipo ALIMENTARE
        Prodotto cereali = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Cereali", "", new BigDecimal("4.995"), false, "2025-12-01", "Kellogs");
        Prodotto cocaCola = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Coca-Cola", "", new BigDecimal("1.79"), false, "2026-12-01", "Coca-Cola");
        Prodotto fanta = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Fanta", "", new BigDecimal("1.7"), false, "2026-12-01", "Fanta");
        Prodotto patatine = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Patatine", "", new BigDecimal("1.2"), false, "2025-08-01", "San Carlo");
        Prodotto gelato = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Maxi-Bon", "", new BigDecimal("2.509"), true, "2024-06-01", "Nestle");

        // TODO step 1: creazione prodotti, step 2: creazione carrello, step 3: aggiungiamo prodotti a carrello, step 4: creazione magazzino, step 5: aggiungiamo il carrello al magazzino, step 6: effetuazione operazioni del magazzino
        // Prodotti di tipo ABBIGLIAMENTO
        Prodotto pantalone = new Prodotto(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Pantaloni ", "a vita alta", new BigDecimal("179.99"));
        Prodotto giacca = new Prodotto(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Giacca tinta ", "unita in lana cotta", new BigDecimal("685.50"));
        Prodotto scarpe = new Prodotto(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Scarpe ", "decollete col tacco", new BigDecimal("450.00"));
        Prodotto calzini = new Prodotto(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Calzini", " a taglia unica", new BigDecimal("99.99"));
        Prodotto maglietta = new Prodotto(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "t-shirt", " a taglia unica", new BigDecimal("110.99"));
        Prodotto intimo = new Prodotto(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "intimo ", "super fresco ed elegante", new BigDecimal("179.99"));

        //Creazione carrelli
        Carrello carrelloEuronics1 = new Carrello();
        Carrello carrelloEuronics2 = new Carrello();
        Carrello carrelloEsselunga1 = new Carrello();
        Carrello carrelloEsselunga2 = new Carrello();
        Carrello carrelloArmani1 = new Carrello();
        Carrello carrelloArmani2 = new Carrello();

        // TODO aggiungi prodotti a carrelli

        // Simulazione dell'acquisto

        // Stampa del magazzino Euronics prima della vendita
        System.out.println("Magazzino Euronics prima della vendita:");
        magazzinoEuronics.stampaMagazzino();
        System.out.println();

        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics1, smartphone1);
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics1, smartphone2);
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics1, tablet1);
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics2, tablet2);
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics2, notebook1);
        magazzinoEuronics.aggiungiProdottoACarrello(carrelloEuronics2, notebook2);

        // Stampa dei prodotti nei carrelli Euronics
        System.out.println("Prodotti nel carrello1 di Euronics:");
        carrelloEuronics1.stampaProdottiCarrello();

        // Effettuazione del pagamento
        carrelloEuronics1.effettuaPagamento();
        System.out.println();

        System.out.println("Prodotti nel carrello2 di Euronics:");
        carrelloEuronics2.stampaProdottiCarrello();
        System.out.println();

        // Effettuazione del pagamento
        carrelloEuronics2.effettuaPagamento();
        System.out.println();

        // Stampa del magazzino Esselunga prima della vendita
        System.out.println("Magazzino Esselunga prima della vendita:");
        magazzinoEsselunga.stampaMagazzino();
        System.out.println();

        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga1, cereali);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga1, gelato);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga1, cocaCola);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga2, fanta);
        magazzinoEsselunga.aggiungiProdottoACarrello(carrelloEsselunga2, patatine);

        // Stampa dei prodotti nel carrello Esselunga
        System.out.println("Prodotti nel carrello1 di Esselunga:");
        carrelloEsselunga1.stampaProdottiCarrello();
        System.out.println();

        // Effettuazione del pagamento
        carrelloEsselunga1.effettuaPagamento();
        System.out.println();


        System.out.println("Prodotti nel carrello2 di Esselunga:");
        carrelloEsselunga2.stampaProdottiCarrello();
        System.out.println();

        // Effettuazione del pagamento
        carrelloEsselunga2.effettuaPagamento();
        System.out.println();

        magazzinoArmani.aggiungiProdottoACarrello(carrelloArmani1,calzini);
        magazzinoArmani.aggiungiProdottoACarrello(carrelloArmani1,giacca);
        magazzinoArmani.aggiungiProdottoACarrello(carrelloArmani2,maglietta);
        // Stampa dei prodotti nel carrello Armani
        System.out.println("Prodotti nel carrello1 di Armani:");
        carrelloArmani1.stampaProdottiCarrello();
        System.out.println();

        // Effettuazione del pagamento
        carrelloArmani1.effettuaPagamento();
        System.out.println();

        System.out.println("Prodotti nel carrello2 di Armani:");
        carrelloArmani2.stampaProdottiCarrello();
        System.out.println();

        // Effettuazione del pagamento
        carrelloArmani2.effettuaPagamento();
        System.out.println();

        //check dispositivi

        ((Smartphone)smartphone1).checkSmartphone();

        //check su vestiario
       giacca.stampaDettagliProdotto();


    }

}