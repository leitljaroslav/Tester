package cz.actis.tutorial.tester6;

public class TesterArray {
    /***
     * Zadani:
     * Naimplementuj public metodu nazvem intArraySorterASC, ktera bude vracet serazene pole integeru (od nejmensiho po nejvetsi)
     * Jako argument bude mit pole integeru
     */
    public int[] intArraySorterASC(int[] unsortedArray) {
        int[] sortedArray = new int[unsortedArray.length];
        for (int i = 0; i < unsortedArray.length; i++) {
            sortedArray[i] = unsortedArray[i];
        }
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray.length - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int buffer = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = buffer;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Zadani:
     * Naimplementuj funkci intArraySorterDESC, ktera bude stejne jako intArraySorter radit, ale tentokrat od nejvetsiho po nejmensi
     */

    public int[] intArraySorterDESC(int[] unsortedArray) {
        int[] ints = new int[unsortedArray.length];
        for (int i = 0; i < unsortedArray.length; i++) {
            ints[unsortedArray.length - 1 - i] = unsortedArray[i];
        }
        return ints;
    }
}
