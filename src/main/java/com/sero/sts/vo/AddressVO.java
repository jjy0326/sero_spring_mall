package com.sero.sts.vo;

public class AddressVO {
	private String zip_Num;
	private String sido;
	private String gugun;
	private String dong;
	private String zip_Code;
	private String bunji;

	public AddressVO() {

	}

	@Override
	public String toString() {
		return "AddressVO [zipNum=" + zip_Num + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", zipCode="
				+ zip_Code + ", bunji=" + bunji + "]";
	}

	public String getzipNum() {
		return zip_Num;
	}

	public void setzipNum(String zipNum) {
		this.zip_Num = zipNum;
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
		return zip_Code;
	}

	public void setzipCode(String zipCode) {
		this.zip_Code = zipCode;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
}

