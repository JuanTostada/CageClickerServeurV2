package rest;


import generated.World;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Services {
    
    World readWorldFromXml() {
        try {
            
        InputStream input = getClass().getClassLoader().getResourceAsStream("world.xml");
        JAXBContext cont = JAXBContext.newInstance(World.class);
        Unmarshaller u = cont.createUnmarshaller();
        World world = (World) u.unmarshal(input);
        return world;
        }
        
        catch (Exception e) {
           System.out.println(e.getMessage());
           return null;
       }      
    }
    
    void saveWorldToXml (World world) {
        
        try {   
        
        JAXBContext cont = JAXBContext.newInstance(World.class);
        Marshaller m = cont.createMarshaller();
        OutputStream output = new FileOutputStream("world.xml");
        m.marshal(world, output);
        }
        
        catch (Exception e) {
           System.out.println(e.getMessage());
       }    
    }
}
