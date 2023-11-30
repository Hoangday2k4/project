package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public class QuickSort extends Sorting {
    public QuickSort(int[] values) {
        super(values);
        this.sortingDisplay = new SortingDisplay();
        this.sortingDisplay.setValues(values); // Pass the values array to SortingDisplay
        this.sortingDisplay.setVisible(true);
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public SortingDisplay getSortingDisplay() {
        return sortingDisplay;
    }

    public void setSortingDisplay(SortingDisplay sortingDisplay) {
        this.sortingDisplay = sortingDisplay;
    }

    @Override
    public void sort() {
        quickSort(values, 0, values.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            this.accessCount++;

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                this.swapCount++;

                sortingDisplay.repaint();
                sortingDisplay.sleep();
            }

            this.comparisons++;
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        this.swapCount++;

        sortingDisplay.repaint();
        sortingDisplay.sleep();

        return i + 1;
    }
}