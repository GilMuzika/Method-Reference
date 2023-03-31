package org.example;

import org.example.Order;
import org.example.OrderCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://javarevisited.blogspot.com/2017/03/what-is-method-references-in-java-8-example.html#ixzz7xZ89XkGv
public class Main {
    public static void main(String[] args) {
        // initialize order book with few orders
        List<Order> orderBook = OrderCreator.generateMultipleOrders(100);


        // Sort all orders on price, using lambda expression
        System.out.println("Before sorting : " + orderBook);
        Collections.sort(orderBook, (a, b) -> a.get_quantity() - b.get_quantity());

        // replacing lambda expression to method reference
        // Above code can also be written like this, where
        // we are just calling a method of Order class from
        // lambda expression, this can be replaced by Method
        // reference.
        Collections.sort(orderBook, (a, b) -> Order.compareByQuantity(a, b)); //Lambda that calls a static method of Order class and passes the parameters to it
        Collections.sort(orderBook, Order::compareByQuantity); //Calling a static method of Order class with Method Reference (::). The parameters are implied, the compiler knows about the parameters from the signature of the method
        System.out.println("After sorting by order quantity : " + orderBook);

        // Did you notice, two things while using method reference
        // first, we use :: double colon to invoke method,
        // similar to scope resolution operator of C++.
        // second, you don't need to provide parenthesis
        // for method parameter, it’s just a name
        // Similarly you can call other static method
        // using method reference.
        // Another key thing is syntax of method must
        // match with syntax of functional
        // interface, for example compareByQuantity() syntax
        // is same as compare() method of
        // Comparator interface, which is a functional
        // interface and Collections.sort() accept
        // Comparator. Let's sort this List by trade value
        // The requirements to match the "compare()" method of "Comparator" interface
        // are that the method must accept two parameters of the type objects of which need to be compared,
        // and return an integer. Positive if the first compared object is greater than the second,
        // negative if it is smaller,
        // and zero if the two objects are equal
        Collections.sort(orderBook, Order::compateByValue);
        System.out.println("After sorting by trade value : " + orderBook);

        // Java supports four types of method reference,
        // let's see example of each of them
        // Our previous example, in which we are
        // referring to static method was an
        // example of static method reference,
        // while below is an example of instance method
        // reference, where we are invoking and instance
        // method from Order class.
        // You can reference a constructor in the same way
        // as a static method by using the name new

        // Instance Method Reference allows calling instance methods using Method Reference (::)
        Order ord = OrderCreator.generateOrder(); //Jut a random object, its data doesn't matter, it needed only for object reference
        Collections.sort(orderBook, ord::compareByPrice);
        System.out.println("--------------------------------------------");
        System.out.println("Order book after sorting by price : ");
        orderBook.forEach(System.out::println);


        // method reference example of
        // an Arbitrary Object of a Particular Type
        // equivalent lambda expression for following would be
        // (String a, String b)-> a.compareToIgnoreCase(b)
        String[] symbols = { "GOOG.NS", "APPL.NS", "MSFT.NS", "AMZN.NS"};
        Arrays.sort(symbols, String::compareToIgnoreCase);
















    }
}