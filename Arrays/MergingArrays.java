
package mergingarrays;

import java.util.*;
public class MergingArrays {

    
    public static void main(String[] args) {
        
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter the size of the first array : ");
        int size1 = input.nextInt();
        System.out.println("Enter the size of the second array : ");
        int size2 = input.nextInt();
        int array1 [] = new int [size1];
        int array2 [] = new int [size2];
        
        for(int i =0; i<size1;i++){
            array1[i] = (int)(1+Math.random()*100);
        }
        for(int i =0; i<size2;i++){
             array2[i] = (int)(1+Math.random()*100);
        }
        
        int array3 [] = new int [size1 + size2];
        
         for(int i =0; i<size1;i++){
            array3[i] = array1[i];

        }
         int j =0;
         for(int i = size1 ; i<array3.length; i++){
             array3[i] = array2[j];
             if(j<array2.length-1)
             j++;
         }
         System.out.print("Array 1 \n");
        for(int i =0; i<size1;i++){
            
            System.out.print(array1[i] + "  ");
        }
        System.out.print("\nArray 2 \n");
        for(int i =0; i<size2;i++){
            
             System.out.print(array2[i] + "  ");
        }
        System.out.println("\nArray 3 \n");
        for(int i =0; i<array3.length;i++){  
             System.out.print(array3[i] + "  ");
        }
        
    }
    
}
