package finalexam;

import finalexam.defaultsorting.BubbleSort;
import finalexam.display.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
        });
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(300);
        }

        return arr;
    }

    public static List<String> getListSorting() {
        List<String> sortingList = new ArrayList<>();
        sortingList.add("Bubble sort");
        sortingList.add("Insertion sort");
        sortingList.add("Selection sort");
        sortingList.add("Quick sort");
        sortingList.add("Merge sort");

        return sortingList;
    }
}