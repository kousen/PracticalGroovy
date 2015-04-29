package ast.singleton

import spock.lang.Specification;

class PointSpec extends Specification {
    def "can't instantiate"() {
        when: new Point(x:3.0,y:4.0)
        then: thrown(RuntimeException)
    }
    
    def "instance is not null"() {
        expect: Point.instance
    }
    
    def "can change values"() {
        when:
        Point.instance.x = 3.0
        Point.instance.y = 4.0
        
        then:
        Point.instance.x == 3.0
        Point.instance.y == 4.0
    }
    
}
