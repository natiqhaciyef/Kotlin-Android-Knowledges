package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.factory

sealed class Currencies{
    interface CurrencyInterface{
        val symbol : String
        val name: String
    }

    class Euro(): CurrencyInterface {
        override val symbol: String
            get() = "€"
        override val name: String
            get() = "Euro"
    }

    class Manat(): CurrencyInterface {
        override val symbol: String
            get() = "AZN"
        override val name: String
            get() = "Azerbaijani manat"
    }

    class Lira(): CurrencyInterface {
        override val symbol: String
            get() = "TL"
        override val name: String
            get() = "Turkish lira"
    }

    class Pound(): CurrencyInterface {
        override val symbol: String
            get() = "£"
        override val name: String
            get() = "Pound"
    }

    class Dollar(): CurrencyInterface {
        override val symbol: String
            get() = "$"
        override val name: String
            get() = "Dollar"
    }

    fun currencyFactory(country: Countries): CurrencyInterface?{
        return when(country){
            Countries.Azerbaijan -> Manat()
            Countries.Turkey -> Lira()
            Countries.England -> Pound()
            Countries.Norway, Countries.Spain -> Euro()
            Countries.USA -> Dollar()
            else -> null
        }
    }
}
