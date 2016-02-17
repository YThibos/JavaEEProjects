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
public enum Graad implements Serializable {
    
    Captain, SeniorFlightOfficer, SecondOfficer, JuniorFlightOfficer, Steward,
    Purser;
    
    private static final long serialVersionUID = 1L;
}
