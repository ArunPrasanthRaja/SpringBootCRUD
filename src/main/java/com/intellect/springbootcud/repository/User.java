package com.intellect.springbootcud.repository;

import org.springframework.data.annotation.Id;

import static com.intellect.springbootcud.util.PreCondition.isTrue;
import static com.intellect.springbootcud.util.PreCondition.notEmpty;
import static com.intellect.springbootcud.util.PreCondition.notNull;

import java.util.Date;

/**
 * @author Arun 
 */
final class User {

   /* static final int MAX_LENGTH_DESCRIPTION = 500;
    static final int MAX_LENGTH_TITLE = 100;*/

    @Id
    private String id;

    private String fName;

    private String lName;
    
    private String email;
    
    private Integer pinCode;
    
    private Date birthDate;
    
    private Boolean isActive; 
    

    public User() {}

    private User(Builder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.email = builder.email;
        this.pinCode = builder.pinCode;
        this.birthDate = builder.birthDate;
        this.isActive = builder.isActive;
    }

    static Builder getBuilder(String fName,String email) {
        return new Builder(fName,email);
    }

    public String getId() {
        return id;
    }

    public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void update(Integer pinCode, Date birthDate) {
        //checkTitleAndDescription(pinCode, pinCode);

        this.pinCode = pinCode;
        this.pinCode = pinCode;
    }

   

    /**
     * We don't have to use the builder pattern here because the constructed class has only two String fields.
     * However, I use the builder pattern in this example because it makes the code a bit easier to read.
     */
    static class Builder {

    	 private String fName;

    	    private String lName;
    	    
    	    private String email;
    	    
    	    private Integer pinCode;
    	    
    	    private Date birthDate;
    	    
    	    private Boolean isActive; 

        public Builder(String fName,String email) {
        	this.fName = fName;        
            this.email = email;
        }

       
        Builder lastName(String lName) {
            this.lName = lName;
            return this;
        }
                      
        Builder pinCode(Integer pinCode) {
            this.pinCode = pinCode;
            return this;
        }
        
        Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        
        Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        User build() {
            User build = new User(this);

            build.validateFields(build.getEmail(), build.getfName(), build.getBirthDate(), build.pinCode);

            return build;
        }
    }

    private void validateFields(String email, String firstName, Date birthDate,Integer pinCode ) {
        notNull(email, "Email cannot be null");
        notEmpty(email, "Email cannot be empty");
        
        notNull(firstName, "First Name cannot be null");
        notEmpty(firstName, "First Name cannot be empty");
        
        if(birthDate!=null){
        isTrue(birthDate.before(new Date()),
                "Birth date should not greater than current date"
                
        );
        }

       /* if (description != null) {
            isTrue(description.length() <= MAX_LENGTH_DESCRIPTION,
                    "Description cannot be longer than %d characters",
                    MAX_LENGTH_DESCRIPTION
            );
        }*/
    }
}
