package cz.actis.tutorial.testers

import cz.actis.tutorial.testers.tester4.Point
import spock.lang.Shared
import spock.lang.Specification

class Tester4Spec extends Specification {
    @Shared
    Tester4 tester4

    void setup() {
        tester4 = new Tester4()
    }

    def "SolveQuadraticEquation with 2 roots"() {
        setup:
        double a = 1
        double b = 7
        double c = 12

        when:
        List<Point> roots = tester4.solveQuadraticEquation(a, b, c)

        then:
        roots.size() == 2
        roots[0].x == -4
        roots[0].y == 0
        roots[1].x == -3
        roots[1].y == 0

        when:
        a = 1
        b = 5
        c = 6
        roots = tester4.solveQuadraticEquation(a, b, c)

        then:
        roots.size() == 2
        roots[0].x == -3
        roots[0].y == 0
        roots[1].x == -2
        roots[1].y == 0

        when:
        a = -1
        b = 5
        c = 6
        roots = tester4.solveQuadraticEquation(a, b, c)

        then:
        roots.size() == 2
        roots[0].x == 6
        roots[0].y == 0
        roots[1].x == -1
        roots[1].y == 0

        when:
        a = 1
        b = 1
        c = -2
        roots = tester4.solveQuadraticEquation(a, b, c)

        then:
        roots.size() == 2
        roots[0].x == -2
        roots[0].y == 0
        roots[1].x == 1
        roots[1].y == 0
    }

    def "SolveQuadraticEquation with 1 root"() {
        setup:
        double a = 1
        double b = -10
        double c = 25

        when:
        List<Point> roots = tester4.solveQuadraticEquation(a, b, c)

        then:
        roots.size() == 1
        roots[0].x == 5
        roots[0].y == 0
    }


    def "SolveQuadraticEquation with 0 roots"() {
        setup:
        double a = 1
        double b = 1
        double c = 1

        when:
        List<Point> roots = tester4.solveQuadraticEquation(a, b, c)

        then:
        roots.size() == 0
    }
}