package cz.actis.tutorial.testers;

import cz.actis.tutorial.testers.tester4.Point;
import cz.actis.tutorial.testers.utils.QuadraticEquation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class Tester7 {
    public void calculateParametersFromFile(InputStream inputStream) throws IOException {
        {
            double[] params = new double[3];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            for (int i = 0; i < 1000; i++) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] lineParameter = line.split(";");
                String valueA = lineParameter[0];
                String valueB = lineParameter[1];
                String valueC = lineParameter[2];
                params[0] = Double.parseDouble(valueA);
                params[1] = Double.parseDouble(valueB);
                params[2] = Double.parseDouble(valueC);
                QuadraticEquation quadraticEquation = new QuadraticEquation(params[0], params[1], params[2]);
                BufferedImage bufferedImage = new BufferedImage(900, 900, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = bufferedImage.createGraphics();
                graphics2D.setColor(Color.red);
                List<Point> points = quadraticEquation.pointsOfFunction();
                for (int j = 1; j < 1000; j++) {
                    double x1 = points.get(j - 1).getX();
                    double y1 = points.get(j - 1).getY();
                    double x2 = points.get(j).getX();
                    double y2 = points.get(j).getY();
                    graphics2D.draw(new Line2D.Double(x1, y1, x2, y2));
                }
                ImageIO.write(bufferedImage, "PNG", new File("C:\\Users\\jakub.masek\\Documents\\file"));
            }
        }

    }
}

