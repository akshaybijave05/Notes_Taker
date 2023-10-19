package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note_01;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title = req.getParameter("title");
			String name= req.getParameter("name");
			String mobile=req.getParameter("mobile");
			String date=req.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date date1=sdf.parse(date);
			String noteType = req.getParameter("note_type");
			String content=req.getParameter("content");
			
			int noteId=Integer.parseInt(req.getParameter("noteId").trim());
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			Note_01 note=s.get(Note_01.class, noteId);
			note.setTitle(title);
			note.setName(name);
			note.setMobile(mobile);
			note.setDate(date1);
			note.setNote_type(noteType);
			note.setContent(content);

			tx.commit();
			s.close();
			response.sendRedirect("showNotes.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}




