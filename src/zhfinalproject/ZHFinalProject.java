//Zach Hart

package zhfinalproject;
//import AVL Tree
//import Treaps
import java.util.*;

public class ZHFinalProject {
    
    public static void main(String[] args) {
        ArrayList<ArrayList> testArrays = new ArrayList<>(); //New ArrayList object testArrays creation
        for(int i = 1; i <= 100000; i *= 10){ //For loop from 1 to 100,000, increasing by a magnitude of 10 each run
            testArrays.add(generate(i)); //building ArrayList through generate function
        }
        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            System.out.println(arr);
        }
    }

public static ArrayList generate(int size){
    ArrayList result = new ArrayList(size);
    for(int i = 0; i < size; i++){
        result.add((int)(Math.random() * (double)size));
    }
    return result;
}
 
}