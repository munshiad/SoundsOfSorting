package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sorts.Sorts;

public class SwapEvent<T extends Comparable<T>> implements SortEvent<T> {
    int index1;
    int index2;
    
    public SwapEvent(int i, int j) {
        index1 = i;
        index2 =j;
    }
    public void apply(T[] arr) {
        Sorts.swap(arr, index1, index2);
    }

    
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<>(2);
        list.add(index1);
        list.add(index2);
        return list;
    }

    
    public boolean isEmphasized() {
        return true;
    }

}
