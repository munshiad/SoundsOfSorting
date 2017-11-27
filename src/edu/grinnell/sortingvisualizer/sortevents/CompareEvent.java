package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T extends Comparable<T>> implements SortEvent<T> {
    int index1;
    int index2;
    
    public CompareEvent (int i, int j){
        index1 = i;
        index2 = j;
    }
    
    public void apply(T[] arr) {//do nothing
        
    }


    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<>(2);
        list.add(index1);
        list.add(index2);
        return list;
    }


    public boolean isEmphasized() {
        return false;
    }



}
