//Main implementation
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        BinarySearchTree bst = new BinarySearchTree();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            
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

                    case "SIZE" :
                        if (blocks.length !=1) {
                            System.out.println("Input not valid");
                            break;
                        }
                        System.out.printf("%-18s", "SIZE:", bst.getSize());
                    
                    case "HEIGHT" :
                        if (blocks.length !=1) {
                            System.out.println("Input not valid");
                            break;
                        }
                        System.out.printf("%-18s", "HEIGHT:", bst.height());
                        break;

                    case "SEARCH" :
                        if (blocks.length != 2) {
                            System.out.println("Input not valid");
                            break;
                        }
                        try {
                            int data = Integer.parseInt(blocks[1]);
                            boolean found = bst.search(data);
                            System.out.printf("%-18s", "SEARCH " + data + ": " + found);
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
                                System.out.printf("%-18s", "KTH_SMALLEST " + data + ": " + kthSmallest);
                            } else {
                                System.out.printf("%-18s", "KTH_SMALLEST " + data + ": Not found");
                            }
                        } catch ( NumberFormatException e){
                            System.out.println("Input not valid");
                        }
                        break;
                    
                    default:
                        System.out.println("Input not valid");
                        break;

                }

            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}