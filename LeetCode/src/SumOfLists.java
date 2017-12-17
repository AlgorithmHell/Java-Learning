import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Helga on 11/21/2017.
 */
public class SumOfLists {

    private class ListNode{
        int value;
        ListNode next;
        public ListNode(int value) { this.value = value; next = null; }
    }

    private List<Integer> l1;
    private List<Integer> l2;

    public SumOfLists(String path, int listSize)throws FileNotFoundException{
        Scanner in = new Scanner(new File(path));
        int i = 0;
        l1 = new LinkedList<>();
        l2 = new LinkedList<>();
        while(i < listSize){
            l1.add(in.nextInt());
            i++;
        }
        while(i < listSize*2) {
            l2.add(in.nextInt());
            i++;
        }
    }

    private void printList(List<Integer> l){
        for (Integer i : l){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public List<Integer> sumOfLists(){


        if(l1 == null || l2 == null) return l2 == null ? l1 : l2;

        printList(l1);
        printList(l2);

        List<Integer> result = new LinkedList<>();

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int wholePart = (l1.get(index1) + l2.get(index2))/10;
        int remainder = (l1.get(index1) + l2.get(index2))%10;

        if(wholePart!=0){
            result.add(wholePart);
            index++;
        }
        result.add(remainder);
        index1++;
        index2++;
        index++;

        while(index1!=l1.size()){
             wholePart = (l1.get(index1) + l2.get(index2))/10;
             remainder = (l1.get(index1) + l2.get(index2))%10;
             result.set(index-1, result.get(index-1)+wholePart);
             result.add(remainder);
             index1++;
             index2++;
             index++;
        }
        printList(result);

        return result;
    }
}
