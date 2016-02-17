/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import java.io.Serializable;

/**
 *
 * @author yannick.thibos
 */
public enum Certificaat implements Serializable {
    
    
    PPL     ("Private Pilot License"),
    ATPL    ("Airline Transport Pilot License"),
    CPL     ("Commercial Pilot License"),
    EHBO    ("First Aid"),
    EVAC    ("Evacuation Procedures"),
    FIRE    ("Fire Fighting");
    
    private static final long serialVersionUID = 1L;
    
    private final String omschrijving;
    
    private Certificaat(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    
    public String getOmschrijving() {
        return this.omschrijving;
    }
}
