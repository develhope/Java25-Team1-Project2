public enum TipoDispositivoEnum {
    SMARTPHONE ("Smartphone"),
    NOTEBOOK ("Notebook"),
    TABLET ("Tablet");

    private String descrizione;

    TipoDispositivoEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}



