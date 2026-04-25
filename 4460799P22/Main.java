//Main implementation
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name (e.g., input.txt): ");
        String fileName = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            sc.close();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) continue; // Skip empty lines
                String[] blocks = line.split("\\s+");
                String command = blocks[0].toUpperCase();

                switch (command){

                    case "BUILD" :
                        if (blocks.length < 2) {
                            System.out.println("Input not valid");
                            break;
                        }
                        try {
                            for (int i = 1 ; i < blocks.length; i++){
                                bst.insert(Integer.parseInt(blocks[i]));    // NO OUTPUT 
                            }
                        } catch ( NumberFormatException e){
                            System.out.println("Input not valid");
                        }
                        break;

                    case "IN_ORDER" :
                        if (blocks.length != 1) {
                            System.out.println("Input not valid");
                            break;
                        } 
                        System.out.printf("%-18s", "IN_ORDER:");
                        bst.print_in_order();
                        break;

                    case "SIZE" :
                        if (blocks.length !=1) {
                            System.out.println("Input not valid");
                            break;
                        }
                        System.out.printf("%-18s%d\n", "SIZE:", bst.getSize());
                        break;
                    
                    case "HEIGHT" :
                        if (blocks.length !=1) {
                            System.out.println("Input not valid");
                            break;
                        }
                        System.out.printf("%-18s%d\n", "HEIGHT:", bst.height());
                        break;

                    case "SEARCH" :
                        if (blocks.length != 2) {
                            System.out.println("Input not valid");
                            break;
                        }
                        try {
                            int data = Integer.parseInt(blocks[1]);
                            boolean found = bst.search(data);
                            System.out.printf("SEARCH %d: %s\n", data, found);
                        } catch ( NumberFormatException e){
                            System.out.println("Input not valid");
                        }
                        break;

                    case "DELETE" :
                        if (blocks.length != 2) {
                            System.out.println("Input not valid");
                            break;
                        }
                        try {
                            int data = Integer.parseInt(blocks[1]);
                            bst.delete(data);                           // NO OUTPUT 
                        } catch ( NumberFormatException e){
                            System.out.println("Input not valid");
                        }
                        break;

                    case "INSERT" :
                        if (blocks.length != 2) {
                            System.out.println("Input not valid");
                            break;
                        }
                        try {
                            int data = Integer.parseInt(blocks[1]);
                            bst.insert(data);                           // NO OUTPUT 
                        } catch ( NumberFormatException e){
                            System.out.println("Input not valid");
                        }
                        break;
                    case "KTH_SMALLEST" :
                        if (blocks.length != 2) {
                            System.out.println("Input not valid");
                            break;
                        }
                        try {
                            int data = Integer.parseInt(blocks[1]);
                            int kthSmallest = bst.find_kth_smallest(data);
                            if (kthSmallest != -1) {
                                System.out.printf("KTH_SMALLEST %d: %d\n", data, kthSmallest);
                            } else {
                                System.out.printf("KTH_SMALLEST %d: Not found\n", data);
                            }
                        } catch ( NumberFormatException e){
                            System.out.println("Input not valid");
                        }
                        break;
                    
                    default:
                        System.out.println("");
                        System.out.println("Input not valid");
                        break;

                }

            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}