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
import sai.persistence.ahora.Articulo;

/**
 *
 * @author Professor
 */
public class ProvaAfegir {
    public static void main(String[] args) {
        String up = "UP-SQLServer";
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            em = null;
            emf = null;
            System.out.println("Intent amb " + up);
            emf = Persistence.createEntityManagerFactory("UP-SQLServer");
            System.out.println("EntityManagerFactory creada");
            em = emf.createEntityManager();
            System.out.println("EntityManager creat");
            
            

            
            Query q;
            // CLIENTS --------------------------------------------------------
            q = em.createQuery("select p from Articulo p");
            List<Articulo> arts = q.getResultList();
            System.out.println("Clients de l'eurowin:");
            for (Articulo art:arts) {
                System.out.println(art);
            }
            
            
            
            
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
