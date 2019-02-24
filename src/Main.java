import java.io.*;
import java.util.*;

public class Main implements Runnable{
	
	static void title() {
System.out.println("        _");
System.out.println("       ;`',							");
System.out.println("       `,  `,						");
System.out.println("        ',   ;   ,,-====..,         ");
System.out.println("         \\    ','          \\        ");
System.out.println(" ,-'''-., ;    '    __.-=-.;		");
System.out.println(",\" ,,_    \"V      _.\"				");
System.out.println(";,'   ''-,         \"=--,_		");
System.out.println("     ,-''    _  _       `,		");
System.out.println("    /   ,.-+(_)(_)´--.,   ;		");
System.out.println("   ,'  /   ; (_)       `\\ ,		");
System.out.println("   ; ,/    ;._.;         ;		");
System.out.println("   !,'     ;   ;		  ===============================================	");
System.out.println("   V'      ;   ;		  |   	Dalam rat race orang2 maniak ini,	|");
System.out.println("           ;._.;		  |	Kalau seorang programmer terpaku        |");
System.out.println("           ;   ;		  |     terus matanya ke layar komputer,        |");
System.out.println("           ;   ;        ~         |	  Apa bedanya dia ada di kelas dengan   |");
System.out.println("~          ;._.;		  |       tersesat di Lonely Island?            |");
System.out.println("      ~    ;   ;		  ===============================================		");
System.out.println("          .´   `.                ~ ");
System.out.println("    __,.--;.___.;--.,___			");
System.out.println("_,,-\"\"      ;     ;       \"\"-,,_			");
System.out.println(".-´´            ;     ;             ``-.		");
System.out.println("\",              ´       `               ,\"    ");
System.out.println("\"-_                                _-\"		");
 	
System.out.println(" _                       _          ");
System.out.println("| |                    | |      	");
System.out.println("| |     ___  _ __   ___| |_   _ 	");
System.out.println("| |    / _ \\| '_ \\ / _ \\ | | | |	");
System.out.println("| |___| (_) | | | |  __/ | |_| |	");
System.out.println("\\_____/\\___/|_| |_|\\___|_|\\__, |	");
System.out.println("                          _ _/ |	");
System.out.println("                          |___/ 	");

System.out.println(" _____    _                 _ 	");
System.out.println("|_   _|  | |               | |	");
System.out.println("  | | ___| | __ _ _ __   __| |  ");
System.out.println("  | |/ __| |/ _` | '_ \\ / _` |	");
System.out.println(" _| |\\__ \\ | (_| | | | | (_| |	");
System.out.println(" \\___/___/_|\\__,_|_| |_|\\__,_|	");
                             

	}
	
	public static void main(String args[]) {
		new Thread(null, new Main(), "thread1", 1<<26).start();//setting stack size for depth first search
	}

	public void run() {
		
		//title
		title();
		
		String fileName;
		Scanner sc = new Scanner(System.in);
		//File Input
		System.out.println("");
		System.out.print("Please enter your file name: ");
		fileName = sc.nextLine();
		System.out.println("Reading "+fileName);
		System.out.println("");
		
		Scanner fsc = null;
		
		try {
			fsc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
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
		
		//Find all lonely island(s) and enumeration
		A.LastResort(r);
		
		
		Iterator<Integer> i = A.LonelyIsland.iterator();
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}
		
		System.out.println("\n");
		System.out.println("Paths enumeration: ");
		Iterator<LinkedList<Integer>> j = A.allPaths.iterator();
		while(j.hasNext()){
			Iterator<Integer> k = j.next().iterator();
			System.out.print("[");
			while(k.hasNext()) {
				System.out.print(k.next());
				if(k.hasNext()) {
					System.out.print("-> ");
				}
			}
			System.out.println("]");
		}
	
	}
}
