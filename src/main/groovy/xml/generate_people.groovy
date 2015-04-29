package xml

import groovy.xml.MarkupBuilder

def builder = new MarkupBuilder()
builder.people {
    person(id:1) {
        name 'Buffy'
    }
    person(id:2) {
        name 'Willow'
    }
}