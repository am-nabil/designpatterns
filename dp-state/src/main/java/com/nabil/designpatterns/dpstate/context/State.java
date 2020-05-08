package com.nabil.designpatterns.dpstate.context;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum State {
    WINNING {
        @Override
        public void behave() {
            System.out.println("I should defend to preserve score");
        }
    }, LOOSING {
        @Override
        public void behave() {
            System.out.println("I should Attack to score goals");
        }
    }, DRAW {
        @Override
        public void behave() {
            System.out.println("I should keep ball possession");
        }
    };

    public abstract void behave();

    private static final List<State> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static State pickRandomState() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
