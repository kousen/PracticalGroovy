package io

def files = []
new File('.').eachFileRecurse { file ->
    if (file.name.endsWith('.groovy')) {
        files << file
    }
}
assert files
println "There are ${files.size()} groovy files"

String data = new File('files.groovy').text
assert data.contains('text')

List<String> lines = new File('files.groovy').readLines()*.trim()
assert lines[0] == 'package io'

lines.reverse().each { println it }

List dataLines = []
new File('data.txt').splitEachLine(',') {
    dataLines << it
}
assert dataLines == [['1','2','3'],['a','b','c']]

File f = new File("output.dat")
f.write('Hello, Groovy!')

assert f.text == 'Hello, Groovy!'
f.delete()

File temp = new File('temp.txt')

// Don't really need parens here, so why use them?
temp.write 'Groovy Kind of Love'
assert temp.readLines().size() == 1

// Need to start with a carriage return
temp.append "\nGroovin', on a Sunday afternoon..."

// Note use of overloaded << operator
temp << "\nFeelin' Groovy"
assert temp.readLines().size() == 3
temp.delete()
