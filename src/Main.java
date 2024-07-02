import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno", "Via Libica, 91100 TRAPANI (TP)");
        Magazzino magazzinoEsselunga = new Magazzino("Esselunga", "Piazza Gae Aulenti, 20124 Milano (MI)");
        Magazzino magazzinoArmani = new Magazzino("Emporio Armani", "Piazza dei Martiri 61-62, 80121 NAPOLI (NA)");

        // Prodotti di tipo ELETTRONICA
        Smartphone smartphone1 = new Smartphone(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Samsung Galaxy S8", "", new BigDecimal("599.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB", 300.00);
        Prodotto smartphone2 = new Smartphone(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.SMARTPHONE, "Asus Rog Phone 7 Ultimate", "", new BigDecimal("799.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB", 300.00);
        Prodotto notebook1 = new Notebook(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.NOTEBOOK, "Acer Predator Helios 300", "", new BigDecimal("2399.99"), "", "", 15.0, ProdottoEnum.SSD, "512GB", 300.00);
        Prodotto notebook2 = new Notebook(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.NOTEBOOK, "MacBook pro", "", new BigDecimal("1599.99"), "", "", 14.6, ProdottoEnum.SSD, "512GB", 300.00);
        Prodotto tablet1 = new Tablet(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.TABLET, "Samsung Galaxy Note 3", "", new BigDecimal("299.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB", 300.00);
        Prodotto tablet2 = new Tablet(UUID.randomUUID(), ProdottoEnum.ELETTRONICA, ProdottoEnum.TABLET, "Samsung Galaxy S12", "", new BigDecimal("699.99"), "", "", 5.6, ProdottoEnum.MVME, "512GB", 300.00);

        // Prodotti di tipo ALIMENTARE
        Prodotto cereali = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Cereali", "", new BigDecimal("4.995"), false, "2025-12-01", "Kellogs");
        Prodotto cocaCola = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Coca-Cola", "", new BigDecimal("1.79"), false, "2026-12-01", "Coca-Cola");
        Prodotto fanta = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Fanta", "", new BigDecimal("1.7"), false, "2026-12-01", "Fanta");
        Prodotto patatine = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Patatine", "", new BigDecimal("1.2"), false, "2025-08-01", "San Carlo");
        Prodotto gelato = new Alimentare(UUID.randomUUID(), ProdottoEnum.ALIMENTARE, "Maxi-Bon", "", new BigDecimal("2.509"), true, "2024-06-01", "Nestle");

        // Prodotti di tipo ABBIGLIAMENTO
        Prodotto pantalone = new Abbigliamento(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Pantaloni ", "a vita alta", new BigDecimal("179.99"), "L", "Blu", "Raso", true);
        Prodotto giacca = new Abbigliamento(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Giacca ", "tinta unita in lana cotta", new BigDecimal("685.50"), "L", "Nero", "Lana cotta", true);
        Prodotto scarpe = new Abbigliamento(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Scarpe ", "decollete col tacco", new BigDecimal("450.00"), "40", "Nero", "Cuoio", false);
        Prodotto calzini = new Abbigliamento(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Calzini", " a taglia unica", new BigDecimal("19.99"), "Taglia unica", "Bianchi", "Cotone", false);
        Prodotto maglietta = new Abbigliamento(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "T-shirt", " a taglia unica", new BigDecimal("110.99"), "M", "Verde", "Cotone", false);
        Prodotto intimo = new Abbigliamento(UUID.randomUUID(), ProdottoEnum.ABBIGLIAMENTO, "Intimo ", "super fresco ed elegante", new BigDecimal("179.99"), "S", "Nero", "Cotone", false);

        // Creazione carrelli
        Carrello carrelloEuronics1 = new Carrello();
        Carrello carrelloEuronics2 = new Carrello();
        Carrello carrelloEsselunga1 = new Carrello();
        Carrello carrelloEsselunga2 = new Carrello();
        Carrello carrelloArmani1 = new Carrello();
        Carrello carrelloArmani2 = new Carrello();

        // Aggiungi prodotti ai magazzini
        magazzinoEuronics.aggiungiProdotto(smartphone1);
        magazzinoEuronics.aggiungiProdotto(smartphone2);
        magazzinoEuronics.aggiungiProdotto(notebook1);
        magazzinoEuronics.aggiungiProdotto(notebook2);
        magazzinoEuronics.aggiungiProdotto(tablet1);
        magazzinoEuronics.aggiungiProdotto(tablet2);

        magazzinoEsselunga.aggiungiProdotto(cereali);
        magazzinoEsselunga.aggiungiProdotto(gelato);
        magazzinoEsselunga.aggiungiProdotto(cocaCola);
        magazzinoEsselunga.aggiungiProdotto(fanta);
        magazzinoEsselunga.aggiungiProdotto(patatine);

        magazzinoArmani.aggiungiProdotto(calzini);
        magazzinoArmani.aggiungiProdotto(giacca);
        magazzinoArmani.aggiungiProdotto(maglietta);
        magazzinoArmani.aggiungiProdotto(intimo);

        // Stampa dei magazzini prima della vendita
        System.out.println("Magazzino Euronics prima della vendita:");
        magazzinoEuronics.stampaMagazzino();
        System.out.println();

        System.out.println("Magazzino Esselunga prima della vendita:");
        magazzinoEsselunga.stampaMagazzino();
        System.out.println();

        System.out.println("Magazzino Armani prima della vendita:");
        magazzinoArmani.stampaMagazzino();
        System.out.println();

        // Simulazione degli acquisti e pagamento

        // Acquisti e pagamento presso Euronics
        System.out.println("\nAcquisti presso Euronics:");
        carrelloEuronics1.aggiungiProdotto(smartphone1);
        carrelloEuronics1.aggiungiProdotto(smartphone2);
        carrelloEuronics1.aggiungiProdotto(tablet1);

        carrelloEuronics2.aggiungiProdotto(tablet2);
        carrelloEuronics2.aggiungiProdotto(notebook1);
        carrelloEuronics2.aggiungiProdotto(notebook2);

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
        carrelloEsselunga1.aggiungiProdotto(cereali);
        carrelloEsselunga1.aggiungiProdotto(gelato);
        carrelloEsselunga1.aggiungiProdotto(cocaCola);
        carrelloEsselunga1.aggiungiProdotto(fanta);
        carrelloEsselunga1.aggiungiProdotto(patatine);

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
        carrelloArmani1.aggiungiProdotto(calzini);
        carrelloArmani1.aggiungiProdotto(giacca);
        carrelloArmani1.aggiungiProdotto(scarpe);

        carrelloArmani2.aggiungiProdotto(maglietta);
        carrelloArmani2.aggiungiProdotto(intimo);
        carrelloArmani2.aggiungiProdotto(pantalone);

        System.out.println("\nCarrello1 di Armani:");
        carrelloArmani1.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloArmani1.effettuaPagamento();

        System.out.println("\nCarrello2 di Armani:");
        carrelloArmani2.stampaProdottiCarrello();
        System.out.println("Totale da pagare: ");
        carrelloArmani2.effettuaPagamento();

        System.out.println();
        // Utilizzo specifico
        smartphone1.checkSmartphone();

        System.out.println();
        giacca.stampaDettagliProdotto();
    }
}