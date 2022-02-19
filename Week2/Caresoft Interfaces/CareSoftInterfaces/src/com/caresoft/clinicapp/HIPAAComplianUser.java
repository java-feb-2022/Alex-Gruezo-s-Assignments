package com.caresoft.clinicapp;

public interface HIPAAComplianUser {
	abstract boolean assignPin (int pin);
	abstract boolean accessAuthorized (Integer confirmedAuthID);
}
