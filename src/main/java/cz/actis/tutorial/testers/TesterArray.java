package cz.actis.tutorial.testers;


import java.util.Arrays;

public class TesterArray {
    /***
     * Zadani:
     * Naimplementuj public metodu nazvem intArraySorterASC, ktera bude vracet serazene pole integeru (od nejmensiho po nejvetsi)
     * Jako argument bude mit pole integeru
     */
    public int[] intArraySorterASC(int[] ints) {
        int[] sorted = ints.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    /**
     * Zadani:
     * Naimplementuj funkci intArraySorterDESC, ktera bude stejne jako intArraySorter radit, ale tentokrat od nejvetsiho po nejmensi
     */
    public int[] intArraySorterDESC(int[] ints) {
        int[] sorted = ints.clone();
        int sortedLength = sorted.length;
        for (int i = 0; i < sortedLength / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sortedLength - 1 - i];
            sorted[sortedLength - 1 - i] = temp;
        }
        return sorted;
    }
}

