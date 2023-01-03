package PACK1;
import PACK1.PACK2.Second;
public class First
{
    public static void main(String args[])
    {
        System.out.println("____We are in the first class's main____ ");
        System.out.println("Calling second class's function:");
        Second obj = new Second();
        obj.fn2();
    }
}
