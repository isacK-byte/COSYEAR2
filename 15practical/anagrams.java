//4460799 Practical 5 E1
//Used Claude AI free version to help convert some python to code to java

import java.io.*;
import java.util.*;

public class anagrams{
    
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

        HashMap<String, Integer> D = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "ISO-8859-1"))){
            
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] tokens = line.split("\\s+");
                
                for (String token : tokens) {
                    String w = cleanWord(token);

                    if (w.isEmpty()) continue ;

                    D.put(w, D.getOrDefault(w, 0)+ 1);
                }
                System.out.println("Lines read:"+ lineNumber);
                System.out.println("Unique tokens"+ D.size());

                            }
        } catch (IOException e) {
            System.err.println("Error reading file");
            System.exit(1);
        }


        HashMap<String, ArrayList<String>> A = new HashMap<>();
        for (String w : D.keySet()){
            String sig = signature(w);
            if (!A.containsKey(sig)){
                A.put(sig, new ArrayList<>());
            }
            A.get(sig).add(w);
        }

        System.out.println("Anagram Dictionary :)");

    
        List<String> sortedKeys = new ArrayList<>(A.keySet());
        Collections.sort(sortedKeys);
        
        int groupCount = 0;
        for ( String key : sortedKeys){
            ArrayList<String> group = A.get(key);
            if (group.size() >= 2) {
                Collections.sort(group);
                System.out.println(key +" : "+ group);
                groupCount++;
            }
        }
        System.out.println("Total groups:"+groupCount);

        ArrayList<String> allLines = new ArrayList<>();

        for (String key : A.keySet()) {
            ArrayList<String> group = A.get(key);
            if (group.size() >= 2) continue;
            Collections.sort(group);

            int n = group.size();
            for (int rotation = 0 ; rotation  < n ; rotation++) {
                StringBuilder sb =  new StringBuilder();
                for (int i = 0; i < n; i++){
                    if (i > 0) sb.append(" ");
                  //  sb.append(group.get(i+rotation) % n);
                }
                allLines.add(sb.toString()+ "||||");
            }
        }
        Collections.sort(allLines);

        //Latex part
        
        File latexDir = new File("latex");
        if (!latexDir.exists()) {
            latexDir.mkdir();
        }

        try (PrintWriter texWriter = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream("latex/theAnagrams.tex"), "UTF-8"))) {

            char currentLetter = 0;

            for (String lemma : allLines) {
                char initial = Character.toLowerCase(lemma.charAt(0));

               
                if (initial != currentLetter) {
                    currentLetter = initial;
                    texWriter.println("\n\\vspace{14pt}");
                    texWriter.println("\\noindent\\textbf{\\Large " +
                            Character.toUpperCase(initial) + "}\\\\*[+12pt]");
                }

                texWriter.println(lemma);
            }

            System.out.println("\nLaTeX file written to latex/theAnagrams.tex");

        } catch (IOException e) {
            System.err.println("Error writing LaTeX file: " + e.getMessage());
            System.exit(1);
        }







    }
}
