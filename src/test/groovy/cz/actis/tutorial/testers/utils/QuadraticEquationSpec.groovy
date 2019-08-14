package cz.actis.tutorial.testers.utils

import cz.actis.tutorial.testers.tester4.Point
import spock.lang.Shared
import spock.lang.Specification

class QuadraticEquationSpec extends Specification {
    @Shared
    QuadraticEquation quadraticEquation

    void setup() {
        quadraticEquation = new QuadraticEquation(1, 7, 12)
    }

    def "Solve quadratic equation with 2 roots"() {

        when:
        List<Point> root = quadraticEquation.solveQuadraticEquation()
        then:
        root.size() == 2
        root[0].x == -4
        root[0].y == 0
        root[1].x == -3
        root[1].y == 0

        when:
        a = -1
        b = 5
        c = 6
        quadraticEquation = new QuadraticEquation(a, b, c)
        root = quadraticEquation.solveQuadraticEquation()
        then:
        root.size() == 2
        root[0].x == -1
        root[0].y == 0
        root[1].x == 6
        root[1].y == 0

        when:
        a = 1
        b = 5
        c = 6
        quadraticEquation = new QuadraticEquation(a, b, c)
        root = quadraticEquation.solveQuadraticEquation()
        then:
        root.size() == 2
        root[0].x == -3
        root[0].y == 0
        root[1].x == -2
        root[1].y == 0

        when:
        a = 1
        b = 1
        c = -2
        quadraticEquation = new QuadraticEquation(a, b, c)
        root = quadraticEquation.solveQuadraticEquation()
        then:
        root.size() == 2
        root[0].x == -2
        root[0].y == 0
        root[1].x == 1
        root[1].y == 0
    }

    def "Solve quadratic equation with one root"() {
        setup:
        double a = 1
        double b = -10
        double c = 25
        quadraticEquation = new QuadraticEquation(a, b, c)
        when:
        List<Point> root = quadraticEquation.solveQuadraticEquation()
        then:
        root.size() == 1
        root[0].x == 5
        root[0].y == 0
    }

    def "Solve quadratic equation without root"() {
        setup:
        double a = 1
        double b = 1
        double c = 1
        quadraticEquation = new QuadraticEquation(a, b, c)
        when:
        List<Point> root = quadraticEquation.solveQuadraticEquation()
        then:
        root.size() == 0
    }

    def "Solve points of quadratic function"() {
        setup:
        double a = -1
        double b = 5
        double c = 6
        quadraticEquation = new QuadraticEquation(a, b, c)
        when:
        List<Point> points = quadraticEquation.pointsOfFunction()
        then:
        points.size() == 1000
        points[0].x == -6
        points[0].y == -60
        points[999].x == 3.99
        points[999].y == 10.029900000000001
        points[500].x == -1
        points[500].y == 0
        points[400].x == -2
        points[400].y == -8
        points[300].x == -3
        points[300].y == -18
        points[700].x == 1
        points[700].y == 10

    }

    def "List of points test"() {
        setup:
        double a = 1
        double b = 7
        double c = 12
        quadraticEquation = new QuadraticEquation(a, b, c)
        when:
        List<Point> root = quadraticEquation.solveQuadraticEquation()
        List<Point> points = quadraticEquation.pointsOfFunction()
        then:
        root.size() == 2
        root[0].getX() == -4
        root[0].getY() == 0
        root[1].getX() == -3
        root[1].getY() == 0
        points.size() == 1000
        isEqual(points[0].getX() - points[1].getX(), -0.01)
        points[0].getX() == -9
        points[0].getY() == 30
       Math.round( points[points.size() - 1].getX() * 100) / 100 == 0.99
        points[points.size() - 1].getY() == 19.9101

    }
    public boolean isEqual(double a, double b) {
        return Math.round(a * 1000000) == Math.round(b * 1000000)
    }
}
