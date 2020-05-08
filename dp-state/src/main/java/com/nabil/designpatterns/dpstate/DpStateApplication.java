package com.nabil.designpatterns.dpstate;

import com.nabil.designpatterns.dpstate.context.Agent;
import com.nabil.designpatterns.dpstate.context.State;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class DpStateApplication implements CommandLineRunner {

    private static final List<State> VALUES = List.of(State.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static State pickRandomState() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static void main(String[] args) {
        SpringApplication.run(DpStateApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Agent agent = new Agent(State.DRAW);
        boolean matchNotFinished = true;
        Scanner sc = new Scanner(System.in);
        while (matchNotFinished) {
            System.out.println("Type Q to leave the match or any else touch to continue");
            matchNotFinished = !sc.nextLine().equalsIgnoreCase("Q");
            agent.setState(pickRandomState());
            System.out.print("My current state is : " + agent.getState().name() + ", What should i do : ");
            agent.behave();
        }
    }
}
