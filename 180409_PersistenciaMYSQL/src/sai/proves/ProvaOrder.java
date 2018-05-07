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
import sai.persistence.order.OrderDetail;
import sai.persistence.order.Orders;

/**
 *
 * @author Professor
 */
public class ProvaOrder {
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
            q = em.createQuery("select p from Orders p");
            List<Orders> orders = q.getResultList();
            int max = -1;
            for (Orders ord:orders) {
                System.out.println(ord);
                if (ord.getIdOrder()>max) {
                    max  = ord.getIdOrder();
                }
                
                Query qd;
                qd = em.createQuery("select p from OrderDetail p where idOrder=" + ord.getIdOrder());
                List<OrderDetail> orderd = qd.getResultList();
                for (OrderDetail od: orderd) {
                    System.out.println("\t" + od);
                }
                
            }
            max += 1;
            
            
            em.getTransaction().begin();
            
            //1 - CREACIO SUPPLIER
            Orders o = new Orders(max,"ORD001",2,1,1,4,"payment");
            
            em.persist(o);
            
//            for (int i=1 ; i<5 ; i++) {
//                SupplierLang spl = new SupplierLang(sp.getIdSupplier(),i,"","","","");
//                em.persist(spl);
//            }
//            
//            SupplierShop sps = new SupplierShop(sp.getIdSupplier(),1);
//            em.persist(sps);
            OrderDetail od = new OrderDetail(16,o.getIdOrder(),1,1,5,"prod",BigDecimal.ZERO,"",BigDecimal.valueOf(12.0),"refprod",2,BigDecimal.valueOf(24.0),BigDecimal.valueOf(24.0));
            OrderDetail od2 = new OrderDetail(17,o.getIdOrder(),1,1,6,"prod",BigDecimal.ZERO,"",BigDecimal.valueOf(20.0),"refprod2",2,BigDecimal.valueOf(40.0),BigDecimal.valueOf(40.0));
            em.persist(od);
            em.persist(od2);
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
