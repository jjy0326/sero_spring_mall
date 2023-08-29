package com.sero.sts.vo;

public class AddressVO {
	private String zipNum;
	private String sido;
	private String gugun;
	private String dong;
	private String zipCode;
	private String bunji;

	public AddressVO() {

	}

	@Override
	public String toString() {
		return "AddressVO [zipNum=" + zipNum + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", zipCode="
				+ zipCode + ", bunji=" + bunji + "]";
	}

	public String getzipNum() {
		return zipNum;
	}

	public void setzipNum(String zipNum) {
		this.zipNum = zipNum;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getzipCode() {
		return zipCode;
	}

	public void setzipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
}

