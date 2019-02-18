//By M. Rifky I. Bariansyah
//13517081

import java.util.*;
import java.io.*;



class Island {

	private int N; //number of islands
	public LinkedList<Integer> adj[]; //Array of Adjacency Linked List
	// adj[u]: array of adjacency from u
	// [i1, i2, ...] to i1, i2, ...
	
	//Island Constructor
	Island(int m){
		N = m; //m islands
		adj = new LinkedList[N+1]; //N LinkedLists
		adj[0] = null;
		for (int i = 1 ; i <= m ; i++) {
			adj[i] = new LinkedList();
			//System.out.println(i);
			}
		System.out.println("Constructor Activated "+ N +" Island(s)");
	}
	
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
	} //add a directed Bridge from u to i
	
	
	//Class tests
	public static void main(String args[]){
		
		Island a = new Island(5);
		
		a.addBridge(1, 3);
		a.addBridge(3, 5);
		a.addBridge(5, 1);
	}

	
}




