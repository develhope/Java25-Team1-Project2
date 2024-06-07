
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino();
        Magazzino magazzinoEsselunga = new Magazzino();
        Magazzino magazzinoArmani = new Magazzino();

        Carrello carrello = new Carrello();

        Smartphone smartphone1 = new Smartphone(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.SMARTPHONE,"Samsung Galaxy S8","",599.99,"","",5.6,
                                TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,300.00);

        Smartphone smartphone2 = new Smartphone(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.SMARTPHONE,"Samsung Galaxy S8","",599.99,"","",5.6,
                TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,300.00);

        Notebook notebook1 = new Notebook(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.NOTEBOOK,"Samsung Galaxy S8","",599.99,"","",5.6,
                TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,300.00);

        Notebook notebook2 = new Notebook(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.NOTEBOOK,"Samsung Galaxy S8","",599.99,"","",5.6,
                TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,300.00);

        Tablet tablet1 = new Tablet(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.TABLET,"Samsung Galaxy S8","",599.99,"","",5.6,
                TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,300.00);

        Tablet tablet2 = new Tablet(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.TABLET,"Samsung Galaxy S8","",599.99,"","",5.6,
                TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,300.00);

        magazzinoEuronics.aggiungiProdotto(smartphone1);
        magazzinoEuronics.aggiungiProdotto(smartphone2);
        magazzinoEuronics.aggiungiProdotto(notebook1);
        magazzinoEuronics.aggiungiProdotto(notebook2);
        magazzinoEuronics.aggiungiProdotto(tablet1);
        magazzinoEuronics.aggiungiProdotto(tablet2);

        // Esempio di utilizzo dei metodi di ricerca
        magazzinoEuronics.cercaDispositiviPerTipo(TipoDispositivoEnum.SMARTPHONE);
        magazzinoEuronics.cercaDispositiviPerProduttore("Samsung");
        magazzinoEuronics.cercaDispositiviPerModello("Galaxy S8");
        magazzinoEuronics.ricercaPerPrezzoAcquisto(450.00);
        magazzinoEuronics.ricercaPerPrezzoVendita(600.00);
    }
}