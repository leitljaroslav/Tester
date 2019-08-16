package cz.actis.tutorial.testers.utils

import cz.actis.tutorial.testers.Tester7
import cz.actis.tutorial.testers.tester4.Point
import jdk.nashorn.internal.runtime.Specialization
import spock.lang.Shared
import spock.lang.Specification

import java.awt.image.BufferedImage
import java.nio.charset.StandardCharsets

class Tester7Spec extends Specification{
    @Shared
    private Tester7 tester7

    @Shared
    private QuadraticEquation quadraticEquation

    private List<Point> precounted = []
    void setup() {
        tester7 = new Tester7()
    }

    def "make 1000 files"() {
        when:
        tester7.calculateParametersFromFile(this.class.classLoader.getResourceAsStream('quadratic.source'))

        then:
        File file = new File("random", "temp")
    }
}