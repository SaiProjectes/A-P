/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.text.Normalizer;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.persistence.Category.Category;
import sai.persistence.Category.CategoryGroup;
import sai.persistence.Category.CategoryLang;
import sai.persistence.Category.CategoryShop;
import sai.persistence.ahora.Familia;
import sai.persistence.comprovacio.ConFamilias;
import sai.persistence.comprovacio.ConSubfamilias;
import sai.persistence.matches.MatchCategory;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerFamilies {
    EntityManager emSQLServer;
    EntityManager emMySQL;

    public TraspasManagerFamilies(EntityManager emSQLServer, EntityManager emMySQL) {
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
    }
    
    
    
    public void actualitzarFamilies (int shop, boolean comprovacions) {
        String up = "UP-SQLServer";
        Query q;
        
        try {
            //Recorregut sobre les marques, per cada una d'elles, creem
            //l'equivalen per a la BD de MySQL
            q = emSQLServer.createQuery("select p from Familia p");
            
            List<Familia> families = q.getResultList();
            //System.out.println("Families: \n\n");
            
            //canviar.....
            int i = 1;
            int ultim = 3;
            for (Familia fam:families) {
                
                /*MatchCategory mc = emMySQL.find(MatchCategory.class, fam.getCodigo().trim());
                if (mc == null) {
                    crearCategory(fam,shop,i,ultim);
                    emSQLServer.getTransaction().begin();
                    fam.setEstado(1);
                    emSQLServer.persist(fam);
                    emSQLServer.getTransaction().commit();
                    
                    emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConFamilias where codigo = '" + fam.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();
                }
                
                int sum = 3 + fam.getNumSubfamilies()*2;
                //ultim += sum;*/
                System.out.println(fam);
                
            }
            /*q = emSQLServer.createQuery("select p from Subfamilia p where TRIM(familia) = '' and p.estado=0");
            
            
            List<Subfamilia> subfamilies = q.getResultList();
            for (Subfamilia sfam:subfamilies) {
                
                MatchCategory mc = emMySQL.find(MatchCategory.class, sfam.getCodigo().trim());
                if (mc == null) {
                    crearCategory(sfam.getCodigo().trim(),sfam.getNombre().trim(),2,shop,1,1);
                    emSQLServer.getTransaction().begin();
                    sfam.setEstado(1);
                    emSQLServer.persist(sfam);
                    emSQLServer.getTransaction().commit();
                    
                    emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConSubfamilias where codigo = '" + sfam.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();
                }
            }
            
            
            if (comprovacions) {
                
                comprovarFamilies();
                
            }*/
            
            
            
            
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
     * D'unes dades en concret, crea un Manufacturer, amb les
     * files correponents que s'han de crear a les altres taules
     * relacionades amb MYSQL, Lang i Shop.
     * Finalment crea un registre a la taula que relaciona 
     * els codis (PK) de les maques en ambdós BDs
     */
    
    
    private int maxIdCategory () {
        try {
            Query q = emMySQL.createQuery("select max(p.id) from Category p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    private void crearCategory(Familia f, int shop, int position, int ultim) {
        /*try {
            Date now = new Date();
            int codi = maxIdCategory() +1;
            if (codi == -1  || codi == 0) {
                //No existeix encara cap marca, posem codi 1
                codi = 1;
            }
            //position -> 0
            Category c  = new Category(codi,2,(short)2,(short)1,0,(short)0);
            //c.setNleft(ultim+1);
            //c.setNright(ultim+3 + f.getNumSubfamilies()*2);
            //ultim = ultim+2;
            emMySQL.getTransaction().begin();
            emMySQL.persist(c);
            
            for (int i=1; i<=3;i++) {
                CategoryGroup cg = new CategoryGroup (c.getIdCategory(),i);
                emMySQL.persist(cg);
            }
            String nombre = f.getNombre().trim();
            String nombreNop = Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            String codigo = f.getCodigo().trim();
            for (int i=1; i<=4;i++) {
                CategoryLang cl = new CategoryLang (c.getIdCategory(),shop,i,nombre,nombre,nombreNop.replace(" ", "-"),"","","");
                emMySQL.persist(cl);
            }
//            position = maxPositionShop() + 1;
//            if (position == -1 || position == 0) {
//                position = 1;
//            }
            CategoryShop cs = new CategoryShop(c.getIdCategory(),shop,1);
            emMySQL.persist(cs);
            
            
            //Falta crear l'entrada match, emparellant les id's per la diferencia int -string
            MatchCategory match = new MatchCategory (codi, codigo,false);
            emMySQL.persist(match);
            emMySQL.getTransaction().commit();
            //crear subfamilies
            Iterator subf = f.getIteratorSubfamilies();
            int i = 0;
            while (subf.hasNext()){
                Subfamilia sf = (Subfamilia) subf.next();
                MatchCategory mc = emMySQL.find(MatchCategory.class, sf.getCodigo().trim());
                if (mc == null) {
                    crearCategory(sf.getCodigo(),sf.getNombre(),c.getIdCategory(),shop,i,ultim);
                    //ultim = ultim+2;
                    emSQLServer.getTransaction().begin();
                    sf.setEstado(1);
                    emSQLServer.persist(sf);
                    emSQLServer.getTransaction().commit();
                    
                    emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConSubfamilias where codigo = '" + sf.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();
                }
                i++;
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }*/
    }
    
    private void crearCategory(String codigo, String nombre, int parent, int shop, int position, int ultim) {
        /*try {
            Date now = new Date();
            int codi = maxIdCategory() +1;
            if (codi == -1  || codi == 0) {
                codi = 1;
            }
            Category c  = new Category(codi,parent,(short)3,(short)1,0,(short)0);
            emMySQL.getTransaction().begin();
            emMySQL.persist(c);
            
            for (int i=1; i<=3;i++) {
                CategoryGroup cg = new CategoryGroup (c.getIdCategory(),i);
                emMySQL.persist(cg);
            }
            nombre = nombre.trim();
            String nombreNop = Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            
            for (int i=1; i<=4;i++) {
                CategoryLang cl = new CategoryLang (c.getIdCategory(),shop,i,nombre,nombre,nombreNop.replace(" ", "-"),"","","");
                emMySQL.persist(cl);
            }
            //position = maxSub(parent) + 1;
            CategoryShop cs = new CategoryShop(c.getIdCategory(),shop,1);
            emMySQL.persist(cs);
            
            
            //Falta crear l'entrada match, emparellant les id's per la diferencia int -string
            MatchCategory match = new MatchCategory (codi, codigo,false);
            
            emMySQL.persist(match);
            emMySQL.getTransaction().commit();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    private void checkFam(Familia fam, MatchCategory mc) {
        /*//buscar nom familia
        String qry = "select p from CategoryLang p where p.idCategory = "+ mc.getIdPresta() + " and p.idLang = 1";
        Query q;
        q = emMySQL.createQuery(qry);
        CategoryLang cl = (CategoryLang) q.getSingleResult();
        
        //comprovacions amb prov.
        String nombre = fam.getNombre().trim();
        if (!nombre.equals(cl.getName())) {
            emMySQL.getTransaction().begin();
            String query = "update CategoryLang s\n" +
                                            " set s.description = '" + nombre+"'" +
                                            " , s.name = '" + nombre+"'" +
                                            " , s.linkRewrite = '" + nombre+"'" +
                                            " where s.idCategory = " + mc.getIdPresta();
            Query qm = emMySQL.createQuery(query);
            int res = qm.executeUpdate();
            //System.out.println("Updated CategoryLang: " + res);
            emMySQL.getTransaction().commit();
        }*/
    }

    private void comprovarFamilies() {
        /*String sdelete = "(";
        
        
        String query = "select p from ConFamilias p";
        Query qc = emSQLServer.createQuery(query);
        List<ConFamilias> conections = qc.getResultList();
        
        for (ConFamilias cfam:conections) {
            MatchCategory mp = emMySQL.find(MatchCategory.class, cfam.getCodigo().trim());
            if (mp!=null) {
                if (cfam.getAccio() == 2) {
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                if (cfam.getAccio() == 1) {
                    Familia fam = emSQLServer.find(Familia.class, cfam.getCodigo());
                    if (fam!= null) {
                        checkFam(fam,mp);
                    }
                    
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(cfam);
            emSQLServer.getTransaction().commit();
        }
        
        
        
        sdelete += ")";
        if (sdelete.length()>2) {
            String qryDel = "delete from MatchCategory where idPresta in " + sdelete;
            String qryDelCat = "delete from Category where idCategory  in " + sdelete;
            String qryDelCatGroup = "delete from CategoryGroup where idCategory in " + sdelete;
            String qryDelCatLang = "delete from CategoryLang where idCategory in " + sdelete;
            String qryDelCatShop = "delete from CategoryShop where idCategory in " + sdelete;

            emMySQL.getTransaction().begin();
            Query q1 = emMySQL.createQuery(qryDel);
            Query q2 = emMySQL.createQuery(qryDelCat);
            Query q3 = emMySQL.createQuery(qryDelCatGroup);
            Query q4 = emMySQL.createQuery(qryDelCatLang);
            Query q5 = emMySQL.createQuery(qryDelCatShop);
            int j = q1.executeUpdate();
            System.out.println("Deleted q1: " + j);
            j = q2.executeUpdate();
            System.out.println("Deleted q2: " + j);
            j = q3.executeUpdate();
            System.out.println("Deleted q3: " + j);
            j = q4.executeUpdate();
            System.out.println("Deleted q4: " + j);
            j = q5.executeUpdate();
            System.out.println("Deleted q5: " + j);
            emMySQL.getTransaction().commit();
        }
        
        
        sdelete = "(";
        
        
        query = "select p from ConSubfamilias p";
        qc = emSQLServer.createQuery(query);
        List<ConSubfamilias> conectionsf = qc.getResultList();
        
        for (ConSubfamilias cfam:conectionsf) {
            
            MatchCategory mp = emMySQL.find(MatchCategory.class, cfam.getCodigo().trim());
            if (mp!=null) {
                if (cfam.getAccio() == 2) {
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                if (cfam.getAccio() == 1) {
                    String qsubfam = "Select p from Subfamilia p where codigo = '" +cfam.getCodigo() +"' and familia = '"+ cfam.getFamilia()+ "'";
                    Query qrysfm = emSQLServer.createQuery(qsubfam);
                    Subfamilia fam = (Subfamilia)qrysfm.getSingleResult();
                    if (fam!= null) {
                        checkSubfam(fam,mp);
                    }
                    
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(cfam);
            emSQLServer.getTransaction().commit();
        }
        
        
        
        sdelete += ")";
        if (sdelete.length()>2) {
            String qryDel = "delete from MatchCategory where idPresta in " + sdelete;
            String qryDelCat = "delete from Category where idCategory  in " + sdelete;
            String qryDelCatGroup = "delete from CategoryGroup where idCategory in " + sdelete;
            String qryDelCatLang = "delete from CategoryLang where idCategory in " + sdelete;
            String qryDelCatShop = "delete from CategoryShop where idCategory in " + sdelete;

            emMySQL.getTransaction().begin();
            Query q1 = emMySQL.createQuery(qryDel);
            Query q2 = emMySQL.createQuery(qryDelCat);
            Query q3 = emMySQL.createQuery(qryDelCatGroup);
            Query q4 = emMySQL.createQuery(qryDelCatLang);
            Query q5 = emMySQL.createQuery(qryDelCatShop);
            int j = q1.executeUpdate();
            System.out.println("Deleted q1: " + j);
            j = q2.executeUpdate();
            System.out.println("Deleted q2: " + j);
            j = q3.executeUpdate();
            System.out.println("Deleted q3: " + j);
            j = q4.executeUpdate();
            System.out.println("Deleted q4: " + j);
            j = q5.executeUpdate();
            System.out.println("Deleted q5: " + j);
            emMySQL.getTransaction().commit();
        }*/
        
    }

    public List<Familia> getFamilies() {
        try {
            Query q = emSQLServer.createQuery("select p from Familia p");
            
            List<Familia> families = q.getResultList();
            return families;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int  creaCate(String f) {
        try {
        //primer buscar l'element familia a SQLSERVER
            Familia fm = emSQLServer.find(Familia.class, f);
            int idf = creaCatAhora(fm);
            return idf;
        }
        catch (Exception e) {
            return 2;
        }
    }

    private int creaCatAhora(Familia fm) {
        try {
            //comprovar si té pare
            String pare = fm.getIdFamiliaPadre();
            int idpadre = 2; // id 2 es quan penja de l'arrel.
            if (pare != null && pare.trim().length() > 0) {
                //si té pare, comprovar si s'ha creat
                MatchCategory mc = emMySQL.find(MatchCategory.class, pare.trim());
                if (mc == null) {
                    //si no s'ha creat el pare, crearlo
                    Familia fpare = emSQLServer.find(Familia.class, pare.trim());
                    if (fpare !=null) {
                        idpadre = creaCatAhora(fpare);
                    }
                }
                else {
                    idpadre = mc.getIdPresta();
                }

            }
            

            //crear familia amb idpadre
            Date now = new Date();
            int codi = maxIdCategory() +1;
            if (codi == -1  || codi == 0) {
                codi = 1;
            }
            Category c  = new Category(codi,idpadre,(short)3,(short)1,0,(short)0);
            emMySQL.getTransaction().begin();
            emMySQL.persist(c);
            
            for (int i=1; i<=3;i++) {
                CategoryGroup cg = new CategoryGroup (c.getIdCategory(),i);
                emMySQL.persist(cg);
            }
            String nombre = fm.getDescrip().trim();
            String nombreNop = Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            
            for (int i=1; i<=4;i++) {
                CategoryLang cl = new CategoryLang (c.getIdCategory(),1,i,nombre,nombre,nombreNop.replace(" ", "-"),"","","");
                emMySQL.persist(cl);
            }
            //position = maxSub(parent) + 1;
            CategoryShop cs = new CategoryShop(c.getIdCategory(),1,1);
            emMySQL.persist(cs);
            
            
            //Falta crear l'entrada match, emparellant les id's per la diferencia int -string
            MatchCategory match = new MatchCategory (codi, fm.getIdFamilia(),false);
            
            emMySQL.persist(match);
            emMySQL.getTransaction().commit();
            return codi;
            
            
        }
        catch(Exception e) {
            return 2;
        }
        
    }

    

}
