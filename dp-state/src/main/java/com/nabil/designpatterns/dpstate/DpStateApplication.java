package com.nabil.designpatterns.dpstate;

import com.nabil.designpatterns.dpstate.context.Agent;
import com.nabil.designpatterns.dpstate.context.State;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DpStateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DpStateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Agent agent = new Agent(State.DRAW);
        boolean matchNotFinished = true;

        synchronized (agent) {
            while (matchNotFinished) {
                agent.setState(State.pickRandomState());
                agent.behave();
                agent.wait(2000);
            }
        }
    }
}
