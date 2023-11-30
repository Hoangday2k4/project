package finalexam.display;

import finalexam.display.modeframe.CompareModeFrame;
import finalexam.display.modeframe.SingleModeFrame;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;

    public MainFrame() {
        frame = new JFrame("Sorting Visualization");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // UI components
        JLabel titleLabel = new JLabel("Sorting Visualization");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton singleModeButton = new JButton("Single Mode");
        JButton compareModeButton = new JButton("Compare Mode");
        JButton customAlgorithmButton = new JButton("Your Custom Algorithm");

        // Add actions to buttons
        singleModeButton.addActionListener(e -> openSingleModeFrame());
        compareModeButton.addActionListener(e -> openCompareModeFrame());
        customAlgorithmButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Your Custom Algorithm Selected"));

        // Create panel
        JPanel panel = new JPanel();
        panel.add(titleLabel);
        panel.add(singleModeButton);
        panel.add(compareModeButton);
        panel.add(customAlgorithmButton);

        // Add panel to frame
        frame.add(panel);

        // Display frame
        frame.setVisible(true);
    }

    private void openSingleModeFrame() {
        new SingleModeFrame(this);
        this.frame.setVisible(false);
    }

    private void openCompareModeFrame() {
        new CompareModeFrame(this);
        this.frame.setVisible(false);
    }

    public void showMainFrame() {
        frame.setVisible(true);
    }
}
