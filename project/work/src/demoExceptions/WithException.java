package demoExceptions;

public class WithException {

	public static void main (String[] args) {
    	  System.out.println ("Main starts");
    	  int a = 20;
    	  int b = 0;
    	  
    	  try {
    			  int c = a/b;
                  // jre creates an exception object and throwing
                  // ArithmeticException ex = new 

    			  System.out.println("result: "+c);
    	  }
    		
    			  catch (ArithmeticException e) {
    				  System.out. println ("denominator should not be zero") ;
    			  }
    	  System.out. println ("Main Ends") ;
	}
	}
	
