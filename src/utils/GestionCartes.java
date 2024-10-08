package utils;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import Cartes.*;

public class GestionCartes {
	
	public static <T> T extraireDirect(List<T> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        T element = list.remove(index);
        return element;
    }
	
	public static <T> T extraireIterator(List<T> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        ListIterator<T> iterator = list.listIterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        T element = iterator.next();
        iterator.remove();
        return element;
    }
	
	public static <T> List<T> melanger(List<T> list) {
        List<T> shuffledList = new ArrayList<>();
        while (!list.isEmpty()) {
            T element = extraireDirect(list);
            shuffledList.add(element);
        }
        return shuffledList;
    }
	
	public static <T> boolean verifierMelange(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (T element : list1) {
            int frequency1 = Collections.frequency(list1, element);
            int frequency2 = Collections.frequency(list2, element);
            if (frequency1 != frequency2) {
                return false;
            }
        }
        return true;
    }
	
	public static <T> List<T> rassembler(List<T> list) {
        List<T> rearrangedList = new ArrayList<>();
        for (T element : list) {
            if (!rearrangedList.contains(element)) {
                rearrangedList.add(element);
            } else {
                int index = rearrangedList.lastIndexOf(element);
                rearrangedList.add(index, element);
            }
        }
        return rearrangedList;
    }
	
	public static <T> boolean verifierRassemblement(List<T> list) {
        ListIterator<T> iterator1 = list.listIterator();
        T previous = null;
        while (iterator1.hasNext()) {
            T current = iterator1.next();
            if (previous != null && !current.equals(previous)) {
                ListIterator<T> iterator2 = list.listIterator(iterator1.previousIndex());
                while (iterator2.hasNext()) {
                    T next = iterator2.next();
                    if (next.equals(previous)) {
                        return false;
                    }
                }
            }
            previous = current;
        }
        return true;
    }
	
	public static <T> void testerMelangeEtRassemblement(List<T> list) {
        List<T> originalList = new ArrayList<>(list);
        List<T> shuffledList = GestionCartes.melanger(list);
        System.out.println("Original list: " + originalList);
        System.out.println("Shuffled list: " + shuffledList);
        System.out.println("Shuffled list without error? " + GestionCartes.verifierMelange(originalList, shuffledList));
        List<T> rearrangedList = GestionCartes.rassembler(shuffledList);
        System.out.println("Rearranged list: " + rearrangedList);
        System.out.println("Rearranged list without error? " + GestionCartes.verifierRassemblement(rearrangedList));
    }

    public static void testerMelangeEtRassemblementSurListe() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 1, 2, 1, 3));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 1));

        testerMelangeEtRassemblement(list1);
        testerMelangeEtRassemblement(list2);
        testerMelangeEtRassemblement(list3);
        testerMelangeEtRassemblement(list4);
    }


    public static void testerMelangeEtRassemblementSurJeuDeCartes() {
        JeuDeCartes jeu = new JeuDeCartes();
        List<Cartes> listeCarteNonMelangee = new LinkedList<>();
        for (Cartes carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }
        List<Cartes> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        System.out.println(listeCartes);
        listeCartes = GestionCartes.melanger(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste mélangée sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));
    }

}
