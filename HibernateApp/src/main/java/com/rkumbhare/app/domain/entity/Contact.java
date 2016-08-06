/**
 * @auther Rakesh
 * @time Aug 6, 2016
 */

package com.rkumbhare.app.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	@Column(name = "phone")
	private String phone;
	@Column(name = "mobile")
	private String mobile;

	public Contact() {
	}

	public Contact(String phone, String mobile) {
		this.phone = phone;
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
