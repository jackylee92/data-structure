import java.util.ArrayList;
public class Main{
    // 搜索树Set测试
    private void testBSTSet() {
        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime();

        System.out.println("Times:" + (endTime-startTime)/1000000000.0);
    }

    // 链表Set测试
    private void testLinkListSet() {
        long startTime = System.nanoTime();

        System.out.println("傲慢与偏见");
        ArrayList<String> word1 = new ArrayList<>();
        if (FileOperation.readFile("Set/pride-and-prejudice.txt", word1)) {
            System.out.println("Total words: " + word1.size());

            LinkListSet<String> l1 = new LinkListSet<>();
            for (String word: word1) {
                if (!l1.contains(word)) {
                    l1.add(word);
                }
            }
            System.out.println("Total different words: " + l1.getSize());
        }

        System.out.println();

        System.out.println("双城记");

        ArrayList<String> word2 = new ArrayList<>();
        if (FileOperation.readFile("Set/a-tale-of-two-cities.txt", word2)) {
            System.out.println("Total words: " + word2.size());
            
            LinkListSet<String> l2 = new LinkListSet<>();
            for (String word: word2) {
                if (!l2.contains(word)) {
                    l2.add(word);
                }
            }

            System.out.println("Total different words: " + l2.getSize());
        }

        long endTime = System.nanoTime();

        System.out.println("Times:" + (endTime-startTime)/1000000000.0);
    }
    
    public static void main(String argv[]) {
        Main main = new Main();
        main.testLinkListSet();
        System.out.println();
        main.testBSTSet();
    }
        
}