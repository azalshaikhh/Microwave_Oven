package MicrowaveOven.guiDomain;

import MicrowaveOven.microwaveDomain.Oven;
import MicrowaveOven.simulatedMicrowaveHardwareDomain.*;

public class SetCookingPeriodCallback {
    private Oven oven;
    private SimulatedHardwareDomain simulatedMicrowave;

    public SetCookingPeriodCallback(Oven oven, SimulatedHardwareDomain simulatedMicrowave) {
        this.oven = oven;
        this.simulatedMicrowave = simulatedMicrowave;
    }

    public void setCookingPeriod(int period) {
        simulatedMicrowave.setCookingPeriod(period);
        System.out.println("Cooking period set to " + period + " milliseconds.");
    }
}
