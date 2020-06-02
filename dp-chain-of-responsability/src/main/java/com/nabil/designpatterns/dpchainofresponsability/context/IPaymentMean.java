package com.nabil.designpatterns.dpchainofresponsability.context;

import java.util.function.Consumer;

@FunctionalInterface
public interface IPaymentMean {
    boolean cash(double price);

    default IPaymentMean next(IPaymentMean paymentMean) {
        return (price -> cash(price) || paymentMean.cash(price));
    }

    static IPaymentMean handlePayment(double balance, Consumer<Double> consumer) {
        return (price) -> {
            if (balance - price >= 0) {
                consumer.accept(price);
                return true;
            }
            return false;
        };
    }

    static IPaymentMean freeTokensMean(double balance) {
        return handlePayment(balance, price -> System.out.println("Payment from free tokens : amount = " + price));
    }

    static IPaymentMean accountBalanceMean(double balance) {
        return handlePayment(balance, price -> System.out.println("Payment from account balance : amount = " + price));
    }

    static IPaymentMean creditCardMean(double balance) {
        return handlePayment(balance, price -> System.out.println("Payment from credit card : amount = " + price));
    }

}
