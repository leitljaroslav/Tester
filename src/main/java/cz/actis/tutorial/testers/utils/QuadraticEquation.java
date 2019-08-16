package cz.actis.tutorial.testers.utils;

import cz.actis.tutorial.testers.tester4.Point;

import java.util.ArrayList;
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
        List<Point> root = new ArrayList<>();
        double d = b * b - (4 * a * c);
        double y = 0;
        if (a != 0) {
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
        } else {
            double x = -c/b;
            Point linearRoot = new Point(x,y);
            root.add(linearRoot);
        }
        return root;
    }

    public List<Point> pointsOfFunction() {
        List<Point> functionPoints = new ArrayList<>();
        double step = 0.01;
        double y = 0;
        double x = 0;
        if (a == 0 && b != 0) {
            y = 750;
            x = (y - c) / b;
            Point linearPoint1 = new Point(x, y);
            functionPoints.add(linearPoint1);
            x = (-y - c) / b;
            Point linearPoint2 = new Point(x, -y);
            functionPoints.add(linearPoint2);

        } else if (a != 0) {
            double xTop = -b / (2 * a);
            if (a < 0) {
                for (int i = 0; i <= 1; i++) {
                    x = 0;
                    y = 0;
                    if (i == 0) {
                        while (y >= -750) {
                            x = x + step;
                            double temp = xTop - x;
                            y = a * temp * temp + b * temp + c;
                            Point quadraticPoint = new Point(temp, y);
                            functionPoints.add(quadraticPoint);
                        }
                        functionPoints = getreversedList(functionPoints);
                    } else {
                        while (y >= -750) {
                            x = x + step;
                            double temp = xTop + x;
                            y = a * temp * temp + b * temp + c;
                            Point quadraticPoint = new Point(temp, y);
                            functionPoints.add(quadraticPoint);
                        }
                    }
                }
            } else {
                for (int j = 0; j <= 1; j++) {
                    x = 0;
                    y = 0;
                    if (j == 0) {
                        while (y <= 750) {
                            x = x - step;
                            double temp1 = xTop - x;
                            y = a * temp1 * temp1 + b * temp1 + c;
                            Point quadraticPoint = new Point(temp1, y);
                            functionPoints.add(quadraticPoint);
                        }
                        functionPoints = getreversedList(functionPoints);
                    } else {
                        while (y <= 750) {
                            x = x - step;
                            double temp1 = xTop + x;
                            y = a * temp1 * temp1 + b * temp1 + c;
                            Point quadraticPoint = new Point(temp1, y);
                            functionPoints.add(quadraticPoint);
                        }
                    }
                }
            }
        }
        return functionPoints;
    }

    public List<Point> getreversedList(List<Point> functionPoints) {
        List<Point> reversedList = new ArrayList<>();
        for (int i = 1; i <= functionPoints.size(); i++) {
            reversedList.add(functionPoints.get(functionPoints.size() - i));
        }
        return reversedList;
    }
}
