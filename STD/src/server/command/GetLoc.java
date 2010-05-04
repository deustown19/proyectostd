package server.command;


import server.ClientRequest;

public class GetLoc extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==3){
			respuesta = "" + CRLF;
			cr.setState(2);
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
	

}
