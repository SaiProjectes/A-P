/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.persistence.ahora.Proveedor;
import sai.persistence.Supplier;
import sai.persistence.SupplierLang;
import sai.persistence.SupplierShop;
import sai.persistence.comprovacio.ConProveedores;
import sai.persistence.matches.MatchSupplier;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerProveedores {
    EntityManager emSQLServer;
    EntityManager emMySQL;

    public TraspasManagerProveedores(EntityManager emSQLServer, EntityManager emMySQL) {
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
    }

    /*
    Mètode que actualitza els proveïdors, si es vol comprovar canvis en ells, ho canvia en MYSQL
    Si el proveïdor encara no existeix, el crea.
    */
    public void actualitzarProveedores (int shop, boolean comprovacions) {
        
        try {
            //Recorregut sobre proveidors
            Query q;
            q = emSQLServer.createQuery("select p from Proveedor p where");
            
            List<Proveedor> provs = q.getResultList();
            for (Proveedor prov:provs) {
                /*//Comprovem en la nostra taula "log" on hi consten els id's d'eurowin ja traspassats
                MatchSupplier mc = emMySQL.find(MatchSupplier.class, prov.getCodigo().trim());
                //Si encara no existeix, es un proveidor no traspassat, per tant, se'n crea un
                if (mc == null) {
                    crearProveedor(prov.getCodigo().trim(), prov.getNombre().trim(),shop);
                    emSQLServer.getTransaction().begin();
                    prov.setEstado(1);
                    emSQLServer.persist(prov);
                    emSQLServer.getTransaction().commit();
                    
                    emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConProveedores where codigo = '" + prov.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();
                }*/
                
                System.out.println(prov);
                
            }
            if (comprovacions) {
                
                //comprovarProveidors();
                
                
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
     * D'unes dades en concret, crea un Supplier, amb les
     * files correponents que s'han de crear a les altres taules
     * relacionades amb MYSQL, Lang i Shop.
     * Finalment crea un registre a la taula que relaciona 
     * els codis (PK) de proveidors en ambdós BDs
     */
    private void crearProveedor(String codigo, String nombre, int shop) {
        try {
            Date now = new Date();
            int codi = maxIdSupplier() +1;
            //Si ens torna -1 (que +1 és 0), serà primer proveïdor, per tant ha de ser id 1
            if (codi == -1  || codi == 0) {
                codi = 1;
            }
            Supplier sup = new Supplier(codi,nombre, now, now, (short)1);
            emMySQL.getTransaction().begin();
            emMySQL.persist(sup);
            for (int i=1; i<=4;i++) {
                SupplierLang sl = new SupplierLang (sup.getIdSupplier(),i,"", "", "", "");
                emMySQL.persist(sl);
            }
            SupplierShop ss = new SupplierShop(sup.getIdSupplier(),shop);
            emMySQL.persist(ss);
            
            //Gravem aquest proveïdor nou en la taula de registres ja traspassats
            //amb l'emparellament de l'id d'eurowin i l'id de prestashop, ja que 
            //són de tipus diferents (STRING VS INT)
            MatchSupplier match = new MatchSupplier (codigo,sup.getIdSupplier());
            emMySQL.persist(match);
            emMySQL.getTransaction().commit();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    Busca l'últim id de proveïdor numèric del prestashop.
    Si no n'existeix cap retorna -1.
    */
    private int maxIdSupplier () {
        try {
            Query q = emMySQL.createQuery("select max(p.idSupplier) from Supplier p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    
    /*
    Busca les dues referències necessàries de les dues bandes
    PROVEEDOR - SUPPLIER
    Comprova si els camps comuns es mantenen igual, si no és
    així, fa els canvis pertinents a les taules que s'escauen.
    */
    private void checkProv(Proveedor prov, MatchSupplier mc) {
        
        /*//buscar supplier
        Supplier sup = emMySQL.find(Supplier.class, mc.getIdPresta());
        //comprovacions amb prov.
        String nombre = prov.getNombre().trim();
        if (!nombre.equals(sup.getName())) {
            emMySQL.getTransaction().begin();
            sup.setName(nombre);
            //1 al 4 
            emMySQL.persist(sup);
            String query = "update SupplierLang s\n" +
                                            " set s.description = '" + nombre+"'" +
                                            " where s.idSupplier = " + mc.getIdPresta();
            Query q = emMySQL.createQuery(query);
            int res = q.executeUpdate();
            System.out.println("Updated SupplierLang: " + res);
            emMySQL.getTransaction().commit();
        }*/
        
    }

    private void comprovarProveidors() {
        String sdelete = "(";
        
        
        String query = "select p from ConProveedores p";
        Query qc = emSQLServer.createQuery(query);
        List<ConProveedores> conections = qc.getResultList();
        
        for (ConProveedores cprov:conections) {
            MatchSupplier mp = emMySQL.find(MatchSupplier.class, cprov.getCodigo().trim());
            if (mp!=null) {
                if (cprov.getAccio() == 2) {
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                if (cprov.getAccio() == 1) {
                    Proveedor prov = emSQLServer.find(Proveedor.class, cprov.getCodigo());
                    if (prov!= null) {
                        checkProv(prov,mp);
                    }
                    
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(cprov);
            emSQLServer.getTransaction().commit();
        }
        
        
        /*
        Realitzem unes sentències senzilles amb l'string que hem creat en el bucle
        previ, i executem les deletes en les taules necessàries per tal d'eliminar totalment
        el proveïdor de MYSQL
        */
        sdelete += ")";
        if (sdelete.length()>2) {
            String qryDel = "delete from MatchSupplier where idPresta in " + sdelete;
            String qryDelMan = "delete from Supplier where idSupplier in " + sdelete;
            String qryDelManLang = "delete from SupplierLang where idSupplier in " + sdelete;
            emMySQL.getTransaction().begin();
            Query q1 = emMySQL.createQuery(qryDel);
            Query q2 = emMySQL.createQuery(qryDelMan);
            Query q3 = emMySQL.createQuery(qryDelManLang);
            int i = q1.executeUpdate();
            System.out.println("Deleted q1: " + i);
            i = q2.executeUpdate();
            System.out.println("Deleted q2: " + i);
            i = q3.executeUpdate();
            System.out.println("Deleted q3: " + i);
            emMySQL.getTransaction().commit();
        }
        
    }
    
}
