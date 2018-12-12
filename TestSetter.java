package test;

import java.util.ArrayList;
import java.util.List;

// edit these imports according to your project
import Searcher.BFS;
import Searcher.Board_Searchable;
import Searcher.Searchable;
import Searcher.Searcher;
import Searcher.Solution;
import Searcher.State;
import Server.Cache_Manager;
import Server.Client_Handler;
import Server.My_Cache_Manager;
import Server.My_Client_Handler;
import Server.My_Server;
import Server.My_Solver;
import Server.Pipe_Game_Board;
import Server.Server;
import Server.Solver;

public class TestSetter {
	
	public static void setClasses(DesignTest dt){
		
		// set the server's Interface, e.g., "Server.class"
		// don't forget to import the correct package e.g., "import server.Server"
		dt.setServerInteface(Server.class);
		// now fill in the other types according to their names
		// server's implementation
		dt.setServerClass(My_Server.class);
		// client handler interface
		dt.setClientHandlerInterface(Client_Handler.class);
		// client handler class
		dt.setClientHandlerClass(My_Client_Handler.class);
		// cache manager interface
		dt.setCacheManagerInterface(Cache_Manager.class);
		// cache manager class
		dt.setCacheManagerClass(My_Cache_Manager.class);
		// solver interface
		dt.setSolverInterface(Solver.class);
		// solver class
		dt.setSolverClass(My_Solver.class);
		// searchable interface
		dt.setSearchableInterface(Searchable.class);
		// searcher interface
		dt.setSearcherInterface(Searcher.class);
		// your searchable pipe game class
		dt.setPipeGameClass(Board_Searchable.class);
		// your Best First Search implementation
		dt.setBestFSClass(BFS.class);
	}
	
	// run your server here
	static Server s;
	public static void runServer(int port){
		s=new My_Server(port);
		s.start(new My_Client_Handler(new My_Solver<Character>(new BFS<Character>())), new My_Solver<Character>(new BFS<Character>()));
	}
	// stop your server here
	public static void stopServer(){
		s.stop();
	}
	
	/* ------------- Best First Search Test --------------
	 * You are given a Maze
	 * Create a new Searchable from the Maze
	 * Solve the Maze
	 * and return a list of moves from {UP,DOWN,RIGHT,LEFT}
	 *  
	 */
	
	public static List<String> solveMaze(Maze m){
		return null;
	}

}
