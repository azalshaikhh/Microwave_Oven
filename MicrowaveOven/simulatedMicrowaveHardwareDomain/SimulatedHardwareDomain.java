package MicrowaveOven.simulatedMicrowaveHardwareDomain;

import java.util.Timer;
import java.util.TimerTask;

// SimulatedHardwareDomain class to manage the simulated hardware
public class SimulatedHardwareDomain {

    private Frame theFrame;
    private TextInputField cookingPeriodTextInput;
    private PushButton setCookingPeriodButton;
    private PushButton startCookingButton;
    private PushButton doorOpenButton;
    private PushButton doorCloseButton;

    // Constructor to initialize the simulated hardware components
    public SimulatedHardwareDomain() {
        initialise();
    }

    // Method to initialize the hardware components and UI
    public void initialise() {
        theFrame = new Frame("COMP3110/6311 (2003) Microwave Oven", 600, 50);
        cookingPeriodTextInput = new TextInputField("10000");
        setCookingPeriodButton = new PushButton("Set Cooking Period", new SetCookingPeriodCallback());
        startCookingButton = new PushButton("Start Cooking", new StartCookingCallback());
        doorOpenButton = new PushButton("Open Door", new DoorOpenCallback());
        doorCloseButton = new PushButton("Close Door", new DoorCloseCallback());

        theFrame.addComponent(cookingPeriodTextInput);
        theFrame.addComponent(setCookingPeriodButton);
        theFrame.addComponent(startCookingButton);
        theFrame.addComponent(doorOpenButton);
        theFrame.addComponent(doorCloseButton);
    }

    // Callback class for setting the cooking period
    private class SetCookingPeriodCallback implements Callback {
        @Override
        public void execute() {
            // Logic for setting cooking period
            System.out.println("Cooking period set to: " + cookingPeriodTextInput.getText() + " milliseconds.");
        }
    }

    // Callback class for starting the cooking process
    private class StartCookingCallback implements Callback {
        @Override
        public void execute() {
            // Logic for starting cooking process
            System.out.println("Cooking started.");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Cooking finished.");
                }
            }, Long.parseLong(cookingPeriodTextInput.getText()));
        }
    }

    // Callback class for opening the microwave door
    private class DoorOpenCallback implements Callback {
        @Override
        public void execute() {
            // Logic for opening the door
            System.out.println("Door opened.");
        }
    }

    // Callback class for closing the microwave door
    private class DoorCloseCallback implements Callback {
        @Override
        public void execute() {
            // Logic for closing the door
            System.out.println("Door closed.");
        }
    }

    // Main method for testing the simulated hardware domain
    public static void main(String[] args) {
        SimulatedHardwareDomain simulatedHardwareDomain = new SimulatedHardwareDomain();
        simulatedHardwareDomain.initialise();
    }
}

// Interfaces and classes to simulate UI components and callbacks
interface Callback {
    void execute();
}

class Frame {
    private String title;
    private int width;
    private int height;

    public Frame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void addComponent(Object component) {
        // Add component to frame (simulation)
        System.out.println("Component added to frame: " + component.getClass().getSimpleName());
    }
}

class TextInputField {
    private String text;

    public TextInputField(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class PushButton {
    private String label;
    private Callback callback;

    public PushButton(String label, Callback callback) {
        this.label = label;
        this.callback = callback;
    }
}
