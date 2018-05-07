/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.persistence.Manufacturer;
import sai.persistence.ManufacturerLang;
import sai.persistence.ManufacturerShop;
import sai.persistence.ahora.Marca;
import sai.persistence.comprovacio.ConMarcas;
import sai.persistence.matches.MatchManufacturer;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerMarcas {
    EntityManager emSQLServer;
    EntityManager emMySQL;

    public TraspasManagerMarcas(EntityManager emSQLServer, EntityManager emMySQL) {
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
    }
    
    
    public void actualitzarMarques (int shop, boolean comprovacions) {
        
        try {
            //Recorregut sobre les marques, per cada una d'elles, creem
            //l'equivalen per a la BD de MySQL
            Query q;
            q = emSQLServer.createQuery("select p from Marca p");
            
            List<Marca> marcas = q.getResultList();
            for (Marca marca:marcas) {
                //comprovar l'existencia a MYSQL
                MatchManufacturer mc = emMySQL.find(MatchManufacturer.class, marca.getIdMarca()+"");
                if (mc == null) {
                    crearMarca(marca.getIdMarca(), marca.getDescrip().trim(),shop);
                    //marcar com a traspassada
                    
                    
                    //eliminar del trigger els canvis.
                    /*emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConMarcas where codigo = " + marca.getIdMarca()+"";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();*/
                }
            }
            if (comprovacions) {
                comprovarMarques();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
    }
    
    
    public void actualitzarMarques (int shop, boolean comprovacions, String codDesde, String codHasta, String nomDesde, String nomHasta) {
        
        try {
            //Recorregut sobre les marques, per cada una d'elles, creem
            //l'equivalen per a la BD de MySQL
            String sql = "select p from Marca p where p.estado = 0";
            String where = "";
            /*if (codDesde.trim().length()>0) {
                where += " and  p.codigo >= :codi1";
            }
            if (codHasta.trim().length()>0) {
                where += " and p.codigo <= :codi2";
            }
            if (nomDesde.trim().length()>0) {
                where += " and p.nombre >= :nom1";
            }
            if (nomHasta.trim().length()>0) {
                where += " and p.nombre <= :nom2";
            }
            Query q;
            q = emSQLServer.createQuery(sql + where);
            
            if (codDesde.trim().length()>0) {
                q.setParameter("codi1", codDesde.trim());
            }
            if (codHasta.trim().length()>0) {
                q.setParameter("codi2", codHasta.trim());
            }
            if (nomDesde.trim().length()>0) {
                q.setParameter("nom1", nomDesde.trim());
            }
            if (nomHasta.trim().length()>0) {
                q.setParameter("nom2", nomHasta.trim());
            }*/
            Query q;
            q = emSQLServer.createQuery(sql + where);
            List<Marca> marcas = q.getResultList();
            for (Marca marca:marcas) {
                //comprovar l'existencia a MYSQL
                /*MatchManufacturer mc = emMySQL.find(MatchManufacturer.class, marca.getCodigo().trim());
                if (mc == null) {
                    crearMarca(marca.getCodigo().trim(), marca.getNombre().trim(),shop);
                    emSQLServer.getTransaction().begin();
                    marca.setEstado(1);
                    emSQLServer.persist(marca);
                    emSQLServer.getTransaction().commit();
                    
                    emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConMarcas where codigo = '" + marca.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();
                }*/
                
                System.out.println(marca);
                
                
            }
            if (comprovacions) {
                //comprovarMarques();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
    }
    
    
    private int crearMarca(int codigo, String nombre, int shop) {
        try {
            Date now = new Date();
            int codi = maxIdMarca() +1;
            if (codi == -1  || codi == 0) {
                //No existeix encara cap marca, posem codi 1
                codi = 1;
            }
            Manufacturer m = new Manufacturer(codi,nombre, now, now, (short)shop);
            //emMySQL.getTransaction().begin();
            emMySQL.persist(m);
            for (int i=1; i<=4;i++) {
                ManufacturerLang ml = new ManufacturerLang (m.getId(),i,"<p>"+nombre+"</p>", nombre, "", "", "");
                emMySQL.persist(ml);
            }
            ManufacturerShop ms = new ManufacturerShop(m.getId(),shop);
            emMySQL.persist(ms);
            
            //Falta crear l'entrada match, emparellant les id's per la diferencia int -string
            MatchManufacturer match = new MatchManufacturer (codi, codigo);
            emMySQL.persist(match);
            return codi;
            //emMySQL.getTransaction().commit();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    private int maxIdMarca () {
        try {
            Query q = emMySQL.createQuery("select max(p.id) from Manufacturer p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    private int addMarca(Marca m, int shop) {
        try {
            return crearMarca(m.getIdMarca(),m.getDescrip().trim(),shop);
        }
        catch(Exception ex) {
            return -1;
        }
    }
    
    public int newMarca(int id, int shop){
        try {
            Marca m = emSQLServer.find(Marca.class, id);
            return addMarca(m,shop);
        }
        catch(Exception ex) {
            return -1;
        }
    }

    private void checkMarca(Marca marca, MatchManufacturer mc) {
        //buscar supplier
        Manufacturer man = emMySQL.find(Manufacturer.class, mc.getIdPresta());
        
        //comprovacions amb prov.
        /*String nombre = marca.getNombre().trim();
        if (!nombre.equals(man.getName())) {
            emMySQL.getTransaction().begin();
            man.setName(nombre);
            //1 al 4 
            emMySQL.persist(man);
            String query = "update ManufacturerLang s\n" +
                                            " set s.description = '<p>" + nombre+"</p>'" +
                                            " , s.shortDescription = '" + nombre+"'" +
                                            " where s.idManufacturer = " + mc.getIdPresta();
            Query q = emMySQL.createQuery(query);
            int res = q.executeUpdate();
            System.out.println("Updated ManufacturerLang: " + res);
            emMySQL.getTransaction().commit();
        }*/
    }

    private void comprovarMarques() {
        /*String sdelete = "(";
        String query = "select p from ConMarcas p";
        Query qc = emSQLServer.createQuery(query);
        List<ConMarcas> conections = qc.getResultList();
        
        for (ConMarcas cmarca:conections) {
            MatchManufacturer mp = emMySQL.find(MatchManufacturer.class, cmarca.getCodigo().trim());
            if (mp!=null) {
                if (cmarca.getAccio() == 2) {
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                if (cmarca.getAccio() == 1) {
                    Marca marca = emSQLServer.find(Marca.class, cmarca.getCodigo());
                    if (marca!= null) {
                        checkMarca(marca,mp);
                    }
                    
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(cmarca);
            emSQLServer.getTransaction().commit();
        }
        
        sdelete += ")";
        
        if (sdelete.length()>2) {
            String qryDel = "delete from MatchManufacturer where idPresta in " + sdelete;
            String qryDelMan = "delete from Manufacturer where id in " + sdelete;
            String qryDelManLang = "delete from ManufacturerLang where idManufacturer in " + sdelete;
            String qryDelManShop = "delete from ManufacturerShop where idManufacturer in " + sdelete;

            emMySQL.getTransaction().begin();

            Query q1 = emMySQL.createQuery(qryDel);
            Query q2 = emMySQL.createQuery(qryDelMan);
            Query q3 = emMySQL.createQuery(qryDelManLang);
            Query q4 = emMySQL.createQuery(qryDelManShop);
            int i = q1.executeUpdate();
            System.out.println("Deleted q1: " + i);
            i = q2.executeUpdate();
            System.out.println("Deleted q2: " + i);
            i = q3.executeUpdate();
            System.out.println("Deleted q3: " + i);
            i = q4.executeUpdate();
            System.out.println("Deleted q4: " + i);

            emMySQL.getTransaction().commit();
        }*/
        
    }
    
}
