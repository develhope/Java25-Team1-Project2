import java.util.UUID;

public class Smartphone extends Prodotto {
    private String descrizione;


    public Smartphone(TipoDispositivo tipoDispositivo, String produttore, String modello, Double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, SpazioDiArchiviazione dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id , String descrizione) {
        super(tipoDispositivo, produttore, modello, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String stampaDescrizioneDefoultSmartphone(){
        return "Questo smartphone e' un " + getProduttore() + " " + getModello() + ", la dimensione del display e' di " + getDimensioneDisplay() +
                " pollici, con una capacita' di " + getDimensioneArchiviazione()  + " Gb";
    }
}
