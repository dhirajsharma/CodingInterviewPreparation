import java.lang.*;

public class CompilerDemo {

   public static void main(String[] args) {
       
     CompilerDemo cls = new CompilerDemo();
     CompilerDemo subcls = new SubClass1();
   
     // class CompilerDemo
     Class c = cls.getClass(); 
     System.out.println(c);
 
     // sub class SubClass1
     Class c1 = subcls.getClass();
     System.out.println(c1);
      
     /* Let's compile CompilerDemo class using command method */
     Object retval = Compiler.command("javac ConsoleDemo");
   
     System.out.println("Return Value = " + retval); 
   }
} 

class SubClass1 extends CompilerDemo {
   // sub class
} 
