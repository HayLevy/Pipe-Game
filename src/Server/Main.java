package Server;

import Searcher.BFS;

public class Main {

	/*public static void main(String[] args) {
	My_Server server = new My_Server(7438);
	server.start(new My_Client_Handler(new My_Solver<Character>(new BFS<Character>())), new My_Solver<Character>(new BFS<Character>()));
	try {
		TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		Scanner sc = new Scanner(System.in);
		while(!sc.nextLine().equals("stop"))
			{
			
			
			}
		sc.close();	
		server.stop();
	}*/
	
	 public static void main(String[] args) {
	    	System.out.println("**** Server Is Running ****");

	       
	        try {
	            Server s = new Multi_Server(6400,5);//Take the port from the args

	        	s.start(new My_Client_Handler(new My_Solver<Character>(new BFS<Character>())));
	        	System.in.read();
	            s.stop();
	            System.out.println("Closed server");
	        }catch(Exception e) {e.printStackTrace();}
	    }
}
