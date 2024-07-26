package MicrowaveOven.guiDomain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MicrowaveOven.simulation.MicrowaveSimulation;

public class DoorCloseCallback implements ActionListener {
    private MicrowaveSimulation simulation;

    public DoorCloseCallback(MicrowaveSimulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Logic to handle door close event
        simulation.closeDoor();
    }
}
