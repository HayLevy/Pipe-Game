package Server;

public interface Server {
	public void start(My_Client_Handler ch);
	//void runServer(Solver<?> sol) throws IOException;
	void stop();
}
