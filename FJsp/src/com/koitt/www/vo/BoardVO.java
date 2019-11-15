package com.koitt.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class BoardVO {
	private int bno;
	private String bwriter;
	private String btitle;
	private String bbody;
	private int bfno;
	private char bisshow;
	private Date wDate;
	private Time wTime;
	private String sDate;
	private String sTime;
	
	
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBbody() {
		return bbody;
	}

	public void setBbody(String bbody) {
		this.bbody = bbody;
	}

	public int getBfno() {
		return bfno;
	}

	public void setBfno(int bfno) {
		this.bfno = bfno;
	}

	public char getBisshow() {
		return bisshow;
	}

	public void setBisshow(char bisshow) {
		this.bisshow = bisshow;
	}

	public Date getwDate() {
		return wDate;
	}

	public void setwDate(Date wDate) {
		this.wDate = wDate;
		setsDate();
	}

	public Time getwTime() {
		return wTime;
	}

	public void setwTime(Time wTime) {
		this.wTime = wTime;
		setsTime();
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	//===================셋팅
	public void setsTime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.sTime = form.format(wTime);
	}
	
	public void setsDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		this.sDate = form.format(wDate);
	}
	
	
}
