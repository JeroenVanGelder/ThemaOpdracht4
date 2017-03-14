/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.services;

import nl.hu.to4.groep1.domain.Bedrijf;
import nl.hu.to4.groep1.modelServices.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.ejb.Stateless;

/**
 *
 * @author Jeroen
 */
@Stateless
public class BedrijfService implements Service<Bedrijf, String> {
    
    @Override
    public void create(Bedrijf entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bedrijf find(String id) {
        Bedrijf bedrijf = null;
        String fileName = id + ".obj";
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            bedrijf = (Bedrijf)obj;
            ois.close();
        }
        catch(IOException io)
        {
            System.err.println("IOException");
        }
        catch(ClassNotFoundException fnfe)
        {
            System.err.println("ClassNotFoundException");
        }
        return bedrijf;
    }

    @Override
    public Bedrijf update(Bedrijf entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Bedrijf entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
