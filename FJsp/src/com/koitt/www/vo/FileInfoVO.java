package com.koitt.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.*;

public class FileInfoVO {
	private int fno;
	private String oriname;
	private String savename;
	private String dir;
	private long len;
	private Date fdate;
	private String sdate;
	private Time ftime;
	private String sTime;
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
		setSdate();
	}
	public String getSdate() {
		return sdate;
	}
	public Time getFtime() {
		return ftime;		
	}
	public void setFtime(Time ftime) {
		this.ftime = ftime;
		setsTime();
	}
	public String getsTime() {
		return sTime;
	}
	
	//=================시간계산=============
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy.MM.dd");
		this.sdate = form.format(fdate);
	}
	public void setsTime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.sTime = form.format(ftime);
	}
	
	
}
