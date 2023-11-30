
package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public abstract class Sorting {
    public int[] values;
    public SortingDisplay sortingDisplay;
    public int accessCount; //đếm số lần lặp
    public int comparisons; //đếm số lần so sánh
    public int swapCount; //đếm số lần đổi chỗ
    public double timeExecuted; //thời gian chạy

    public Sorting(int[] values) {
        this.values = values;
        this.accessCount = 0;
        this.comparisons = 0;
        this.swapCount = 0;
        this.timeExecuted = 0;
    }

    public SortingDisplay getSortingDisplay() {
        return sortingDisplay;
    }

    public void setSortingDisplay(SortingDisplay sortingDisplay) {
        this.sortingDisplay = sortingDisplay;
    }

    public void setValues(int[] newValues) {
        this.values = newValues;
    }

    public abstract void sort();
}