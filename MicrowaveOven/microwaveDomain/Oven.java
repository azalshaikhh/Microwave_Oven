package MicrowaveOven.microwaveDomain;

import MicrowaveOven.mechanismDomain.ActiveClass;
import MicrowaveOven.mechanismDomain.EventInstance;
import MicrowaveOven.mechanismDomain.State;
import MicrowaveOven.mechanismDomain.Transition;

public class Oven extends ActiveClass {
    public static final int START_COOKING_EVENT = 0;
    public static final int CANCEL_COOKING_EVENT = 1;
    public static final int COOKING_COMPLETE_EVENT = 2;

    private Door door;
    private Light light;

    public Oven() {
        CookingState cookingState = new CookingState();
        IdleState idleState = new IdleState();

        addState(cookingState);
        addState(idleState);

        addTransition(new Transition(idleState, cookingState, START_COOKING_EVENT));
        addTransition(new Transition(cookingState, idleState, CANCEL_COOKING_EVENT));
        addTransition(new Transition(cookingState, idleState, COOKING_COMPLETE_EVENT));

        setInitialState(idleState);
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    private class CookingState extends State {
        @Override
        public void procedure(Object parameters) {
            System.out.println("Oven is cooking.");
            if (light != null) {
                light.processEvent(new EventInstance(Light.LIGHT_ON_EVENT, null));
            }
        }
    }

    private class IdleState extends State {
        @Override
        public void procedure(Object parameters) {
            System.out.println("Oven is idle.");
            if (light != null) {
                light.processEvent(new EventInstance(Light.LIGHT_OFF_EVENT, null));
            }
        }
    }

    public void startCooking() {
        if (door != null && door.isSecure()) {
            processEvent(new EventInstance(START_COOKING_EVENT, null));
        } else {
            System.out.println("Door is not secure. Cannot start cooking.");
        }
    }

    public void cancelCooking() {
        processEvent(new EventInstance(CANCEL_COOKING_EVENT, null));
    }

    public void cookingComplete() {
        processEvent(new EventInstance(COOKING_COMPLETE_EVENT, null));
    }
}
