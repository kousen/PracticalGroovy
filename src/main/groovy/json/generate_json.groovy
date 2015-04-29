package json

import groovy.json.*

def builder = new JsonBuilder()
builder([name:'Buffy',  role:'slayer'], [name:'Willow', role:'witch'])

assert builder.toString() ==
        '[{"name":"Buffy","role":"slayer"},{"name":"Willow","role":"witch"}]'