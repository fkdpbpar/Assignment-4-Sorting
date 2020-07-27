/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static java.util.Objects.hash;

/**
 *
 * @author George.Pasparakis
 */
public class Sort {
    private List<TShirt> tShirts;
    
    Sort(List<TShirt> shirts) {
        this.tShirts = new ArrayList<TShirt>(shirts);
    }

    public List<TShirt> gettShirts() {
        return tShirts;
    }

    public void settShirts(List<TShirt> tShirts) {
        this.tShirts = tShirts;
    }
    
    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    */
    public List<TShirt> sortBySize(int sortMethod, int sortOrder, int buckets) {
        List<TShirt> shirts = new ArrayList<TShirt>(this.tShirts);
        switch(sortMethod) {
            case 0:
                shirts = quickSortBySize(0, shirts.size()-1, sortOrder);
                break;
            case 1:
                shirts = bubbleSortBySize(sortOrder);
                break;
            case 2:
                shirts = bucketSortBySize(sortOrder, buckets);
                break;
        }
        
        return shirts;
    }
    
    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    */
    public List<TShirt> sortByColor(int sortMethod, int sortOrder) {
        List<TShirt> shirts = new ArrayList<TShirt>();
        switch(sortMethod) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        
        return shirts;
            
    }
    
    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    */
    public List<TShirt> sortByFabric(int sortMethod, int sortOrder) {
        List<TShirt> shirts = new ArrayList<TShirt>();
        switch(sortMethod) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        
        return shirts;
        
    }
    
    private List<TShirt> bubbleSortBySize(int type) {
        int n = tShirts.size(); 
        List<TShirt> tempShirts = tShirts;
        switch(type) {
            case 0:
                for (int i = 0; i < n-1; i++) {
                    for (int j = 0; j < n-i-1; j++) 
                        if (tempShirts.get(j).getSize().ordinal() > tempShirts.get(j+1).getSize().ordinal()) 
                        { 
                            TShirt temp = tempShirts.get(j); 
                            tempShirts.set(j, tempShirts.get(j+1));
                            tempShirts.set(j+1, temp); 
                        }
                }
                break;
            case 1:
                for (int i = 0; i < n-1; i++) {
                    for (int j = 0; j < n-i-1; j++) 
                        if (tempShirts.get(j).getSize().ordinal() < tempShirts.get(j+1).getSize().ordinal()) 
                        { 
                            TShirt temp = tempShirts.get(j); 
                            tempShirts.set(j, tempShirts.get(j+1));
                            tempShirts.set(j+1, temp); 
                        }
                }
                break;
        }
        
        return tempShirts;
    }
    
    private int quickPartition(List<TShirt> arr, int low, int high, int sortOrder) 
    { 
        TShirt pivot = arr.get(high);  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            if(sortOrder == 0) {
                // If current element is smaller than the pivot 
                if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) 
                { 
                    i++; 

                    // swap arr[i] and arr[j] 
                    TShirt temp = arr.get(i); 
                    arr.set(i, arr.get(j)); 
                    arr.set(j, temp); 
                } 
            }
            else {
                 // If current element is smaller than the pivot 
                if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) 
                { 
                    i++; 

                    // swap arr[i] and arr[j] 
                    TShirt temp = arr.get(i); 
                    arr.set(i, arr.get(j)); 
                    arr.set(j, temp); 
                } 
            }
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        TShirt temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
        return i+1; 
    }
    
    private List<TShirt> quickSortBySize(int low, int high, int sortOrder) 
    { 
        List<TShirt> arr = this.tShirts;
        List<TShirt> arr2 = arr; 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = quickPartition(arr2, low, high, sortOrder); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSortBySize(low, pi-1, sortOrder); 
            quickSortBySize(pi+1, high, sortOrder); 
        } 
        return arr2;
    } 
    
    private List<TShirt> bucketSortBySize(int sortOrder, int noOfBuckets) {
        List<TShirt> shirts = this.tShirts;
        shirts = bucketSort(shirts, noOfBuckets, sortOrder);
        return shirts;
    }
    
    private List<TShirt> bucketSort(List<TShirt> shirts, int noOfBuckets, int sortOrder){
        // Create bucket array
        List<TShirt>[] buckets = new List[noOfBuckets];
        // Associate a list with each index 
        // in the bucket array         
        for(int i = 0; i < noOfBuckets; i++){
            buckets[i] = new LinkedList<>();
        }
        // Assign numbers from array to the proper bucket
        // by using hashing function
        for(TShirt tshirt : shirts){
            //System.out.println("hash- " + hash(num));
            buckets[tshirt.hashCode()].add(tshirt);
        }
        // sort buckets
        for(List<TShirt> bucket : buckets){
            Collections.sort(bucket);
        }
        int i = 0;
        // Merge buckets to get sorted array
        for(List<TShirt> bucket : buckets){
            for(TShirt num : bucket){
                shirts.set(i++, num);
            }
        }
        return shirts;
    }
}
