public enum TipoMemoriaArchiviazioneEnum {
    HDD("HDD"),
    SSD("SSD"),
    NVMe("NVMe");

    private String descrizione;

    TipoMemoriaArchiviazioneEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
