package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public class MergeSort extends Sorting {
    public MergeSort(int[] values) {
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
        mergeSort(values, 0, values.length - 1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[low + i];
            this.accessCount++;
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[mid + 1 + j];
            this.accessCount++;
        }

        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            this.comparisons++;
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            this.swapCount++;

            sortingDisplay.repaint();
            sortingDisplay.sleep();

            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;

            this.swapCount++;
            sortingDisplay.repaint();
            sortingDisplay.sleep();
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;

            this.swapCount++;
            sortingDisplay.repaint();
            sortingDisplay.sleep();
        }
    }
}
