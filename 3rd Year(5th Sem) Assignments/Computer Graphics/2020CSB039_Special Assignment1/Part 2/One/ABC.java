import PACK_D.Child;
import PACK1.Base;
public class ABC
{
    public static void main(String args[])
    {
        System.out.println("____We are in the ABC class's main____ ");
        System.out.println("Creating object of child class:");
        Child obj = new Child();
        System.out.println("1. Calling base class's method with it:");
        obj.fn();
        System.out.println("2. Creating child class's method with it:");
        obj.fn1();
    }
}