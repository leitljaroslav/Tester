package cz.actis.tutorial.tester6

import spock.lang.Shared
import spock.lang.Specification

class TesterArraySpec extends Specification {
    @Shared
    TesterArray tester1

    def setup() {
        tester1 = new TesterArray()
    }

    def "sorter array ASC"() {
        setup:
        int[] ints = new int[100]

        int i = 0
        (100..1).each {
            ints[i] = it
            i++
        }

        when:
        ints.length == 100
        ints[0] == 100
        ints[99] == 1
        int[] sorted = tester1.intArraySorterASC(ints)

        then:
        ints[0] == 100
        ints[99] == 1
        sorted[0] == 1
        sorted[99] == 100
        sorted[79] == 80
        sorted.length == 100
    }

    def "sort array DESC"() {
        setup:
        int[] ints = new int[100]

        int i = 0
        (1..100).each {
            ints[i] = it
            i++
        }

        when:
        int[] sorted = tester1.intArraySorterDESC(ints)

        then:
        ints[0] == 1
        ints[99] == 100
        sorted[0] == 100
        sorted[99] == 1
    }
}
