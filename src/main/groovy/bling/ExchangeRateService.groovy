package bling

import groovy.json.JsonSlurper

@Singleton(lazy = true)
class ExchangeRateService {
    static Map<String, BigDecimal> rates = new HashMap<>()

    static {
        String url = 'http://openexchangerates.org/latest.json?app_id=df12e49e55a34cf0927f592c2a36f8b0'
        def json = new JsonSlurper().parse(url.toURL())
        json.rates.each { k,v ->
            rates[k] = v.toBigDecimal()
        }
    }

    Money convert(Money from, String to) {
        new Money(amount: from.amount * rates[to] / rates[from.currency],
            currency: to)
    }
}
