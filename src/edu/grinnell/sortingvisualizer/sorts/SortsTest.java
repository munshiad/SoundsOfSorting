package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class SortsTest {
    private <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void selectionSortTest() {
        String[] arr1 = {"dog", "cat", "peacock", "bird", "alligator", "zebra" , "albert", "aditi"};
        Integer[] arr2 = {5, 6, 7 , 8, 10, 14, 100}; //already sorted
        Integer[] arr3 = {100, 7, 10, 14, 2, 1, 43}; //unsorted
        Integer[] arr4 = {4, 4, 4, 7, 2, 5, 0, 4, 9, 4, 4, 4}; //repeated numbers
        Integer[] arr5 = {-1, 6, 8, -4, 0};
        String[] arr1Copy = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
        Integer[] arr3Copy = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr4Copy = Arrays.copyOf(arr4, arr4.length);
        Integer[] arr5Copy = Arrays.copyOf(arr5, arr5.length);
        Sorts.eventSort(arr1Copy, Sorts.selectionSort(arr1));
        Sorts.eventSort(arr2Copy, Sorts.selectionSort(arr2));
        Sorts.eventSort(arr3Copy, Sorts.selectionSort(arr3));
        Sorts.eventSort(arr4Copy, Sorts.selectionSort(arr4));
        Sorts.eventSort(arr5Copy, Sorts.selectionSort(arr5));
        assert(isSorted(arr1));
        assert(isSorted(arr2));
        assert(isSorted(arr3));
        assert(isSorted(arr4));
        assert(isSorted(arr5));
        assert(isSorted(arr1Copy));
        assert(isSorted(arr2Copy));
        assert(isSorted(arr3Copy));
        assert(isSorted(arr4Copy));
        assert(isSorted(arr5Copy));
    }
    
    @Test
    public void insertionSortTest() {
        String[] arr1 = {"dog", "cat", "peacock", "bird", "alligator", "zebra" , "albert", "aditi"};
        Integer[] arr2 = {5, 6, 7 , 8, 10, 14, 100}; //already sorted
        Integer[] arr3 = {100, 7, 10, 14, 2, 1, 43}; //unsorted
        Integer[] arr4 = {4, 4, 4, 7, 2, 5, 0, 4, 9, 4, 4, 4}; //repeated numbers
        Integer[] arr5 = {-1, 6, 8, -4, 0};
        String[] arr1Copy = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
        Integer[] arr3Copy = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr4Copy = Arrays.copyOf(arr4, arr4.length);
        Integer[] arr5Copy = Arrays.copyOf(arr5, arr5.length);
        Sorts.eventSort(arr1Copy, Sorts.insertionSort(arr1));
        Sorts.eventSort(arr2Copy, Sorts.insertionSort(arr2));
        Sorts.eventSort(arr3Copy, Sorts.insertionSort(arr3));
        Sorts.eventSort(arr4Copy, Sorts.insertionSort(arr4));
        Sorts.eventSort(arr5Copy, Sorts.insertionSort(arr5));
        assert(isSorted(arr1));
        assert(isSorted(arr2));
        assert(isSorted(arr3));
        assert(isSorted(arr4));
        assert(isSorted(arr5));
        assert(isSorted(arr1Copy));
        assert(isSorted(arr2Copy));
        assert(isSorted(arr3Copy));
        assert(isSorted(arr4Copy));
        assert(isSorted(arr5Copy));
    }
    
    @Test
    public void mergeSortTest() {
        String[] arr1 = {"dog", "cat", "peacock", "bird", "alligator", "zebra" , "albert", "aditi"};
        Integer[] arr2 = {5, 6, 7 , 8, 10, 14, 100}; //already sorted
        Integer[] arr3 = {100, 7, 10, 14, 2, 1, 43}; //unsorted
        Integer[] arr4 = {4, 4, 4, 7, 2, 5, 0, 4, 9, 4, 4, 4}; //repeated numbers
        Integer[] arr5 = {-1, 6, 8, -4, 0};
        String[] arr1Copy = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
        Integer[] arr3Copy = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr4Copy = Arrays.copyOf(arr4, arr4.length);
        Integer[] arr5Copy = Arrays.copyOf(arr5, arr5.length);
        Sorts.eventSort(arr1Copy, Sorts.mergeSort(arr1));
        Sorts.eventSort(arr2Copy, Sorts.mergeSort(arr2));
        Sorts.eventSort(arr3Copy, Sorts.mergeSort(arr3));
        Sorts.eventSort(arr4Copy, Sorts.mergeSort(arr4));
        Sorts.eventSort(arr5Copy, Sorts.mergeSort(arr5));
        assert(isSorted(arr1));
        assert(isSorted(arr2));
        assert(isSorted(arr3));
        assert(isSorted(arr4));
        assert(isSorted(arr5));
        assert(isSorted(arr1Copy));
        assert(isSorted(arr2Copy));
        assert(isSorted(arr3Copy));
        assert(isSorted(arr4Copy));
        assert(isSorted(arr5Copy));
    }
    
    @Test
    public void quickSortTest() {
        String[] arr1 = {"dog", "cat", "peacock", "bird", "alligator", "zebra" , "albert", "aditi"};
        Integer[] arr2 = {5, 6, 7 , 8, 10, 14, 100}; //already sorted
        Integer[] arr3 = {100, 7, 10, 14, 2, 1, 43}; //unsorted
        Integer[] arr4 = {4, 4, 4, 7, 2, 5, 0, 4, 9, 4, 4, 4}; //repeated numbers
        Integer[] arr5 = {-1, 6, 8, -4, 0};
        String[] arr1Copy = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
        Integer[] arr3Copy = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr4Copy = Arrays.copyOf(arr4, arr4.length);
        Integer[] arr5Copy = Arrays.copyOf(arr5, arr5.length);
        Sorts.eventSort(arr1Copy, Sorts.quickSort(arr1));
        Sorts.eventSort(arr2Copy, Sorts.quickSort(arr2));
        Sorts.eventSort(arr3Copy, Sorts.quickSort(arr3));
        Sorts.eventSort(arr4Copy, Sorts.quickSort(arr4));
        Sorts.eventSort(arr5Copy, Sorts.quickSort(arr5));
        assert(isSorted(arr1));
        assert(isSorted(arr2));
        assert(isSorted(arr3));
        assert(isSorted(arr4));
        assert(isSorted(arr5));
        assert(isSorted(arr1Copy));
        assert(isSorted(arr2Copy));
        assert(isSorted(arr3Copy));
        assert(isSorted(arr4Copy));
        assert(isSorted(arr5Copy));
    }
    
    @Test
    public void bubbleSortTest() {
        String[] arr1 = {"dog", "cat", "peacock", "bird", "alligator", "zebra" , "albert", "aditi"};
        Integer[] arr2 = {5, 6, 7 , 8, 10, 14, 100}; //already sorted
        Integer[] arr3 = {100, 7, 10, 14, 2, 1, 43}; //unsorted
        Integer[] arr4 = {4, 4, 4, 7, 2, 5, 0, 4, 9, 4, 4, 4}; //repeated numbers
        Integer[] arr5 = {-1, 6, 8, -4, 0};
        String[] arr1Copy = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
        Integer[] arr3Copy = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr4Copy = Arrays.copyOf(arr4, arr4.length);
        Integer[] arr5Copy = Arrays.copyOf(arr5, arr5.length);
        Sorts.eventSort(arr1Copy, Sorts.bubbleSort(arr1));
        Sorts.eventSort(arr2Copy, Sorts.bubbleSort(arr2));
        Sorts.eventSort(arr3Copy, Sorts.bubbleSort(arr3));
        Sorts.eventSort(arr4Copy, Sorts.bubbleSort(arr4));
        Sorts.eventSort(arr5Copy, Sorts.bubbleSort(arr5));
        assert(isSorted(arr1));
        assert(isSorted(arr2));
        assert(isSorted(arr3));
        assert(isSorted(arr4));
        assert(isSorted(arr5));
        assert(isSorted(arr1Copy));
        assert(isSorted(arr2Copy));
        assert(isSorted(arr3Copy));
        assert(isSorted(arr4Copy));
        assert(isSorted(arr5Copy));
    }

}
