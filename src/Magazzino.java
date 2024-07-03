import java.math.BigDecimal;
import java.util.*;

public class Magazzino {
    private Map<Prodotto, Integer> listaProdottiMagazzino;
    private List<Carrello> carrelli;
    private String nomeMagazzino;
    private String ubicazione;

    public Magazzino(String nomeMagazzino, String ubicazione) {
        this.listaProdottiMagazzino = new HashMap<>();
        this.carrelli = new ArrayList<>();
        this.nomeMagazzino = nomeMagazzino;
        this.ubicazione = ubicazione;
    }

    // Metodi getter e setter per nomeMagazzino e ubicazione
    public String getUbicazione() {
        return ubicazione;
    }

    public void setUbicazione(String ubicazione) {
        this.ubicazione = ubicazione;
    }

    public String getNomeMagazzino() {
        return nomeMagazzino;
    }

    public void setNomeMagazzino(String nomeMagazzino) {
        this.nomeMagazzino = nomeMagazzino;
    }

    public Map<Prodotto, Integer> getListaProdottiMagazzino() {
        return listaProdottiMagazzino;
    }

    public List<Carrello> getCarrelli() {
        return carrelli;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdottiMagazzino.put(prodotto,listaProdottiMagazzino.getOrDefault(prodotto,0) + prodotto.getQuantita());
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        listaProdottiMagazzino.remove(prodotto);
    }


    public void stampaMagazzino() {

        for (Map.Entry<Prodotto, Integer> entryMagazzino : listaProdottiMagazzino.entrySet())  {
            System.out.println(entryMagazzino.getKey() + ": " + entryMagazzino.getValue());
        }

    }
    public void aggiungiDaCarrello(Carrello carrello) {
        for (Prodotto prodotto : carrello.getListaProdottiCarrello()) {
            aggiungiProdotto(prodotto);
        }

    }

    // Metodo per cercare prodotti per tipo
    public List<Prodotto> cercaPerTipoProdotto(ProdottoEnum tipoProdotto) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        for (Map.Entry<Prodotto, Integer> entryMagazzino : listaProdottiMagazzino.entrySet()) {
            if (entryMagazzino.getKey().getTipologiaProdotto() == tipoProdotto) {
                dispositiviTrovati.add(entryMagazzino.getKey());
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per cercare prodotti per prezzo di vendita
    public List<Prodotto> ricercaPerPrezzoVendita(BigDecimal inputPrezzo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        try {
            if (inputPrezzo == null) {
                throw new IllegalArgumentException("Prezzo di input non può essere nullo.");
            }

            BigDecimal rangeMinimo = inputPrezzo.subtract(new BigDecimal("50"));
            BigDecimal rangeMassimo = inputPrezzo.add(new BigDecimal("50"));

            if (rangeMinimo.compareTo(BigDecimal.ZERO) < 0) {
                rangeMinimo = BigDecimal.ZERO;
            }

            for (Prodotto prodotto : listaProdottiMagazzino.keySet()) {
                BigDecimal prezzoVendita = prodotto.getPrezzoVendita();
                if (prezzoVendita.compareTo(rangeMinimo) >= 0 && prezzoVendita.compareTo(rangeMassimo) <= 0) {
                    dispositiviTrovati.add(prodotto);
                }
            }

            if (dispositiviTrovati.isEmpty()) {
                throw new IllegalStateException("Nessun dispositivo trovato con un prezzo di vendita entro " + rangeMinimo + " e " + rangeMassimo + " €.");
            } else {
                for (Prodotto dispositivo : dispositiviTrovati) {
                    System.out.println(dispositivo);
                }
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        return dispositiviTrovati;
    }
}