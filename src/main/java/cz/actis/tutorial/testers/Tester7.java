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
    private int WIDTH = 1500;
    private int HEIGHT = 1500;
    private double SCALE = 1;

    public void calculateParametersFromFile(InputStream inputStream) throws IOException {

        double[] params = new double[3];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String sentence = "Parameters of this Function:  ";
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineParameter = line.split(";");
            String valueA = lineParameter[0];
            String valueB = lineParameter[1];
            String valueC = lineParameter[2];
            params[0] = Double.parseDouble(valueA);
            params[1] = Double.parseDouble(valueB);
            params[2] = Double.parseDouble(valueC);
            QuadraticEquation quadraticEquation = new QuadraticEquation(params[0], params[1], params[2]);
            BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.setColor(Color.white);
            graphics2D.fillRect(0, 0, WIDTH, HEIGHT);
            List<Point> points = quadraticEquation.pointsOfFunction();
            System.out.println(i);
            String total = sentence + valueA + "; " + valueB + "; " + valueC;
            graphics2D.setColor(Color.black);
            getAxis(graphics2D, quadraticEquation,params);
            graphics2D.setFont(new Font("Arial", Font.BOLD, 20));
            graphics2D.drawString(total, WIDTH - 500, HEIGHT - 1450);
            for (int j = 1; j < points.size(); j++) {
                double x1 = (points.get(j - 1).getX() * SCALE) + WIDTH / 2;
                double y1 = -((points.get(j - 1).getY() * SCALE) - HEIGHT / 2);
                double x2 = (points.get(j).getX() * SCALE) + WIDTH / 2;
                double y2 = -((points.get(j).getY() * SCALE) - HEIGHT / 2);
                graphics2D.setColor(Color.black);
                graphics2D.draw(new Line2D.Double(x1, y1, x2, y2));
            }
            new File("data").mkdirs();
            ImageIO.write(bufferedImage, "PNG", new File("data\\file" + i + ".png"));
            i++;
        }
    }

    public void getAxis(Graphics2D graphics2D, QuadraticEquation quadraticEquation, double[] params) {
        int step = 10;
        graphics2D.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        graphics2D.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);
        String x = "x";
        String y = "y";
        double touchPoint1Num;
        double touchPoint2Num;
        String information;
        String legend = "Step is: " + Integer.toString(step);
        graphics2D.setFont(new Font("Arial", Font.BOLD, 20));
        if (quadraticEquation.getRoots().size() == 0) {
            information = "This Function don't have any touch points";
            graphics2D.drawString(information, WIDTH - 500, HEIGHT - 1350);
        } else if(quadraticEquation.getRoots().size() == 1) {
            touchPoint1Num = quadraticEquation.getRoots().get(0).getX();
            information = "Touch point is: ";
            String touchPoint = x + "= " + touchPoint1Num;
            graphics2D.drawString(information, WIDTH - 500, HEIGHT - 1350);
            graphics2D.drawString(touchPoint,WIDTH - 300, HEIGHT - 1350);
        }else if(quadraticEquation.getRoots().size() == 1 && params[0] == 0){
            information = "Touch point is: ";
            touchPoint1Num = quadraticEquation.getRoots().get(0).getX();
            String touchPoint = x + "= " + touchPoint1Num;
            graphics2D.drawString(information, WIDTH - 500, HEIGHT - 1350);
            graphics2D.drawString(touchPoint, WIDTH - 300, HEIGHT - 1350);
        } else  {
            touchPoint1Num = quadraticEquation.getRoots().get(0).getX();
            touchPoint2Num = quadraticEquation.getRoots().get(1).getX();
            information = "Touch points are: ";
            String touchPoint1 = x + "= " + touchPoint1Num;
            String touchPoint2 = x + "= " + touchPoint2Num;
            graphics2D.drawString(information,WIDTH - 500, HEIGHT - 1350 );
            graphics2D.drawString(touchPoint1, WIDTH - 300, HEIGHT - 1350 );
            graphics2D.drawString(touchPoint2, WIDTH - 300, HEIGHT - 1300 );
        }
        graphics2D.drawString(x, WIDTH - 50, HEIGHT / 2 + 50);
        graphics2D.drawString(y, WIDTH / 2 - 50, HEIGHT - 1450);
        graphics2D.drawString(legend, WIDTH - 500, HEIGHT - 1400);
        for (int l = 0; l < WIDTH / step; l++) {
            int valueX = l * step;
            graphics2D.drawLine(WIDTH - valueX, HEIGHT / 2, WIDTH - valueX, HEIGHT / 2 - 5);
            if (l % 5 == 0) {
                graphics2D.drawLine(WIDTH - valueX, HEIGHT / 2, WIDTH - valueX, HEIGHT / 2 - 10);
                int calloutNumberX = -(valueX - 750);
                String calloutX = Integer.toString(calloutNumberX);
                graphics2D.setFont(new Font("Arial", Font.ITALIC, 10));
                graphics2D.drawString(calloutX, WIDTH - valueX - 7, HEIGHT / 2 + 10);
            }

        }
        for (int k = 0; k < HEIGHT / step; k++) {
            int valueY = k * step;
            graphics2D.drawLine(WIDTH / 2 + 5, HEIGHT - valueY, WIDTH / 2, HEIGHT - valueY);
            if (k % 5 == 0) {
                graphics2D.drawLine(WIDTH / 2 + 10, HEIGHT - valueY, WIDTH / 2, HEIGHT - valueY);
                int calloutNumberY = valueY - 750;
                String calloutY = Integer.toString(calloutNumberY);
                if (calloutNumberY != 0) {
                    graphics2D.setFont(new Font("Arial", Font.ITALIC, 10));
                    graphics2D.drawString(calloutY, WIDTH / 2 - 25, HEIGHT - valueY + 5);
                }
            }
        }

    }


}
