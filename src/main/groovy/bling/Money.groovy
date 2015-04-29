package bling

import groovy.transform.Immutable

@Immutable
class Money {
    BigDecimal amount
    String currency

    Money plus(Money m) {
        if (this.currency != m.currency) {
            throw new IllegalArgumentException("Currencies must be the same")
        } else {
            return new Money(amount: this.amount + m.amount,
                currency: this.currency)
        }
    }

    Money minus(Money m) {
        plus(-m)
    }

    Money multiply(Number num) {
        new Money(amount: this.amount * num, currency: this.currency)
    }

    Money div(Number num) {
        new Money(amount: this.amount / num, currency: this.currency)
    }

    Money negative() {
        //new Money(amount: -this.amount, currency: this.currency)
        this * -1
    }

}
