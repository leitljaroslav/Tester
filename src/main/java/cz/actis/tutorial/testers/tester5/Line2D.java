package cz.actis.tutorial.testers.tester5;

import cz.actis.tutorial.testers.tester4.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Line2D {
    /**
     * Zadání: V balíku tester5 vytvoř třídu Line2D.
     * Jako argument konstruktoru budou 2 body (tester4.Point)
     *
     * Této tříde naimplmenetuj funkce:
     *  isPerpendicular s argumentem Line2D.
     *  Tato třída vrací boolean, pokud jsou přímky na sebe kolmé
     *
     *  isParallel s argumentem Line2D
     *  Tato třída vrací boolean pokud jsou přímky rovnoběžné
     *
     *  getAngle s argumentem Line2D
     *  Tato třída vrací double hodnotu úhlu ve stupních (vždy ten menší úhel)
     */

    private Point a;
    private Point b;

    public Line2D(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    /**
     *
     * @param line
     * @return true if argument is perpendicular
     */
    public boolean isPerpendicular(Line2D line) {
        throw new NotImplementedException();
    }

    public boolean isParallel(Line2D line) {
        throw new NotImplementedException();

    }

    public double getAngle(Line2D line) {
        throw new NotImplementedException();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }
}
