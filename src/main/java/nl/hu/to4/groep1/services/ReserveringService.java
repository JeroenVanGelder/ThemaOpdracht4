/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.ejb.Stateless;
import nl.hu.to4.groep1.domain.Bedrijf;
import nl.hu.to4.groep1.domain.ParkeerReservering;

/**
 *
 * @author Nederlandhc
 */
@Stateless
public class ReserveringService implements Service<ParkeerReservering, String> {

    @Override
    public void create(ParkeerReservering entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParkeerReservering find(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       /* Bedrijf bedrijf = null;
        String fileName = "bedrijf.obj";
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            bedrijf = (Bedrijf)obj;
        }
        catch(IOException io){
            System.err.println("IOException");
        }
        catch(ClassNotFoundException fnfe){
            System.err.println("ClassNotFoundException");
        }
        return bedrijf;*/
    }

    @Override
    public ParkeerReservering update(ParkeerReservering entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ParkeerReservering entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
