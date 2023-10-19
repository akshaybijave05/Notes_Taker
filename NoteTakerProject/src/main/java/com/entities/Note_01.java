package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Note_01 {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String title;
	private String mobile;
	@Temporal(TemporalType.DATE)
	private Date date; 
	private String note_type;
	@Lob
	private byte[] image;
	private boolean checkbox;
	@Column(length = 1500)
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName(){
		return name;
		
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getTitle() {
		return title;
		
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote_type() {
		return note_type;
	}
	public void setNote_type(String note_type) {
		this.note_type = note_type;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Note_01(int id, String name, String title, String mobile, Date date, String note_type, byte[] image,
			boolean checkbox, String content) {
		
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.mobile = mobile;
		this.date = date;
		this.note_type = note_type;
		this.image = image;
		this.checkbox = checkbox;
		this.content = content;
		
	
	}
	
	public Note_01() {
		super();
		
	}
	
	
}
