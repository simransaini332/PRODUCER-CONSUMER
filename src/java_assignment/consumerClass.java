package java_assignment;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class consumerClass extends Thread {
	 private Queue<Integer> data;
	    private int maxSize;
		consumerClass(Queue<Integer> data,int maxSize)
		{
			this.data=data;
			this.maxSize=maxSize;
		}
		@Override
		public void run()
		{
			while(true)
			{
		      synchronized(data)
		      {
		    	  while(data.size()==0)
		    	  {
		    		  try
		    		  {
		    		System.out.println("consumer is wating for consumer to produce data");
		    		data.wait();}
		    		  catch(Exception ex) 
				      {
						ex.printStackTrace(); 
					  } 
		    	  }
		    	  System.out.println("Consuming value : " + data.remove());
		    	  synchronized(data)
		    	  {
	              data.notify();
		    	  }
		      }
				
			}
		}

}
