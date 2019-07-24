package cz.actis.tutorial.testers;

import cz.actis.tutorial.testers.tester4.Point;

import java.util.ArrayList;
import java.util.List;

public class Tester4 {
    /**
     * Zadani:
     * Napis public funkci solveQuadraticEquation, ktera bude mit 3 parametry (a, b, c) a bude vracet List<Point>
     * Argumenty jsou double, double, double
     * Vraci se List<Point>, ktery bude obsahovat 0, 1 nebo 2 body.
     * Point vytvor pres new Point(x, y), kde x je souradnice na ose x, a y souradnice na ose y.
     */

    public List<Point> solveQuadraticEquation(double a, double b, double c) {
        ArrayList<Point> roots        = new ArrayList<>(2);
        double           discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant < 0) {
            return roots;
        }

        if (discriminant == 0) {
            double x = (-b + Math.sqrt(discriminant)) / 2 * a;
            roots.add(new Point(x, 0));
        }

        if (discriminant > 0) {
            double x1 = (-b - Math.sqrt(discriminant)) / 2 * a;
            double x2 = (-b + Math.sqrt(discriminant)) / 2 * a;
            if(x1 < x2) {
                roots.add(new Point(x1, 0));
                roots.add(new Point(x2, 0));
            } else {
                roots.add(new Point(x2, 0));
                roots.add(new Point(x1, 0));
            }
        }
        return roots;
    }
}
