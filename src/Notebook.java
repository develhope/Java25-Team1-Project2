import java.util.UUID;

public class Notebook  {

    private TipoDispositivo tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazione tipoMemoria;
    private SpazioDiArchiviazione dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setDimensioneDisplay(Double dimensioneDisplay) {
        this.dimensioneDisplay = dimensioneDisplay;
    }

    public void setTipoMemoria(TipoMemoriaArchiviazione tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public void setDimensioneArchiviazione(SpazioDiArchiviazione dimensioneArchiviazione) {
        this.dimensioneArchiviazione = dimensioneArchiviazione;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public void setPrezzoVendita(Double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Prodotto notebookBiuld(){
        return new Prodotto(tipoDispositivo,produttore,modello,dimensioneDisplay,tipoMemoria,dimensioneArchiviazione,prezzoAcquisto,prezzoVendita,id);
    }
}

