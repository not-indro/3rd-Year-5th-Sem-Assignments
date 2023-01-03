package PACK1.PACK2;
import PACK1.PACK2.PACK3.Third;
public class Second 
{
    public void fn2()
    {
        System.out.println("This is second class's function.");
        System.out.println("Calling third class's function:");
        Third obj = new Third();
        obj.fn3();
    }    
}