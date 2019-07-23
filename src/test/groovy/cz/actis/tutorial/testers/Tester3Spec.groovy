package cz.actis.tutorial.testers

import cz.actis.tutorial.exceptions.InvalidArgumentException
import spock.lang.Shared
import spock.lang.Specification

class Tester3Spec extends Specification {
    @Shared
    Tester3 tester3

    def setup() {
        tester3 = new Tester3()
    }

    def "square test"() {
        when:
        int a = 3

        then:
        tester3.square(a) == 9
        tester3.square(10) == 100
        tester3.square(0) == 0
        tester3.square(-2) == 4
        tester3.square(11.54d as int) == 121

    }

    def "power test"() {
        when:
        int a = 3

        then:
        tester3.power(a, 3) == 27
        tester3.power(10, 3) == 1000
        tester3.power(0, 0) == 1
        tester3.power(1, 1000) == 1
        tester3.power(2, 6) == 64

    }

    def "sqrt test"() {
        when:
        int a = 3

        then:
        tester3.sqrt(9) == 3
        tester3.sqrt(0) == 0
        tester3.sqrt(1000) == 31.622776601683793d
        tester3.sqrt(2) == 1.4142135623730951d
        tester3.sqrt(2049) == 45.2658811910251d

        when:
        tester3.sqrt(-1)

        then:
        thrown(InvalidArgumentException)

    }

    def "root test"() {
        when:
        int a = 3

        then:
        tester3.root(27, 3) == 3
        Math.round(tester3.root(1000, 3)) == 10
        tester3.root(1, 1) == 1
        tester3.root(1, 1000) == 1
        tester3.root(2187, 7) == 3

        when:
        tester3.root(-1, 1)

        then:
        thrown(InvalidArgumentException)

    }
}
