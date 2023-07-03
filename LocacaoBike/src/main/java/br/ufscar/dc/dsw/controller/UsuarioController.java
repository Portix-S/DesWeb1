package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;
import java.util.Locale;
import java.util.ResourceBundle;;


@WebServlet(urlPatterns = "/loginCliente/*")
public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceptLanguage = request.getHeader("Accept-Language");

		String lang = acceptLanguage.split("-")[0];
		String country = acceptLanguage.split("-")[1];
		

		request.setAttribute("javax.servlet.jsp.jstl.fmt.locale", new Locale(lang, country));
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getPapel().equals("cliente") || usuario.getPapel().equals("admin")) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/index.jsp");
            dispatcher.forward(request, response);
    	} else {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [cliente] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    	}    	
    }
}