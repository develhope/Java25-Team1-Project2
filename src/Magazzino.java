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
    public List<Prodotto> cercaPerTipoDispositivo(TipoDispositivoEnum tipoDispositivo) {
        List<Prodotto> dispositiviTrovati = new ArrayList<>();

        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto instanceof Dispositivo && ((Dispositivo) prodotto).getTipoDispositivo() == tipoDispositivo) {
                dispositiviTrovati.add(prodotto);
            }
        }

        return dispositiviTrovati;
    }

    public List<Prodotto> cercaDispositiviPerModello(String modello) {

        List<Prodotto> dispositiviTrovati = new ArrayList<>();

        for (Prodotto prodotto : listaProdottiMagazzino) {

            // Controlla se il prodotto è un'istanza di Smartphone e se il suo tipo di dispositivo corrisponde a quello specificato
            if (prodotto instanceof Smartphone && Objects.equals(((Smartphone) prodotto).getModello(), modello)) {
                // Aggiungi il prodotto alla lista dei dispositivi trovati
                dispositiviTrovati.add(prodotto);

            } else if (prodotto instanceof Tablet && Objects.equals(((Tablet) prodotto).getModello(), modello)){
                dispositiviTrovati.add(prodotto);

            } else if (prodotto instanceof Notebook && Objects.equals(((Notebook) prodotto).getModello(), modello)) {
                dispositiviTrovati.add(prodotto);
            }
        }
        return dispositiviTrovati;
    }

//    public List<Prodotto> cercaDispositiviPerPrezzoAcquisto(Double prezzo) {
//        List<Prodotto> dispositiviTrovati = new ArrayList<>();
//        double rangeMinimo = prezzo - 150;
//        double rangeMassimo = prezzo + 150;
//        for (Prodotto prodotto : listaProdottiMagazzino) {
//            if (prodotto.getPrezzoAcquisto() >= rangeMinimo && prodotto.getPrezzoAcquisto() <= rangeMassimo) {
//                dispositiviTrovati.add(prodotto);
//            }
//        }
//        return dispositiviTrovati;
//    }

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

//    public void ricercaPerPrezzoAcquisto(Double inputPrezzo) {
//        try {
//            inputPrezzo = inputPrezzo.replace(",", ".");
//            BigDecimal prezzoAcquisto = new BigDecimal(inputPrezzo);
//
//            double prezzoAcquistoDouble = prezzoAcquisto.doubleValue();
//            List<Prodotto> dispositiviTrovati = cercaDispositiviPerPrezzoAcquisto(prezzoAcquistoDouble);
//
//            if (dispositiviTrovati.isEmpty()) {
//                System.out.println("Nessun dispositivo trovato con un prezzo di acquisto entro " + (prezzoAcquistoDouble - 150) + " e " + (prezzoAcquistoDouble + 150) + " €.");
//            } else {
//                for (Prodotto dispositivo : dispositiviTrovati) {
//                    System.out.println(dispositivo);
//                }
//            }
//        } catch (NumberFormatException | ArithmeticException e) {
//            System.out.println("Input non valido. Assicurati di inserire un numero valido.");
//        }

    public void ricercaPerPrezzoVendita(Double inputPrezzo) {
        try {
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


