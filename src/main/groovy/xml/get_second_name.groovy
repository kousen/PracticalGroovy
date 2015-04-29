package xml

def root = new XmlSlurper().parse('people.xml')
println "The second name is ${root.person[1].name}"
println "The second name is ${root.person[1].@id}"