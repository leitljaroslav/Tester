package cz.actis.tutorial.testers;

import cz.actis.tutorial.testers.tester4.Point;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static List<Point> solveQuadraticEquation(double a, double b, double c) {
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

    public static List<List<Point>> pointsOfFunction(String line) {
        List<List<Point>> function = new ArrayList<>();
        Point[] functionPoints = new Point[1000];
            double[] parameter = getParameters(line);
            double a = parameter[0];
            double b = parameter[1];
            double c = parameter[2];
        for (int i = 0; i < 1000; i++) {
            if (solveQuadraticEquation(a, b, c).size() == 1 || solveQuadraticEquation(a, b, c).size() == 2) {
                double root1 = solveQuadraticEquation(a, b, c).get(0).getX();
                double temp = root1 + 0.01 * (i - 500);
                double y = a * temp * temp + b * temp + c;
                Point functionPoint = new Point(temp, y);
                functionPoints[i] = functionPoint;
            } else {
                continue;
            }

        }
        function.add(Arrays.asList(functionPoints));
        return function;
    }

    public static List<List<List<Point>>> listOfFunctions() throws IOException {
        List<List<List<Point>>> totalResult = new ArrayList<>();
        InputStream inputStream = new FileInputStream("C:\\Users\\jakub.masek\\IdeaProjects\\Tester\\src\\test\\resources\\quadratic.source");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            totalResult.add(pointsOfFunction(line));
        }
        return totalResult;
    }

    public static double[] getParameters(String line) {
        double[] parameters = new double[3];
        String[] params = line.split(";");
        String valueA = params[0];
        parameters[0] = Double.parseDouble(valueA);
        String valueB = params[1];
        parameters[1] = Double.parseDouble(valueB);
        String valueC = params[2];
        parameters[2] = Double.parseDouble(valueC);
        return parameters;
    }

    public static void main(String[] args) throws IOException {
        List<List<List<Point>>> lists = listOfFunctions();
        System.out.println("finished");
    }
}