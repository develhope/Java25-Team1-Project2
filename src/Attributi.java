import java.util.UUID;

public interface Attributi {
    public String leggiProduttore();
    public String leggiModello();
    public String leggiDescrizioneProdotto();
    public int leggiSpazioArchiviazione();
    public double leggiDisplay();
    public double leggiPrezzoAcquisto();
    public double leggiPrezzoVendita();
    public UUID leggiId();
    public TipoDispositivo leggiTipoDispositivo();
    public TipoMemoriaArchiviazione leggiTipoMemoriaArchiviazione();
}

