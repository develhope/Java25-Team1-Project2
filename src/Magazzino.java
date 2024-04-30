import java.util.ArrayList;

public class Magazzino {
     ArrayList<Prodotti> prodottiInMagazzino = new ArrayList<>();

     ArrayList<Prodotti> prodottiInCarrello = new ArrayList<>();

     public void aggiungiProdotti (Prodotti prodotti) {
         prodottiInMagazzino.add(prodotti);
         System.out.println("Prodotto aggiunto al magazzino.");
     }

     public void stampaMagazzino(){
       System.out.println("Prodotti in magazzino = ");
       for(Prodotti prodotti : prodottiInMagazzino){
        System.out.println(" ID " + prodotti.leggiId());
    }
   }
 }
