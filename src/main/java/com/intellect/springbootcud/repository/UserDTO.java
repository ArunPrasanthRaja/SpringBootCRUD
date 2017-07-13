package com.intellect.springbootcud.repository;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * This data transfer object contains the information of a single user
 * entry and specifies validation rules that are used to ensure that only
 * valid information can be saved to the used database.
 * @author Arun
 */
public final class UserDTO {

    private String id;

    private String fName;

    private String lName;
    
    private String email;
    
    private Integer pinCode;
    
    private Date birthDate;
    
    private Boolean isActive; 
   

    public UserDTO() {

    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getPinCode() {
		return pinCode;
	}


	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pinCode="
				+ pinCode + ", birthDate=" + birthDate + ", isActive=" + isActive + "]";
	}



}
