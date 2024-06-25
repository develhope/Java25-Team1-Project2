import java.math.BigDecimal;
import java.util.UUID;

public class Tablet extends Prodotto implements Dispositivo.DispositivoElettronico {
    private UUID id;
    private ProdottoEnum tipoDispositivo;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private BigDecimal prezzoVendita;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private ProdottoEnum tipoMemoria;
    private String dimensioneArchiviazione;
    private Double prezzoAcquisto;

    public Tablet(UUID id, ProdottoEnum tipologiaProdotto, ProdottoEnum tipoDispositivo, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita,
                  String produttore, String modello, Double dimensioneDisplay, ProdottoEnum tipoMemoria,
                  String dimensioneArchiviazione, Double prezzoAcquisto) {
        super(id, tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita);
        this.id = id;
        this.tipoDispositivo = tipoDispositivo;
        this.nomeProdotto = nomeProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.prezzoVendita = prezzoVendita;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.tipoMemoria = tipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.setDescrizioneProdotto(descrizioneProdotto + ", Display: " + dimensioneDisplay +
                "\", Memoria: " + tipoMemoria + ", Spazio: " + dimensioneArchiviazione);
    }

    @Override
    public ProdottoEnum getTipoDispositivo() {
        return tipoDispositivo;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nomeProdotto;
    }

    @Override
    public String getDescrizione() {
        return descrizioneProdotto;
    }

    @Override
    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    @Override
    public void accendi() {
        System.out.println("Tablet acceso");
    }

    @Override
    public void spegni() {
        System.out.println("Tablet spento");
    }

    public void setTipoDispositivo(ProdottoEnum tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getDimensioneDisplay() {
        return dimensioneDisplay;
    }

    public void setDimensioneDisplay(Double dimensioneDisplay) {
        this.dimensioneDisplay = dimensioneDisplay;
    }

    public ProdottoEnum getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(ProdottoEnum tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public String getDimensioneArchiviazione() {
        return dimensioneArchiviazione;
    }

    public void setDimensioneArchiviazione(String dimensioneArchiviazione) {
        this.dimensioneArchiviazione = dimensioneArchiviazione;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    @Override
    public void stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Tipo Dispositivo: " + tipoDispositivo + ", Produttore: " + produttore +
                ", Modello: " + modello + ", Dimensione display: " + dimensioneDisplay + "\", Tipo di memoria: "
                + tipoMemoria + ", Dimensione: " + dimensioneArchiviazione +
                ", Prezzo acquisto: " + prezzoAcquisto);
    }
}
