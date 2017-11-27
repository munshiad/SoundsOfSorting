package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T extends Comparable<T>> implements SortEvent<T> {

    int index;
    T value;
    
    public CopyEvent(int i, T value) {
        index = i;
        this.value = value;
    }
    
    public void apply(T[] arr) {
        arr[index] = value;
    }

    
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<>(1);
        list.add(index);
        return list;
    }

    
    public boolean isEmphasized() {
        return true;
    }

}
