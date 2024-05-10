import java.util.UUID;

public class Tablet extends Prodotti  {
    public Tablet(TipoDispositivo tipoDispositivo, String produttore, String modello, String descrizione, double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, Integer dimensioneArchiviazione, double prezzoAcquisto, double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, descrizione, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}