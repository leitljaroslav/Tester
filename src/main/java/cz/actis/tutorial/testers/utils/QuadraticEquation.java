package cz.actis.tutorial.testers.utils;

import cz.actis.tutorial.testers.tester4.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadraticEquation {
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public List<Point> getRoots() {
        return solveQuadraticEquation();
    }

    public List<Point> getPoints() {
        return pointsOfFunction();
    }

    private double a;
    private double b;
    private double c;

    public List<Point> solveQuadraticEquation() {
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

    public List<Point> pointsOfFunction() {
        List<Point> functionPoints = new ArrayList<>();
        if (a == 0) {
            double x1 = 0;
            for (int k = 0; k < 2500; k++) {
                double temp1 = x1 + 0.01 * (k - 1250);
                double y1 = (b * temp1) + c;
                Point linearPoint = new Point(temp1,y1);
                functionPoints.add(linearPoint);
            }
        } else {
            for (int i = 0; i < 2500; i++) {
                double xTop = -b / (2 * a);
                double temp = xTop + 0.01 * (i - 1250);
                double y = a * temp * temp + b * temp + c;
                Point functionPoint = new Point(temp, y);
                functionPoints.add(functionPoint);
            }
        }
        return functionPoints;
    }
}
