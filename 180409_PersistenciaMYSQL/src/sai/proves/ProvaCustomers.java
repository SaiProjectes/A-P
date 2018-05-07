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
import sai.persistence.customer.Customer;
import sai.persistence.customer.CustomerGroup;
import sai.persistence.product.Product;

/**
 *
 * @author Professor
 */
public class ProvaCustomers {
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
            
            
            System.out.println("CATEGORIES ----------------------------------------------------------------------- ");
            Query q;
            q = em.createQuery("select p from Customer p");
            List<Customer> customers = q.getResultList();
            int max = -1;
            for (Customer cus:customers) {
                System.out.println(cus);
                if (cus.getIdCustomer()>max) {
                    max  = cus.getIdCustomer();
                }
            }
            max += 1;
            em.getTransaction().begin();
            Customer c;
            //public Customer(int idCustomer, int idShop, int idGender, String firstName,
            //String lastName, String email, String passwd) {
    
            c = new Customer(max,1,1,"Pepito","Netbeans","pepito@netbeans.com","passPepito");
            em.persist(c);
            CustomerGroup cg = new CustomerGroup(c.getIdCustomer(),4);
            em.persist(cg);
            em.getTransaction().commit();
            //Customer
            //Product p = new Product(max);
            
            //crear categoria:
            
            //BASE de la categoria
            
            
            
            
            
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
