
public class RationalNumber {
    private int numerator;
    private int denominator;
    
      
    
    //Define a constructor to initialize the data fields
    //it should receive 2 integer numbers
   public RationalNumber (  int num, int denom)
   {
      numerator = num;
      denominator = denom;
   }
   
    public  RationalNumber   add (RationalNumber op2)
   {
      
       int x =  (numerator*op2.denominator)+(op2.numerator*denominator);
       int y = (denominator*op2.denominator);
       return new RationalNumber(x,y);
   }
    
    //-----------------------------------------------------------------
   public RationalNumber multiply (RationalNumber op2)
   {
      
       int x =  (numerator*op2.numerator);
       int y = (denominator*op2.denominator);
       return new RationalNumber(x,y);
       
       
   }
   
  
   public String toString ()
   {
      
       return numerator + "/" + denominator;
       
       
       
   }

    



}
