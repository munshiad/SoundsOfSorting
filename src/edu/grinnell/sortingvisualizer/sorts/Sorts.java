package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;

public class Sorts {
    // Swap two elements of an array
    public static <T> void swap(T[] arr, int i, int j) { 
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Sort an array using selection sort
    // Return a list of sorting events so that the sort can be replayed
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        for(int i = 0; i < arr.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i; j < arr.length; j++) {
                events.add(new CompareEvent<T>(i, j));
                if (arr[j].compareTo(arr[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            swap(arr, i, lowestIndex);
            events.add(new SwapEvent<T>(i, lowestIndex));
        } 
        return events;
    }
    
    // Sort an array using insertion sort
    // Return a list of sorting events so that the sort can be replayed
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while(j > 0 && arr[j-1].compareTo(arr[j]) > 0) {
                events.add(new CompareEvent<T>(j-1, j));
                swap(arr, j, j-1);
                events.add(new SwapEvent<T>(j, j-1));
                j--;
            }
            if (j > 0) {
                events.add(new CompareEvent<T>(j-1, j));
            }
        }
        return events;
    }
    
    // Sort an array using merge sort
    // Return a list of sorting events so that the sort can be replayed
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(Object[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    // Helper method for merge sort that keeps track of what part of the array is being sorted
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(Object[] arr, int start, int end) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        if (start == end) {
            return events;
        }
        int rightHalfStart = (start + end + 1) / 2;
        Object[] sortedArr = new Object[arr.length];
        int lCounter = start;
        int rCounter = rightHalfStart;
        
        events.addAll(mergeSort(arr, start, rightHalfStart - 1));
        events.addAll(mergeSort(arr, rightHalfStart, end));
        
        int sortedIndex = 0;
        while(lCounter < rightHalfStart && rCounter <= end) {
            
            
            events.add(new CompareEvent<T>(lCounter, rCounter));
            if (((T) arr[lCounter]).compareTo((T) arr[rCounter]) < 0) { //left is smaller than right
                sortedArr[sortedIndex] = arr[lCounter];
                sortedIndex++;
                lCounter++;
            }
            else {
                sortedArr[sortedIndex] = arr[rCounter];
                sortedIndex++;
                rCounter++;
            }
        }
        while (lCounter < rightHalfStart) {
            sortedArr[sortedIndex] = arr[lCounter];
            sortedIndex++;
            lCounter++;
        }
        while (rCounter <= end) {
            sortedArr[sortedIndex] = arr[rCounter];
            sortedIndex++;
            rCounter++;
        }
        for (int i = 0; i < sortedArr.length; i++) {
            events.add(new CopyEvent<T>(i));
            arr[i] = sortedArr[i];
        }
        return events;
    }
    
    // Sort an array using quick sort
    // Return a list of sorting events so that the sort can be replayed
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }
    
    // Helper method for quick sort that keeps track of what part of the array is being sorted
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr, int start, int end) {
        List<SortEvent<T>> events = new ArrayList<>();
        if(start >= end) {
            return events;
        }
        int leftHalf = start;
        int pivotIndex = median(arr, start, end);
        T pivotValue = arr[pivotIndex];

        events.add(new SwapEvent<T>(start, pivotIndex));
        swap(arr, start, pivotIndex);
        for (int i = start + 1; i <= end; i++) {
            events.add(new CompareEvent<T>(i, start));
            if(arr[i].compareTo(pivotValue) < 0) {    
                leftHalf++;
                events.add(new SwapEvent<T>(leftHalf, i));
                swap(arr, leftHalf, i);
            }
        }
        events.add(new SwapEvent<T>(leftHalf, start));
        swap(arr, leftHalf, start);
        events.addAll(quickSort(arr, start, leftHalf - 1));
        events.addAll(quickSort(arr, leftHalf + 1, end));
        return events;
        
    }
    
    // Helper method for quick sort that picks a pivot index
    private static <T extends Comparable<T>> int median(T[] arr, int start, int end, List<SortEvent<T>> events) {
        int firstIndex = start;
        int lastIndex = end;
        int midIndex = (end + start) / 2;
        T first = arr[firstIndex];
        T last = arr[lastIndex];
        T mid = arr[midIndex];
        
        int firstLast = first.compareTo(last);
        int firstMid = first.compareTo(mid);
        int midLast = mid.compareTo(last);
        events.add(new CompareEvent<T>(firstIndex, midIndex));
        events.add(new CompareEvent<T>(firstIndex, lastIndex));
        events.add(new CompareEvent<T>(lastIndex, midIndex));
        
        if (firstMid * midLast >= 0) { // if the inequalities are in the same direction or equal
            return midIndex;
        }
        if (firstLast * midLast < 0) { // if the inequalities are in different direction
            return lastIndex;
        }
        return firstIndex;
    }
    
    // Sort an array using bubble sort
    // Return a list of sorting events so that the sort can be replayed
    public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {//number of elements sorted
            for (int j = 1; j < arr.length - i; j++) { //find the biggest element, place at end
                if(arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr, j, j-1);
                }
            }
        }
        return null; //fix
    }
    
    // Sort an array using bubble sort
    // Return a list of sorting events so that the sort can be replayed
    public static <T extends Comparable<T>> List<SortEvent<T>> customSort(T[] arr) {
        return bubbleSort(arr);
    }
    
    // Sort an array by replaying sort events
    public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
        
    }
   
}
