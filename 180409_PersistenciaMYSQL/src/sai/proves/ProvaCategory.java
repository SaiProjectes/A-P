/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.proves;

import java.math.BigDecimal;
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
import sai.persistence.product.Product;

/**
 *
 * @author Professor
 */
public class ProvaCategory {
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
            q = em.createQuery("select p from Category p");
            List<Category> categories = q.getResultList();
            int max = -1;
            for (Category cat:categories) {
                System.out.println(cat);
                if (cat.getIdCategory()>max) {
                    max  = cat.getIdCategory();
                }
            }
            max += 1;
            Category c;
            //Product p = new Product(max);
            
            //crear categoria:
            
            //BASE de la categoria
            c = new Category (max,2,(short)2,(short)1,0,(short)0);
            String nom = "Categoria Netbeans";
            String desc = "<p>JDKLKSFKSDJFKLSD sklldfklsfjklsdjf sdfkjdsklfjsdk</p>";
            
            em.getTransaction().begin();
            em.persist(c);
            //NOMS per idioma (4)
                            //values (12,1,1,'Hombre','<p>Men''s clothes jfklsdjflksjflsjdfkljs</p>','men','','','');
            for (int i=1; i<=4;i++) {
                CategoryLang cl1 = new CategoryLang (c.getIdCategory(),1,i,nom, desc,nom, "", "", "");
                em.persist(cl1);
            }
            //CATEGORY_GROUP (3)
            for (int i=1; i<4;i++) {
                CategoryGroup cg = new CategoryGroup (c.getIdCategory(),i);
                em.persist(cg);
            }
            
            //CATEGORY_SHOP
            CategoryShop cs = new CategoryShop(c.getIdCategory(),1,0);
            em.persist(cs);
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
