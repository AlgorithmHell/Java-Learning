import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Helga on 11/21/2017.
 */
public class CollectionsEx {
    public  void arrayListExample() throws FileNotFoundException {

        Scanner in = new Scanner (new File("Data.txt"));
        Scanner in2 = new Scanner (new File("Data.txt"));
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(in.hasNextInt()){
            list.add(in.nextInt());
        }
        printList(list);
        for(int i = 0 ; i < 6; i++){
            list2.add(in2.nextInt());
        }
        list2.add(0);

        System.out.println("\n"+list.contains(5));
        System.out.println(list.indexOf(5));
        System.out.println(list.lastIndexOf(5));
        System.out.println(list.hashCode());


        list.addAll(list2);
        list.addAll(5,list2);
        printList(list);

        System.out.println();
        Collections.shuffle(list2);
        printList(list2);
        Collections.sort(list);
        printList(list);
        System.out.println();


        Comparator<Integer> c = (Integer a, Integer b)->{ return b - a;};
        Collections.sort(list,c);
        System.out.println();
        printList(list);

    }
    public void linkedListExample() throws FileNotFoundException{
        List<Integer> linkedList = new LinkedList<>();
        Scanner in = new Scanner(new File("Data.txt"));

        while(in.hasNextInt()){
            linkedList.add(in.nextInt());
        }
        printList(linkedList);
        while(linkedList.contains(5)){
            linkedList.remove((Integer)5);
            printList(linkedList);
        }
    }
    public void stackAndQueueExample() throws FileNotFoundException {

        Stack <Integer> stack = new Stack<>();
        Scanner in = new Scanner(new File("Data.txt"));
        Scanner in1 = new Scanner(new File("Data.txt"));
        while(in.hasNextInt()){
            stack.push(in.nextInt());
        }
        printVector(stack);
        printVector(stack);
        System.out.println(stack.search(7));
        Queue<Integer> queue = new LinkedList<>();

        while(in1.hasNextInt()){
            queue.add(in1.nextInt());
        }
        printQueue(queue);

        for(int i = 0; i < 5; i++){
            int k = queue.element();
            System.out.println(k);
            queue.remove(k);
        }
        printQueue(queue);
        queue.remove();
        printQueue(queue);
    }
    public void setExample()throws FileNotFoundException{
        System.out.println();
        System.out.println();
        System.out.println();
        Scanner in = new Scanner(new File("Data.txt"));
        Scanner in1 = new Scanner(new File("Data1.txt"));
        Scanner in2 = new Scanner(new File("Data1.txt"));
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        while (in.hasNextInt()){
            set.add(in.nextInt());
        }
        while (in1.hasNextInt()){
            set1.add(in1.nextInt());
        }
        while(in2.hasNextInt()){
            treeSet.add(in2.nextInt());
        }
        printSet(set);
        printSet(set1);
        set.add(1);
        printSet(set);
        set.add(100);
        printSet(set);
        set.retainAll(set1);
        printSet(set);
        treeSet.retainAll(set);
        printSet(treeSet);
        treeSet.add(10000);
        printSet(treeSet);
        treeSet.add(8889);
        printSet(treeSet);

    }
    public void mapExample()throws FileNotFoundException{
        System.out.println();

        System.out.println();
        System.out.println();
        Scanner in = new Scanner(new File("Data.txt"));
        Scanner in1 = new Scanner(new File("Data.txt"));
        Scanner in2 = new Scanner(new File("Data.txt"));
        int i = 0;
         Map<Integer, Integer> map = new TreeMap<>();
         while(i<16){
             map.put(i,in.nextInt());
             i+=2;
         }
         int j = 1;
         while (j < 15){
             map.put(j,in.nextInt());
             j+=2;
         }
        System.out.println(map.size()+" size ");
         printMap(map);
        System.out.println(map.remove(0));
        printMap(map);
        System.out.println(map.remove(1,8));
        printMap(map);
        System.out.println(map.remove(2,10));
        printMap(map);
        System.out.println(map.remove(1,null));
        printMap(map);

    }

    public  <T>  void  printList(List<T> list){
        for(T i : list ){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public <T> void printVector(Vector<T> v){
        for(T i : v){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public <T> void printQueue(Queue<T> q){
        for(T i : q){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public  <T> void printSet(Set<T> set){
        for(T i : set){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public <K,V> void printMap(Map<K,V> map){
        for(int k = 0; k < map.size(); k++){
            System.out.print(k+" : "+map.get(k)+" ,");
        }
        System.out.println();
    }
}
