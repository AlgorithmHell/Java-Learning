package series;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Helga on 11/11/2017.
 */
public abstract class Series {
    protected int first;
    protected int delimeter;
    protected int amount;
    public abstract int calculate(int index);
    public int sum(){
        int result=0;
        for(int i=0;i<amount;i++){
            result+=calculate(i+1);
        }
        return result;
    }
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder(Integer.toString(first));
        for(int i=1;i<amount;i++){
            stringBuilder.append(" ");
            stringBuilder.append(calculate(i+1));
        }
        return stringBuilder.toString();
    }
    public void save(String path, String what) throws IOException {

            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(what);
            writer.close();

    }
}
