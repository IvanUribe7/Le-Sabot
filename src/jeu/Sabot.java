package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Cartes.*;

public class Sabot implements Iterable<Cartes>{

    private Cartes[] cartes;  
    private int nbCartes;   
    private int capaciteMax = 106;
    private int modCount = 0;

    public Sabot(Cartes[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;  
    }
   
    public boolean estVide() {
        return this.nbCartes == 0;
    }
    
    public void ajouterCarte(Cartes carte) throws Exception {
        if (nbCartes > capaciteMax) {
            throw new Exception("Le sabot est plein.");
        }
        cartes[nbCartes] = carte;
        nbCartes++;
    }
    
    @Override
    public Iterator<Cartes> iterator() {
        return new SabotIterator();
    }
    
    private class SabotIterator implements Iterator<Cartes> {
        private int index = 0;
        private boolean lastRetired = false; 
        private int expectedModCount = modCount; 

        @Override
        public boolean hasNext() {
            return index < nbCartes;
        }

        @Override 
        public Cartes next() throws ConcurrentModificationException,NoSuchElementException{
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Le sabot a été modifié pendant l'itération.");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Pas de carte suivante.");
            }
            lastRetired = false;
            return cartes[index++];
        }

        @Override
        public void remove() throws ConcurrentModificationException,IllegalStateException{
        	
        	if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Le sabot a été modifié pendant l'itération.");
            }
            if (index == 0 || lastRetired) {
                throw new IllegalStateException("Impossible de retirer la carte.");
            }
            
            for (int i = index - 1; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i + 1];
            }
            cartes[--nbCartes] = null;
            lastRetired = true;
            modCount++;
            expectedModCount = modCount;  
        }
    }

}
