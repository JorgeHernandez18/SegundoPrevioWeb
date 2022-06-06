package co.empresa.bancoBBVA.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.bancoBBVA.dao.BillDao;
import co.empresa.bancoBBVA.dao.BillDaoFactory;
import co.empresa.bancoBBVA.modelo.Bill;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/Bill")
public class BillServlet extends HttpServlet {
	private BillDao billDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		String type = getServletContext().getInitParameter("type");
		this.billDao = BillDaoFactory.getBillDao(type);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarBill(request, response);
				break;
			case "/delete":
				eliminarBill(request, response);
				break;
			case "/ver":
				showForm(request, response);
				break;
			default:
				listBills(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void listBills(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bill> listBills = billDao.selectAll();
		request.setAttribute("listBills", listBills);

		RequestDispatcher dispatcher = request.getRequestDispatcher("billlist.jsp");
		dispatcher.forward(request, response);
	}

	private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Bill billActual = billDao.select(id);

		request.setAttribute("bill", billActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill.jsp");
		dispatcher.forward(request, response);
	}

	private void eliminarBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		billDao.delete(id);

		response.sendRedirect("list");

	}

	private void insertarBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String observation = request.getParameter("observation");
		int type = Integer.parseInt(request.getParameter("type"));
		int value = Integer.parseInt(request.getParameter("value"));

		Bill bill = new Bill(observation, type, value);

		billDao.insert(bill);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
