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
     * <p>
     * return
     */
    public List<Point> solveQuadraticEquation(double a, double b, double c) {
        double d = b * b - (4 * a * c);
        List<Point> root = new ArrayList<>();
        double y = 0;
        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            if (x1 < x2) {
                Point root1 = new Point(x1, y);
                Point root2 = new Point(x2, y);
                root.add(0, root1);
                root.add(1, root2);
            } else {
                Point root1 = new Point(x1, y);
                Point root2 = new Point(x2, y);
                root.add(0, root2);
                root.add(1, root1);
            }
        } else if (d == 0) {
            double x3 = -b / (2 * a);
            Point root0 = new Point(x3, y);
            root.add(0, root0);
        }
        return root;
    }
}
