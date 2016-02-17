/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastenboek;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public class Gastenboek implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<GastenboekEntry> entries;

    public Gastenboek() {
        entries = new ArrayList<>();
    }
        
    public void addEntry(GastenboekEntry entry) {
        entries.add(entry);
    }
    
    public List getEntries() {
        return entries;
    }

}
