package MicrowaveOven.mechanismDomain;

import java.lang.Thread.State;

public class Transition {
    private State sourceState;
    private State targetState;
    private int event;

    public Transition(State sourceState, State targetState, int event) {
        this.sourceState = sourceState;
        this.targetState = targetState;
        this.event = event;
    }

    public State getSourceState() {
        return sourceState;
    }

    public State getTargetState() {
        return targetState;
    }

    public int getEvent() {
        return event;
    }

    public void setSourceState(State sourceState) {
        this.sourceState = sourceState;
    }

    public void setTargetState(State targetState) {
        this.targetState = targetState;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "sourceState=" + sourceState +
                ", targetState=" + targetState +
                ", event=" + event +
                '}';
    }
}
