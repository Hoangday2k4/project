package finalexam.display.modeframe;

import finalexam.display.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ModeFrame {
    protected JFrame modeFrame;

    public ModeFrame(String title, List<String> algorithms) {
        modeFrame = new JFrame(title);
        modeFrame.setSize(800, 600);
        modeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // UI components
        JButton backButton = new JButton("Back");
        JButton startButton = new JButton("Start");
        JComboBox<String> algorithmComboBox = new JComboBox<>(algorithms.toArray(new String[0]));

        // Set button size
        Dimension buttonSize = new Dimension(100, 30);
        backButton.setPreferredSize(buttonSize);
        startButton.setPreferredSize(buttonSize);

        // Add actions to buttons
        backButton.addActionListener(e -> backToMainFrame());
        startButton.addActionListener(e -> startSorting(algorithmComboBox.getSelectedItem().toString()));

        // Create panel
        JPanel panel = new JPanel();
        panel.add(backButton);
        panel.add(startButton);
        panel.add(new JLabel("Select Algorithm:"));
        panel.add(algorithmComboBox);

        // Add panel to frame
        modeFrame.add(panel);

        // Display frame
        modeFrame.setVisible(true);
    }

    private void backToMainFrame() {
        modeFrame.dispose();
        new MainFrame().showMainFrame();
    }

    protected abstract void startSorting(String algorithm);
}
