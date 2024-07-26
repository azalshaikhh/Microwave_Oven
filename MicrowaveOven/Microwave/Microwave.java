package MicrowaveOven.Microwave;

import MicrowaveOven.mechanismDomain.EventInstance;
import MicrowaveOven.microwaveDomain.Door;
import MicrowaveOven.microwaveDomain.Light;
import MicrowaveOven.microwaveDomain.Oven;
import MicrowaveOven.microwaveDomain.MicrowaveToHardwareServerInterface;
import MicrowaveOven.simulatedMicrowaveHardwareDomain.SimulatedHardwareDomain;

public class Microwave {

    public static void main(String[] args) {
        // Create instances of the components
        Oven oven = new Oven();
        Door door = new Door();
        Light light = new Light();

        // Link the components
        door.linkToOven(oven);
        oven.setDoor(door);
        oven.setLight(light);

        // Create and configure the simulated hardware domain
        SimulatedHardwareDomain simulatedHardware = new SimulatedHardwareDomain();
        MicrowaveToHardwareServerInterface hardwareServer = new MicrowaveToHardwareServerInterface() {
            @Override
            public void setCookingPeriod(int cookingTime) {
                System.out.println("Setting cooking period to " + cookingTime + " milliseconds.");
            }

            @Override
            public void startCooking() {
                System.out.println("Starting cooking.");
                oven.startCooking();
            }

            @Override
            public void cancelCooking() {
                System.out.println("Cancelling cooking.");
                oven.cancelCooking();
            }

            @Override
            public void cookingComplete() {
                System.out.println("Cooking complete.");
                oven.cookingComplete();
            }

            @Override
            public void openDoor() {
                System.out.println("Opening door.");
                door.processEvent(new EventInstance(Door.DOOR_RELEASE_EVENT, null));
            }

            @Override
            public void closeDoor() {
                System.out.println("Closing door.");
                door.processEvent(new EventInstance(Door.DOOR_CLOSED_EVENT, null));
            }

            @Override
            public boolean isDoorSecure() {
                return door.isSecure();
            }

            @Override
            public void turnLightOn() {
                System.out.println("Turning light on.");
                light.processEvent(new EventInstance(Light.LIGHT_ON_EVENT, null));
            }

            @Override
            public void turnLightOff() {
                System.out.println("Turning light off.");
                light.processEvent(new EventInstance(Light.LIGHT_OFF_EVENT, null));
            }

            @Override
            public String getMicrowaveStatus() {
                return "Microwave status: " + oven.getCurrentState();
            }

            @Override
            public void updateStatus(String status) {
                System.out.println("Microwave status updated to: " + status);
            }

            @Override
            public int getRemainingCookingTime() {
                // Return a placeholder value
                return 0;
            }
        };

        // Simulate interactions
        hardwareServer.setCookingPeriod(60000); // Set cooking time to 60 seconds
        hardwareServer.openDoor();
        hardwareServer.closeDoor();
        hardwareServer.startCooking();
        // After some time, cancel or complete the cooking process
        hardwareServer.cookingComplete();
    }
}
