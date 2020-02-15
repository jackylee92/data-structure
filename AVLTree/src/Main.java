import java.util.ArrayList;

public class Main{
    public void testBinarySearchTreeMap() {
        long startTime = System.nanoTime();

        System.out.println("傲慢与偏见");
        ArrayList<String> word1 = new ArrayList<>();
        if (FileOperation.readFile("Map/pride-and-prejudice.txt", word1)) {
            System.out.println("Total words: " + word1.size());

            AVLTree<String, Integer> map1 = new AVLTree<>();
            for (String word: word1) {
                if (map1.contains(word))
                    map1.set(word, map1.get(word)+1);
                else
                    map1.set(word, 1); 

            }
            System.out.println("Total different words: " + map1.size());
            System.out.println("Frequency of PRIDE: " + map1.get("pride"));  
            System.out.println("Frequency of PREJUDICE: " + map1.get("prejudice"));

            System.out.println("Is Binary Tree: " + map1.isBST());
            System.out.println("Is AVL tree: " + map1.isAVL());
        }
        long endTime = System.nanoTime();

        System.out.println("Times:" + (endTime-startTime)/1000000000.0);
    }

    public static void main(String[] argv) {
        Main main = new Main();
        main.testBinarySearchTreeMap();
    }
}