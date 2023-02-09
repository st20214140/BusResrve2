package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BusReserveLogic;
import model.Bus_ReserveBean;

/**
 * Servlet implementation class BusReserveServlet
 */
@WebServlet("/BusReserveServlet")
public class BusReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		int flight_number = Integer.parseInt(request.getParameter("flight_number"));
		String user_id = request.getParameter("user_id");
		String seat_id = request.getParameter("seat_id");
		int reserve_flag = Integer.parseInt(request.getParameter("reserve_flag"));
		String price_id = request.getParameter("price_id");


		
		Bus_ReserveBean bus_reservebean = new Bus_ReserveBean(flight_number, user_id, seat_id, reserve_flag, price_id);
		
		BusReserveLogic busreservelogic = new BusReserveLogic();
		boolean isFlag = busreservelogic.execute(bus_reservebean);
		
		/*falseの時が予約がまだっされていない->予約ページに飛ばす*/
		if(isFlag == false) {
			/*予約ページのjspにとばす*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("");
			dispatcher.forward(request, response);
		}else {
			/*予約済みと表示*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Reserved.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
