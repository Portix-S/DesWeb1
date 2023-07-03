package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;
import java.util.Locale;
import java.util.ResourceBundle;;



@WebServlet(name = "Index", urlPatterns = { "/index.jsp", "/logout.jsp"})
public class IndexController extends HttpServlet {

	String pietro;
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acceptLanguage = request.getHeader("Accept-Language");

		String lang = acceptLanguage.split("-")[0];
		String country = acceptLanguage.split("-")[1];
		pietro = lang;

		request.setAttribute("javax.servlet.jsp.jstl.fmt.locale", new Locale(lang, country));
		doGet(request, response);
    }
	private static final long serialVersionUID = 1L;
	
	ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "EN"));
	String Erro1 = bundle.getString("Erro1");
	String Erro2 = bundle.getString("Erro2");
	String Erro3 = bundle.getString("Erro3");
	String Erro4 = bundle.getString("Erro4");

	
    
    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(pietro == "en")
		{
			bundle = ResourceBundle.getBundle("messages", new Locale("en", "EN"));
		}
		else
			bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

		Erro erros = new Erro();
		if (request.getParameter("bOK") != null) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			if (email == null || email.isEmpty()) {
				erros.add(Erro1);
			}
			if (senha == null || senha.isEmpty()) {
				erros.add(Erro4);
			}
			if (!erros.isExisteErros()) {
				UsuarioDAO dao = new UsuarioDAO();
				Usuario usuario = dao.getbyEmail(email);
				if (usuario != null) {
					if (usuario.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", usuario);
                        String papel = usuario.getPapel();
						if (papel.equals("admin")) {
							response.sendRedirect("admin/");
						} else if(papel.equals("cliente")){
							response.sendRedirect("loginCliente/");
						} else{
                            response.sendRedirect("loginLocadora/");
                        }
						return;
					} else {
						erros.add(Erro2);
					}
				} else {
					
					erros.add(Erro3);
				}
			}
			
		}
        System.out.println(erros.getErros());
		request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		if (!erros.isExisteErros())
		{
			String URL = "/pagInicial.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);
		}
		else
		{
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
	}
}