package server.command;

import java.sql.ResultSet;

public class Pass extends Command
{
	@Override
	public String command(CommandManager commandManager, String[] params){
		String respuesta = "";
		if (commandManager.getState()==1){
			if (params.length == 0) {
				return "403 ERR Falta la clave" + CRLF;
			}else{
				String user = commandManager.getUser();
				String realUser = "";
				String realPass = "";
				try{
					ResultSet rs = commandManager.getDbm().executeSelect("SELECT * FROM usuario WHERE nombre='"+user+"'");			
					//rs.next();
					realUser = rs.getString("nombre");
					realPass = rs.getString("pass");
					rs.close();
				}catch (Exception e){
					e.printStackTrace();
				}
				if (user.equals(realUser) && params[0].equals(realPass))
				{
					commandManager.setState(2);
					respuesta =  "202 OK Bienvenido al sistema" + CRLF;
				}else{
					commandManager.setState(0);
					commandManager.setUser("");
					respuesta =  "402 ERR La clave es incorrecta. Introduzca usuario" + CRLF;
					
				}
			}
		}else respuesta = "450 ERR Comando no válido" + CRLF;		
		return respuesta;
	}
}
