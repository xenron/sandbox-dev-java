package packt;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class UsingTheCurrencyClassInJava7 {

    public static void main(String[] args) {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        for (Currency currency : currencies) {
            System.out.println("" + currency.getDisplayName()
                    + " - " + currency.getDisplayName(Locale.GERMAN)                  
                    + " - " + currency.getNumericCode());
        }

    }
}
