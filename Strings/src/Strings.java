

/**
 * Created by Helga on 10/15/2017.
 */

public class Strings {
    public static void main(String...args) {
        try {
            if (args.length != 1) throw new InputException(Integer.toString(args.length));
            StringBuffer stringBuffer = new StringBuffer(args[0]);
            if (!isValid(stringBuffer)) throw new InvalidStringException();

            int prevLeftIndex = stringBuffer.indexOf("(");
            int curLeftIndex = prevLeftIndex;
            int curRightIndex = stringBuffer.indexOf(")");
            int howManyToSkip;

            System.out.println(stringBuffer.toString());

            while (curRightIndex != -1 && curLeftIndex != -1) {
                prevLeftIndex = stringBuffer.indexOf("(");
                curLeftIndex = prevLeftIndex;
                howManyToSkip = -1;
                while (curLeftIndex < curRightIndex && curLeftIndex != -1) {
                    prevLeftIndex = curLeftIndex;
                    curLeftIndex = stringBuffer.indexOf("(", curLeftIndex + 1);
                    howManyToSkip++;
                }
                curLeftIndex = prevLeftIndex;
                stringBuffer.delete(curLeftIndex, curRightIndex + 1);
                curRightIndex = 0;
                System.out.println(stringBuffer.toString());
                for (int i = 0; i <= howManyToSkip; i++) {
                    curRightIndex = stringBuffer.indexOf(")", curRightIndex + 1);
                }
            }

            String string = stringBuffer.toString();
            System.out.println(string);
        } catch(InvalidStringException e) {
            System.out.println("Invalid string");
        }
        catch(InputException e )
        {
            System.out.println("Input Exception  "+e.getMessage());
    }

    }

    public static boolean isValid(StringBuffer stringBuffer)
    {
        int leftBraces=countIf(stringBuffer,"(");
        int rightBraces=countIf(stringBuffer,")");
        return leftBraces==rightBraces?true:false;
    }
    public static int countIf(StringBuffer stringBuffer,String a)
    {int count=0;
        int prevLeftIndex=stringBuffer.indexOf(a);
        int curLeftIndex=prevLeftIndex;
        while(curLeftIndex<stringBuffer.length()&&curLeftIndex!=-1)
        {
            curLeftIndex=stringBuffer.indexOf(a,prevLeftIndex+1);
            prevLeftIndex=curLeftIndex;
            count++;
        }
        return count;
    }
 }

