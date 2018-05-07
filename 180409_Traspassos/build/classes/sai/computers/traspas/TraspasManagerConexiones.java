/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.persistence.customer.Customer;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerConexiones {
    EntityManager emMySQL;

    public TraspasManagerConexiones(EntityManager emMySQL) {
        this.emMySQL = emMySQL;
    }
    
    public String getConexiones () {
        String result = "CLIENTES QUE HAN VISITADO LA TIENDA: \n\n";
        try {
            
            String qryok = "select count(c.idConnections), c.idGuest, max(c.dateAdd) from Connections c group by c.idGuest";
            Query q2 = emMySQL.createQuery(qryok);
            List<Object[]> llc = q2.getResultList();
            for (Object[] con: llc) {
                long numcon = (long) con[0];
                int idguest = (int) con[1];
                Date ultimaconexio = (Date) con[2];
                //buscar idcustomer
                int idcli = findCli(idguest);
                String nomCli = findNameCli(idcli);
                if (nomCli!= null) {
                    result += "- " + nomCli + ", " + numcon + " connexions (" + ultimaconexio + ")\n";
                }
                //buscar customer
            }
            
            return result;
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
        return "";
    }
    
    /**
     * Busca l'id del Client (customer) en la taula Guest
     * corresponent a l'id de guest que se li passa per paràmetre
     * @param idguest
     * @return 
     */
    private int findCli(long idguest) {
        try {
            String qry = "select distinct idCustomer from Guest where idGuest = " + idguest;
            Query q = emMySQL.createQuery(qry);
            int idcust = (int) q.getSingleResult();
            return idcust;
        }
        catch(Exception ex) {
            System.out.println(ex.getCause());
            return -1;
        }
    }

    private String findNameCli(int idcli) {
        try {
            Customer c = emMySQL.find(Customer.class,idcli);
            if (c!=null) {
                return c.getFirstName().trim() + " " + c.getLastName().trim();
            }
            else {
                return null;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getCause());
            return null;
        }
    }
}
