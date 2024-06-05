public enum TipologiaProdottoEnum {
    ALIMENTARE("Alimentare"),
    ELETTRONICA("Elettronica"),
    ABBIGLIAMENTO("Abbigliamento");


    private String descrizione;

    TipologiaProdottoEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
