/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.proves;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sai.persistence.product.Product;
import sai.persistence.Supplier;
import sai.persistence.SupplierLang;
import sai.persistence.SupplierShop;

/**
 *
 * @author Professor
 */
public class ProvaProveidor {
    public static void main(String[] args) {
        String up = "UP-MySQL";
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            em = null;
            emf = null;
            System.out.println("Intent amb " + up);
            emf = Persistence.createEntityManagerFactory("UP-MySQL");
            System.out.println("EntityManagerFactory creada");
            em = emf.createEntityManager();
            System.out.println("EntityManager creat");
            
            /**
             * 
             * insert into prestashop.ps_product
                        values (9,1,1,5,1,1,0,0,0,null,null, 0.0, 5,1,12,3,null,
			0, 0, 'Prova des sql',null, null, 0,0,0,0,2,0,0,0,0,1,
			'404',0,1,null,0,'new',1,0,'both', 0,0,0,0,now(), now(),0,3,1);
             */
            
            //Product p;
            //p = new Product (null,1,1,5,1,1,(short)0,(short)0,BigDecimal.valueOf(55.55));
            System.out.println("SUPPLIERS -------------------------------- ");
            Query q;
            q = em.createQuery("select p from Supplier p");
            List<Supplier> suppliers = q.getResultList();
            int max = -1;
            for (Supplier supp:suppliers) {
                System.out.println(supp);
                if (supp.getIdSupplier()>max) {
                    max  = supp.getIdSupplier();
                }
            }
            max += 1;
            
            
            em.getTransaction().begin();
            
            //1 - CREACIO SUPPLIER
            Supplier sp = new Supplier(max, "SupplierNetbeans",new Date(), new Date(), (short)1);
            
            em.persist(sp);
            for (int i=1 ; i<5 ; i++) {
                SupplierLang spl = new SupplierLang(sp.getIdSupplier(),i,"","","","");
                em.persist(spl);
            }
            
            SupplierShop sps = new SupplierShop(sp.getIdSupplier(),1);
            em.persist(sps);
            
            em.getTransaction().commit();
            
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
                System.out.println("EntityManager tancat");
            }
            if (emf != null) {
                emf.close();
                System.out.println("EntityManagerFactory tancada");
            }
        }
    }
    
}
