package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class Order {
    public enum Side {
        BUY, SELL
    };
    @Getter
    private int _quantity;
    @Getter
    private String _symbol;
    @Getter
    private double _price;
    @Getter
    private Side _side;

    @Override
    public String toString() {
        return String.format("%s %d %s at price %.02f", _side, _quantity, _symbol, _price);
    }

    public static int compareByQuantity(Order a, Order b) {
        return a._quantity - b._quantity;
    }

    public int compareByPrice(Order a, Order b) {
        return Double.valueOf(a.get_price()).compareTo(Double.valueOf(b.get_price()));
    }

    public static int compateByValue(Order a, Order b) {
        Double tradeValueOfA = a.get_price() * a.get_quantity();
        Double tradeValueOfB = b.get_price() * b.get_quantity();
        return tradeValueOfA.compareTo(tradeValueOfB);
    }

}
