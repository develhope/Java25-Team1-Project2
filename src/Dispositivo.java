import java.math.BigDecimal;
import java.util.UUID;


public interface Dispositivo {
//controllo dello stato del dispositivo
    boolean isAcceso();

    boolean isSpento();

    void setAcceso(boolean acceso);

    void setSpento(boolean spento);

// controllo per la gestione delle chiamate ed sms
    String Chiamare();

    String SMS();

    void inviaChiamata(String chiamare, String numero);

    void inviaSMS(String SMS, String numero);
}