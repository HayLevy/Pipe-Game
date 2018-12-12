package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Server.Client_Handler;

public abstract class My_Server implements Server {

	private int port;
	private Client_Handler handler;
	private volatile boolean done;
	
	public My_Server(int port) {
		this.port = port;
		this.done = false;
	}
	
	public void start(Client_Handler ch, Solver<?> sol) {
		this.handler= ch;
		new Thread(()->{
			try {
				runServer(sol);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void runServer(Solver<?> sol) throws IOException {
		ServerSocket server = new ServerSocket(port);
		server.setSoTimeout(1000);
		while (!done)
		{
			try {
				Socket aClient = server.accept();
				ExecutorService executor = Executors.newCachedThreadPool();
				executor.execute(new Runnable() {
					public void run() {
						try {
							handler = new My_Client_Handler(sol);
							handler.hc(aClient.getInputStream(), aClient.getOutputStream());
							aClient.getInputStream().close();
							aClient.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
			catch (SocketTimeoutException e) { }
		}
		server.close();
	}

	@Override
	public void stop() {
		this.done = true;
	}

}
