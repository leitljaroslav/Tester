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
        double a = -1
        double b = 5
        double c = 6
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
    def "Solve linear function"() {
        setup:
        double a = 0
        double b = 14
        double c = 32
        quadraticEquation = new QuadraticEquation(a, b, c)
        when:
        List<Point> root = quadraticEquation.solveQuadraticEquation()
        then:
        root[0].getX() == -2.2857142857142856
        root[0].getY() == 0
    }
    def "Get points of function"() {
        setup:
        double a = -10
        double b = -49
        double c = -31
        quadraticEquation = new QuadraticEquation(a, b, c)
        when:
        List<Point> points = quadraticEquation.pointsOfFunction()
        then:
        points[0].getX() == -11.279999999999855
        points[0].getY() == -750.6639999999746
        points[points.size()/2].getX() == -2.4400000000000004
        points[points.size()/2].getY() == 29.023999999999994
        points[points.size()-1].getX() == 6.379999999999856
        points[points.size()-1].getY() == -750.6639999999745

        when:
        a = 16
        b = -36
        c = -50
        quadraticEquation = new QuadraticEquation(a, b, c)
        points = quadraticEquation.pointsOfFunction()
        then:
        points[0].getX() == 8.294999999999892
        points[0].getY() == 752.2923999999753
        points[points.size()/2].getX() == 1.115
        points[points.size()/2].getY() == -70.2484
        points[points.size()-1].getX() == -6.044999999999892
        points[points.size()-1].getY() == 752.292399999975

        when:
        a = 0
        b = 14
        c = 32
        quadraticEquation = new QuadraticEquation(a, b, c)
        points = quadraticEquation.pointsOfFunction()
        then:
        points[0].getY() == 750
        points[0].getX() == 51.285714285714285
        points[1].getX() == -55.857142857142854
        points[1].getY() == -750
    }
}
