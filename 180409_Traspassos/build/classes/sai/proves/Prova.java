/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.proves;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import sai.computers.gestortraspas.GestioTraspasException;
import sai.persistence.matches.MatchOrder;
import sai.persistence.order.Orders;

/**
 *
 * @author PROGRAMACIO3
 */
public class Prova {
    public static void main(String[] args) {
        
        
        Map<String, String> persistenceMap = new HashMap<String, String>();

        persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://192.168.10.79:3306/prestashop_beta");
        persistenceMap.put("javax.persistence.jdbc.user", "admin");
        persistenceMap.put("javax.persistence.jdbc.password", "admin");
        
        
        try {
            
            EntityManagerFactory emfMySQL = Persistence.createEntityManagerFactory("UP-MySQL", persistenceMap);
            EntityManager emMySQL =  emfMySQL.createEntityManager();
            
            String ql = "select p from Orders p where p.idOrder not in (select mp.idPresta from MatchOrder mp)";
             
            Query q = emMySQL.createQuery(ql);
            
            List<Orders> oords = q.getResultList();
            for (Orders ord:oords) {
                System.out.println("ORDER: " + ord.getIdOrder() +" , " + ord.getReference() + " , " + ord.getTotalPaid().toString());
            }
            
            emMySQL.close();
            emfMySQL.close();
        }
        catch (Exception ex) {
            System.out.println("Exception " + ex);
           
        }
        
        
    }
}
