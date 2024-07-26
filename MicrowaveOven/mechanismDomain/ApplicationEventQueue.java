package MicrowaveOven.mechanismDomain;

import java.util.LinkedList;
import java.util.Queue;

public class ApplicationEventQueue {
    private static ApplicationEventQueue instance;
    private Queue<EventInstance> eventQueue = new LinkedList<>();

    private ApplicationEventQueue() {
        // Private constructor for singleton pattern
    }

    public static ApplicationEventQueue getInstance() {
        if (instance == null) {
            instance = new ApplicationEventQueue();
        }
        return instance;
    }

    public void addEvent(EventInstance eventInstance) {
        eventQueue.add(eventInstance);
    }

    public EventInstance getNextEvent() {
        return eventQueue.poll();
    }

    public boolean isEmpty() {
        return eventQueue.isEmpty();
    }

    public static void generateEvent(int eventType, Object parameters, ActiveClass target) {
        EventInstance eventInstance = new EventInstance(eventType, parameters);
        ApplicationEventQueue.getInstance().addEvent(eventInstance);
        target.processEvent(eventInstance);
    }
}
