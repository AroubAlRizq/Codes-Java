 package lab12.dar.pkg;

// import the packakge
import java.util.Scanner;
import java.util.InputMismatchException;
 
public class Lab12DAR {
    public static  String lessThan100(  int number ) throws  Exception
	{
	if ( number  >=  100 ){
           throw new ArithmeticException("Number greater than 100\n"); 
            }
            else
            return "The number is less than 100\n";
        }
    public static  String lessThan50(  int number ) throws  Exception
	{
	if ( number  >=  50 &&  number < 100 ){
        throw new ArithmeticException("Number is between 50 and 100\n"); }

        
	else if ( number  >=  100 )
            return  lessThan100( number );

        else 
            return "The number is less than 50\n";

	}
	public static  void  main( String  args[] )
	{ Scanner input  = new Scanner(System.in);
        
            try{
                System.out.println("Please enter a number : ");
                int number = input.nextInt();
               System.out.print(lessThan50(number));
                
            }
            catch (InputMismatchException ex){
                System.out.println("The input value is not an integer number!");
            }
            
            catch(Exception exception){
        
            System.out.println(exception.toString());
            
            }
            

	} //  end main method

}


