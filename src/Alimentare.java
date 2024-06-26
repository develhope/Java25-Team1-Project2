import java.math.BigDecimal;
import java.util.UUID;

public class Alimentare extends Prodotto implements ProdottoAlimentare {

    private Boolean daFrigo;
    private String dataScadenza;
    private String marca;

    public Alimentare(UUID id, ProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita, Boolean daFrigo, String dataScadenza, String marca) {
        super(id, tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita);
        this.daFrigo = daFrigo;
        this.dataScadenza = dataScadenza;
        this.marca = marca;
    }

    @Override
    public boolean isDaFrigo() {
        return daFrigo;
    }

    @Override
    public void setDaFrigo(Boolean daFrigo) {
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
    public void stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Da frigo: " + isDaFrigo() + ", Data di scadenza: " + getDataScadenza() + ", Marca: " + getMarca());
    }
}
