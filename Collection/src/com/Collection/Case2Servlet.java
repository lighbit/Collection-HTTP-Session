package com.Collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Case2 @author zulkarnaen
 */

@WebServlet("/Case2Servlet")
public class Case2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Case2Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: membuat string myobject dengan memanggil parameter id
		String myObjectId = request.getParameter("id");

		// TODO: panggil manipulasi dengan nama ambil
		DataPresiden ambil = new DataPresiden();

		// TODO: selanjutnya buat list emplist 2
		List<DataPresiden> empList2 = new ArrayList<DataPresiden>();

		// TODO: Session
		ArrayList<DataPresiden> std = (ArrayList<DataPresiden>) request.getSession(false).getAttribute("empList1");
		for (DataPresiden counter : std) {

			if (counter.getId().equals(myObjectId)) {

				ambil.setGaji(counter.getGaji());
				ambil.setGolongan(counter.getGolongan());
				empList2.add(ambil);
			}
		}

		request.setAttribute("empList2", empList2);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/case2.jsp");
		rd.forward(request, response);

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
