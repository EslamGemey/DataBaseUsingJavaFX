/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

/**
 *
 * @author future
 */
public class Data {
    public String id;
    public String name;
    public String phon;
    public String email;
    public String address;
    public String jop;

    public Data() {
    }
    
    

    public Data(String id, String name, String phon, String email, String address, String jop) {
        this.id = id;
        this.name = name;
        this.phon = phon;
        this.email = email;
        this.address = address;
        this.jop = jop;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhon(String phon) {
        this.phon = phon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhon() {
        return phon;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getJop() {
        return jop;
    }

    
}
