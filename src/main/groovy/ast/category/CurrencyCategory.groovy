package ast.category

import java.text.NumberFormat

@Category(Number)
class CurrencyCategory {

// Legal, but can use default args as shown below
//    String asCurrency() {
//        NumberFormat.currencyInstance.format(this)
//    }

    String asCurrency(Locale loc = Locale.default) {
        NumberFormat.getCurrencyInstance(loc).format(this)
    }
}
