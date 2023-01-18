
@FunctionalInterface
interface demoFunctionalInteface
{

    void printDemoMessage(int num);

}



public class functionalInterfaceImpl
{
    public static void main(String args[])
    {
        demoFunctionalInteface demoInterface = ( r ) -> {
            System.out.println( "Number =" + r );
        };
        demoInterface.printDemoMessage( 2 );

    }
}
