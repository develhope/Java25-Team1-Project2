public class Nootebook implements Attributi{

    private String produttore;
    private String modello;
    private double display;
    private int rom;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private TipoDispositivo dispositivo;
    private int id;

    public Nootebook(TipoDispositivo dispositivo, int id,  String produttore, String modello, double display, int rom,
                     double prezzoAcquisto, double prezzoVendita) {
        this.dispositivo = dispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.display = display;
        this.rom = rom;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
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
        return "Un prodotto " + produttore + " di ottima fattura, parliamo del " + modello + " dotato di un SSD da "
                + rom + "GB di spazio di archiviazione con un display di " + display + " pollici. Il costo del prodotto è di "
                + prezzoVendita;
    }

    @Override
    public int leggiRom() {
        return rom;
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
    public String toString() {
        return "Nootebook = " +
                "produttore: " + produttore +
                ", modello: " + modello +
                ", display: " + display +
                ", rom: " + rom +
                ", prezzoAcquisto: " + prezzoAcquisto +
                ", prezzoVendita: " + prezzoVendita +
                ", dispositivo: " + dispositivo +
                ", id: " + id;
    }
}
