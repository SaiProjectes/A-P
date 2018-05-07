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
import sai.persistence.Category.Category;
import sai.persistence.Category.CategoryGroup;
import sai.persistence.Category.CategoryLang;
import sai.persistence.Category.CategoryShop;
import sai.persistence.Manufacturer;
import sai.persistence.ManufacturerLang;
import sai.persistence.ManufacturerShop;
import sai.persistence.product.Product;

/**
 *
 * @author Professor
 */
public class ProvaManufacturer {
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
             * insert into prestashop.ps_category
values (null,2,1,2,23,24,1,'2017-05-02','2017-05-02',0,0)
             */
            
            //Product p;
            //p = new Product (null,1,1,5,1,1,(short)0,(short)0,BigDecimal.valueOf(55.55));
            System.out.println("CATEGORIES ----------------------------------------------------------------------- ");
            Query q;
            q = em.createQuery("select p from Manufacturer p");
            List<Manufacturer> marques = q.getResultList();
            int max = -1;
            for (Manufacturer man:marques) {
                System.out.println(man);
                if (man.getId()>max) {
                    max  = man.getId();
                }
            }
            max += 1;
            Manufacturer m;
            //Product p = new Product(max);
            
            //crear categoria:
            
            //BASE de la categoria
            Date now = new Date();
            m = new Manufacturer(max,"MarcaNetbeans", now, now, (short)1);
            String nom = "MarcaNetbeans";
            String desc = "<p>JDKLKSFKSDJFKLSD sklldfklsfjklsdjf sdfkjdsklfjsdk</p>";
            
            em.getTransaction().begin();
            em.persist(m);
            //NOMS per idioma (4)
                            //values (12,1,1,'Hombre','<p>Men''s clothes jfklsdjflksjflsjdfkljs</p>','men','','','');
            for (int i=1; i<=4;i++) {
                ManufacturerLang ml = new ManufacturerLang (m.getId(),i,desc, nom, "", "", "");
                em.persist(ml);
            }
            
            //MANUFACTURER_SHOP
            ManufacturerShop ms = new ManufacturerShop(m.getId(),1);
            em.persist(ms);
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
