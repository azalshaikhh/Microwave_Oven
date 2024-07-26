package MicrowaveOven.guiDomain;

import MicrowaveOven.mechanismDomain.ApplicationEventQueue;
import MicrowaveOven.microwaveDomain.Door;
import MicrowaveOven.microwaveDomain.Oven;

public class DoorOpenCallback {
    private Door door;
    private Oven oven;

    public DoorOpenCallback(Door door, Oven oven) {
        this.door = door;
        this.oven = oven;
    }

    public void onDoorOpen() {
        if (door != null) {
            ApplicationEventQueue.generateEvent(Door.DOOR_RELEASE_EVENT, null, door);
            System.out.println("Door opened");
        }
    }
}
