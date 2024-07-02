import java.math.BigDecimal;
import java.util.UUID;

public class Alimentare extends Prodotto implements ProdottoAlimentare {

    private boolean daFrigo;
    private String dataScadenza;
    private String marca;

    public Alimentare(ProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita, boolean daFrigo, String dataScadenza, String marca, Integer quantita) {
        super( tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita, quantita );
        this.daFrigo = daFrigo;
        this.dataScadenza = dataScadenza;
        this.marca = marca;
    }

    @Override
    public boolean isDaFrigo() {
        return daFrigo;
    }

    public void setDaFrigo(boolean daFrigo) {
        this.daFrigo = daFrigo;
    }

    @Override
    public String getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Da frigo: " + isDaFrigo() + ", Data di scadenza: " + getDataScadenza() + ", Marca: " + getMarca());
        return null;
    }
}
