import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;
public class MagazzinoTest {
    @Test
    public void confermaAggiuntaProdotto(){
        Magazzino magazzino = new Magazzino();
        Prodotti prodotto1 = new Prodotti(TipoDispositivo.SMARTPHONE, "Apple", "Iphone12", "Ciao", 5.5, TipoMemoriaArchiviazione.NVMe, 128, 899.99, 999.99, UUID.randomUUID());
        Boolean verificaProdotto = magazzino.aggiungiProdotto(prodotto1);
        Assert.assertTrue(verificaProdotto);
    }
    @Test
    public void confermaRimozioneProdottoInventario(){
        Magazzino magazzino = new Magazzino();
        Prodotti prodotto1 = new Prodotti(TipoDispositivo.SMARTPHONE, "Apple", "Iphone12", "Ciao", 5.5, TipoMemoriaArchiviazione.NVMe, 128, 899.99, 999.99, UUID.randomUUID());
        magazzino.aggiungiProdotto(prodotto1);
        Boolean rimozioneProdotto = magazzino.rimuoviProdotto(prodotto1.getId());
        Assert.assertTrue(rimozioneProdotto);
    }
    @Test
    public void confermaMancataRimozioneProdottoInventario(){
        Magazzino magazzino = new Magazzino();
        Prodotti prodotto1 = new Prodotti(TipoDispositivo.SMARTPHONE, "Apple", "Iphone12", "Ciao", 5.5, TipoMemoriaArchiviazione.NVMe, 128, 899.99, 999.99, UUID.randomUUID());
        Boolean rimozioneProdotto = magazzino.rimuoviProdotto(prodotto1.getId());
        Assert.assertFalse(rimozioneProdotto);
    }


}