package bling

Money m1 = new Money(amount: 100, currency: 'USD')
Money m2 = new Money(amount: 25, currency: 'USD')
Money m3 = new Money(amount: 30, currency: 'EUR')
println m1 + m2
//println m1 + m3

println m1 - m2
println( -m1 )
println m1*10


ExchangeRateService ers = ExchangeRateService.instance
Money from = new Money(amount: 1, currency: 'USD')
println ers.convert(from, 'CAD')