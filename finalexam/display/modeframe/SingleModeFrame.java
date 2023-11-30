package finalexam.display.modeframe;

import finalexam.App;
import finalexam.defaultsorting.*;
import finalexam.display.MainFrame;
import finalexam.display.SortingDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SingleModeFrame extends JFrame implements ModeInterface {
    MainFrame mainFrame;
    private Sorting sorting;
    private String currentSelection;
    private JLabel sortingName;
    public SingleModeFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager (BorderLayout for the overall frame)
        setLayout(new BorderLayout());

        // Create a panel for the top row (north)
        JPanel topPanel = new JPanel(new FlowLayout());

        JButton startButton = new JButton("Start");
        JButton backButton = new JButton("Back");
        JButton resetArray = new JButton("Reset Array");
        JComboBox<String> comboBox = new JComboBox<>(App.getListSorting().toArray(new String[0]));

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setCurrentSelection((String) comboBox.getSelectedItem());
                }
            }
        });

        this.currentSelection = (String) comboBox.getSelectedItem();

        // Add action listeners to buttons
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
        topPanel.add(comboBox);

        // Add the top panel to the frame at the top (north)
        add(topPanel, BorderLayout.NORTH);

        // Add the test panel to the center of the frame
        this.sorting = new BubbleSort(App.generateRandomArray(200));
        add(this.sorting.getSortingDisplay(), BorderLayout.CENTER);

        // Create a panel to put the output text in (south)
        sortingName = new JLabel();
        sortingName.setHorizontalAlignment(SwingConstants.CENTER);
        sortingName.setText(currentSelection);
        add(sortingName, BorderLayout.SOUTH);

        // Set frame size
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
        int[] newValues = App.generateRandomArray(200);
        this.sorting.setValues(newValues);
        this.sorting.getSortingDisplay().setValues(newValues);
        this.sorting.getSortingDisplay().repaint();
    }

    public void setCurrentSelection(String selection) {
        this.currentSelection = selection;
        sortingName.setText(selection);
        System.out.println("Change to selection " + selection);

        int[] x = App.generateRandomArray(200);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting.getSortingDisplay() != null) {
            remove(sorting.getSortingDisplay());
            revalidate(); // Cập nhật layout
            repaint();    // Vẽ lại container
        }

        if (selection.equals("Bubble sort")) {
            sorting = new BubbleSort(x);
        } else if (selection.equals("Insertion sort")) {
            sorting = new InsertionSort(x);
        } else if (selection.equals("Selection sort")) {
            sorting = new SelectionSort(x);
        } else if (selection.equals("Quick sort")) {
            sorting = new QuickSort(x);
        } else if (selection.equals("Merge sort")) {
            sorting = new MergeSort(x);
        } else {
            return;
        }

        // Thêm sortingDisplay mới vào container
        add(sorting.getSortingDisplay());
        revalidate(); // Cập nhật layout
        repaint();    // Vẽ lại container
        this.sorting.getSortingDisplay().repaint();
    }
}