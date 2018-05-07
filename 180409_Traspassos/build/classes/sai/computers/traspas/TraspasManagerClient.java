/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.persistence.ahora.Cliente;
import sai.persistence.Supplier;
import sai.persistence.comprovacio.ConClientes;
import sai.persistence.customer.Customer;
import sai.persistence.customer.CustomerGroup;
import sai.persistence.matches.MatchCustomer;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerClient {
    EntityManager emSQLServer;
    EntityManager emMySQL;

    public TraspasManagerClient(EntityManager emSQLServer, EntityManager emMySQL) {
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
    }
    
    public void actualitzarClients(int shop, boolean comprovacions) {
    }
    
    public void actualitzarClients(int shop, boolean comprovacions, String coddesde, String codhasta) {
        
        try {
            //Recorregut sobre els clients
            //l'equivalent per a la BD de MySQL
            String sql = "select p from Client p where p.estado = 0";
            
            //aplicació de filtres a client: codi
            String where = "";
            /*if (coddesde.trim().length()>0) {
                where += " and p.codigo >= :codi1";
            }
            if (codhasta.trim().length()>0) {
                where += " and p.codigo<= :codi2";
            }*/
            sql = sql + where;
            Query q;
            q = emSQLServer.createQuery(sql);
            /*if (coddesde.trim().length()>0) {
                q.setParameter("codi1", coddesde.trim()+"%");
            }
            if (codhasta.trim().length()>0) {
                q.setParameter("codi2", codhasta.trim()+"%");
            }*/
            List<Cliente> clients = q.getResultList();
            for (Cliente cli:clients) {
                
                /*MatchCustomer mc = emMySQL.find(MatchCustomer.class,cli.getCodigo());
                if (mc==null) {
                    emSQLServer.getTransaction().begin();
                    crearClient(cli.getCodigo().trim(), cli.getNombre().trim(), cli.getNombre2().trim(),cli.getEmail(),shop);
                    cli.setEstado(1);
                    emSQLServer.persist(cli);
                    emSQLServer.getTransaction().commit();
                    emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConClientes where codigo = '" + cli.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();
                }*/
                System.out.println(cli);
                
            }
            if (comprovacions) {
                //comprovarClients();
            }
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
    }
    
    /**
     * 
     * @param codigo
     * @param nombre
     * @param shop 
     * D'unes dades en concret, crea un Client, amb les
     * files correponents que s'han de crear a les altres taules
     * relacionades amb MYSQL, CustomerGroup.
     * Finalment crea un registre a la taula que relaciona 
     * els codis (PK) dels clients en ambdós BDs
     */
    private void crearClient(String codigo, String nombre,String nombre2,String email, int shop) {
        try {
            Date now = new Date();
            int codi = maxIdClient() +1;
            if (codi == -1  || codi == 0) {
                //No existeix encara cap client, posem codi 1
                codi = 1;
            }
            //(int idCustomer, int idShop, int idGender, String firstName,String lastName,
            //String email, String passwd) {
            email = email.trim();
            if (email == null || email.equals("")) {
                email = Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                
                email = email.replace(".", "");
                email = email.replace(",", "");
                email = email.replace(" ", "");
                email += "@email.com";
                email = email.toLowerCase();
            }
            String pwdEncrypted = "$2y$10$4joX0cvw/iMirgoi7Q1HhutB3ISsuLP4Xc9jEE27QsaRXtdO0ncPe";
            Customer cs = new Customer(codi, shop, 1,nombre, nombre2,email,pwdEncrypted);
            emMySQL.getTransaction().begin();
            emMySQL.persist(cs);
            CustomerGroup csg = new CustomerGroup(cs.getIdCustomer(),3);
            emMySQL.persist(csg);
            emMySQL.getTransaction().commit();
            //Falta crear l'entrada match, emparellant les id's per la diferencia int -string
            MatchCustomer match = new MatchCustomer (codi, codigo);
            emMySQL.getTransaction().begin();
            emMySQL.persist(match);
            emMySQL.getTransaction().commit();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Busca l'Id següent que tocaria a MYSQL
     * @return 
     */
    private int maxIdClient () {
        try {
            Query q = emMySQL.createQuery("select max(p.idCustomer) from Customer p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
   
    private void checkClient(Cliente cli, MatchCustomer mc) {
        /*Customer cs = emMySQL.find(Customer.class, mc.getIdPresta());
        String nombre = cli.getNombre().trim();
        if (!nombre.equals(cs.getFirstName())) {
            emMySQL.getTransaction().begin();
            cs.setFirstName(nombre);
            emMySQL.persist(cs);
            emMySQL.getTransaction().commit();
        }*/
    }

    private void comprovarClients() {
        String sdelete = "(";
        
        String query = "select p from ConClientes p";
        Query qc = emSQLServer.createQuery(query);
        List<ConClientes> conections = qc.getResultList();
        
        for (ConClientes ccli:conections) {
            MatchCustomer mp = emMySQL.find(MatchCustomer.class, ccli.getCodigo().trim());
            if (mp!=null) {
                if (ccli.getAccio() == 2) {
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                if (ccli.getAccio() == 1) {
                    Cliente cli = emSQLServer.find(Cliente.class, ccli.getCodigo());
                    if (cli!= null) {
                        checkClient(cli,mp);
                    }
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(ccli);
            emSQLServer.getTransaction().commit();
        }
        
        sdelete += ")";
        
        if (sdelete.length()>2) {
            String qryDel = "delete from MatchCustomer where idPresta in " + sdelete;
            String qryDelCustomer = "delete from Customer where idCustomer in " + sdelete;
            String qryDelCustomerGroup = "delete from CustomerGroup where idCustomer in " + sdelete;
            String qryDelSpecific = "delete from SpecificPrice where idCustomer in " + sdelete;
            //delete specificprice
            emMySQL.getTransaction().begin();
            Query q1 = emMySQL.createQuery(qryDel);
            Query q2 = emMySQL.createQuery(qryDelCustomer);
            Query q3 = emMySQL.createQuery(qryDelCustomerGroup);
            Query q4 = emMySQL.createQuery(qryDelSpecific);
            int i = q1.executeUpdate();
            System.out.println("Deleted q1: " + i);
            i = q2.executeUpdate();
            System.out.println("Deleted q2: " + i);
            i = q3.executeUpdate();
            System.out.println("Deleted q3: " + i);
            i = q4.executeUpdate();
            System.out.println("Deleted q4: " + i);
            emMySQL.getTransaction().commit();
        }
        
    }
    
}
