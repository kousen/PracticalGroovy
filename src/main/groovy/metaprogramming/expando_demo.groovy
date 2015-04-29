package metaprogramming

Expando ex = new Expando()
ex.name = 'Fido'
ex.speak = { "$name says Woof!" }
ex.speak()

class Cat {}
Cat.metaClass.name = 'Garfield'
Cat.metaClass.says = 'wants lasagna'
Cat.metaClass.speak { "$name $says" }
Cat c = new Cat()
assert 'Garfield wants lasagna' == c.speak()

c.name = 'Fluffy'
c.says = 'meow'
assert c.speak() == 'Fluffy meow'