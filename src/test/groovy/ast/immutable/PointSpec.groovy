package ast.immutable

import spock.lang.Specification

class PointSpec extends Specification {
    Point p

    def 'can use map-based constructor'() {
        when:
        p = new Point(x:3.0, y:4.0)

        then:
        p.x == 3.0
        p.y == 4.0
    }

    def 'can use tuple constructor'() {
        when:
        p = new Point(3.0, 4.0)

        then:
        p.x == 3.0
        p.y == 4.0
    }

    def 'equals method works'() {
        when:
        p = new Point(3.0, 4.0)
        Point p1 = new Point(3.0, 4.0)
        Point p2 = new Point(x:3.0, y:5.0)

        then:
        p == p1
        p1 != p2
    }

    def 'equals and hashcode work in a set'() {
        when:
        p = new Point(3.0, 4.0)
        Point p1 = new Point(3.0, 4.0)
        Point p2 = new Point(x:3.0, y:4.0)
        Set points = [p, p1, p2]

        then:
        points.size() == 1
    }

    def "can't change x"() {
        given:
        p = new Point(x:3.0, y:4.0)

        when:
        p.x = 5.0

        then:
        ReadOnlyPropertyException e = thrown()
    }

    def "can't change y"() {
        given:
        p = new Point(x:3.0, y:4.0)

        when:
        p.y = 5.0

        then:
        ReadOnlyPropertyException e = thrown()
    }

    def 'can you change x using direct ref?'() {
        given:
        p = new Point(x:3.0, y:4.0)

        when:
        p.@y = 5.0

        then:
        GroovyRuntimeException e = thrown()
        e.message == 'Cannot set the property \'y\' because the backing field is final.'
    }
}
