//4460799 Practical 5 E1
//Used Claude AI free version to help convert some python to code to java

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

        Hashmap<String, Integer> D = new Hashmap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "ISO-8859-1"))){
            
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++
                String[] tokens = line.split("\\s+");
                
                for (String token : tokens) {
                    String w = cleanWord(token);

                    if (w.isEmpty()) continue ;

                    D.put(w, D.getOrDefault(w, 0)+ 1);
                }
                System.out.println("Lines read:"+ lineNumber);
                System.out.println("Unique tokens"+ D.size);

                            }
        } catch (IOException e) {
            System.err.println("Error reading file");
            System.ext(1);
        }


        Hashmap<String, Arraylist<String>> A = new Hashmap<>();
        
    }
}
