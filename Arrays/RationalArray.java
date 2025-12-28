
public class RationalArray {
    
    public static void main(String [] args){
        RationalNumber [] num = new RationalNumber [3];
        RationalNumber [] num1 = new RationalNumber [3];
        RationalNumber [] add = new RationalNumber [3];
        RationalNumber [] multiply = new RationalNumber [3];
        String [] list  = {"List 1" , "List 2", "Add  ", "Multiply"};        
        num [0] = new RationalNumber (3,4);
        num [1] = new RationalNumber (1,3);
        num [2] = new RationalNumber (1,2);
        
        num1 [0] = new RationalNumber (2,5);
        num1 [1] = new RationalNumber (1,4);
        num1 [2] = new RationalNumber (3,5);

        for(int i =0 ; i<num1.length; i++){
            add[i] = num[i].add(num1[i]);
            multiply[i] = num[i].multiply(num1[i]);
        }
        System.out.printf("%5s%20s%20s%20s%n" , list[0], list[1], list [2], list [3]);
        for(int i =0 ; i<num1.length; i++){
            System.out.printf("%5s%20s%20s%20s%n" , num[i], num1[i] , add[i], multiply[i]);
            
        }
        }





    }

