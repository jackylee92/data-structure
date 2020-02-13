import java.util.ArrayList;
public class main{
    public static void main(String argv[]) {
        System.out.println("傲慢与偏见");
        ArrayList<String> word1 = new ArrayList<>();
        if (FileOperation.readFile("Set/pride-and-prejudice.txt", word1)) {
            System.out.println("Total words: " + word1.size());

            BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<>();
            for (String word: word1) {
                //System.out.println(word);
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("双城记");

        ArrayList<String> word2 = new ArrayList<>();
        if (FileOperation.readFile("Set/a-tale-of-two-cities.txt", word2)) {
            System.out.println("Total words: " + word2.size());
            
            BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
            for (String word: word2) {
                set2.add(word);
            }

            System.out.println("Total different words: " + set2.getSize());
        }
    }
}