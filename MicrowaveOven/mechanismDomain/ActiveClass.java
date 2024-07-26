package MicrowaveOven.mechanismDomain;

import java.lang.Thread.State;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ActiveClass {
    private Vector<State> stateVector = new Vector<>();
    private Vector<Transition> transitionVector = new Vector<>();
    private State currentState;

    public void addState(State state) {
        stateVector.add(state);
    }

    public void addTransition(Transition transition) {
        transitionVector.add(transition);
    }

    public Enumeration<Transition> transitions() {
        return transitionVector.elements();
    }

    public void setInitialState(State state) {
        this.currentState = state;
    }

    public void processEvent(EventInstance eventInstance) {
        Transition transition;
        for (Enumeration<Transition> e = transitions(); e.hasMoreElements();) {
            transition = e.nextElement();
            if (transition.getSourceState().equals(currentState)) {
                if (transition.getEvent() == eventInstance.getEvent()) {
                    transition.getTargetState().procedure(eventInstance.getParameters());
                    currentState = transition.getTargetState();
                    return;
                }
            }
        }
    }

    public State getCurrentState() {
        return currentState;
    }
}
