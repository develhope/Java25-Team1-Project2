import java.math.BigDecimal;
import java.util.UUID;

public class Abbigliamento extends Prodotto implements Abito {

    private String taglia;
    private String colore;
    private String materiale;
    private boolean lavaggioSecco;

    public Abbigliamento(ProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita, String taglia, String colore, String materiale, boolean lavaggioSecco, Integer quantita) {
        super(tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita, quantita);
        this.taglia = taglia;
        this.colore = colore;
        this.materiale = materiale;
        this.lavaggioSecco = lavaggioSecco;
    }

    @Override
    public String getTaglia() {
        return taglia;
    }

    @Override
    public String getColore() {
        return colore;
    }

    @Override
    public String getMateriale() {
        return materiale;
    }

    @Override
    public boolean isLavaggioSecco() {
        return lavaggioSecco;
    }

    @Override
    public void setTaglia(String getTaglia) {
        this.taglia = taglia;
    }

    @Override
    public void setColore(String getColore) {
        this.colore = colore;
    }

    @Override
    public void setMateriale(String getMateriale) {
        this.materiale = materiale;
    }

    @Override
    public void setLavaggioSecco(boolean isLavaggioSecco) {
        this.lavaggioSecco = lavaggioSecco;
    }

    @Override
    public String stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
            System.out.println("Taglia :" + getTaglia() + ", colore: " + getColore() + ", materiale: " + getMateriale() + ", lavaggio a secco: " + this.isLavaggioSecco());
        return null;
    }
}

