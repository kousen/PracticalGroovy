package ast.category

BigDecimal amount = 1234567.8901234

use(CurrencyCategory) {
    println amount.asCurrency()
    println amount.asCurrency(Locale.FRANCE)
    println amount.asCurrency(new Locale('hin', 'IN'))
}