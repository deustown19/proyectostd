package debugueo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public final class consolaCliente {

	public static void main(String[] args) {
		try{
			
			int port;
			if (args.length>1){//Comprobación de que el puerto es un número válido. 3000 por defecto.
				try{
					port = Integer.parseInt(args[1]);
					if (port<1024 || port> 49152){
						System.out.println("Número de puerto incorrecto. Debe estar entre 1024 y 49152. Elegido el puerto 3000 en su lugar.");
						port = 3000;
					}
				}
				catch (NumberFormatException e) {
					System.out.println("El puerto debe ser un número. Elegido el puerto 3000 en su lugar.");
					port = 3000;
				}
			}
			else {
				port = 3000;
			} 
			
			String ip;
			if (args.length>0)
				ip = args[0];
			else ip = "127.0.0.1";
			
			
	        Socket s = new Socket(ip,port);
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

	String ip
}
