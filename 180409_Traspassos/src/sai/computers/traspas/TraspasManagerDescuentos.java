/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import sai.persistence.ahora.Cliente;
import sai.persistence.comprovacio.ConClientes;
import sai.persistence.comprovacio.ConDescuen;
import sai.persistence.comprovacio.ConLinDesc;
import sai.persistence.customer.Customer;
import sai.persistence.customer.CustomerGroup;
import sai.persistence.descomptes.SpecificPrice;
import sai.persistence.descomptes.SpecificPriceRule;
import sai.persistence.descomptes.SpecificPriceRuleCondition;
import sai.persistence.descomptes.SpecificPriceRuleConditionGroup;
import sai.persistence.group.Group;
import sai.persistence.group.GroupLang;
import sai.persistence.group.GroupShop;
import sai.persistence.matches.MatchCategory;
import sai.persistence.matches.MatchCustomer;
import sai.persistence.matches.MatchGroupLinDesc;
import sai.persistence.matches.MatchManufacturer;
import sai.persistence.matches.MatchProduct;
import sai.persistence.matches.MatchSpecificPriceDescuen;
import sai.persistence.matches.MatchSpecificPriceLinDesc;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerDescuentos {
    EntityManager emSQLServer;
    EntityManager emMySQL;

    public TraspasManagerDescuentos(EntityManager emSQLServer, EntityManager emMySQL) {
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
    }
    //mal mal
    public void actualitzarDtos(int shop, boolean comprovacions) {
        /*
        try {
            //Recorregut sobre els clients
            //l'equivalent per a la BD de MySQL
            Query q;
            String query = "select p.linDes ,p.codigo from Client p where p.estado=1 and p.linDes not like ''";
            q = emSQLServer.createQuery("select p from Client p where p.estado = 0");
            
            List<Object[]> list = emSQLServer.createQuery("SELECT p.linDes, p.codigo FROM Client p where p.estado=1 and p.linDes not like '' order by p.linDes").getResultList();
            
            Date from = null;
            Date until = null;
            
            int ids[] = new int[100];
            int qt = 0;
            String idsCli = "(";
            String ultimdes ="";
            for (Object[] obj : list){
                try {
                    String des = obj[0].toString();
                    String codigo = obj[1].toString();
                    if (des.equals(ultimdes) ) {
                        //no fem res (?)
                    }
                    else {
                        //Crear grup amb tots els ids de clients
                        //agafar cada detall i crear specific group
                        if (qt>0) {
                            int idgrup;
                            idgrup = crearGrup(ids, qt, des);
                            crearRole(idgrup, ultimdes,ids, qt);
                        }
                        ultimdes = des;
                        qt=0;
                    }
                    int idcli = findCli(codigo);
                    if (idcli>0) {
                        ids[qt] = idcli;
                        qt++;
                    }
                }
                catch(Exception exc) {
                    System.out.println(exc.getMessage());
                }
            }
            //Crear grup amb tots els ids de clients
            //agafar cada detall i crear specific group
            if (qt>=1) {
                int idgrup;
                idgrup = crearGrup(ids,qt, ultimdes);
                crearRole(idgrup, ultimdes, ids, qt);
                
            }
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
        
        */
    }
    
    
    public void actualitzarDescuentos(int shop, boolean comprovacions) {
        /*try {
            actualitzarLinDesc(shop);
            actualitzarDescuen(shop);
            if (comprovacions) {
                //comprovarClients-LinDesc
                
                comprovarDescomptes();
                comprovarLinDesc();
                comprovarClients();
                
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }*/
    }
    
    public void actualitzarDtosOk(int shop, boolean comprovacions) {
        /*try {
            List<Object[]> list = emSQLServer.createQuery("SELECT p.linDes, p.codigo FROM Client p where p.estado=1 and p.linDes not like '' and p.linDes in (select ln.codigo from Lineas ln where ln.estado = 0) order by p.linDes").getResultList();
            
            int ids[] = new int[100];
            int qt = 0;
            String ultimdes ="";
            
            for (Object[] obj : list){
                try {
                    String des = obj[0].toString();
                    String codigo = obj[1].toString();
                    if (des.equals(ultimdes) ) {
                        //no fem res (?)
                    }
                    else {
                        //Crear grup amb tots els ids de clients
                        //agafar cada detall i crear specific group
                        if (qt>0) {
                            int idgrup;
                            idgrup = crearGrup(ids, qt, des);
                            crearRole(idgrup, ultimdes,ids, qt);
                        }
                        ultimdes = des;
                        qt=0;
                    }
                    int idcli = findCli(codigo);
                    if (idcli>0) {
                        ids[qt] = idcli;
                        qt++;
                    }
                }
                catch(Exception exc) {
                    System.out.println(exc.getMessage());
                }
            }
//            Crear grup amb tots els ids de clients
//            agafar cada detall i crear specific group
            if (qt>=1) {
                int idgrup;
                idgrup = crearGrup(ids,qt, ultimdes);
                crearRole(idgrup, ultimdes, ids, qt);
            }
            altresDes();
            if (comprovacions) {
                comprovarDescomptes();
//                comprovarLinDesc();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } */
    }

    private int findCli(String codigo) {
        MatchCustomer mc = emMySQL.find(MatchCustomer.class,codigo);
        if (mc!=null) {
            return mc.getIdPresta();
        }
        else {
            return -1;
        }
        
    }

    private int crearGrup(int[] ids, int qt, String des) {
        int nextid = nextIdGroup() +1;
        //int idGroup, BigDecimal reduction, int priceDisplayMethod, short show_prices
        if (nextid<=0) {
            nextid = 1;
        }
        emMySQL.getTransaction().begin();
        Group gp = new Group(nextid,BigDecimal.ZERO,1,(short)1);
        emMySQL.persist(gp);
        for (int i=1; i<5; i++) {
            GroupLang gpl = new GroupLang(gp.getIdGroup(),i,des);
            emMySQL.persist(gpl);
        }
        GroupShop gs = new GroupShop(gp.getIdGroup(),1);
        emMySQL.persist(gs);
        //falta agrupar els clients en el grup:
        //select id_customer, 4 from ps_customer where id_customer in (1,2,3,4)
        
        for(int i=0;i<qt;i++) {
            CustomerGroup cg = new CustomerGroup(ids[i],gp.getIdGroup());
            String upd = "update Customer c set c.idDefaultGroup = " + gp.getIdGroup() + " where c.idCustomer = " + i;
            Query qupd = emMySQL.createQuery(upd);
            int r = qupd.executeUpdate();
            System.out.println("ACTU: " + r);
            emMySQL.persist(cg);
        }
        
        
        emMySQL.getTransaction().commit();
        
        
        return gp.getIdGroup();
    }

    private void crearRole(int idgrup, String des, int[] ids, int qt) {
        /*String qdet = "select c from LinDes c where c.codigo like '" + des + "' and c.estado = 0";
        
        Query q = emSQLServer.createQuery(qdet);
        List<LinDes> lines = q.getResultList();
        for (LinDes line: lines) {
            MatchSpecificPriceLinDesc msp = findMatchLinDesc(line);
            if (msp ==null) {
                if (!line.getArticulo().trim().equals("")) {
                    //per cada cli SPECIFICPRICE
                    BigDecimal descompte = line.getDto1().divide(BigDecimal.valueOf(100));
                    int idproduct = findProduct(line.getArticulo().trim());
                    //per cada client del grup
                    if (idproduct>0) {
                        int unitats = line.getUniIni().intValue();
                        for(int i=0; i<qt; i++) {
                            int idsp = maxIdSpecificPrice() + 1;
                            if (idsp <=0) {
                                idsp = 1;
                            }
                            SpecificPrice sp = new SpecificPrice(idsp,0,idproduct,ids[i],BigDecimal.valueOf(-1.0),unitats==0?1:unitats,descompte, (short)0,"percentage",line.getFechaIn(), line.getFechaFin());
                            SpecificPrice spclon = buscarCoIndex(sp);
                            if (spclon == null) {
                                emMySQL.getTransaction().begin();
                                emMySQL.persist(sp);
                                emMySQL.getTransaction().commit();
                            }
                            else {
                                int coincidencies = sp.getReduction().compareTo(spclon.getReduction());
                                if (coincidencies > 0) {
                                    //hem de reemplaçar SpecificPrice pel nostre.
                                    emMySQL.getTransaction().begin();
                                    emMySQL.remove(spclon);
                                    emMySQL.getTransaction().commit();

                                    emMySQL.getTransaction().begin();
                                    emMySQL.persist(sp);
                                    emMySQL.getTransaction().commit();
                                }
                            }
                        }
                    }
                }
                if (!line.getMarca().trim().equals("") || !line.getSubfamilia().trim().equals("") || !line.getFamilia().trim().equals("")) {
                    tractarCatOrMan(line, idgrup, ids, qt);
                }
                emSQLServer.getTransaction().begin();
                line.setEstado(1);
                emSQLServer.getTransaction().commit();
                
            }
            
        }*/
    }

    private int buscaNextIdSPR() {
        try {
            Query q = emMySQL.createQuery("select max(p.idSpecificPriceRule) from SpecificPriceRule p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int findManufacturer(String man) {
        MatchManufacturer mc = emMySQL.find(MatchManufacturer.class,man);
        if (mc!=null) {
            return mc.getIdPresta();
        }
        else {
            return -1;
        }
    }
    
    /*private MatchSpecificPriceDescuen findMatchDescuen (Descuen d) {
        try {
            String qryDes = "select p from MatchSpecificPriceDescuen p where p.idEuroCliente = '" +d.getCliente().trim() +"' and p.idEuroLinea = "+ d.getLinia();
            Query q = emMySQL.createQuery(qryDes);
            List<MatchSpecificPriceDescuen> matches = q.getResultList();
            if (!matches.isEmpty()) {
                return matches.get(0);
            }
            else {
                return null;
            }
        }
        catch(Exception ex) {
            System.out.println("---------------------!!!!!!!!!!!!!!!!!!!!!---------------------" + ex.getMessage());
            return null;
        }
        
    }*/
    
//    private MatchSpecificPriceLinDesc findMatchLinDesc (LinDes d) {
//        try {
//            String qryDes = "select p from MatchSpecificPriceLinDesc where p.idEuroCodigo = '" + d.getCodigo().trim();
//            qryDes += "' and p.idEuroArticulo = '"+ d.getArticulo().trim() + "' and p.idEuroFamilia = '" + d.getFamilia().trim();
//            qryDes += "' and p.idEuroSubfamilia = '"+ d.getSubfamilia().trim() + "' and p.idEuroLinea = " + d.getLinea();
//            Query q = emMySQL.createQuery(qryDes);
//            List<MatchSpecificPriceLinDesc> matches = q.getResultList();
//            if (!matches.isEmpty()) {
//                return matches.get(0);
//            }
//            else {
//                return null;
//            }
//        }
//        catch(Exception ex) {
//            System.out.println("---------------------!!!!!!!!!!!!!!!!!!!!!---------------------" + ex.getMessage());
//            return null;
//        }
//    }
    
    /*private MatchSpecificPriceLinDesc findMatchLinDesc (LinDes d) {
        try {
            String qryDes = "select p from MatchSpecificPriceLinDesc p where p.idEuroCodigo = '" + d.getCodigo().trim() + "' and p.idEuroLinea = " + d.getLinea();
            Query q = emMySQL.createQuery(qryDes);
            List<MatchSpecificPriceLinDesc> matches = q.getResultList();
            if (!matches.isEmpty()) {
                return matches.get(0);
            }
            else {
                return null;
            }
        }
        catch(Exception ex) {
            System.out.println("---------------------!!!!!!!!!!!!!!!!!!!!!---------------------" + ex.getMessage());
            return null;
        }
    }*/

    private int nextIdSPRC() {
        try {
            Query q = emMySQL.createQuery("select max(p.idSpecificPriceRuleCondition) from SpecificPriceRuleCondition p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int findCategory(String codigo) {
        MatchCategory mc = emMySQL.find(MatchCategory.class,codigo.trim());
        if (mc!=null) {
            return mc.getIdPresta();
        }
        else {
            return -1;
        }
        
    }

    private int findProduct(String codigo) {
        MatchProduct mc = emMySQL.find(MatchProduct.class,codigo);
        if (mc!=null) {
            return mc.getIdPresta();
        }
        else {
            return -1;
        }
    }

    private int nextIdGroup() {
        try {
            Query q = emMySQL.createQuery("select max(p.idGroup) from Group p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int buscaNextIdSPRCG() {
        try {
            Query q = emMySQL.createQuery("select max(p.idSpecificPriceRuleConditionGroup) from SpecificPriceRuleConditionGroup p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
            System.out.println(ex.getMessage());
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return -1;
        }
    }

    private int maxIdSpecificPrice() {
        //aqui
        try {
            Query q = emMySQL.createQuery("select max(p.idSpecificPrice) from SpecificPrice p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    /*private void tractarCatOrMan(LinDes line, int idgrup, int[] ids, int qt) {
        int nextid = buscaNextIdSPR() +1;
        if (nextid<=0) {
            nextid = 1;
        }
        BigDecimal descompte = line.getDto1().divide(BigDecimal.valueOf(100));
        emMySQL.getTransaction().begin();
        String nomPriceRule = line.getCodigo() + "-" + line.getLinea();
        SpecificPriceRule spr = new SpecificPriceRule(nextid,nomPriceRule,1,0,0,0,1,BigDecimal.valueOf(-1.0),descompte,(short)0,"percentage",line.getFechaIn(), line.getFechaFin()); 
        emMySQL.persist(spr);
        emMySQL.getTransaction().commit();
        
        String sql1 = "";
        String sql2 = "";
        
        if (!line.getFamilia().trim().equals("") && line.getSubfamilia().trim().equals("")) {
            int idCat = findCategory(line.getFamilia().trim());
            sql2 = "select c.idProduct from CategoryProduct c where c.idCategory = "+idCat;
            
            String qssub = "select idCategory from Category where idParent = " + idCat;
            Query qsub = emMySQL.createQuery(qssub);
            List<Integer> idSub = qsub.getResultList();
            //si subfam.count > 0 
            if (idSub.size()>0) {
                for(Integer subfam : idSub) {
                    //per cada subfam group + condition
                    int nextidcg2 = buscaNextIdSPRCG()+1;
                    if (nextidcg2<=0) {
                        nextidcg2 = 1;
                    }
                    int idsprc = nextIdSPRC()+1;
                    if(idsprc<= 0) {
                        idsprc = 1;
                    }
                    SpecificPriceRuleConditionGroup snou = new SpecificPriceRuleConditionGroup(nextidcg2,spr.getIdSpecificPriceRule());
                    SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,nextidcg2,"category",subfam+"");
                    emMySQL.getTransaction().begin();
                    emMySQL.persist(snou);
                    emMySQL.persist(sprc);
                    emMySQL.getTransaction().commit();
                    sql2 += " or c.idCategory = "+subfam;
                }
            }
            else {
//                int idsprc = nextIdSPRC()+1;
//                if(idsprc<= 0) {
//                    idsprc = 1;
//                }
//                //else condition
//                SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,sprcg.getIdSpecificPriceRuleConditionGroup(),"category",idCat+"");
//                emMySQL.getTransaction().begin();
//                emMySQL.persist(sprcg);
//                emMySQL.persist(sprc);
//                emMySQL.getTransaction().commit();
            }  
        }
        
        if (!line.getMarca().trim().equals("") || !line.getSubfamilia().trim().equals("")) {
            
            int nextidcg = buscaNextIdSPRCG()+1;
            if (nextidcg<=0) {
                nextidcg = 1;
            }
            emMySQL.getTransaction().begin();
            SpecificPriceRuleConditionGroup sprcg = null;
            sprcg = new SpecificPriceRuleConditionGroup(nextidcg,nextid);
            emMySQL.persist(sprcg);
            emMySQL.getTransaction().commit();
        
            if (!line.getMarca().trim().equals("")) {
                int idMarca = findManufacturer(line.getMarca().trim());
                int idsprc = nextIdSPRC()+1;
                if(idsprc<= 0) {
                    idsprc = 1;
                }
                SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,sprcg.getIdSpecificPriceRuleConditionGroup(),"manufacturer",idMarca+"");
                emMySQL.getTransaction().begin();
                emMySQL.persist(sprc);
                emMySQL.getTransaction().commit();
                sql1 = "select p.idProducte from Product p where p.idManufacturer = " + idMarca;
            }
            if (!line.getSubfamilia().trim().equals("")) {
                int idCat = findCategory(line.getSubfamilia().trim());
                int idsprc = nextIdSPRC()+1;
                if(idsprc<= 0) {
                    idsprc = 1;
                }
                SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,sprcg.getIdSpecificPriceRuleConditionGroup(),"category",idCat+"");
                emMySQL.getTransaction().begin();
                emMySQL.persist(sprc);
                emMySQL.getTransaction().commit();
                sql2 = "select c.idProduct from CategoryProduct c where c.idCategory = "+idCat;
            }
            
            
        }
        
        List<Integer> idsprods = new ArrayList<Integer>();
        List<Integer> idsprods2;
        if (sql1.length()>5) {
            Query qprods = emMySQL.createQuery(sql1);
            idsprods = qprods.getResultList();
        }
        if (sql2.length()>5) {
            Query qprods = emMySQL.createQuery(sql2);
            idsprods2 = qprods.getResultList();
            idsprods.addAll(idsprods2);
        }
                
        for (Integer id: idsprods) {
            int unitats = line.getUniIni().intValue();
            for(int i=0; i<qt; i++) {
                int idsp = maxIdSpecificPrice() + 1;
                if (idsp <=0) {
                    idsp = 1;
                }
                SpecificPrice sp = new SpecificPrice(idsp,spr.getIdSpecificPriceRule(),id,ids[i],BigDecimal.valueOf(-1.0),unitats==0?1:unitats,descompte, (short)0,"percentage",line.getFechaIn(), line.getFechaFin());
                emMySQL.getTransaction().begin();
                emMySQL.persist(sp);
                emMySQL.getTransaction().commit();
            }
        }
        //MatchSpecificPriceLinDesc mspl = new MatchSpecificPriceLinDesc(nextid,line.getCodigo().trim(), line.getArticulo().trim(),line.getFamilia().trim(),line.getSubfamilia().trim(),line.getLinea());
//        emMySQL.getTransaction().begin();
//        emMySQL.persist(mspl);
//        emMySQL.getTransaction().commit(); //peta!
    }*/

    private void comprovarDescomptes() {
        /*String sdelete = "(";
        String query = "select p from ConDescuen p";
        Query qc = emSQLServer.createQuery(query);
        List<ConDescuen> desc = qc.getResultList();
        SpecificPrice spaux = null;
        for (ConDescuen des:desc) {
            //torna list ????
            List<MatchSpecificPriceDescuen> llm = findMatchSpecificPriceDescuen(des);
            if (llm!=null && !llm.isEmpty()) {
                String sids = "";
                for(MatchSpecificPriceDescuen mc : llm) {
                    spaux = emMySQL.find(SpecificPrice.class, mc.getIdPresta());
                    //en tots dos casos (eliminació o variació, s'ha d'eliminar)
                    emMySQL.getTransaction().begin();
                    emMySQL.remove(mc);
                    emMySQL.remove(spaux);
                    emMySQL.getTransaction().commit();
                }
                if (des.getAccio() == 2) {
//                    fer delete directe .... guardar en var ideuro .... guardar ids per cada match
                    if (sdelete.length()>1) {
                        sdelete += ", " + sids;
                    }
                    else {
                        sdelete += sids +"";
                    }
                }
                if (des.getAccio() == 1) {
                    Descuen d = findDescuen(llm.get(0));
                    if (d!= null) {
                        ferNouDescuen(d);
                    }
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(des);
            emSQLServer.getTransaction().commit();
        }
        
        sdelete += ")";
        
        if (sdelete.length()>2) {
//            String qryDel = "delete from MatchSpecificPriceDescuen where idPresta in " + sdelete;
            String qryDelSpecific = "delete from SpecificPrice where idSpecificPrice in " + sdelete;
            

            emMySQL.getTransaction().begin();
//            Query q1 = emMySQL.createQuery(qryDel);
            Query q2 = emMySQL.createQuery(qryDelSpecific);
//            int i = q1.executeUpdate();
//            System.out.println("Deleted q1: " + i);
            int i = q2.executeUpdate();
            System.out.println("Deleted q2: " + i);
            emMySQL.getTransaction().commit();
        }*/
        
        
    }

    private void altresDes() {
        //recorregut sobre descuento: Taula Descuen
        /*String query = "select d from Descuen d where d.estado = 0";
        Query q = emSQLServer.createQuery(query);
        List<Descuen> descs = q.getResultList();
        for (Descuen des: descs) {
            MatchCustomer cm = emMySQL.find(MatchCustomer.class, des.getCliente().trim());
            MatchSpecificPriceDescuen msp = findMatchDescuen(des);
            if (msp==null && cm!=null) {
                tractarDes(des);
            }
            emSQLServer.getTransaction().begin();
            String deleteCon = "delete from ConDescuen cd where cd.cliente = '" +  des.getCliente() +"' and cd.linea = " + des.getLinia();
            Query dCon = emSQLServer.createQuery(deleteCon);
            int result = dCon.executeUpdate();
            emSQLServer.getTransaction().commit();
        }*/
    }

    private int findClient(String idcli) {
        try {
            MatchCustomer mc = emMySQL.find(MatchCustomer.class, idcli);
            if (mc!=null) {
                return mc.getIdPresta();
            }
            else {
                return 0;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getCause());
            return 0;
        }
    }

    /**
     * Busca si existeix un descompte amb les mateixes característiques 
     * (client, dates, quantitat minima, article...
     * I retorna:
     *  - En cas que no hi ha coincidències: -2
     *  - En cas que hi ha coincidència i la nova és més favorable: 1
     *  - En cas que hi ha coincidència però són idèntiques en valor: 0
     *  - En cas que hi ha coincidència pero l'existent és més favorable: -1
     * @param sp
     * @return 
     */
    private SpecificPrice buscarCoIndex(SpecificPrice sp) {
        /*String qrySem = "select sp from SpecificPrice sp where sp.idProduct = " + sp.getIdProduct() + " and sp.idCustomer = " + sp.getIdCustomer() + " and sp.from = ?1";
        qrySem += " and sp.to = ?2 and sp.fromQuantity = " + sp.getFromQuantity()+ " and sp.idGroup = " + sp.getIdGroup() + " and sp.idSpecificPriceRule = " + sp.getIdSpecificPriceRule();
        try {
            Query q = emMySQL.createQuery(qrySem);
            q.setParameter(1, sp.getFrom(),TemporalType.TIMESTAMP);
            q.setParameter(2, sp.getTo(),TemporalType.TIMESTAMP);
            List<SpecificPrice> sps = q.getResultList();
            if (sps.size() == 1 ) {
                //existeix
                return sps.get(0);
            }
            else if (sps.isEmpty()) {
                //no existeix
                return null;
            }
        }
        catch (Exception ex) {
            return null;
        }*/
        return null;
    }

    private void comprovarLinDesc() {
        /*try {
            String query = "select p from ConLinDesc p";
            Query qc = emSQLServer.createQuery(query);
            List<ConLinDesc> conections = qc.getResultList();
            for (ConLinDesc clin:conections) {
                MatchSpecificPriceLinDesc msl = findMatchSpecificPriceLinDesc(clin);
                //MatchManufacturer mp = emMySQL.find(MatchManufacturer.class, clin.getCodigo().trim());
                if (msl!=null) {
                    if (clin.getAccio() == 2) {
                        delLinDes(msl);
                    }
                    if (clin.getAccio() == 1) {
                        //buscar linea i fer comprovacions:
                        LinDes ld = findLinDes(msl);
                        if (ld!= null) {
                            checkLinDes(ld,msl);

                        }
                    }
                }
                emSQLServer.getTransaction().begin();
                emSQLServer.remove(clin);
                emSQLServer.getTransaction().commit();
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }*/
        
    }

    private MatchSpecificPriceLinDesc findMatchSpecificPriceLinDesc(ConLinDesc lin) {
        try {
            String sql = "select p from MatchSpecificPriceLinDesc p where p.idEuroCodigo = '" + lin.getCodigo().trim() + "' and p.idEuroLinea = " + lin.getLinea();
            Query q = emMySQL.createQuery(sql);
            MatchSpecificPriceLinDesc mspld = (MatchSpecificPriceLinDesc) q.getSingleResult();
            return mspld;
        }
        catch (Exception ex) {
            System.out.println(ex.getCause() + ex.getMessage());
            return null;
        }
    }

    /*private LinDes findLinDes(MatchSpecificPriceLinDesc msl) {
        try {
            String sql = "select p from LinDes p where p.codigo = '" + msl.getIdEuroCodigo() + "' and p.linea = " + msl.getIdEuroLinea();
            Query q = emSQLServer.createQuery(sql);
            LinDes ld = (LinDes) q.getSingleResult();
            return ld;
        }
        catch (Exception ex) {
            System.out.println(ex.getCause() + ex.getMessage());
            return null;
        }
    }*/

    /*private void checkLinDes(LinDes ld, MatchSpecificPriceLinDesc msl) {
        //si es article i aquest ha canviat -> canviar id article
        //agafar anterior: specificpricerule
        //comprovacions:
        //saber què teniem abans OTR-ART
        MatchGroupLinDesc mg = emMySQL.find(MatchGroupLinDesc.class, ld.getCodigo().trim());
        if (mg!=null) {
            if (msl.getTipusPresta().equals("OTR")) {
                //eliminar rule , derivats i SpecificPrice
                String del1 = "delete from SpecificPrice sp where sp.idSpecificPriceRule = " + msl.getIdPresta();
                String del2 = "delete from SpecificPriceRule r where r.idSpecificPriceRule = " + msl.getIdPresta();
                String del4 = "delete from SpecificPriceRuleConditionGroup rcg where rcg.idSpecificPriceRule = " + msl.getIdPresta();
                String del3 = "delete from SpecificPriceRuleCondition rc where rc.idSpecificPriceRuleConditionGroup in (select rcb.idSpecificPriceRuleConditionGroup from SpecificPriceRuleConditionGroup rcb where rcb.idSpecificPriceRule = "+ msl.getIdPresta()+ ") ";
                emMySQL.getTransaction().begin();
                Query q1 = emMySQL.createQuery(del1);
                Query q2 = emMySQL.createQuery(del2);
                Query q3 = emMySQL.createQuery(del3);
                Query q4 = emMySQL.createQuery(del4);
                int i1 = q1.executeUpdate();
                int i2 = q2.executeUpdate();
                int i3 = q3.executeUpdate();
                int i4 = q4.executeUpdate();
                emMySQL.remove(msl);
                emMySQL.getTransaction().commit();
                tractarLinDes(ld, mg.getIdPrestaGroup());
            }
            if (msl.getTipusPresta().equals("ART")) {
                //eliminar SpecificPrice d'article
                //tractar lindes i fer
                String del = "delete from SpecificPrice sp where sp.idSpecificPrice = " + msl.getIdPresta();
                emMySQL.getTransaction().begin();
                Query q1 = emMySQL.createQuery(del);
                int i1 = q1.executeUpdate();
                tractarLinDes(ld, mg.getIdPrestaGroup());
                emMySQL.remove(msl);
                emMySQL.getTransaction().commit();
            }
        }
        
    }*/

    private List<MatchSpecificPriceDescuen> findMatchSpecificPriceDescuen(ConDescuen des) {
        try {
            String sql = "select p from MatchSpecificPriceDescuen p where p.idEuroCliente = '" + des.getCliente() + "' and p.idEuroLinea = " + des.getLinea();
            
            Query q = emMySQL.createQuery(sql);
            List<MatchSpecificPriceDescuen> dess = q.getResultList();
            if (dess.size()>0) {
                return dess;
            }
            else {
                return null;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getCause() + ex.getMessage());
            return null;
        }
    }

    /*private Descuen findDescuen(MatchSpecificPriceDescuen msd) {
        try {
            String sqry ="select d from Descuen d where d.cliente = '" + msd.getIdEuroCliente() + "' and d.linia = " + msd.getIdEuroLinea();
            Query q = emSQLServer.createQuery(sqry);
            Descuen de = (Descuen) q.getSingleResult();
            return de;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage() + " - " + ex.getCause());
            return null;
        }
        
        
    }*/

    /*private void ferNouDescuen(Descuen d) {
        tractarDes(d);
    }*/

    /*private void tractarDes(Descuen des) {
        String cliente = des.getCliente();
        String articulo = des.getArticulo();
        String familia = des.getFamilia();
        String subfamilia = des.getSubfamilia();
        String marca = des.getMarca();

        int unitats = des.getUniMin().intValue();
        BigDecimal descompte = des.getDto1().divide(BigDecimal.valueOf(100));

        String where = "";
        int idCli = findClient(cliente.trim());
        if (articulo.trim().length()>0) {
            //passar article des
            MatchProduct mp  = emMySQL.find(MatchProduct.class, articulo.trim());
            if (mp!=null) {
                int id = mp.getIdPresta();
                int idsp = maxIdSpecificPrice() + 1;
                if (idsp <=0) {
                    idsp = 1;
                }
                //buscar coincidencies: index 'id_product_2'
                SpecificPrice sp = new SpecificPrice(idsp,0,id,idCli,BigDecimal.valueOf(-1.0),unitats==0?1:unitats,descompte, (short)0,"percentage",des.getFechaIn(), des.getFechaFin());
                SpecificPrice sp2 = buscarCoIndex(sp);
                if (sp2 != null) {
                    int coincidencies = sp.getReduction().compareTo(sp2.getReduction());
                    if (coincidencies > 0) {
                        //hem de reemplaçar SpecificPrice pel nostre.
                        emMySQL.getTransaction().begin();
                        emMySQL.remove(sp2);
                        emMySQL.getTransaction().commit();
                        emMySQL.getTransaction().begin();
                        emMySQL.persist(sp);
                        emMySQL.getTransaction().commit();
                    }
                }
                else {
                    //no existex descompte com aquest aixi que el creem
                    emMySQL.getTransaction().begin();
                    emMySQL.persist(sp);
                    emMySQL.getTransaction().commit();
                }
                MatchSpecificPriceDescuen mspd = new MatchSpecificPriceDescuen(idsp,des.getCliente(),des.getLinia());
                emMySQL.getTransaction().begin();
                emMySQL.persist(mspd);
                emMySQL.getTransaction().commit();
            }
        }
        else {
            List<Integer> ll1 = null;
            if (familia.trim().length()>0 && subfamilia.trim().length()==0) {
                MatchCategory mc = emMySQL.find(MatchCategory.class, familia.trim());
                
                if (mc!=null) {
                    int idCat = mc.getIdPresta();
                    String qssub = "select c.idCategory from Category c where c.idParent = " + idCat;
                    Query qsub = emMySQL.createQuery(qssub);
                    List<Integer> idSub = qsub.getResultList();

                    String queryCats = "Select cp.idProduct from CategoryProduct cp";
                    String whereC = "";
                    if (idSub.isEmpty()) {
                        whereC = " where cp.idCategory = " + idCat;
                    }
                    else {
                        for(int cat : idSub) {
                            if (whereC.length()>2) {
                                whereC += " or cp.idCategory = "+cat;
                            }
                            else {
                                whereC += " where cp.idCategory = " + cat;
                            }
                        }
                    }
                    Query q1 = emMySQL.createQuery(queryCats + "" + whereC);
                    ll1 = q1.getResultList();
                }
            }

            int idsub=0;
            if (subfamilia.trim().length()>0) {
                MatchCategory mc = emMySQL.find(MatchCategory.class, subfamilia.trim());
                if (mc!=null) {
                    idsub = mc.getIdPresta();
                    String queryCats = "Select cp.idProduct from CategoryProduct cp where cp.idCategory = " + idsub;
                    Query q1 = emMySQL.createQuery(queryCats);
                    ll1 = q1.getResultList();
                }
            }
            List<Integer> ll2 = null;
            int idman = 0;
            if (marca.trim().length()>0) {
                MatchManufacturer mm = emMySQL.find(MatchManufacturer.class, marca.trim());
                if(mm!=null) {
                    idman =  mm.getIdPresta();
                    String queryMan = "Select p.idProducte from Product p where p.idManufacturer = " + idman;
                    Query q2 = emMySQL.createQuery(queryMan);
                    ll2 = q2.getResultList();
                }
            }
            List<Integer> idsProductes = null;
            if (ll1 != null && ll1.isEmpty()) {
                ll1 = null;
            }
            if (ll2!=null && ll2.isEmpty()) {
                ll2 = null;
            }

            if (ll1 != null && ll2!=null) {
                ll1.retainAll(ll2);
                idsProductes = ll1;
            }
            if (ll1 == null) {
                idsProductes = ll2;
            }
            if (ll2 == null) {
                //nomes ll1
                idsProductes = ll1;
            }

            if (idsProductes!= null) {
                for (Integer prod : idsProductes) {
                    //crear per cada prod que entra en les opcions:
                    //ps_specific_price
                    int idsp = maxIdSpecificPrice() + 1;
                    if (idsp <=0) {
                        idsp = 1;
                    }
                    //int idSpecificPrice, int idSpecificPriceRule, int idProduct, int idCustomer, BigDecimal price, int fromQuantity, BigDecimal reduction, short reductionTax, String reductionType, Date from, Date to) {
                    SpecificPrice sp = new SpecificPrice(idsp,0,prod,idCli,BigDecimal.valueOf(-1.0),unitats==0?1:unitats,descompte, (short)0,"percentage",des.getFechaIn(), des.getFechaFin());
                    SpecificPrice spclon = buscarCoIndex(sp);
                    if (spclon == null) {
                        emMySQL.getTransaction().begin();
                        emMySQL.persist(sp);
                        emMySQL.getTransaction().commit();
                    }
                    else {
                        int coincidencies = sp.getReduction().compareTo(spclon.getReduction());
                        if (coincidencies > 0) {
                            //hem de reemplaçar SpecificPrice pel nostre.
                            emMySQL.getTransaction().begin();
                            emMySQL.remove(spclon);
                            emMySQL.getTransaction().commit();

                            emMySQL.getTransaction().begin();
                            emMySQL.persist(sp);
                            emMySQL.getTransaction().commit();
                        }
                    }
                    //canviar pk match a tot.
                    MatchSpecificPriceDescuen mspd = new MatchSpecificPriceDescuen(idsp,des.getCliente(),des.getLinia());
                            
                    emMySQL.getTransaction().begin();
                    emMySQL.persist(mspd);
                    emMySQL.getTransaction().commit();
                    
                }
            }

        }
        emSQLServer.getTransaction().begin();
        des.setEstado(1);
        emSQLServer.getTransaction().commit();
    }*/

    /*private void actualitzarLinDesc(int shop) {
        String sqls = "select f from LinDes f where f.estado = 0";
        Query q = emSQLServer.createQuery(sqls);
        List<LinDes> linies = q.getResultList();
        for(LinDes lin : linies) {
            MatchGroupLinDesc mgld = findMatchGroupLinDesc(lin.getCodigo());
            if (mgld != null) {
                MatchSpecificPriceLinDesc mspld = findMatchLinDesc(lin);
                if (mspld ==null) {
                    afegirLineaLinDesc(lin,mgld.getIdPrestaGroup());
                }
                //si no es crea de nou el lin_desc
                
            }
            else {
                String nom = lin.getCodigo().trim();
                int nextid = nextIdGroup() +1;
                if (nextid<=0) {
                    nextid = 1;
                }
                emMySQL.getTransaction().begin();
                Group gp = new Group(nextid,BigDecimal.ZERO,1,(short)1);
                emMySQL.persist(gp);
                for (int i=1; i<5; i++) {
                    GroupLang gpl = new GroupLang(gp.getIdGroup(),i,nom);
                    emMySQL.persist(gpl);
                }
                GroupShop gs = new GroupShop(gp.getIdGroup(),1);
                emMySQL.persist(gs);
                emMySQL.getTransaction().commit();
                //falta agrupar els clients en el grup:
                //select id_customer, 4 from ps_customer where id_customer in (1,2,3,4)
                afegirClients(nom, nextid);
                emMySQL.getTransaction().begin();
                mgld = new MatchGroupLinDesc(nextid,nom);
                emMySQL.persist(mgld);
                emMySQL.getTransaction().commit();
                afegirLineaLinDesc(lin,mgld.getIdPrestaGroup());
            }
            emSQLServer.getTransaction().begin();
            String deleteCon = "delete from ConLinDesc cd where cd.codigo = '" +  lin.getCodigo() +"' and cd.linea = " + lin.getLinea();
            Query dCon = emSQLServer.createQuery(deleteCon);
            int result = dCon.executeUpdate();
            emSQLServer.getTransaction().commit();
            //si ja existeix LinDes
            //si no existeix
            //un cop creat o afegit, comprovar membres del grup
            
        }
        
    }*/

    private void actualitzarDescuen(int shop) {
        altresDes();
    }

    private MatchGroupLinDesc findMatchGroupLinDesc(String codigo) {
        try {
            MatchGroupLinDesc mg = emMySQL.find(MatchGroupLinDesc.class, codigo);
            return mg;
        }
        catch(Exception ex) {
            System.out.println(ex);
            return null;
        }
        
    }

    /*private void afegirLineaLinDesc(LinDes lin, int mgld) {
        try {
            if (lin.getArticulo().trim().length()>0) {
                int idproduct = findProduct(lin.getArticulo().trim());
                if (idproduct > 0) {
                    BigDecimal descompte = lin.getDto1().divide(BigDecimal.valueOf(100));
                    int unitats = lin.getUniIni().intValue();
                    int nextid = maxIdSpecificPrice() +1;
                    if (nextid<=0) {
                        nextid = 1;
                    }
                    SpecificPrice sp = new SpecificPrice(nextid,0,idproduct,0,BigDecimal.valueOf(-1.0),unitats==0?1:unitats,descompte, (short)0,"percentage",lin.getFechaIn(), lin.getFechaFin());
                    sp.setIdGroup(mgld);
                    emMySQL.getTransaction().begin();
                    emMySQL.persist(sp);
                    emMySQL.getTransaction().commit();
                    MatchSpecificPriceLinDesc md  = new MatchSpecificPriceLinDesc("ART",nextid,lin.getCodigo(), lin.getArticulo().trim(), "", "", lin.getLinea());
                    emMySQL.getTransaction().begin();
                    emMySQL.persist(md);
                    emMySQL.getTransaction().commit();
                }
            }
            else {
                int nextid = buscaNextIdSPR() +1;
                if (nextid<=0) {
                    nextid = 1;
                }
                BigDecimal descompte = lin.getDto1().divide(BigDecimal.valueOf(100));
                emMySQL.getTransaction().begin();
                String nomPriceRule = lin.getCodigo() + "-" + lin.getLinea();
                SpecificPriceRule spr = new SpecificPriceRule(nextid,nomPriceRule,1,0,0,0,1,BigDecimal.valueOf(-1.0),descompte,(short)0,"percentage",lin.getFechaIn(), lin.getFechaFin()); 
                emMySQL.persist(spr);
                emMySQL.getTransaction().commit();

                String sql1 = "";
                String sql2 = "";

                if (!lin.getFamilia().trim().equals("") && lin.getSubfamilia().trim().equals("")) {
                    int idCat = findCategory(lin.getFamilia().trim());
                    sql2 = "select c.idProduct from CategoryProduct c where c.idCategory = "+idCat;
                    String qssub = "select idCategory from Category where idParent = " + idCat;
                    Query qsub = emMySQL.createQuery(qssub);
                    List<Integer> idSub = qsub.getResultList();
                    //si subfam.count > 0 
                    if (idSub.size()>0) {
                        for(Integer subfam : idSub) {
                            //per cada subfam group + condition
                            int nextidcg2 = buscaNextIdSPRCG()+1;
                            if (nextidcg2<=0) {
                                nextidcg2 = 1;
                            }
                            int idsprc = nextIdSPRC()+1;
                            if(idsprc<= 0) {
                                idsprc = 1;
                            }
                            SpecificPriceRuleConditionGroup snou = new SpecificPriceRuleConditionGroup(nextidcg2,spr.getIdSpecificPriceRule());
                            SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,nextidcg2,"category",subfam+"");
                            emMySQL.getTransaction().begin();
                            emMySQL.persist(snou);
                            emMySQL.persist(sprc);
                            emMySQL.getTransaction().commit();
                            sql2 += " or c.idCategory = "+subfam;
                        }
                    }
                }
                if (!lin.getMarca().trim().equals("") || !lin.getSubfamilia().trim().equals("")) {
                    int nextidcg = buscaNextIdSPRCG()+1;
                    if (nextidcg<=0) {
                        nextidcg = 1;
                    }
                    emMySQL.getTransaction().begin();
                    SpecificPriceRuleConditionGroup sprcg = null;
                    sprcg = new SpecificPriceRuleConditionGroup(nextidcg,nextid);
                    emMySQL.persist(sprcg);
                    emMySQL.getTransaction().commit();

                    if (!lin.getMarca().trim().equals("")) {
                        int idMarca = findManufacturer(lin.getMarca().trim());
                        int idsprc = nextIdSPRC()+1;
                        if(idsprc<= 0) {
                            idsprc = 1;
                        }
                        SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,sprcg.getIdSpecificPriceRuleConditionGroup(),"manufacturer",idMarca+"");
                        emMySQL.getTransaction().begin();
                        emMySQL.persist(sprc);
                        emMySQL.getTransaction().commit();
                        sql1 = "select p.idProducte from Product p where p.idManufacturer = " + idMarca;
                    }
                    if (!lin.getSubfamilia().trim().equals("")) {
                        int idCat = findCategory(lin.getSubfamilia().trim());
                        int idsprc = nextIdSPRC()+1;
                        if(idsprc<= 0) {
                            idsprc = 1;
                        }
                        SpecificPriceRuleCondition sprc = new SpecificPriceRuleCondition(idsprc,sprcg.getIdSpecificPriceRuleConditionGroup(),"category",idCat+"");
                        emMySQL.getTransaction().begin();
                        emMySQL.persist(sprc);
                        emMySQL.getTransaction().commit();
                        sql2 = "select c.idProduct from CategoryProduct c where c.idCategory = "+idCat;
                    }
                }

                List<Integer> idsprods = new ArrayList<Integer>();
                List<Integer> idsprods2;
                if (sql1.length()>5) {
                    Query qprods = emMySQL.createQuery(sql1);
                    idsprods = qprods.getResultList();
                }
                if (sql2.length()>5) {
                    Query qprods = emMySQL.createQuery(sql2);
                    idsprods2 = qprods.getResultList();
                    idsprods.addAll(idsprods2);
                }
                for (Integer id: idsprods) {
                    int unitats = lin.getUniIni().intValue();
                    int idsp = maxIdSpecificPrice() + 1;
                    if (idsp <=0) {
                        idsp = 1;
                    }
                    SpecificPrice sp = new SpecificPrice(idsp,spr.getIdSpecificPriceRule(),id,0,BigDecimal.valueOf(-1.0),unitats==0?1:unitats,descompte, (short)0,"percentage",lin.getFechaIn(), lin.getFechaFin());
                    sp.setIdGroup(mgld);
                    emMySQL.getTransaction().begin();
                    emMySQL.persist(sp);
                    emMySQL.getTransaction().commit();
                }
                MatchSpecificPriceLinDesc md  = new MatchSpecificPriceLinDesc("OTR",nextid,lin.getCodigo(), "", lin.getSubfamilia(), lin.getSubfamilia(), lin.getLinea());
                emMySQL.getTransaction().begin();
                emMySQL.persist(md);
                emMySQL.getTransaction().commit();
            }
            emSQLServer.getTransaction().begin();
            lin.setEstado(1);
            emSQLServer.getTransaction().commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }*/

    private void afegirClients(String nom, int grup) {
        String sqls = "select c.codigo from Client c where c.linDes = '" + nom + "' and c.estado = 1";
        Query qs = emSQLServer.createQuery(sqls);
        List<String> codis = qs.getResultList();
//        List<Object[]> codis = qs.getResultList();
        for (String cod : codis) {
            emMySQL.getTransaction().begin();
            String codi = cod;
            MatchCustomer mc = emMySQL.find(MatchCustomer.class, codi);
            if (mc!=null) {
                CustomerGroup cg = new CustomerGroup(mc.getIdPresta(),grup);
                String upd = "update Customer c set c.idDefaultGroup = " + grup + " where c.idCustomer = " + mc.getIdPresta();
                Query qupd = emMySQL.createQuery(upd);
                int r = qupd.executeUpdate();
                System.out.println("ACTU: " + r);
                emMySQL.persist(cg);
            }
            emMySQL.getTransaction().commit();
        }
    }
    
    /*private void comprovarClients() {
        //accio 3 = canvi en lin_desc , accio = 2 -> delete, accio = 1 -> update
        String sclis = "select c.codigo from ConClientes c where accio = 3";
        Query qcli = emSQLServer.createQuery(sclis);
        List<String> llcli = qcli.getResultList();
        for (String cli: llcli) {
            //afegir del grup o treure
            Client c = emSQLServer.find(Client.class, cli);
            MatchCustomer mc = emMySQL.find(MatchCustomer.class, cli);
            String slin = c.getLinDes();
            if (mc!=null) {
                emMySQL.getTransaction().begin();
                String sdel = "delete from CustomerGroup where idCustomer = " + mc.getIdPresta() + " and idGroup>3";
                Query qdel = emMySQL.createQuery(sdel);
                int x = qdel.executeUpdate();
                int group = 0;
                if (slin.trim().length()>0) {
                    MatchGroupLinDesc mg = emMySQL.find(MatchGroupLinDesc.class, slin.trim());
                    if (mg!=null) {
                        CustomerGroup cg = new CustomerGroup(mc.getIdPresta(),mg.getIdPrestaGroup());
                        emMySQL.persist(cg);
                        group = mg.getIdPrestaGroup();
                    }
                }
                else {
                    group = 3;
                }
                String upd = "update Customer c set c.idDefaultGroup = " + group + " where c.idCustomer = " + mc.getIdPresta();
                Query qupd = emMySQL.createQuery(upd);
                int r = qupd.executeUpdate();
                emMySQL.getTransaction().commit();
            }
        }
    }*/

    /*private void tractarLinDes(LinDes ld, int grup) {
        afegirLineaLinDesc(ld,grup);
    }*/

    private void delLinDes(MatchSpecificPriceLinDesc msl) {
        emMySQL.getTransaction().begin();
        MatchGroupLinDesc mg = emMySQL.find(MatchGroupLinDesc.class, msl.getIdEuroCodigo().trim());
        if (mg!=null) {
            if (msl.getTipusPresta().equals("OTR")) {
                //eliminar rule , derivats i SpecificPrice
                String del1 = "delete from SpecificPrice sp where sp.idSpecificPriceRule = " + msl.getIdPresta();
                String del2 = "delete from SpecificPriceRule r where r.idSpecificPriceRule = " + msl.getIdPresta();
                String del4 = "delete from SpecificPriceRuleConditionGroup rcg where rcg.idSpecificPriceRule = " + msl.getIdPresta();
                String del3 = "delete from SpecificPriceRuleCondition rc where rc.idSpecificPriceRuleConditionGroup in (select rcb.idSpecificPriceRuleConditionGroup from SpecificPriceRuleConditionGroup rcb where rcb.idSpecificPriceRule = "+ msl.getIdPresta()+ ") ";
                Query q1 = emMySQL.createQuery(del1);
                Query q2 = emMySQL.createQuery(del2);
                Query q3 = emMySQL.createQuery(del3);
                Query q4 = emMySQL.createQuery(del4);
                int i1 = q1.executeUpdate();
                int i2 = q2.executeUpdate();
                int i3 = q3.executeUpdate();
                int i4 = q4.executeUpdate();
            }
            if (msl.getTipusPresta().equals("ART")) {
                //eliminar SpecificPrice d'article
                //tractar lindes i fer
                String del = "delete from SpecificPrice sp where sp.idSpecificPrice = " + msl.getIdPresta();
                Query q1 = emMySQL.createQuery(del);
                int i1 = q1.executeUpdate();
            }
        }
        emMySQL.remove(msl);
        emMySQL.getTransaction().commit();
    }

    
}
