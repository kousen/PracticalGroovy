package ast.category

import spock.lang.Specification

class CurrencyCategorySpec extends Specification {
    Number num = 1234567.890123

    def 'default currency category works'() {
        expect:
        use (CurrencyCategory) {
            num.asCurrency() == '$1,234,567.89'
        }
    }

    def 'French locale returns formatted euros'() {
        expect:
        use(CurrencyCategory) {
            num.asCurrency(Locale.FRANCE) == "1 234 567,89 €"
        }
    }

    def 'can work with Locale constructor'() {
        expect:
        use(CurrencyCategory) {
            num.asCurrency(new Locale('hin','IN')) == 'INR 1,234,567.89'
        }
    }
}
