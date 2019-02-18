import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		
		String fileName;
		Scanner sc = new Scanner(System.in);
		//File Input
		System.out.print("File Name: ");
		fileName = sc.nextLine();
		System.out.println("Reading "+fileName);
		System.out.println("");
		
		Scanner fsc = new Scanner(new File(fileName));
		
		int n, m, r;
		
		n = fsc.nextInt();
		m = fsc.nextInt();
		r = fsc.nextInt();
		
		//Island initialisation
		Island A = new Island(n);
		
		//Bridge Construction
		while(fsc.hasNextInt()){
			int u;
			int i;
		
			u = fsc.nextInt();
			i = fsc.nextInt();
			
			A.addBridge(u, i);
			
		}
		System.out.println("");
		System.out.println("Island construction completed");
		System.out.println("");
		//Printing Bridges
		for (int i = 1; i <=n; i++) {
			System.out.print("Island "+i+" directs to: ");
			System.out.println(A.adj[i]);
		}
	}
}
