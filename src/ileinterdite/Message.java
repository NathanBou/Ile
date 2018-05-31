/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterdite;

/**
 *
 * @author bouviern
 */
public class Message {
    TypesMessage type;
    
    public Message(TypesMessage type) {
        this.type = type;

    }

    public TypesMessage getType() {
        return type;
    }

    public void setType(TypesMessage type) {
        this.type = type;
    }
     
}
