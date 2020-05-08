package com.nabil.designpatterns.dpstate.context;

public class Agent {
    private State state;

    public Agent(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void behave() {
        this.state.behave();
    }
}