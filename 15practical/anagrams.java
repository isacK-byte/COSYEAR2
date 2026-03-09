//4460799 Practical 5 E1

import java.io.*;
import java.util.*;

public class Anagrams{
    
    public static String signature(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }

    public static String cleanWord(String original){
        String w = original.replaceAll("^[^a-zA-Z']+","").replaceAll("[^a-zA-Z']+$","");
        return w.toLowerCase();
    }

    public static void main(String[] args){

        String inputFile =  "joyce1922_ulysses.text";
        System.out.println("reading from file:"+" "+inputFile);

        
    }
}
