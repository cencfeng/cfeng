package com.cen.entity;

public class SeeUser {
    private String id;
    private String ip;//�û���id
    private String seeTime;//�û����ʵ�ʱ��
    private int seeCount;//�û����ʵĴ���
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSeeTime() {
		return seeTime;
	}
	public void setSeeTime(String seeTime) {
		this.seeTime = seeTime;
	}
	public int getSeeCount() {
		return seeCount;
	}
	public void setSeeCount(int seeCount) {
		this.seeCount = seeCount;
	}
    
}