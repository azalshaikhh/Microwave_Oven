package MicrowaveOven.microwaveDomain;

import MicrowaveOven.mechanismDomain.ActiveClass;
import MicrowaveOven.mechanismDomain.Transition;

public class Door extends ActiveClass {
    public static final int DOOR_CLOSED_EVENT = 0;
    public static final int DOOR_RELEASE_EVENT = 1;
    private boolean isSecureAttribute = true;
    private Oven linkedOven;

    public Door() {
        OpenState openState = new OpenState();
        ClosedState closedState = new ClosedState();
        addState(openState);
        addState(closedState);
        addTransition(new Transition(openState, closedState, DOOR_CLOSED_EVENT));
        addTransition(new Transition(closedState, openState, DOOR_RELEASE_EVENT));
        setInitialState(closedState);
    }

    public boolean isSecure() {
        return isSecureAttribute;
    }

    public void linkToOven(Oven oven) {
        this.linkedOven = Door;
    }

    private class OpenState extends State {
        @Override
        public void procedure(Object parameters) {
            isSecureAttribute = false;
            if (linkedOven != null) {
                ApplicationEventQueue.generateEvent(Oven.CANCEL_COOKING_EVENT, null, linkedOven);
            }
        }
    }

    private class ClosedState extends State {
        @Override
        public void procedure(Object parameters) {
            isSecureAttribute = true;
            // Additional logic for when the door is closed can be added here
        }
    }
}
