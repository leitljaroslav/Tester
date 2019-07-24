package cz.actis.tutorial.testers;

import cz.actis.tutorial.exceptions.InvalidArgumentException;

/**
 * Pro vsechny priklady lze pouzit jen tridu java.lang.Math
 */
public class Tester3 {
    /**
     * Naimplementuj metodu square, ktera spocita druhou mocninu argumentu
     * Argument je int
     * Vraci se int
     */
    public static double square(int a) {
        return Math.pow(a, 2);
    }


    /**
     * Naimplementuj metodu power, ktera vezme prvni argument a umocni ho druhym argumentem (x^y)
     * Argument je int a int
     * Vraci se int
     */
    public static double power(int a, int b) {
    return Math.pow(a, b);
    }

    /**
     * Naimplementuj metodu sqrt, ktera spocita druhou odmocninu z argumentu/
     * Pokud je argument zaporny, vyhod vyjimku InvalidArgumentException
     * argument je int
     * Vraci se double
     */
    public static double sqrt(int a){
        if (a >= 0) {
            return Math.sqrt(a);
        } else {
            throw new InvalidArgumentException();
        }
        }

    /**
     * Naimplementuj metodu root, ktera spocita n-tou odmocninu z argumentu.
     * Pokud je argument zaporny, vyhod vyjimku InvalidArgumentException
     * argument je int a int
     * Vraci se double
     */
    public static double root(int a, int b) {
        if (a >= 0){
            return Math.pow(a,(double) 1/b);
        } else {
            throw new InvalidArgumentException();
        }
    }

}
