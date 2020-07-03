/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.requests;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Yassine
 */
public class UserRequest {

    @NotNull(message = "Ce champ ne doit être null")
    @Size(min = 3, message = "Ce champ doit avoir au moins 3 caractères")
    private String firstName;
    @NotNull(message = "Ce champ ne doit être null")
    @Size(min = 3, message = "Ce champ doit avoir au moins 3 caractères")
    private String lastName;
    @NotNull(message = "Ce champ ne doit être null")
    @Email(message = "Ce champ doit respecter le format email !")
    private String email;

    @NotNull(message = "Ce champ ne doit être null")
    @Size(min = 8, message = "Ce champ doit avoir au moins 8 caractères")
    @Size(max = 12, message = "Ce champ doit avoir au maximum 12 caractères")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "le password doit avoir maj mins & doit avoir 8 charactéres")
    private String password;

    private Boolean admin;
     private List<AddressRequest> addresses;
     private ContactRequest contact;
     
     

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public ContactRequest getContact() {
		return contact;
	}

	public void setContact(ContactRequest contact) {
		this.contact = contact;
	}
    public List<AddressRequest> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressRequest> addresses) {
        this.addresses = addresses;
    }

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


}
