package cz.actis.tutorial.testers.tester5;

import cz.actis.tutorial.testers.tester4.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.DecimalFormat;

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
        double sumVector1 = x1 * x1 + y1 * y1;
        double sizeVector1 = Math.sqrt(sumVector1);
        double x2 = b.getX() - a.getX();
        double y2 = b.getY() - a.getY();
        double sumVector2 = x2 * x2 + y2 * y2;
        double sizeVector2 = Math.sqrt(sumVector2);
        double scalarProduct = x1 * x2 + y1 * y2;
        double ratio = scalarProduct / (sizeVector1 * sizeVector2);
        return ratio == 0;

    }

    public boolean isParallel(Line2D line) {
        double u1 = line.b.getX() - line.a.getX();
        double u2 = line.b.getY() - line.a.getY();
        double v1 = b.getX() - a.getX();
        double v2 = b.getY() - a.getY();
        return (u1 / v1) == (u2 / v2);
    }

    public double getAngle(Line2D line) {
        double x3 = line.b.getX() - line.a.getX();
        double y3 = line.b.getY() - line.a.getY();
        double sumVector3 = x3 * x3 + y3 * y3;
        double sizeVector3 = Math.sqrt(sumVector3);
        double x4 = b.getX() - a.getX();
        double y4 = b.getY() - a.getY();
        double sumVector4 = x4 * x4 + y4 * y4;
        double sizeVector4 = Math.sqrt(sumVector4);
        double scalarProduct1 = x3 * x4 + y3 * y4;
        double cosAngle = scalarProduct1 / (sizeVector3 * sizeVector4);
        double angle = Math.acos(cosAngle);
        double result = Math.toDegrees(angle);
        return ((int)(result * 1000)) /1000d;
    }
}