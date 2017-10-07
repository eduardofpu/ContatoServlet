package contatos.servlets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//http://localhost:8080/contatos/index.html
public class Mensagens 
{
	public String mensagemLoginInvalido() 
	{
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html lang=\"pt-br\">");
		sb.append("<head>");
		sb.append("<meta charset=\"Windows-1252\">");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/style.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='container'>");
		sb.append("<div class='panel panel-default'>");
		sb.append("<div class='panel-heading'>");
		sb.append("<h3 class='panel-title'>Nota de Serviço</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		sb.append("<h4>Login ou senha inválidos.<br> Por favor volte e tente novamente.</h4>");
		sb.append("<a href='index.html'><button type='button' class='btn btn-link'>Voltar</button></a>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}

	public String mostraContatos( String nomeLogin ) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		//FileInputStream entrada = new FileInputStream("/home/daniloarantes/git/TrabalhoContatos/contatos/src/contatos.txt");
		
		FileInputStream entrada = new FileInputStream("C:/Users/Eduardo/eclipse-workspace/TrabalhoContatos/contatos/src/contatos.txt");
		
		
		InputStreamReader entradaFormatada = new InputStreamReader(entrada);
		BufferedReader entradaString = new BufferedReader(entradaFormatada);
		
		sb.append("<html lang=\"pt-br\">");
		sb.append("<head>");
		sb.append("<meta charset=\"Windows-1252\">");
		
		sb.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css' integrity='sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M' crossorigin='anonymous1'");

		
		
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/style.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='container'>");
		sb.append("<div class='panel panel-default'>");
		sb.append("<div class='panel-heading'>");
		sb.append("<h3 class='panel-title'>Lista de Contatos</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		
		String linha = entradaString.readLine();
		
		sb.append("<form method=\"post\" action=\"excluiContato\">");
		String[] contatos;
		while(linha != null)
		{
			if( linha.contains(nomeLogin) )
			{
				int primeiro, ultimo;
		        primeiro = linha.indexOf("=") + 1;//+1 para pegar o caracter apos =
		        ultimo = linha.lastIndexOf("");
				contatos = linha.split(";");
				/*
				sb.append("<div class=\"checkbox\">"
						+ "<ul><li>Nome: "+contatos[1]+
							"<ul><li>Telefone: "+contatos[2]
							+"<label><input type=\"checkbox\" name=\"contato\" value=\""
								+linha.substring(primeiro, ultimo)+"\"></label>"+
							"</div></li></li></ul></ul><br>");
				*/
				
				sb.append("<table class='table table-striped'>");
						
																
						sb.append("<tbody>");
													
									sb.append("<tr>");
											
								     sb.append(""
										  + "<td>"+contatos[1]+"</td>"
										  + "<td>"+contatos[2]+"</td>"
										  + "<td><input type=\"checkbox\" name=\"contato\" value=\""+linha.substring(primeiro, ultimo)+"\"></td>"
										);
									
								
							         sb.append("</tr>");
				    
				    
					sb.append("</tbody>");
				sb.append("</table>");
			}
			linha = entradaString.readLine();
		}
		entrada.close();
		sb.append("<button type=\"submit\" class=\"btn btn-danger\">Excluir contatos marcados</button>");
		sb.append("</form>");		
		sb.append("<a href='index.html'><button type='button' class='btn btn-primary'>Trocar de usuario</button></a>");
		sb.append("<a href='addContato.html'><button type='button' class='btn btn-success'>"
				+ "Cadastrar contato</button></a>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
}
