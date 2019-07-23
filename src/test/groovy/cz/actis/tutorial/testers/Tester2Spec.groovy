package cz.actis.tutorial.testers

import spock.lang.Shared
import spock.lang.Specification

class Tester2Spec extends Specification {
    @Shared
    Tester2 tester2

    def setup() {
        tester2 = new Tester2()
    }

    def "test join method"() {
        when:
        String a = "123"
        String b = "456"

        then:
        tester2.join(a, b) == "123456"
    }

    def "test count method"() {
        when:
        String a = "12222133314441551"

        then:
        tester2.count(a, '1' as char) == 4
        tester2.count(a, '2' as char) == 4
        tester2.count(a, '3' as char) == 3
        tester2.count(a, '4' as char) == 3
        tester2.count(a, '5' as char) == 2
        tester2.count(a, '0' as char) == 0
    }
}
