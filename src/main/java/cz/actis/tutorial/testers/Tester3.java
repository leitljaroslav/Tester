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

    public int square(int a) {
        return a * a;
    }

    /**
     * Naimplementuj metodu power, ktera vezme prvni argument a umocni ho druhym argumentem (x^y)
     * Argument je int a int
     * Vraci se int
     */

    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    /**
     * Naimplementuj metodu sqrt, ktera spocita druhou odmocninu z argumentu/
     * Pokud je argument zaporny, vyhod vyjimku InvalidArgumentException
     * argument je int
     * Vraci se double
     */

    public double sqrt(int a) {
        if (a < 0) {
            throw new InvalidArgumentException();
        }
        return Math.sqrt(a);
    }

    /**
     * Naimplementuj metodu root, ktera spocita n-tou odmocninu z argumentu.
     * Pokud je argument zaporny, vyhod vyjimku InvalidArgumentException
     * argument je int a int
     * Vraci se double
     */

    public double root(int a, int b) {
        if (a < 0) {
            throw new InvalidArgumentException();
        }
        double root = 1.0d / b;
        return Math.pow(a, root);
    }
}
