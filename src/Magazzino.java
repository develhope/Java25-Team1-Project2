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

    public void setListaProdottiMagazzino(List<Prodotto> listaProdottiMagazzino) {
        this.listaProdottiMagazzino = listaProdottiMagazzino;
    }
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

    public void stampaProdotti() {
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

    public List<Prodotto> ricercaPerPrezzoVendita(Double inputPrezzo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();

        try {
            if (inputPrezzo == null) {
                throw new IllegalArgumentException("Prezzo di input non può essere nullo.");
            }

            double rangeMinimo = inputPrezzo - 150;
            double rangeMassimo = inputPrezzo + 150;

            if (rangeMinimo < 0 || rangeMassimo < 0) {
                throw new IllegalArgumentException("Il prezzo di input crea un intervallo di prezzo non valido.");
            }

            for (Prodotto prodotto : listaProdottiMagazzino) {
                if (prodotto.getPrezzoVendita() >= rangeMinimo && prodotto.getPrezzoVendita() <= rangeMassimo) {
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



