package java_assignment;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class producerClass extends Thread{
	
    private Queue<Integer> data;
    private int maxSize;
	producerClass(Queue<Integer> data,int maxSize)
	{
		this.data=data;
		this.maxSize=maxSize;
	}
	@Override
	public void run()
	{
		while(true)
		{
			synchronized (data) 
			{ 
				while (data.size() == maxSize) 
			   { 
				try { 
					System.out .println("data list is full");
			        data.wait(); 
			         } 
			   catch (Exception ex) 
			      {
				   ex.printStackTrace(); 
				   } 
			   }
			}
			Random random = new Random(); 
			int i = random.nextInt(); 
			System.out.println("Producing value : " + i); 
			data.add(i); 
			synchronized(data)
	    	  {
            data.notify();
	    	  }	
		}
	}

}
