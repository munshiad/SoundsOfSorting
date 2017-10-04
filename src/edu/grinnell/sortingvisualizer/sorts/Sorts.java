package edu.grinnell.sortingvisualizer.sorts;

import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class Sorts {
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            swap(arr, i, lowestIndex);
        } //TODO: come back to return list
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j-1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j, j-1);
            }
        }
        //TODO: come back to return list
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
        T[] leftHalf = (T[]) new Object[arr.length / 2];
        T[] rightHalf = (T[]) new Object[arr.length - leftHalf.length];
        T[] sortedArr = (T[]) new Object[arr.length];
        for (int i = 0; i < arr.length / 2; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = leftHalf.length; i < arr.length; i++) {
            rightHalf[i]=arr[i];
        }
        if (leftHalf.length != 1) { //base
            mergeSort(leftHalf);
        }
        if (rightHalf.length != 1) { //base
            mergeSort(rightHalf);
        }
        int lCounter = 0;
        int rCounter = 0;
        while(lCounter != leftHalf.length || rCounter != rightHalf.length) {
            
        
        }
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
        // TODO: implement instrumented quickSort
        return null;
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> customSort(T[] arr) {
        // TODO: implement your own custom sort
        return null;
    }
}
