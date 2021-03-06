//By M. Rifky I. Bariansyah
//13517081

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;



public class Island {

	public int N; //number of islands
	public LinkedList<Integer> adj[]; //Array of Adjacency Linked List
	// adj[u]: array of adjacency from u
	// [i1, i2, ...] to i1, i2, ...
	public LinkedList<Integer> LonelyIsland;//List of Lonely Island
	public LinkedList<Integer> path;//Temporary list for path enumeration
	public LinkedList<LinkedList<Integer>> allPaths;//List of path enumeration
	
	
	//Island Constructor
	Island(int n){
		N = n; //m islands
		adj = new LinkedList[N+1]; //N LinkedLists
		adj[0] = null; 
		LonelyIsland = new LinkedList();
		path = new LinkedList();
		allPaths = new LinkedList<>();
		
		for (int i = 1 ; i <= n ; i++) {
			adj[i] = new LinkedList();
			}
		System.out.println("Constructor Activated "+ N +" Island(s)");
	}
	
	//add a directed Bridge from u to i
	void addBridge(int u, int i) {
		try {
			adj[u].add(i);
			System.out.println("Added an Bridge from "+u+" to "+i);
		}
		catch (NullPointerException error){
			System.out.println("Island is out of bound");
		}
		catch (ArrayIndexOutOfBoundsException error){
			System.out.println("Island is out of bound");
		}
	} 
	
	//Check if there's no more available bridge for connecting to other island(s)
	boolean NoAvailBridge(int i, boolean flag[]) {
		boolean available;
		available = true;
		
		Iterator<Integer> n = adj[i].listIterator(); 
        while (n.hasNext() && available) 
        { 
            int m = n.next(); 
            if (flag[m] == false) {
            	available = false;
            }
        }
        
        return available;
        
	}
	
	void DFS(int i, boolean flag[]) {
		
		LinkedList tempList = new LinkedList();
		
		//Flag island as visited
		flag[i] = true;
		path.add(i);
		
		
		if (NoAvailBridge(i,flag)) {
			//Add to List of Lonely Island(s)
			if(!LonelyIsland.contains(i)){
			LonelyIsland.add(i);}
			//Assigning and then Moving to the next list of path
			
			tempList = (LinkedList) path.clone();			
			allPaths.add(tempList);
			
			
		}
		
		//Recursive for all bridges
		Iterator<Integer> n = adj[i].listIterator(); 
        while (n.hasNext()) 
        { 
            int m = n.next(); 
            if (!flag[m]) {
                DFS(m, flag);} 
        }
		
		
		//Flag island as unvisited for backtracking
		flag[i] = false;
		path.removeLast();
	}
	
	//Find all lonely island(s) and enumeration to the island(s) 
	void LastResort(int i) {
		//array of visited island(s)
		boolean flag[] = new boolean[N+1];
		
		//Depth first search implementation
		System.out.println("Starting DFS..");
		System.out.println("");
		DFS(i,flag);	
	}
	
	
	//Class tests
	/*public static void main(String args[]){
		
		Island a = new Island(5);
		
		a.addBridge(1, 3);
		a.addBridge(3, 5);
		a.addBridge(5, 1);
	}*/

	
}




