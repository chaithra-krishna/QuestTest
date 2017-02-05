/**
 * 
 */
package com.quest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Macbook pro
 *
 */
public class Person implements Serializable, Comparable<Person> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String ppsNumber;

	private String mobileNumber;

	private Date dateOfBirth;

	private String dobInString;

	private Date createdDate;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ppsNumber
	 */
	public final String getPpsNumber() {
		return ppsNumber;
	}

	/**
	 * @param ppsNumber
	 *            the ppsNumber to set
	 */
	public final void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	/**
	 * @return the mobileNumber
	 */
	public final String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public final void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the dateOfBirth
	 */
	public final Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public final void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the createdDate
	 */
	public final Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the dobInString
	 */
	public final String getDobInString() {
		return dobInString;
	}

	/**
	 * @param dobInString
	 *            the dobInString to set
	 */
	public final void setDobInString(String dobInString) {
		this.dobInString = dobInString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", ppsNumber=" + ppsNumber + ", mobileNumber=" + mobileNumber + ", dateOfBirth="
				+ dateOfBirth + ", createdDate=" + createdDate + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ppsNumber == null) ? 0 : ppsNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person person = (Person) obj;
		if (ppsNumber == null) {
			if (person.ppsNumber != null) {
				return false;
			}
		} else if (!ppsNumber.equals(person.ppsNumber)) {
			return false;
		}
		return true;
	}

	public int compareTo(Person person) {
		if (null == person || null == person.getCreatedDate()) {
			return 1;
		} else if (null == this.createdDate) {
			return -1;
		} else if (this.createdDate.before(person.getCreatedDate())) {
			return 1;
		} else if (this.createdDate.after(person.getCreatedDate())) {
			return -1;
		}
		return 0;
	}

}
