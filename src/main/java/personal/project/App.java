package personal.project;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
 /*        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(1);
        System.out.println(maxHeap);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(10);
        System.out.println(maxHeap);
        System.out.println(maxHeap.size()); */


        //testing remove Operations
        MaxHeap maxRemove = new MaxHeap();
        maxRemove.insert(1);
        System.out.println(maxRemove.removeMax());
        System.out.println(maxRemove);
        maxRemove.insert(3);
        maxRemove.insert(2);
        maxRemove.insert(5);
        maxRemove.insert(3);
        maxRemove.insert(10);
        maxRemove.removeMax();
        System.out.println(maxRemove.removeMax());
        System.out.println(maxRemove);

    }
}
