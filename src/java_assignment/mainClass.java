package java_assignment;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class mainClass {
	
	public static void main(String args[])
			{
		  System.out.println("Producer Consumper Problem");
		  
		  Queue<Integer> data = new LinkedList<Integer>(); 
		  int maxSize = 10;
		  Thread producer = new producerClass(data, maxSize); 
		  Thread consumer = new consumerClass(data, maxSize);

		  producer.start();
	      consumer.start();
		  
			}
}
