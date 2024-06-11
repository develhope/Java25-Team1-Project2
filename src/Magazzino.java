import java.math.BigDecimal;
import java.util.*;

class Magazzino {
    private List<Prodotto> listaProdottiMagazzino;

    public Magazzino() {
        this.listaProdottiMagazzino = new ArrayList<>();
    }

    public List<Prodotto> getListaProdottiMagazzino() {
        return listaProdottiMagazzino;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdottiMagazzino.add(prodotto);
    }

    // TODO deve lavorare su oggetto della lista
    public void rimuoviProdotto(UUID id) {
        listaProdottiMagazzino.remove(listaProdottiMagazzino);
    }

    public void stampaProdottoPerId(UUID id) {
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getId().equals(id)) {
                System.out.println(prodotto);
            }
        }
        System.out.println(" Prodotto non trovato.");
    }

    // TODO aggiungi metodo stampa prodotti

    public void stampaProdotti() {
        for (Prodotto prodotto : listaProdottiMagazzino) {
            System.out.println(prodotto);
        }
    }

    // TODO aggiungi metodo stampa duplicati , se trova due prodotti uguali stampa il prodotto una volta sola. Che venga aggiunga il numero di prodotti contenuti nel magazzino
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

    public List<Prodotto> cercaDispositiviPerTipoProdotto(TipologiaProdottoEnum tipoDispositivo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getTipologiaProdotto() == tipoDispositivo) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    public List<Prodotto> cercaDispositiviPerProduttore(String produttore) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getTipoDispositivo().equalsIgnoreCase(produttore)) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    public List<Prodotto> cercaDispositiviPerModello(String modello) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getModello().toLowerCase().contains(modello.toLowerCase())) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    public List<Prodotto> cercaDispositiviPerPrezzoAcquisto(Double prezzo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        double rangeMinimo = prezzo - 150;
        double rangeMassimo = prezzo + 150;
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getPrezzoAcquisto() >= rangeMinimo && prodotto.getPrezzoAcquisto() <= rangeMassimo) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    public List<Prodotto> cercaDispositiviPerPrezzoVendita(Double prezzo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();
        double rangeMinimo = prezzo - 150;
        double rangeMassimo = prezzo + 150;
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getPrezzoVendita() >= rangeMinimo && prodotto.getPrezzoVendita() <= rangeMassimo) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

    public void ricercaPerPrezzoAcquisto(Double inputPrezzo) {
        try {
            inputPrezzo = inputPrezzo.replace(",", ".");
            BigDecimal prezzoAcquisto = new BigDecimal(inputPrezzo);

            double prezzoAcquistoDouble = prezzoAcquisto.doubleValue();
            List<Prodotto> dispositiviTrovati = cercaDispositiviPerPrezzoAcquisto(prezzoAcquistoDouble);

            if (dispositiviTrovati.isEmpty()) {
                System.out.println("Nessun dispositivo trovato con un prezzo di acquisto entro " + (prezzoAcquistoDouble - 150) + " e " + (prezzoAcquistoDouble + 150) + " €.");
            } else {
                for (Prodotto dispositivo : dispositiviTrovati) {
                    System.out.println(dispositivo);
                }
            }
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Input non valido. Assicurati di inserire un numero valido.");
        }
    }
    //TODO Correggere metodo commentato sotto
    // Metodo che cerca e stampa i dispositivi presenti in un determinato Range di prezzo

    public void ricercaPerPrezzoVendita(Double inputPrezzo) {
        try {
            inputPrezzo = inputPrezzo.replace(",", ".");
            BigDecimal prezzoVendita = new BigDecimal(inputPrezzo);

            double prezzoVenditaDouble = prezzoVendita.doubleValue();
            List<Prodotto> dispositiviTrovati = cercaDispositiviPerPrezzoVendita(prezzoVenditaDouble);

            if (dispositiviTrovati.isEmpty()) {
                System.out.println("Nessun dispositivo trovato con un prezzo di vendita entro " + (prezzoVenditaDouble - 150) + " e " + (prezzoVenditaDouble + 150) + " €.");
            } else {
                for (Prodotto dispositivo : dispositiviTrovati) {
                    System.out.println(dispositivo);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input non valido. Assicurati di inserire un numero valido.");
        }
    }
}


