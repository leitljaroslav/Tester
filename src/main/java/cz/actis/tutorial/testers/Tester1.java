package cz.actis.tutorial.testers;

public class Tester1 {
    /**
     * UKAZKA
     * Zadani
     * Naimplementuj public metodu plus, ktera bude scitat 2 cisla. Parametry budou int a int
     * Vracet se bude int
     */

    public int plus(int a, int b) {
        return a + b;
    }

    /**
     * Zadani
     * Naimplementuj public metodu minus, ktera bude odecitat 2 cisla (a - b). Parametry budou int a int
     * Vracet se bude int
     */
    public int minus(int a, int b){
        return a - b;
    }
    /**
     * Zadani
     * Naimplementuj public metodu times, ktera bude nasobit 2 cisla. Parametry budou int a int
     * Vracet se bude int
     */
    public int times(int a, int b) {
        return a * b;
    }

    /**
     * Zadani
     * Naimplementuj public metodu divide, ktera bude delit 2 cisla. Parametry budou int a int
     * Vracet se bude double
     */
    public double divide(int a, int b){
        return (double) a / (double) b;
    }

    /**
     * Zadani
     * Naimplementuj public metodu mod, ktera vrati zbytek po deleni. Parametry budou int a int
     * Vracet se bude int
     */
    public int mod(int a, int b) {
        return a % b;
    }

}
