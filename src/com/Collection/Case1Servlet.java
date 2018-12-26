package com.Collection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Case1 @author zulkarnaen
 */

@WebServlet("/Case1Servlet")
public class Case1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Case1Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO: Panggil File Collectionnya dg nama msgfile
		String msgFile = "D:/Collection/Server/collection.csv";
		// TODO: lalu ada file baru bernama myfile berisi msgfile
		File myFile = new File(msgFile);

		// TODO: buat list datapresiden yang ada di myfile
		List<DataPresiden> dataPresidens = Manipulasi.dataPresidens(myFile);

		// TODO: buat httpSession untuk membuat emplist1 di jsp
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("empList1", dataPresidens);

		ArrayList<DataPresiden> httpsession = (ArrayList<DataPresiden>) request.getSession(false)
				.getAttribute("empList1");
		for (DataPresiden dataPresiden : httpsession) {
			dataPresiden.getId();
			dataPresiden.getNama();
			dataPresiden.getTanggal();
			dataPresiden.getGolongan();
			dataPresiden.getGaji();
		}

		// TODO: membuat emplist untuk memunculkan list datapresiden dengan jtsl
		request.setAttribute("empList", dataPresidens);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/case1.jsp");
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
