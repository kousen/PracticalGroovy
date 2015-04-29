package json

import groovy.json.*

String jsonTxt = new File('people.json').text
def json = new JsonSlurper().parseText(jsonTxt)
assert json[1].role == 'witch'