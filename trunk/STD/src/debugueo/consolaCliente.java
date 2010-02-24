package debugueo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public final class consolaCliente {

	public static void main(String[] args) {
		try{
	        Socket s = new Socket("127.0.0.1",3000);
	        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	        String comando = "";

	        BufferedReader teclau = new BufferedReader(new InputStreamReader(System.in));
	        do {
	        	System.out.println("Prueba un comando: ");
	        	comando = teclau.readLine() + "\r\n";
	        	dos.writeBytes(comando);
	        	System.out.println(br.readLine());
	        }   while (!comando.equals("SALIR\r\n"));
	    
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
