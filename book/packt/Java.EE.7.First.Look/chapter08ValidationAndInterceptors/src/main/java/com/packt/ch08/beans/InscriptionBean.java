/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.beans;

import com.packt.ch08.annotation.Case;
import com.packt.ch08.annotation.CaseType;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@ManagedBean
public class InscriptionBean {
    @Size(min=4, message="The full name must have "
            + " at least four characters!")
    private String name;
    @Past
    private Date birthday;
    @NotNull
    @Size(min=1, max=1,message="Enter only one character")
    @Case(type= CaseType.UPPER, message="This value must be uppercase")
    private String gender;
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", 
            message="Invalid phone format, should be as xxx-xxx-xxxx")
    @Size(max = 15)
    private String phone;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
            + "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", 
            message="Invalid email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }        
}
