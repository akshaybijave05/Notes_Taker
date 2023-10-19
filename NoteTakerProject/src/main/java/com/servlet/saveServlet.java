package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public saveServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String title = req.getParameter("title");
			String name= req.getParameter("name");
			String mobile=req.getParameter("mobile");
			String date=req.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date date1=sdf.parse(date);
			String noteType = req.getParameter("note_type");
			String image=req.getParameter("file01");
			
//			FileInputStream fis= new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\NoteTakerProject\\src\\main\\resources\\d2.jpeg");
			@SuppressWarnings("resource")
//			FileInputStream fis= new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\NoteTakerProject\\src\\main\\resources\\n1.png");
			FileInputStream fis= new FileInputStream("C:\\Users\\Asus\\Downloads\\person.png");
			byte[] img1=new byte[fis.available()]; 
			fis.read(img1);
			Note_01 n1=new Note_01();
			n1.setImage(img1);
			
//			image.getBytes()
			
			String content=req.getParameter("content");
			String checkbox=req.getParameter("checkbox01");
			Boolean checkbox1= Boolean.valueOf(checkbox);
			Note_01 note=new Note_01(0, name, title, mobile, date1, noteType, img1, checkbox1, content);
			System.out.println(note.getId()+" : "+ note.getName()+ " : "+ note.getTitle()+ " : "+note.getMobile()+" : " + note.getDate()+ " : "+note.getNote_type()+ " : "+note.getImage()+ " : "+note.getContent());
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<h2> Note Added Successfully....</h2>");
			out.println("<h2><a href='showNotes.jsp'>View All Notes </a></h2>");
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
