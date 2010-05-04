package server.command;

import server.ClientRequest;

public class User extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==0)
		{	
			if (params.length == 0) 
				respuesta = "403 ERR Falta el usuario" + CRLF;
			else{
				cr.setUser(params[0]);
				cr.setState(1);
				respuesta =  "201 OK Bienvenido " + cr.getUser() + CRLF;
			}
		} else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
