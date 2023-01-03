public class First
{
    public static void main(String args[])
    {
        System.out.println("____We are in the first class's main____ ");
        // creating an object out of the second class
        Second obj = new Second();
        System.out.println("Calling second class's function:");
        obj.fn();
    }
}