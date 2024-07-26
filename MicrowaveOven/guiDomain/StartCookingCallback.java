package MicrowaveOven.guiDomain;

import MicrowaveOven.microwaveDomain.Oven;

public class StartCookingCallback implements Callback {
    private Oven oven;

    public StartCookingCallback(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void handleEvent() {
        oven.startCooking();
    }
}
