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
import sai.persistence.product.Attribute;
import sai.persistence.product.Condition;
import sai.persistence.product.Product;
import sai.persistence.product.ProductAttribute;
import sai.persistence.product.ProductAttributeCombination;
import sai.persistence.product.ProductAttributeShop;
import sai.persistence.product.ProductLang;
import sai.persistence.product.ProductShop;
import sai.persistence.product.ProductSupplier;
import sai.persistence.product.RedirectType;
import sai.persistence.product.Visibility;

/**
 *
 * @author Professor
 */
public class ProvaProduct {
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
            
            
            System.out.println("PRODUCTES -------------------------------- ");
            Query q;
            q = em.createQuery("select p from Product p");
            List<Product> products = q.getResultList();
            int max = -1;
            for (Product prod:products) {
                System.out.println(prod);
                if (prod.getIdProducte()>max) {
                    max  = prod.getIdProducte();
                }
            }
            max += 1;
            int shop =1;
            Product p;
            p = new Product(max,1,1,1,1,BigDecimal.valueOf(34.4),BigDecimal.valueOf(34.4),"ref13");
            System.out.println(p);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            
            //int idProduct, int idShop, int idLang, String description, String descriptionShort, 
            //String linkRewrite, String metaDescription, String metaKeywords, String metaTitle, 
            //String name, String availableNow, String availableLater) {
        
            //values (9,1,1,'<p>Descripcio art 9 de proves</p>', '<p>Descr art 9</p>','prova9',
		//	'','','','Prova 9','En stock', '');
            for (int i=1;i<5;i++) {
                ProductLang pl = new ProductLang(p.getIdProducte(),shop,i,"ProducteNETBEANS","prodNB", "prodNB","","","","Prod 14","En stock","");
                em.getTransaction().begin();
                em.persist(pl);
                em.getTransaction().commit();
            }
            //insert into prestashop.ps_attribute
            //values (26,3,'#964B00',14);
            Attribute at = new Attribute(28,4,"",0); //anar incrementant id atribut i pos (1 i 4)
            ProductAttribute pa = new ProductAttribute(49,p.getIdProducte(),"","","","","","",p.getPrice(),BigDecimal.ZERO, BigDecimal.ZERO,
            0,BigDecimal.ZERO,BigDecimal.ZERO,(short)0,1);
            ProductAttributeCombination pac = new ProductAttributeCombination(at.getIdAttribute(),pa.getIdProductAttribute());
            ProductAttributeShop pas = new ProductAttributeShop(p.getIdProducte(),pa.getIdProductAttribute(),
                    shop,p.getWholesalePrice(),p.getPrice(),BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO,
                    (short)0,1);
            
            em.getTransaction().begin();
                em.persist(at);
                em.persist(pa);
                em.persist(pac);
                em.persist(pas);
             em.getTransaction().commit();
             
            //insert into prestashop.ps_product_shop
    //values (9,1,10,1,0,0,0,1,12,3,'',0,0,0,0,0,1,'404',0,1,
		//'0000-00-00',0,'new',1,1,'both',46,0,now(),now(),3);
            ProductShop psh = new ProductShop (p.getIdProducte(), shop, p.getIdCategoryDefault(),p.getPrice(),p.getWholesalePrice());
            int supplier = 1;
            
            //(int idProductSupplier, int idProduct, int idProductAttribute, int idSupplier, 
            //String productSupplierReference, BigDecimal productSupplierPriceTe, int idCurrency) {
     //values (null,9,0,1,'',0,0);
            ProductSupplier psp = new ProductSupplier(19, p.getIdProducte(),pa.getIdProductAttribute(),supplier,
            "",BigDecimal.ZERO,0);
            em.getTransaction().begin();
                em.persist(psh);
                em.persist(psp);
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
