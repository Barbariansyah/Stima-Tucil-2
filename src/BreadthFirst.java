import java.io.*;
import java.util.*;


public class BreadthFirst {
	//Breadth First Search Implementation
	public static LinkedList lastResort(Island A, int r) {
		//Visit flag for islands
		System.out.println("Counting Last Resort...");
		boolean flag[] = new boolean[A.N+1];
		flag[r] = true;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> resort = new LinkedList<Integer>();
		
		queue.add(r);
		
		while(queue.size() != 0) {
			
			int current;
			
			current = queue.pollFirst();//Process head of queue
			if (A.adj[current].isEmpty()) {
				//System.out.println("Resort : "+ current);
				resort.add(current);
			}
			else
			{
				Iterator<Integer> i = A.adj[current].listIterator(); 
				while (i.hasNext()) 
				{ 
					int n = i.next();
					if (!flag[n]) 
					{ 
						flag[n] = true; 
						queue.add(n); 
					} 
				}
			}
		 }
		return resort;
	}
}
