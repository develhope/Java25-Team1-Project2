public class Notebook extends Prodotti implements Attributi{
    private String produttore;
    private String modello;
    private double display;
    private int spazioArchiviazione;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private TipoDispositivo dispositivo;
    private int id;
    private TipoMemoriaArchiviazione tipoMemoriaArchiviazione;

    public Notebook(int id, String produttore, String modello, double display, int spazioArchiviazione, double prezzoAcquisto, double prezzoVendita, TipoMemoriaArchiviazione tipoMemoriaArchiviazione) {
        super(TipoDispositivo.TABLET, id);
        this.produttore = produttore;
        this.modello = modello;
        this.display = display;
        this.spazioArchiviazione = spazioArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.tipoMemoriaArchiviazione = tipoMemoriaArchiviazione;
        this.id = id;
    }

    @Override
    public String leggiProduttore() {
        return produttore;
    }

    @Override
    public String leggiModello() {
        return modello;
    }

    @Override
    public String leggiDescrizioneProdotto() {
        return '\n' + "Un dispositivo di ottima fattura, parliamo del " + TipoDispositivo.NOTEBOOK + "  " + produttore +
                " " + modello + ", dotato  16 GB di RAM e di uno spazio di archiviazione di tipo " + TipoMemoriaArchiviazione.SSD + " da " + spazioArchiviazione +
                " GB, con un display di " + display + " pollici. Il costo del prodotto è di " +
                prezzoVendita + " €" + '\n';
    }

    @Override
    public int leggiSpazioArchiviazione() {
        return spazioArchiviazione;
    }

    @Override
    public double leggiDisplay() {
        return display;
    }

    @Override
    public double leggiPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    @Override
    public double leggiPrezzoVendita() {
        return prezzoVendita;
    }

    @Override
    public int leggiId() {
        return id;
    }

    @Override
    public TipoDispositivo leggiTipoDispositivo() {
        return dispositivo;
    }

    @Override
    public TipoMemoriaArchiviazione leggiTipoMemoriaArchiviazione() {
        return tipoMemoriaArchiviazione;
    }

    @Override
    public String toString() {
        return "Smartphone : " +
                "produttore = " + produttore;
    }
}
