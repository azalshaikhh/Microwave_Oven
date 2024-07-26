package MicrowaveOven.mechanismDomain;

import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Map;

public abstract class ActiveClass {
    private Map<Integer, State> stateMap = new HashMap<>();
    private Map<State, Map<Integer, Transition>> transitionMap = new HashMap<>();
    private State initialState;
    private State currentState;

    public void addState(State state) {
        stateMap.put(state.hashCode(), state); // Using state hash code as key, ensure unique keys in practical implementation
    }

    public void addTransition(Transition transition) {
        transitionMap
            .computeIfAbsent(transition.getSourceState(), k -> new HashMap<>())
            .put(transition.getEvent(), transition);
    }

    public void setInitialState(State state) {
        this.initialState = state;
        this.currentState = state;
    }

    public void handleEvent(int event) {
        Transition transition = findTransition(currentState, event);
        if (transition != null) {
            currentState = transition.getTargetState();
            currentState.procedure(null); // Assuming no parameters for simplicity
        }
    }

    private Transition findTransition(State currentState, int event) {
        Map<Integer, Transition> eventMap = transitionMap.get(currentState);
        if (eventMap != null) {
            return eventMap.get(event);
        }
        return null;
    }

    public State getCurrentState() {
        return currentState;
    }
}
