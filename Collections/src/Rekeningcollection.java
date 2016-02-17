
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yannick.thibos
 */
public class Rekeningcollection {

    public static void main(String[] args) throws RekeningException {

        Set<Rekening> setRek = new HashSet<Rekening>();

            ZichtRekening z1 = new ZichtRekening("001-1234567-11", 1000);
            z1.storten(100.80);
            ZichtRekening z2 = new ZichtRekening("001-1234567-22", 1000);
            z2.storten(200.80);
            SpaarRekening s1 = new SpaarRekening("833-1234567-88", 3.5);
            s1.storten(1500.0);
            SpaarRekening s2 = new SpaarRekening("833-1234567-99", 3.5);
            s2.storten(3000.0);

            setRek.add(z1);
            setRek.add(z2);
            setRek.add(s1);
            setRek.add(s2);

        double somSaldo = 0.0;

        for (Rekening rek : setRek) {
            somSaldo += rek.geefSaldo();
        }
        System.out.println("Totaal saldo: " + somSaldo);
        
        System.out.println("HashSet van Rekeningen:");
        print(setRek);
        
        List<Rekening> alRek = new ArrayList<Rekening>();
        alRek.add(z1);
        alRek.add(z2);
        alRek.add(s1);
        alRek.add(s2);
        
        System.out.println("ArrayList van Rekeningen:");
        print(alRek);
        
        Set<ZichtRekening> setZicht = new HashSet<ZichtRekening>();
        
        setZicht.add(z1);
        setZicht.add(z2);
        
        System.out.println("Set van ZichtRekeningen:");
        print(setZicht);
        
    }// einde main

    public static void print(Collection <?> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }
    
    public static void printRekening(Collection<? extends Rekening> bank) {
        for (Rekening rekening : bank) {
            System.out.println(rekening);
        }
    }
    
}
