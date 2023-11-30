package finalexam.display.modeframe;

import finalexam.App;
import finalexam.defaultsorting.BubbleSort;
import finalexam.defaultsorting.InsertionSort;
import finalexam.defaultsorting.Sorting;
import finalexam.display.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CompareModeFrame extends JFrame implements ModeInterface {
    MainFrame mainFrame;
    private Sorting sorting;
    private String currentSelection;
    public CompareModeFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JPanel topPanel = new JPanel(new FlowLayout());

        JButton startButton = new JButton("Start");
        JButton backButton = new JButton("Back");
        JButton resetArray = new JButton("Reset Array");
        JComboBox<String> comboBox1 = new JComboBox<>(App.getListSorting().toArray(new String[0]));
        JComboBox<String> comboBox2 = new JComboBox<>(App.getListSorting().toArray(new String[0]));
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setCurrentSelection((String) comboBox1.getSelectedItem());
                }
            }
        });
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setCurrentSelection((String) comboBox2.getSelectedItem());
                }
            }
        });
        comboBox1.setBounds(500, 150, 400, 30);
        comboBox2.setBounds(790, 300, 150, 30);
        add(comboBox1);
        add(comboBox2);
        //this.currentSelection = (String) comboBox1.getSelectedItem();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        resetArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetArray();
            }
        });

        // Add buttons to the top panel
        topPanel.add(startButton);
        topPanel.add(backButton);
        topPanel.add(resetArray);
        // Add the top panel to the frame at the top (north)
        add(topPanel, BorderLayout.NORTH);

        // Add the test panel to the center of the frame
        this.sorting = new BubbleSort(App.generateRandomArray(50));
        //add(this.sorting.getSortingDisplay(), BorderLayout.CENTER);
        setSize(800, 600);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void start() {
        Thread sortingThread = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting.sort();
        });

        sortingThread.start();
    }


    @Override
    public void back() {
        setVisible(false);
        mainFrame.showMainFrame();
    }

    @Override
    public void resetArray() {
        int[] newValues = App.generateRandomArray(50);
        this.sorting.setValues(newValues);
        this.sorting.getSortingDisplay().setValues(newValues);
        this.sorting.getSortingDisplay().repaint();
    }

    public void setCurrentSelection(String selection) {
        this.currentSelection = selection;
        System.out.println("Change to selection " + selection);
        int[] x = App.generateRandomArray(50);
        if (selection.equals("1111111")) {
            if (sorting.getSortingDisplay() != null) remove(sorting.getSortingDisplay());
            sorting = new BubbleSort(x);
            add(sorting.getSortingDisplay());
            //this.sorting.getSortingDisplay().repaint();
        } else if (selection.equals("2222222")) {
            if (sorting.getSortingDisplay() != null) remove(sorting.getSortingDisplay());
            sorting = new InsertionSort(x);
            add(sorting.getSortingDisplay());
            //this.sorting.getSortingDisplay().repaint();
        }
    }
}