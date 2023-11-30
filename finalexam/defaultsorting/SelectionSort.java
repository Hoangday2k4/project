package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public class SelectionSort extends Sorting {
    public SelectionSort(int[] values) {
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
        int n = values.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                this.accessCount++;

                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }

                this.comparisons++;
            }

            int temp = values[minIndex];
            values[minIndex] = values[i];
            values[i] = temp;
            this.swapCount++;

            sortingDisplay.repaint();
            sortingDisplay.sleep();
        }
    }
}
