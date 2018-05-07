/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.proves;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import sai.persistence.product.Image;
import sai.persistence.product.ImageLang;
import sai.persistence.product.ImageShop;

/**
 *
 * @author PROGRAMACIO3
 */
public class CopiaImg {
    public static void main(String[] args) {
        
        for (int i=1; i<148649 ; i++) {
            
            try {
                String desti = "C:\\Users\\PROGRAMACIO3\\Desktop\\p";
            
                String num = ""+i;
                for(int j = 0; j<num.length();j++) {
                    desti+= "\\" + num.charAt(j);
                }
                String destiImg = desti + "\\" + i + ".jpg";
                //desti += p.getIdProducte() + ".jpg";

                String ruta = "C:\\Ester\\PersistencePrestaShop\\producte.png";
                File file = new File(ruta);
                File destinationDir = new File(destiImg);
                //utilitzant Apache IOCommons
                FileUtils.copyFile(file, destinationDir);
                
                file = new File("C:\\Users\\PROGRAMACIO3\\Desktop\\p\\index.php");
                destinationDir = new File(desti);
                //utilitzant Apache IOCommons
                FileUtils.copyFileToDirectory(file, destinationDir);

                file = new File("C:\\Users\\PROGRAMACIO3\\Desktop\\p\\fileType");

                destinationDir = new File(desti);
                //utilitzant Apache IOCommons
                FileUtils.copyFileToDirectory(file, destinationDir);

                
                
            } catch (IOException ex) {
                Logger.getLogger(CopiaImg.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
            
        }
        
    }
}
