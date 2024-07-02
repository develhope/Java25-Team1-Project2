import java.math.BigDecimal;


public class Main {

    public static void main(String[] args) {

        // Prodotti di tipo ELETTRONICA
        Smartphone smartphone1 = new Smartphone(ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Samsung Galaxy S8", "", new BigDecimal("599.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB",12);
        Prodotto smartphone2 = new Smartphone(ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Asus Rog Phone 7 Ultimate", "", new BigDecimal("799.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB",12);
        Prodotto notebook1 = new Notebook(ProdottoEnum.ELETTRONICA, ProdottoEnum.NOTEBOOK, "Acer Predator Helios 300", "", new BigDecimal("2399.99"), "", "", 15.0, ProdottoEnum.SSD, "512GB",14);
        Prodotto notebook2 = new Notebook(ProdottoEnum.ELETTRONICA, ProdottoEnum.NOTEBOOK, "MacBook pro", "", new BigDecimal("1599.99"), "", "", 14.6, ProdottoEnum.SSD, "512GB",13);
        Tablet tablet1 = new Tablet(ProdottoEnum.ELETTRONICA, ProdottoEnum.TABLET, "Samsung Galaxy Note 3", "", new BigDecimal("299.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB",14);
        Prodotto tablet2 = new Tablet(ProdottoEnum.ELETTRONICA, ProdottoEnum.TABLET, "Samsung Galaxy S12", "", new BigDecimal("699.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB",14);

        // Prodotti di tipo ALIMENTARE
        Prodotto cereali = new Alimentare(ProdottoEnum.ALIMENTARE, "Cereali", "", new BigDecimal("4.995"), false, "2025-12-01", "Kellogs",23);
        Prodotto cocaCola = new Alimentare(ProdottoEnum.ALIMENTARE, "Coca-Cola", "", new BigDecimal("1.79"), false, "2026-12-01", "Coca-Cola",30);
        Prodotto fanta = new Alimentare(ProdottoEnum.ALIMENTARE, "Fanta", "", new BigDecimal("1.7"), false, "2026-12-01", "Fanta",34);
        Prodotto patatine = new Alimentare(ProdottoEnum.ALIMENTARE, "Patatine", "", new BigDecimal("1.2"), false, "2025-08-01", "San Carlo",10);
        Prodotto gelato = new Alimentare(ProdottoEnum.ALIMENTARE, "Maxi-Bon", "", new BigDecimal("2.509"), true, "2024-06-01", "Nestle",15);

        // Prodotti di tipo ABBIGLIAMENTO
        Prodotto pantalone = new Abbigliamento(ProdottoEnum.ABBIGLIAMENTO, "Pantaloni ", "a vita alta", new BigDecimal("179.99"), "L", "Blu", "Raso", true,54);
        Prodotto giacca = new Abbigliamento(ProdottoEnum.ABBIGLIAMENTO, "Giacca ", "tinta unita in lana cotta", new BigDecimal("685.50"), "L", "Nero", "Lana cotta", true,65);
        Prodotto scarpe = new Abbigliamento(ProdottoEnum.ABBIGLIAMENTO, "Scarpe ", "decollete col tacco", new BigDecimal("450.00"), "40", "Nero", "Cuoio", false,13);
        Prodotto calzini = new Abbigliamento(ProdottoEnum.ABBIGLIAMENTO, "Calzini", " a taglia unica", new BigDecimal("19.99"), "Taglia unica", "Bianchi", "Cotone", false,12);
        Prodotto maglietta = new Abbigliamento(ProdottoEnum.ABBIGLIAMENTO, "T-shirt", " a taglia unica", new BigDecimal("110.99"), "M", "Verde", "Cotone", false,11);
        Prodotto intimo = new Abbigliamento(ProdottoEnum.ABBIGLIAMENTO, "Intimo ", "super fresco ed elegante", new BigDecimal("179.99"), "S", "Nero", "Cotone", false,1);

        // Creazione carrelli
        Carrello carrelloEuronics1 = new Carrello();
        Carrello carrelloEuronics2 = new Carrello();
        Carrello carrelloEsselunga1 = new Carrello();
        Carrello carrelloEsselunga2 = new Carrello();
        Carrello carrelloArmani1 = new Carrello();
        Carrello carrelloArmani2 = new Carrello();

        // Acquisti e pagamento presso Euronics
        System.out.println("\nAcquisti presso Euronics:");
        carrelloEuronics1.aggiungiProdotto(smartphone1, 2);
        carrelloEuronics1.aggiungiProdotto(smartphone2, 2);
        carrelloEuronics1.aggiungiProdotto(tablet1, 3);

        carrelloEuronics2.aggiungiProdotto(tablet2, 4);
        carrelloEuronics2.aggiungiProdotto(notebook1,4);
        carrelloEuronics2.aggiungiProdotto(notebook2,1);

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno", "Via Libica, 91100 TRAPANI (TP)");
        magazzinoEuronics.aggiungiDaCarrello(carrelloEuronics1);
        magazzinoEuronics.aggiungiDaCarrello(carrelloEuronics2);

        System.out.println("\nCarrello1 di Euronics:");
        carrelloEuronics1.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloEuronics1.effettuaPagamento();

        System.out.println("\nCarrello2 di Euronics:");
        carrelloEuronics2.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloEuronics2.effettuaPagamento();


        // Acquisti e pagamento presso Esselunga
        System.out.println("\nAcquisti presso Esselunga:");
        carrelloEsselunga1.aggiungiProdotto(cereali,12);
        carrelloEsselunga1.aggiungiProdotto(gelato,10);
        carrelloEsselunga1.aggiungiProdotto(cocaCola,6);
        carrelloEsselunga1.aggiungiProdotto(fanta,3);
        carrelloEsselunga1.aggiungiProdotto(patatine,6);

        Magazzino magazzinoEsselunga = new Magazzino("Esselunga", "Piazza Gae Aulenti, 20124 Milano (MI)");
        magazzinoEsselunga.aggiungiDaCarrello(carrelloEsselunga1);
        magazzinoEsselunga.aggiungiDaCarrello(carrelloEsselunga2);

        System.out.println("\nCarrello1 di Esselunga:");
        carrelloEsselunga1.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloEsselunga1.effettuaPagamento();

        System.out.println("\nCarrello2 di Esselunga:");
        carrelloEsselunga2.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloEsselunga2.effettuaPagamento();


        // Acquisti e pagamento presso Armani
        System.out.println("\nAcquisti presso Armani:");
        carrelloArmani1.aggiungiProdotto(calzini,5);
        carrelloArmani1.aggiungiProdotto(giacca,1);
        carrelloArmani1.aggiungiProdotto(scarpe,1);

        carrelloArmani2.aggiungiProdotto(maglietta,4);
        carrelloArmani2.aggiungiProdotto(intimo,10);
        carrelloArmani2.aggiungiProdotto(pantalone,2);

        Magazzino magazzinoArmani = new Magazzino("Emporio Armani", "Piazza dei Martiri 61-62, 80121 NAPOLI (NA)");
        magazzinoArmani.aggiungiDaCarrello(carrelloArmani1);
        magazzinoArmani.aggiungiDaCarrello(carrelloArmani2);

        System.out.println("\nCarrello1 di Armani:");
        carrelloArmani1.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloArmani1.effettuaPagamento();

        System.out.println("\nCarrello2 di Armani:");
        carrelloArmani2.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloArmani2.effettuaPagamento();

        // Verifica delle funzionalità aggiuntive dei dispositivi
        System.out.println("\nVerifica dello smartphone 1:");
        smartphone1.checkSmartphone();

        // Verifica specifica per tablet
        System.out.println("\nVerifica avvio dell'applicazione su tablet1:");
        tablet1.avviaApplicazione("Nome dell'applicazione da verificare");

        // Verifica della stampa dettagliata di un capo d'abbigliamento
        System.out.println("\nVerifica della giacca:");
        giacca.stampaDettagliProdotto();

        // Verifica della stampa dettagliata di un alimento
        System.out.println("\nVerifica dei cereali:");
        cereali.stampaDettagliProdotto();
    }
}