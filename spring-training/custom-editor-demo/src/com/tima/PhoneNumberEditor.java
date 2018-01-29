package com.tima;

import java.beans.PropertyEditorSupport;

public class PhoneNumberEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("Received value: " + text);
		// super.setAsText(text);
		Phone phone = new Phone();
		phone.setCountryCode(text.substring(0, 2));
		phone.setCityCode(text.substring(2, 5));
		phone.setNumber(text.substring(5));

		setValue(phone);
	}

}
