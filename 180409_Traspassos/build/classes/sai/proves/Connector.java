/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.proves;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import sai.computers.gestortraspas.GestioTraspasException;
import sai.computers.gestortraspas.GestorTraspas;

/**
 *
 * @author PROGRAMACIO3
 */
public class Connector {
    public static void main(String[] args) {
        if (args.length==1) {
            if (args[0].toString().equals("1")) {
                //clients + provs
                System.out.println("clients + provs  ------");
            }
            if (args[0].toString().equals("2")) {
                //clients + provs
                System.out.println("MARCA + FAMILIA + ARTICLES -----");
            }
            if (args[0].toString().equals("3")) {
                //clients + provs
                System.out.println("MARCA + FAMILIA -------");
            }
            if (args[0].toString().equals("4")) {
                //clients + provs
                System.out.println("PEDIDOS ----- ");
            }
            if (args[0].toString().equals("5")) {
                //clients + provs
                System.out.println("TOTAL: ");
                traspas();
                
            }
            
        }
    }
    
    public static void traspas () {
        Properties prop = new Properties();
	InputStream input = null;
        boolean done = false;
	try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);
            String ip1 = prop.getProperty("sqlserverip");
            String db1= prop.getProperty("sqlserverdb");
            String usr1= prop.getProperty("sqlserverusr");
            String pwd1= prop.getProperty("sqlserverpwd");
            String ip2= prop.getProperty("mysqlip");
            String db2= prop.getProperty("mysqldb");
            String usr2= prop.getProperty("mysqlusr");
            String pwd2= prop.getProperty("mysqlpwd");
            String imgs= prop.getProperty("rutaimg");
            String venedor= prop.getProperty("vendedor");
            done = true;     
            GestorTraspas gt =null;
            try {
                gt = new GestorTraspas(1,ip2,db2,usr2,pwd2,ip1,db1,usr1,pwd1,imgs,false, true, "");
                if (gt!=null) {
                    gt.actualitzarMarques();
                    gt.actualitzarFamilies();
                    gt.actualitzarProveidors();
                    gt.actualitzarClients();
                    gt.actualitzarArticlesFiltrant("","","","","","","");
                    gt.actualitzarPedidos(venedor);
                    gt.close();
                }
            }
            catch(GestioTraspasException ex) {
                if (gt != null) {
                    try {
                        gt.close();
                    }
                    catch (Exception exs) {
                        System.out.println("EXCEPTION.......");
                    }
                }
            }
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
        
        
        
    }
}
