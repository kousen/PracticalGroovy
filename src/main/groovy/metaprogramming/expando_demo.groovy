package metaprogramming

Expando ex = new Expando()
ex.name = 'Fido'
ex.speak = { String msg = 'woof' -> "$name says $msg!" }
assert ex.speak() == 'Fido says woof!'
assert ex.speak('bow wow') == 'Fido says bow wow!'

class Cat {}
Cat.metaClass.name = 'Garfield'
Cat.metaClass.says = 'wants lasagna'
Cat.metaClass.speak { -> "$name $says" }
Cat c = new Cat()
assert 'Garfield wants lasagna' == c.speak()

c.name = 'Fluffy'
c.says = 'says meow'
assert c.speak() == 'Fluffy says meow'