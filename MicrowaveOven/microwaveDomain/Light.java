package MicrowaveOven.microwaveDomain;

import MicrowaveOven.mechanismDomain.ActiveClass;
import MicrowaveOven.mechanismDomain.EventInstance;
import MicrowaveOven.mechanismDomain.Transition;

public class Light extends ActiveClass {
    public static final int LIGHT_OFF_EVENT = 0;
    public static final int LIGHT_ON_EVENT = 1;

    private class OnState extends State {
        @Override
        public void procedure(Object parameters) {
            // Implementation for the light being on
            System.out.println("Light is ON");
            // Additional logic for the light being on can be added here
        }
    }

    private class OffState extends State {
        @Override
        public void procedure(Object parameters) {
            // Implementation for the light being off
            System.out.println("Light is OFF");
            // Additional logic for the light being off can be added here
        }
    }

    public Light() {
        OnState onState = new OnState();
        OffState offState = new OffState();

        addState(onState);
        addState(offState);

        addTransition(new Transition(onState, offState, LIGHT_OFF_EVENT));
        addTransition(new Transition(offState, onState, LIGHT_ON_EVENT));

        setInitialState(offState);
    }

    public void processEvent(EventInstance eventInstance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processEvent'");
    }
}
