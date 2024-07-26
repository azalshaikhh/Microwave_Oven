package MicrowaveOven.guiDomain;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class guiDomain {
    
    public static class Frame extends JFrame {
        public Frame(String title, int width, int height) {
            super(title);
            setSize(width, height);
            setVisible(true);
            getContentPane().setLayout(new FlowLayout());
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }

        public void addComponent(Component component) {
            getContentPane().add(component);
        }

        public void refresh() {
            pack();
        }
    }

    public interface PushButtonCallback {
        void buttonPressed();
    }

    public static class PushButton extends JButton {
        private PushButtonCallback callback;

        public PushButton(String label, final PushButtonCallback callback) {
            super(label);
            setSize(100, 100);
            this.callback = callback;
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    callback.buttonPressed();
                }
            });
            setVisible(true);
        }
    }

    public static class TextInputField extends JTextField {
        public TextInputField(String text) {
            super(text);
            setSize(200, 30);
            setVisible(true);
        }
    }

    public static class TextDisplayPanel extends Component {
        // Placeholder for text display functionality
    }

    public static void main(String[] args) {
        // Initialize GUI
        Frame mainFrame = new Frame("Microwave Oven", 600, 400);
        
        // Create GUI components
        TextInputField cookingPeriodTextInput = new TextInputField("10000");
        PushButton setCookingPeriodButton = new PushButton("Set Cooking Period", new PushButtonCallback() {
            @Override
            public void buttonPressed() {
                // Implementation for setting cooking period
                System.out.println("Set Cooking Period Button Pressed");
            }
        });
        PushButton startCookingButton = new PushButton("Start Cooking", new PushButtonCallback() {
            @Override
            public void buttonPressed() {
                // Implementation for starting cooking
                System.out.println("Start Cooking Button Pressed");
            }
        });
        PushButton doorOpenButton = new PushButton("Open Door", new PushButtonCallback() {
            @Override
            public void buttonPressed() {
                // Implementation for opening door
                System.out.println("Open Door Button Pressed");
            }
        });
        PushButton doorCloseButton = new PushButton("Close Door", new PushButtonCallback() {
            @Override
            public void buttonPressed() {
                // Implementation for closing door
                System.out.println("Close Door Button Pressed");
            }
        });
        
        // Add components to frame
        mainFrame.addComponent(cookingPeriodTextInput);
        mainFrame.addComponent(setCookingPeriodButton);
        mainFrame.addComponent(startCookingButton);
        mainFrame.addComponent(doorOpenButton);
        mainFrame.addComponent(doorCloseButton);
        
        // Refresh frame
        mainFrame.refresh();
    }
}
