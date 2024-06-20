import java.math.BigDecimal;
import java.util.UUID;

public interface Dispositivo {
    ProdottoEnum getTipoDispositivo();

        UUID getId();
        String getNome();
        String getDescrizione();
        BigDecimal getPrezzoVendita();


    public interface DispositivoElettronico extends Dispositivo {
        void accendi();
        void spegni();
    }

    public interface Smartphone extends DispositivoElettronico {
        void chiamare(String numero);
        void inviareSMS(String numero, String messaggio);
    }

    public interface Notebook extends DispositivoElettronico {
        void avviaApplicazione(String nomeApp);
        void spegniApplicazione(String nomeApp);
    }
}