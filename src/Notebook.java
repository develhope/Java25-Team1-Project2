import java.util.UUID;

public class Notebook extends Prodotti{

    public Notebook(TipoDispositivo tipoDispositivo, String produttore, String modello, String descrizione, Double dimensioneDisplay,
                    TipoMemoriaArchiviazione tipoMemoria, Integer spazioArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, descrizione, dimensioneDisplay, tipoMemoria, spazioArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}

