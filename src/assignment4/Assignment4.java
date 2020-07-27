/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author George.Pasparakis
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<TShirt> tShirts = new ArrayList<TShirt>();
        tShirts = generateTShirts(4,0);
        Sort sort = new Sort(tShirts);
        printTShirts(tShirts);
        sort.sortBySize(2, 0, 5);
        printTShirts(tShirts);
        
//        long startTime = System.currentTimeMillis();
//        tShirts = generateTShirts(4000,0); 
//        long endTime = System.currentTimeMillis();
//        System.out.println("Generation of 40 TShirts (type 0) on: " +
//                (endTime - startTime));
        
//        long startTime = System.currentTimeMillis();
//        tShirts = generateTShirts(3,1);
//        sort = new Sort(tShirts);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Generation of 4 TShirts (type 1) on: " + 
//                (endTime - startTime));
//        System.out.println("UnSorted Array");
//        printTShirts(tShirts);
//        System.out.println("Sorted Array");
        
        // Quick Sort ASC
//        System.out.println("QSASC");
//        printTShirts(sort.sortBySize(0, 0));
        
        // Quick Sort DESC
//        System.out.println("QSDESC");
//        printTShirts(sort.quickSortBySize(0, tShirts.size()-1, 1));
//        printTShirts(sort.sortBySize(0, 1));
        
//        System.out.println("ORIGINAL");
        
        
        // Bubble Sort ASC
        //printTShirts(sort.sortBySize(1, 0));
        
        // Bubble Sort DESC
        //printTShirts(sort.sortBySize(1, 1));
        
        
        
    }
    
    public static List<TShirt> generateTShirts(int count, int type) {
        List<TShirt> tShirts = new ArrayList<TShirt>();
        for(int i = 0; i < count; i++) {
            TShirt e = new TShirt();
            e.setName(randomName(type));
            e.setColor(randomColor());
            e.setSize(randomSize());
            e.setFabric(randomFabric());
            tShirts.add(e);
        }
        return tShirts;
    }
    
    /*
    type = 0, String concatenation
    type = 1, StringBuilder
    */
    public static String randomName(int type) {
        char chars[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Random random = new Random();
        String s = "";
        switch(type) {
            case 0:
                for(int i = 0; i < 12; i++) {
                    s += chars[random.nextInt(26)];
                }
                break;
            case 1:
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < 12; i++) {
                    sb.append(chars[random.nextInt(26)]);
                }
                s = sb.toString();
                break;
        }
        return s;
    }
    
    public static Color randomColor() {
        Random random = new Random();
        return Color.values()[random.nextInt(Color.values().length)];
    }
    
    public static Size randomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
    
    public static Fabric randomFabric() {
        Random random = new Random();
        return Fabric.values()[random.nextInt(Fabric.values().length)];
    }
    
    public static void printTShirts(List<TShirt> tShirts) {
        for(TShirt e: tShirts) {
            System.out.println(e.getName() + " " + e.getSize());
        }
    }

}
