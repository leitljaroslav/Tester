package cz.actis.tutorial.testers;

import cz.actis.tutorial.testers.tester4.Point;
import cz.actis.tutorial.testers.utils.QuadraticEquation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tester6 {


    /**
     * Zadani
     * Naimplementuj funkci solveRoots, parametrem bude InputStream.
     * Ze souboru quadratic.src nacti jednotive zadani kvadraticke rovnice.
     * Kazdy radek obsahuje hodnoty a, b a c oddělené středníky
     * Výstupem je List<List<Point>>
     */
    public List<List<Point>> solveRoots(InputStream inputStream) throws IOException {
        List<List<Point>> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            String[] parameters = line.split(";");
            String valueA = parameters[0];
            double a = Double.parseDouble(valueA);
            String valueB = parameters[1];
            double b = Double.parseDouble(valueB);
            String valueC = parameters[2];
            double c = Double.parseDouble(valueC);
            Tester4 tester4 = new Tester4();
            result.add(tester4.solveQuadraticEquation(a, b, c));
        }
        return result;
    }

    /**
     * }
     * Zadani
     * Naimplementuj funkci writeRoots
     * Parametrem bude List<Point> a File
     * Funkce samotna bude void, ale vytvori soubor dle parametru File, který bude obsahovat výstup ve formátu:
     * pro 2 koreny: "x1=%2.5f;x2=2.5f"
     * pro 1 koren:  "x1=%2.5f;"
     * pro 0 korenu: "x1=NaN;"
     */
    public void writeRoots(List<List<Point>> list, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (List<Point> points : list) {
            String output = "";
            if (points.size() == 2) {
                output = String.format("x1=%2.5f;x2=%2.5f", points.get(0).getX(), points.get(1).getX());
            } else if (points.size() == 1) {
                output = String.format("x1=%2.5f;", points.get(0).getX());
            } else {
                output = "x1=NaN;";
            }
            writer.write(output);
        }

    }


}