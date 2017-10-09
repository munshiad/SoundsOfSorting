package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.Arrays;
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
        return null;
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j-1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j, j-1);
            }
        }
        //TODO: come back to return list
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(Object[] arr) {
        Object[] leftHalf = new Object[arr.length / 2];
        Object[] rightHalf = new Object[arr.length - leftHalf.length];
        Object[] sortedArr = new Object[arr.length];
        for (int i = 0; i < arr.length / 2; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = leftHalf.length; i < arr.length; i++) {
            rightHalf[i - leftHalf.length] = arr[i];
        }
        if (leftHalf.length != 1) { //base
            mergeSort(leftHalf);
        }
        if (rightHalf.length != 1) { //base
            mergeSort(rightHalf);
        }
        int lCounter = 0;
        int rCounter = 0;
        int sortedIndex = 0;
        while(lCounter != leftHalf.length && rCounter != rightHalf.length) {
            if(((T) leftHalf[lCounter]).compareTo((T) rightHalf[rCounter]) < 0) { //left is smaller than right
                sortedArr[sortedIndex] = leftHalf[lCounter];
                sortedIndex++;
                lCounter++;
            }
            else {
                sortedArr[sortedIndex] = rightHalf[rCounter];
                sortedIndex++;
                rCounter++;
            }
        }
        while (lCounter != leftHalf.length) {
            sortedArr[sortedIndex] = leftHalf[lCounter];
            sortedIndex++;
            lCounter++;
        }
        while (rCounter != rightHalf.length) {
            sortedArr[sortedIndex] = rightHalf[rCounter];
            sortedIndex++;
            rCounter++;
        }
        for (int i = 0; i < sortedArr.length; i++) {
            arr[i] = sortedArr[i];
        }
        //TODO: return something
        return null;
    }
    
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr, int start, int end) {
        if(start >= end) {
            return null;
            //TODO: change return something thing
        }
        int leftHalf = start;
        int pivotIndex = median(arr, start, end);
        T pivotValue = arr[pivotIndex];

        swap(arr, start, pivotIndex);
        for (int i = start + 1; i <= end; i++) {
            if(arr[i].compareTo(pivotValue) < 0) {    
                leftHalf++;
                swap(arr, leftHalf, i);
            }
        }
        swap(arr, leftHalf, start);
        quickSort(arr, start, leftHalf - 1);
        quickSort(arr, leftHalf + 1, end);
        return null;
        
    }
    private static <T extends Comparable<T>> int median(T[] arr, int start, int end) {
        int firstIndex = start;
        int lastIndex = end;
        int midIndex = (end + start) / 2;
        T first = arr[firstIndex];
        T last = arr[lastIndex];
        T mid = arr[midIndex];
        
        if (lessThan(first, mid, last) || lessThan(last, mid, first)) {
            return midIndex;
        } else if (lessThan(first, last, mid) || lessThan(mid, last, first)) {
            return lastIndex;
        } else {
            return firstIndex;
        }
    }
    
    private static <T extends Comparable<T>> boolean lessThan(T a, T b, T c) { // a is the smallest, c is the biggest
        return a.compareTo(b) <= 0 && b.compareTo(c) <= 0;
    }
    
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
    
    public static <T extends Comparable<T>> List<SortEvent<T>> customSort(T[] arr) {
        return bubbleSort(arr);
    }
   
}
