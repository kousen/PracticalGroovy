package ast.category

import java.text.NumberFormat

@Category(Number)
class CurrencyCategory {
    String asCurrency() {
        NumberFormat.currencyInstance.format(this)
    }

    String asCurrency(Locale loc) {
        NumberFormat.getCurrencyInstance(loc).format(this)
    }
}
