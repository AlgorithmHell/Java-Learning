package ChristmasTree;


/**
 * Created by Helga on 11/10/2017.
 */
public class ChristmasTree  implements Comparable<ChristmasTree>{
    private int height;
    private int [][]tree;
    private int capacity;

    public ChristmasTree(int height){
        this.height=height;
        capacity=height*(1+height)/2;
        tree=new int [height][];
        for(int i=0;i<height;i++){
           tree[i]=new int [i+1];
        }
    }

    public boolean addAttribute(int number){
        double checker=number/Math.pow(10,height);
        if(checker>1) return false;
        if(number==0) return false;
        int level=0;
        while (number/Math.pow(10,level+1)>=1){
            level++;
        }
        int i=0;
        for(;i<tree[level].length;i++){
            if(tree[level][i]==0) {
                tree[level][i]=number;
                break;
            }
        }
        if(i==tree[level].length)
            tree[level][level]=number;
        return true;
    }

    public int weight(){
        int weight=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<tree[i].length;j++){
                weight+=tree[i][j];
            }
        }
        return weight;
    }

    @Override
    public int compareTo( ChristmasTree o) {
        return this.height*this.weight()-o.height*o.weight();
    }

    public boolean equals(ChristmasTree christmasTree){
        return this.compareTo(christmasTree)==0 ;
    }

    public int getHeight() {
        return height;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString(){
     return Integer.toString(weight()*getHeight());
    }
}
