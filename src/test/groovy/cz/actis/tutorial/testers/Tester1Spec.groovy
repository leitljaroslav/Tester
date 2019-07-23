package cz.actis.tutorial.testers

import spock.lang.Shared
import spock.lang.Specification

class Tester1Spec extends Specification {
    @Shared
    Tester1 tester1

    def setup() {
        tester1 = new Tester1()
    }

    def "test plus method"() {
        when:
        int result = tester1.plus(1,1)

        then:
        result == 2
    }

    def "test minus method"() {
        when:
        int result = tester1.minus(1,1)

        then:
        result == 0
    }

    def "test times method"() {
        when:
        int result = tester1.times(1,1)

        then:
        result == 1
        tester1.times(0,0) == 0
        tester1.times(2,10) == 20
        tester1.times(3,5) == 15
        tester1.times(4,1) == 4
    }

    def "test divide method"() {
        when:
        double result = tester1.divide(1,1)

        then:
        result == 1
        tester1.divide(10,5) == 2
        tester1.divide(100,10) == 10
        tester1.divide(0,10) == 0
        tester1.divide(10, 9) == 1.1111111111111112d
        tester1.divide(1510, 944) == 1.5995762711864407d

    }

    def "test mod method"() {
        when:
        double result = tester1.mod(1,1)

        then:
        result == 0
        tester1.mod(1,10) == 1
        tester1.mod(102,10) == 2
        tester1.mod(1541,1000) == 541
        tester1.mod(0,10) == 0
        1 == tester1.mod(1575, 1574)

    }
}
