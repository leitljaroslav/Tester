package cz.actis.tutorial.testers

import cz.actis.tutorial.testers.tester4.Point
import cz.actis.tutorial.testers.tester5.Line2D
import spock.lang.Specification

class Tester5Spec extends Specification {
    def "is perpendicular test"() {
        when:
        Line2D line1 = new Line2D(new Point(0, 0), new Point(5, 0))
        Line2D line2 = new Line2D(new Point(0, -5), new Point(0, 5))
        Line2D line3 = new Line2D(new Point(-5, -5), new Point(5, 5))
        Line2D line4 = new Line2D(new Point(1, 1), new Point(3, 3))
        Line2D line5 = new Line2D(new Point(-1, 1), new Point(-3, 3))
        then:
        line1.isPerpendicular(line2)
        !line1.isPerpendicular(line3)
        line4.isPerpendicular(line5)
    }

    def "is parallel test"() {
        when:
        Line2D line6 = new Line2D(new Point(1, 1), new Point(2, 2))
        Line2D line7 = new Line2D(new Point(5, 5), new Point(6, 6))
        Line2D line8 = new Line2D(new Point(0, 0), new Point(0, 1))
        Line2D line9 = new Line2D(new Point(2, 1), new Point(3, 2))
        then:
        line6.isParallel(line7)
        !line6.isParallel(line8)
        line6.isParallel(line9)
    }

    def "get angle test"() {
        when:
        Line2D line10 = new Line2D(new Point(0, 0), new Point(1, 0))
        Line2D line11 = new Line2D(new Point(1, 1), new Point(9, 9))
        Line2D line12 = new Line2D(new Point(3, 2), new Point(5, 6))
        then:
        line10.getAngle(line11) == 45.000d
        line10.getAngle(line12) == 63.434d

    }
}
