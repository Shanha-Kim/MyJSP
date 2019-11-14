package com.koitt.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class MemberVO {
	private String m_no;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_tel;
	private String m_email;
	private Date joinDate;
	private Time joinTime;
	private String sDate;
	private String sTime;
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Time getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Time joinTime) {
		this.joinTime = joinTime;
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
	public void setsTime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.sTime = form.format(joinTime);
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public void setsDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		this.sDate = form.format(joinDate);
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
}
