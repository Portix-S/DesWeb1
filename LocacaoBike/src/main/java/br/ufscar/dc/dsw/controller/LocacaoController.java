package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/locacoes/*")
public class LocacaoController extends HttpServlet {

    private static final Long serialVersionUID = 1L;
    private LocacaoDAO locacao_dao;
    private LocadoraDAO dao;
    private UsuarioDAO usuarioDao;
    private ClienteDAO clienteDao;

    @Override
    public void init() {
        locacao_dao = new LocacaoDAO();
        dao = new LocadoraDAO();
        usuarioDao = new UsuarioDAO();
        clienteDao = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {           
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        List<Locacao> listaLocacoes = null;
        Cliente cliente = clienteDao.getByEmail(usuario.getEmail());
        if(cliente != null)
        {
            System.out.println("Recebido CPF: " + cliente.getCPF());
            listaLocacoes = locacao_dao.getAll(cliente.getCPF());
        }
        else
        {
            System.out.println("Passouuu");
            Locadora locadora = dao.getByEmail(usuario.getEmail());
            listaLocacoes = locacao_dao.getAllByCNPJ(locadora.getCNPJ());
            System.out.println("Criou Lista");
        }
        request.setAttribute("listaLocacoes", listaLocacoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CNPJ = request.getParameter("CNPJ");
        Locadora locadora = dao.get(CNPJ);
        String email = request.getParameter("Email");
        Cliente cliente = clienteDao.getByEmail(email);
        request.setAttribute("locadora", locadora);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Long id = Long.parseLong(request.getParameter("id"));
        //Locacao locacao = locacao_dao.get(id);
        String CNPJ = request.getParameter("CNPJ");
        Locacao locacao = locacao_dao.getByCNPJ(CNPJ);
        request.setAttribute("locacao", locacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Erro erros = new Erro();
        request.setCharacterEncoding("UTF-8");
        String CPF = request.getParameter("CPF");
        String CNPJ = request.getParameter("CNPJ");
        String data_locacao = request.getParameter("data_locacao");
        String horario_locacao = request.getParameter("horario_locacao");
        String data_horario_locacao = data_locacao + horario_locacao; 

        System.out.println("Data e horario: " + data_horario_locacao);
        if(locacao_dao.getByDataHora(CPF, CNPJ, data_horario_locacao) == null) {
            System.out.println("Triste");
            Locacao locacao = new Locacao(CPF, CNPJ, data_locacao, horario_locacao, data_horario_locacao);
            locacao_dao.insert(locacao);
        }
        else {
            erros.add("Data e hora de locação já em uso!");
        }
        System.out.println(erros.getErros());
		request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		if (!erros.isExisteErros())
		{
			/*String URL = "/pagInicial.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);*/
            response.sendRedirect("lista");  
		}
		else
		{
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth_locacaoDuplicada.jsp");
			rd.forward(request, response);
		}
        
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/locacoes/lista");
        //dispatcher.forward(request, response);
        //response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String CPF = request.getParameter("CPF");
        String CNPJ = request.getParameter("CNPJ");
        String data_locacao = request.getParameter("data_locacao");
        String horario_locacao = request.getParameter("horario_locacao");
        String data_hora_locacao = data_locacao + horario_locacao; 

        Locacao locacao = new Locacao(id, CPF, CNPJ, data_locacao, horario_locacao, data_hora_locacao);
        locacao_dao.update(locacao);

        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        Locacao locacao = locacao_dao.get(id);

        locacao_dao.delete(locacao);

        response.sendRedirect("lista");
    }
}