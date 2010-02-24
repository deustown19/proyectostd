/**
 * 
 */
package server;

import util.SocketManager;

/**
 * @author ziraco
 *
 */
public class ClientRequest implements Runnable {

	final static String CRLF = "\r\n";
	SocketManager sockManager;
	
	public ClientRequest(SocketManager sm){
		this.sockManager = sm;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
