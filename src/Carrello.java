
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;
import java.util.ArrayList;

    public class Carrello {
        private List<Prodotto> prodotti;
        private Magazzino magazzino;

        public Carrello(Magazzino magazzino) {
            this.prodotti = new ArrayList<>();
            this.magazzino = magazzino;
        }

        public List<Prodotto> getProdotti() {
            return prodotti;
        }

        public void aggiungiProdottoACarrello(UUID id) {
            Prodotto prodotto = trovaProdottoPerIdMagazzino(id);
            if (prodotto != null) {
                prodotti.add(prodotto);
            }
        }

        public void rimuoviProdottoDalCarrello(UUID id) {
            prodotti.removeIf(p -> p.getId().equals(id));
        }

        public BigDecimal calcolaTotaleCarrello() {
            return prodotti.stream()
                    .map(p -> BigDecimal.valueOf(p.getPrezzoVendita()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        public void finalizzaAcquistoCarrello() {
            prodotti.clear();
        }

        public Prodotto trovaProdottoPerIdCarrello(UUID id) {
            return prodotti.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        public void visualizzaCarrello() {
            if (prodotti.isEmpty()) {
                System.out.println("Il carrello è vuoto.");
            } else {
                prodotti.forEach(System.out::println);
            }
        }

        private Prodotto trovaProdottoPerIdMagazzino(UUID id) {
            for (Prodotto prodotto : magazzino.getMagazzino()) {
                if (prodotto.getId().equals(id)) {
                    return prodotto;
                }
            }
            return null;
        }
    }
