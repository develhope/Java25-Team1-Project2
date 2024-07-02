public enum ProdottoEnum {

    // Tipologia prodotto
    ALIMENTARE("Alimentare", "Prodotto alimentare"),
    ELETTRONICA("Elettronica", "Prodotto elettronico"),
    ABBIGLIAMENTO("Abbigliamento", "Prodotto di abbigliamento"),

    // Prodotti elettronici
    SMARTPHONE("TipoDispositivo", "Smartphone"),
    NOTEBOOK("TipoDispositivo", "Notebook"),
    TABLET("TipoDispositivo", "Tablet"),

    // Tipi di memoria
    SSD("TipoDiMemoria", "SSD"),
    HDD("TipoDiMemoria", "HDD"),
    MVME("TipoDiMemoria", "MVMe"),

    // Prodotti alimentari
    CEREALI("Alimentare", "Cereali"),
    COCACOLA("Alimentare", "Coca-Cola"),
    FANTA("Alimentare", "Fanta"),
    PATATINE("Alimentare", "Patatine"),
    GELATO("Alimentare", "Gelato"),

    // Prodotti di abbigliamento
    PANTALONE("Abbigliamento", "Pantalone"),
    GIACCA("Abbigliamento", "Giacca invernale"),
    SCARPE("Abbigliamento", "Scarpe da ginnastica"),
    CALZINI("Abbigliamento", "Calzini"),
    MAGLIETTA("Abbigliamento", "Maglietta"),
    INTIMO("Abbigliamento", "Intimo");

    private final String categoria;
    private final String descrizione;

    ProdottoEnum(String categoria, String descrizione) {
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
