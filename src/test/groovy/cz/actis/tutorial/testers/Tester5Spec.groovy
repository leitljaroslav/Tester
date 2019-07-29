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

        then:
        line1.isPerpendicular(line2)
        !line1.isPerpendicular(line3)
    }
}
