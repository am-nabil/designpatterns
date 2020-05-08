package com.nabil.designpatterns.dpstate.context;

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
}
