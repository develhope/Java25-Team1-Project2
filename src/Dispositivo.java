import java.math.BigDecimal;
import java.util.UUID;

// TODO sistemare interfaccia
public interface Dispositivo {

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