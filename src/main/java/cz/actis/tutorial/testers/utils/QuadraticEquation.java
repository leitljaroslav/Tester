package cz.actis.tutorial.testers.utils;

import cz.actis.tutorial.testers.tester4.Point;

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
        return roots;
    }

    public void setRoots(List<Point> roots) {
        this.roots = roots;
    }

    private double      a;
    private double      b;
    private double      c;
    private List<Point> roots;
}
