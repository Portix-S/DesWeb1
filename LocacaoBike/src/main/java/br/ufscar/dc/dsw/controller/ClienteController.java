package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
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

@WebServlet(urlPatterns = "/clientes/*")
public class ClienteController extends HttpServlet {

    private static final Long serialVersionUID = 1L; 
    private ClienteDAO dao;

    @Override
    public void init() {
        dao = new ClienteDAO();
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
        List<Cliente> listaClientes = dao.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CPF = request.getParameter("CPF");
        Cliente cliente = dao.get(CPF);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String CPF = request.getParameter("CPF");
        String sexo = request.getParameter("sexo");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String data_nascimento = request.getParameter("data_nascimento");
        String papel = request.getParameter("papel");
        
        dao.insert(cliente);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String CPF = request.getParameter("CPF");
        String sexo = request.getParameter("sexo");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String data_nascimento = request.getParameter("data_nascimento");
        String papel = request.getParameter("papel");
        
        dao.update(cliente);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String CPF = request.getParameter("CPF");

        Cliente cliente = new Cliente(CPF);
        dao.delete(cliente);
        response.sendRedirect("lista");
    }
}