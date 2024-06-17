import java.math.BigDecimal;
import java.util.*;

class Magazzino{
    private List< Prodotto> listaProdottiMagazzino;
    private String nomeMagazzino;
    private String ubicazione;

    public Magazzino(String nomeMagazzino, String ubicazione) {
        this.listaProdottiMagazzino = new ArrayList<>();
        this.nomeMagazzino = nomeMagazzino;
        this.ubicazione = ubicazione;

    }

    public List<Prodotto> getListaProdottiMagazzino() {
        return listaProdottiMagazzino;
    }
    public String getNomeMagazzino(){return nomeMagazzino;}
    public String getUbicazione(){return ubicazione;}


    public  void setNomeMagazzino(String nomeMagazzino){
        this.nomeMagazzino = nomeMagazzino;
    }

    public void setUbicazione(String ubicazione){
        this.ubicazione = ubicazione;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdottiMagazzino.add(prodotto);
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        listaProdottiMagazzino.remove(prodotto);
    }

    public void stampaMagazzino() {
        System.out.println("Lista prodotti Magazzino: ");
        for (Prodotto prodotto : listaProdottiMagazzino) {
            System.out.println(prodotto);
        }
    }


    public void stampaDuplicati() {
        Map<Prodotto, Integer> prodottoCount = new HashMap<>();
        for (Prodotto prodotto : listaProdottiMagazzino) {
            prodottoCount.put(prodotto, prodottoCount.getOrDefault(prodotto, 0) + 1);
        }
        for (Map.Entry<Prodotto, Integer> entry : prodottoCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - Quantità: " + entry.getValue());
            }
        }
    }

    public List<Prodotto> cercaPerTipoProdotto(TipologiaProdottoEnum tipoProdotto) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getTipologiaProdotto() == tipoProdotto) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    // TODO sistemare il metodo e renderlo generico
    //Metodo di ricerca per i prodotti Elettronici


    public List<Prodotto> cercaDispositiviPerModello(String modello) {

        List<Prodotto> dispositiviTrovati = new ArrayList<>();

        for (Prodotto prodotto : listaProdottiMagazzino) {

            // Controlla se il prodotto è un'istanza di Smartphone e se il suo tipo di dispositivo corrisponde a quello specificato
            if (prodotto instanceof Smartphone && Objects.equals(((Smartphone) prodotto).getModello(), modello)) {
                // Aggiungi il prodotto alla lista dei dispositivi trovati
                dispositiviTrovati.add(prodotto);

                //} else if (prodotto instanceof Tablet && Objects.equals(((Tablet) prodotto).getModello(), modello)){
                dispositiviTrovati.add(prodotto);

            } else if (prodotto instanceof Notebook && Objects.equals(((Notebook) prodotto).getModello(), modello)) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    public List<Prodotto> ricercaPerPrezzoVendita(BigDecimal inputPrezzo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();

        try {
            if (inputPrezzo == null) {
                throw new IllegalArgumentException("Prezzo di input non può essere nullo.");
            }

            BigDecimal rangeMinimo = inputPrezzo.subtract(new BigDecimal("150"));
            BigDecimal rangeMassimo = inputPrezzo.add(new BigDecimal("150"));

            if (rangeMinimo.compareTo(BigDecimal.ZERO) < 0 || rangeMassimo.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Il prezzo di input crea un intervallo di prezzo non valido.");
            }

            for (Prodotto prodotto : listaProdottiMagazzino) {
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
    public boolean aggiungiProdottoACarrello(Carrello carrello, Prodotto prodotto) {
        if (listaProdottiMagazzino.contains(prodotto)) {
            carrello.aggiungiProdotto(prodotto);
            listaProdottiMagazzino.remove(prodotto);
            return true;
        } else {
            System.out.println("Prodotto non disponibile in magazzino.");
            return false;
        }
    }
    public boolean rimuoviProdottoDaCarrello(Carrello carrello, Prodotto prodotto) {
        if (carrello.getListaProdottiCarrello().contains(prodotto)) {
            carrello.rimuoviProdotto(prodotto);
            listaProdottiMagazzino.add(prodotto);
            return true;
        } else {
            System.out.println("Prodotto non presente nel carrello.");
            return false;
        }
    }
}



