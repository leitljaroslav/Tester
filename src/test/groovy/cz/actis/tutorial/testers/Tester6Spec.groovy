package cz.actis.tutorial.testers

import cz.actis.tutorial.testers.tester4.Point
import spock.lang.Shared
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class Tester6Spec extends Specification {
    @Shared
    private Tester6 tester6

    @Shared
    private Tester4 tester4

    private List<List<Point>> precounted = []

    void setup() {
        tester6 = new Tester6()
        tester4 = new Tester4()

        precounted = []
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(
                this.class.classLoader.getResourceAsStream('quadratic.roots'), StandardCharsets.UTF_8))
        String line
        bufferedInputStream
        while ((line = bufferedInputStream.readLine()) != null) {
            String[] params = line.split(';')
            List<Point> point = []
            for (int i = 0; i < params.size(); i++) {
                double xValue = params[i].split('=').last() as double

                if (!(params.length == 1 && xValue.equals(Double.NaN))) {
                    //pokud je vysledkem 1 NaN, nepridavat do vysledku
                    point.add(new Point(xValue, 0))
                }
            }
            precounted.add(point)
        }
    }

    def "solve roots test"() {
        when:
        List<List<Point>> result = tester6.solveRoots(this.class.classLoader.getResourceAsStream('quadratic.source'))

        then:
        precounted.eachWithIndex { List<Point> entry, int i ->
            assert entry.size() == result.get(i).size()
            if (entry.size() > 0) {
                assert Math.round(entry.get(0).getX() * 100000) == Math.round(result.get(i).get(0).getX() * 100000)
                if (entry.size() > 1) {
                    assert Math.round(entry.get(1).getX() * 100000) == Math.round(result.get(i).get(1).getX() * 100000)
                }
            }
        }
    }

    def "writeRoots test"() {
        when:
        File file = File.createTempFile("random", "temp")
        file.delete()
        tester6.writeRoots(
                tester6.solveRoots(this.class.classLoader.getResourceAsStream('quadratic.source')),
                file
        )

        List<String> strings = this.class.classLoader.getResourceAsStream('quadratic.roots').readLines()

        then:
        file.readLines().eachWithIndex { String entry, int i ->
            entry == strings[i]
        }
    }
}
