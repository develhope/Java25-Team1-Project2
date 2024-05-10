import java.util.UUID;

public class Notebook extends Prodotti{

    public Notebook(TipoDispositivo setTipoDispositivo, String produttore, String modello, String descrizione, double dimensioneDisplay, TipoMemoriaArchiviazione setTipoMemoria, double dimensioneArchiviazione, double prezzoAcquisto, double prezzoVendita, UUID id) {
        super(setTipoDispositivo, produttore, modello, descrizione, dimensioneDisplay, setTipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}
