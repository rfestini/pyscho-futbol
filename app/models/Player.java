/*
 * Copyright (c) 2012 Zauber S.A.  -- All rights reserved
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import play.db.jpa.Model;
import play.libs.Crypto;

/**
 * Jugador
 * 
 * 
 * @author Juan Edi
 * @since Feb 18, 2012
 */
@Entity
@Table(name = "players")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Player extends Model {

    public String username;
    public String password;
    public String firstName;
    public String lastName;
    
    public String getPassword() {
        return Crypto.decryptAES(this.password);
    }
    
    public void setPassword(final String password) {
        this.password = Crypto.encryptAES(password);
    }

}
