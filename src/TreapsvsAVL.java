import java.util.*;

public class TreapsvsAVL {

    /*
    the main method uses for loops to calculate the average time it takes for each insertion, deletion, and search method takes for both AVL and treapsgit
     */
    public static void main(String[] args) {
        ArrayList<ArrayList> testArrays = new ArrayList<>(); //New ArrayList object testArrays creation
        for (int i = 1; i <= 1000000; i *= 10) { //For loop from 1 to 100,000, increasing by a magnitude of 10 each run
            testArrays.add(generate(i)); //building ArrayList through generate function
        }

        System.out.println("Testing treap insertion\n ---------------------------");

        TreapNode treapRoot = null;
        double avgTimes = 0;
        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            double start = System.currentTimeMillis();
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < arr.size(); j++) {
                    treapRoot = treapRoot.insert(treapRoot, (int) arr.get(j));
                }
            }
            double end = System.currentTimeMillis();
            double totalTime = end - start;
            avgTimes = totalTime/10;
            System.out.println("It took an average of : " + (long) avgTimes + " milliseconds to insert n= " + arr.size() + " values into a treap");
        }


        System.out.println("---------------------------");
        System.out.println("Testing AVL insertion\n ---------------------------");
        AVL avlTree = new AVL();

        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            double start = System.currentTimeMillis();
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < arr.size(); j++) {
                    avlTree.root = avlTree.insert(avlTree.root, (int) arr.get(j));
                }
            }
            double end = System.currentTimeMillis();
            double totalTime = end - start;
            avgTimes = totalTime/10;
            System.out.println("It took an average of: " + (long) avgTimes + " milliseconds to insert n= " + arr.size() + " values into an AVL tree");
        }
        System.out.println("---------------------------");
        System.out.println("Testing treap search\n ---------------------------");

        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            double start = System.currentTimeMillis();
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < arr.size(); j++) {
                    int chosenIndex = (int) (Math.random() * (double) arr.size());
                    treapRoot.search(treapRoot, chosenIndex);
                }
            }
            double end = System.currentTimeMillis();
            double totalTime = end - start;
            avgTimes = totalTime/10;
            System.out.println("It took an average of: " + (long) avgTimes + " milliseconds to search for n= " + arr.size() + " values in a treap of size n");
        }
        System.out.println("---------------------------");
        System.out.println("Testing AVL search\n ---------------------------");

        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            double start = System.currentTimeMillis();
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < arr.size(); j++) {
                    int chosenIndex = (int) (Math.random() * (double) arr.size());
                    avlTree.search(avlTree.root, chosenIndex);
                }
            }
            double end = System.currentTimeMillis();
            double totalTime = end - start;
            avgTimes = totalTime/10;
            System.out.println("It took an average of : " + (long) avgTimes + " milliseconds to search for n= " + arr.size() + " values in an AVL tree of size n");
        }
        System.out.println("---------------------------");
        System.out.println("Testing Treap deletion\n ---------------------------");
        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            double start = System.currentTimeMillis();
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < arr.size(); j++) {
                    treapRoot = treapRoot.deleteNode(treapRoot, (int) arr.get(j));
                }
            }
            double end = System.currentTimeMillis();
            double totalTime = end - start;
            avgTimes = totalTime/10;
            System.out.println("It took an average of : " + (long) avgTimes + " milliseconds to delete n= " + arr.size() + " values from a treap");
        }
        System.out.println("---------------------------");
        System.out.println("Testing AVL deletion\n ---------------------------");
        for (ArrayList arr : testArrays) { //for each arraylist in test array, println each one
            double start = System.currentTimeMillis();
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < arr.size(); j++) {
                    avlTree.root = avlTree.deleteNode(avlTree.root, (int) arr.get(j));
                }
            }
            double end = System.currentTimeMillis();
            double totalTime = end - start;
            avgTimes = totalTime/10;
            System.out.println("It took an average of : " + (long) avgTimes + " milliseconds to delete n= " + arr.size() + " values from an AVL tree");
        }
        System.out.println("---------------------------");


    }

    //generates an array list of size n
    public static ArrayList generate(int size) {
        ArrayList result = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            result.add((int) (Math.random() * (double) size));
        }
        return result;

    }
}
