package com.jpmc.midascore;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionListener {

    private final List<Double> firstFourAmounts = new ArrayList<>();

    @KafkaListener(topics = "${kafka.topic}", groupId = "midas-core-group")
    public void listen(Transaction transaction) {
        System.out.println("Received transaction: " + transaction);

        if (firstFourAmounts.size() < 4) {
            firstFourAmounts.add(transaction.getAmount());
            System.out.println("Captured amount #" + firstFourAmounts.size() + ": " + transaction.getAmount());
        }
    }

    public List<Double> getFirstFourAmounts() {
        return new ArrayList<>(firstFourAmounts);
    }
}
