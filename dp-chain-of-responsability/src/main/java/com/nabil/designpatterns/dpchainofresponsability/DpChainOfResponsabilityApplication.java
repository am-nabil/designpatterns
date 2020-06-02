package com.nabil.designpatterns.dpchainofresponsability;

import com.nabil.designpatterns.dpchainofresponsability.context.IPaymentMean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DpChainOfResponsabilityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DpChainOfResponsabilityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        IPaymentMean paymentMean = IPaymentMean.freeTokensMean(50)
                .next(IPaymentMean.accountBalanceMean(100))
                .next(IPaymentMean.creditCardMean(Double.MAX_VALUE));

        paymentMean.cash(60);
        paymentMean.cash(40);
        paymentMean.cash(2340);
    }
}
