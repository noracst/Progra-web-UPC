package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.IPedidodao;
import com.dev.dto.Cancion;
import com.dev.dto.Cliente;
import com.dev.dto.Empleado;
import com.dev.dto.Pago;
import com.dev.dto.Pedido;

import com.dev.factory.Factory;
import com.dev.model.cancionModel;
import com.dev.model.clienteModel;
import com.dev.model.pagoModel;
import com.dev.model.pedidoModel;

/**
 * Servlet implementation class pedidoController
 */
@WebServlet({ "/newpd", "/insertapd", "/editapd", "/updatepd", "/removepd", "/deletepd", "/readpd", "/listpd", })
public class pedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private pedidoModel pdmodel = null;
	private clienteModel cmodel = null;
	private cancionModel cnmodel = null;
	private String mensaje = null;
	private String destino = "/panelpd.jsp";

	public pedidoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	
		pdmodel = new pedidoModel();
		cmodel = new clienteModel();
		cnmodel = new cancionModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newpd")) {
				destino = "createpd.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertpd")) {
				insert(request);
				mensaje = list(request, pdmodel);
				destino = "/panelpd.jsp";
				System.out.println("panelpd");

			} else if (path.equals("/editpd")) {
				read(request,pdmodel);
				destino = "/updatepd.jsp";
			} else if (path.equals("/updatepd")) {
				update(request);
				mensaje = list(request, pdmodel);
				destino = "/panelpd.jsp";

			} else if (path.equals("/removepd")) {
				read(request, pdmodel);
				destino = "/deletepd.jsp";
			} else if (path.equals("/deletepd")) {
				delete(request);
				mensaje = list(request, pdmodel);
				destino = "/panelpd.jsp";

			} else if (path.equals("/listpd")) {
				mensaje = list(request, pdmodel);
				destino = "/panelpd.jsp";
			} else if (path.equals("/readpd")) {
				read(request, pdmodel);
				destino = "/readpd.jsp";
			}

			if (mensaje != null) {
				request.setAttribute("mensaje", mensaje);
			} else {
				request.removeAttribute("mensaje");
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);

	}
    
	private void insert(HttpServletRequest request)throws Exception {
		// TODO Auto-generated method stub
		Pedido p = new Pedido();
		Cliente c = new Cliente();
		Cancion ca = new Cancion();
		p.setCod_pedido(request.getParameter("codigo"));
		ca.setCod_cancion(request.getParameter("cod_cancion"));
		c.setCod_cliente(request.getParameter("cod_cliente"));
		p.setCan(ca);
		p.setCl(c);
		
		pdmodel.RegistrarPedido(p);
		
	}
	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		


		Pedido p = new Pedido();
		Cancion c = new Cancion();
		Cliente cl = new Cliente();
		
		String cod = (request.getParameter("codigo"));
		String cod_cancion = (request.getParameter("cod_cancion"));
		String cod_cliente = (request.getParameter("cod_cliente"));
		p.setCod_pedido(cod);
		c.setCod_cancion(cod_cancion);
		cl.setCod_cliente(cod_cliente);
		p.setCan(c);
		p.setCl(cl);
		
		
		pdmodel.ActualizarPedido(p);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		pdmodel.EliminarPedido(cod);
	}

	protected String list(HttpServletRequest request, pedidoModel pdmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Pedido> list =pdmodel.Listarpedido();
		if (list != null) {
			request.setAttribute("lispedidos", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, pedidoModel pdmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Pedido ped = pdmodel.BuscarPedido(cod);
		if (ped != null) {
			request.setAttribute("pedido", ped);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

