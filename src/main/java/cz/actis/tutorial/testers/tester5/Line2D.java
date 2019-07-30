package cz.actis.tutorial.testers.tester5;

import cz.actis.tutorial.testers.tester4.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Line2D {
    /**
     * Zadání: V balíku tester5 vytvoř třídu Line2D.
     * Jako argument konstruktoru budou 2 body (tester4.Point)
     * <p>
     * Této tříde naimplmenetuj funkce:
     * isPerpendicular s argumentem Line2D.
     * Tato třída vrací boolean, pokud jsou přímky na sebe kolmé
     * <p>
     * isParallel s argumentem Line2D
     * Tato třída vrací boolean pokud jsou přímky rovnoběžné
     * <p>
     * getAngle s argumentem Line2D
     * Tato třída vrací double hodnotu úhlu ve stupních (vždy ten menší úhel)
     */

    private Point a;
    private Point b;

    public Line2D(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    /**
     * @param line
     * @return true if argument is perpendicular
     */
    public boolean isPerpendicular(Line2D line) {
        double x1 = line.b.getX() - line.a.getX();
        double y1 = line.b.getY() - line.a.getY();
        double soucetVectoru1 = x1 * x1 + y1 * y1;
        double velikostVectoru1 = Math.sqrt(soucetVectoru1);
        double x2 = b.getX() - a.getX();
        double y2 = b.getY() - a.getY();
        double soucetVectoru2 = x2 * x2 + y2 * y2;
        double velikostVectoru2 = Math.sqrt(soucetVectoru2);
        double skalar = x1 * x2 + y1 * y2;
        double pomer = skalar / (velikostVectoru1 * velikostVectoru2);
        double cosUhlu = Math.cos(pomer);
        return cosUhlu == 1;

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
