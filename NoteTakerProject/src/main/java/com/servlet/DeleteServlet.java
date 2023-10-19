package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthStyle;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note_01;
import com.helper.FactoryProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Note_01 note = (Note_01) s.get(Note_01.class, noteId);
			s.delete(note);
			tx.commit();
			s.close();
			response.sendRedirect("showNotes.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
