package main;

/**
 * Created by Helga on 10/15/2017.
 */
public class RegexReplacement {
    public static void main(String...args)
    {
        StringBuffer stringBuffer=new StringBuffer();
        for (String arg:args) {
            stringBuffer.append(arg+" ");
        }
        System.out.println("//"+stringBuffer+"//");
        String string=stringBuffer.toString();
        string=string.replaceAll( "\\([^\\(\\)]+\\)","");
        System.out.println(string);
        string=string.replaceAll("[\\(\\)]{1}","");
        System.out.println(string);
        string=string.replaceAll("[\\s]{1,}"," ");
        System.out.println(string);

    }
}
