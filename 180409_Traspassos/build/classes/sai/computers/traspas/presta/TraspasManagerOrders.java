/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas.presta;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.persistence.ahora.Articulo;
import sai.persistence.Category.Category;
import sai.persistence.matches.MatchOrder;
import sai.persistence.order.OrderDetail;
import sai.persistence.order.Orders;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerOrders {
    EntityManager emSQLServer;
    EntityManager emMySQL;
    
    String empresa;
    String letra;
    String fpago;
    String almacen;
    String venedor;
//    public void iniciarTraspas () {
//        
//        this.transferirOrder(1); //seria bo guardar info en fitxer de propietats
//    }

    
    public TraspasManagerOrders(EntityManager emSQLServer, EntityManager emMySQL) {
        
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
        
        empresa = "01";
        fpago="01";
        almacen="00";
        letra = "";
    }
    
    
    
    /**
     * S'executa en donar-se d'alta un pedido en MYSQL, per tal de passar-lo a SQLSERVER
     * Es necessita que l'usuari faciliti empresa, lletra, forma de pagament i magatzem 
     * de l'eurowin.
     */
    private void transferirOrder(int idOrder){
        /*String up = "UP-SQLServer";
        
        try {
            Orders ord = emMySQL.find(Orders.class, idOrder);
            //String qs = "select p from Orders p where idOrder = " +idOrder;
            //Query qm = emMySQL.createQuery(qs);
            //Orders ord = (Orders) qm.getSingleResult();
            String usuario = "SUPERVISOR#SOFTWARE3 # PR";
            int envCli =1;
            String cli = buscaClient(ord.getIdCustomer());
            String numero = buscaSegNumero();
            Pedido p = new Pedido(usuario,empresa, numero,letra,envCli,cli,ord.getTotalPaid(),
                        ord.getTotalProducts(),fpago,ord.getTotalPaid(),almacen);
            emSQLServer.getTransaction().begin();
            emSQLServer.persist(p);
            emSQLServer.getTransaction().commit();
            
            Query qd;
            qd = emMySQL.createQuery("select p from OrderDetail p where idOrder=" + ord.getIdOrder());
            List<OrderDetail> orderd = qd.getResultList();
            int i = 1;
            for (OrderDetail od: orderd) {
                
                System.out.println("\t" + od);
                String art = buscaArticulo(od.getProductId());
                String familia = buscaFamilia(od.getProductId());
                
                Articulo a = emSQLServer.find(Articulo.class, art);
                
                if (familia==null) {
                    familia = " ";
                }
                //String usuario, String empresa, String numero, int linea, 
                //String articulo, String definicion, BigDecimal unidades, 
                //BigDecimal precio, BigDecimal importe, String cliente, 
                //BigDecimal importeIva, String familia) 
                PedidoLinea pl = new PedidoLinea (usuario, empresa, p.getNumero(),i,art,a.getNombre() ,
                            BigDecimal.valueOf(od.getProductQuantity()),od.getProductPrice(), od.getTotalPriceTaxIncl(),p.getCliente(),od.getTotalPriceTaxExcl(),familia);
                
                emSQLServer.getTransaction().begin();
                emSQLServer.persist(pl);
                emSQLServer.getTransaction().commit();
                
                i++;
                
            }
            MatchOrder mo = new MatchOrder(ord.getIdOrder(),p.getEmpresa(),p.getNumero(),p.getLetra());
            emMySQL.getTransaction().begin();
            emMySQL.persist(mo);
            emMySQL.getTransaction().commit();
            
            
            
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } */
    }

    public void actualitzarOrders (int shop, String vendedor) {
        try {
            venedor = vendedor;
            String ql = "select p from Orders p where p.idOrder not in (select mp.idPresta from MatchOrder mp)";
            Query q = emMySQL.createQuery(ql);
            List<Orders> oords = q.getResultList();
            for (Orders ord:oords) {
                MatchOrder mc = emMySQL.find(MatchOrder.class, ord.getIdOrder());
                if (mc == null) {
                    crearPedido(ord,shop);
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
    }
    
    public void crearPedido(Orders ord, int shop)  {
        /*try {
            //ok ..... fer altre usuari ?  
            //String usuario = "SUPERVISOR#PILAR # FEINES";
            String usuario = "AUTO#PRESTASHOP";
            int envCli =1;
            String cli = buscaClient(ord.getIdCustomer());
            String numero = buscaSegNumero();
            int bucles = 10 - numero.length();
            String finalNum = "";
            for (int i = 0; i<bucles; i++) {
                finalNum += " ";
            }
            finalNum += numero;
            Vendedor vn = null;
            vn = emSQLServer.find(Vendedor.class, venedor);
            if (vn == null) {
                vn = new Vendedor(venedor,"PRESTASHOP");
                emSQLServer.getTransaction().begin();
                emSQLServer.persist(vn);
                emSQLServer.getTransaction().commit();
            }
            Pedido p = new Pedido(usuario,empresa, finalNum,letra,envCli,cli,ord.getTotalPaid(),
                        ord.getTotalProducts(),fpago,ord.getTotalPaid(),almacen);
            p.setVendedor(vn.getCodigo());
            emSQLServer.getTransaction().begin();
            emSQLServer.persist(p);
            emSQLServer.getTransaction().commit();
            
            Query qd;
            qd = emMySQL.createQuery("select p from OrderDetail p where idOrder=" + ord.getIdOrder());
            List<OrderDetail> orderd = qd.getResultList();
            int i = 1;
            for (OrderDetail od: orderd) {
                
                System.out.println("\t" + od);
                String art = buscaArticulo(od.getProductId());
                String familia = buscaFamilia(od.getProductId());
                
                Articulo a = emSQLServer.find(Articulo.class, art);
                
                if (familia==null) {
                    familia = " ";
                }
                //String usuario, String empresa, String numero, int linea, 
                //String articulo, String definicion, BigDecimal unidades, 
                //BigDecimal precio, BigDecimal importe, String cliente, 
                //BigDecimal importeIva, String familia) 
                PedidoLinea pl = new PedidoLinea (usuario, empresa, p.getNumero(),i,art,a.getNombre() ,
                            BigDecimal.valueOf(od.getProductQuantity()),od.getProductPrice(),od.getTotalPriceTaxExcl(),p.getCliente(),od.getTotalPriceTaxExcl(),familia);
                
                emSQLServer.getTransaction().begin();
                emSQLServer.persist(pl);
                emSQLServer.getTransaction().commit();
                i++;
                
            }
            MatchOrder mo = new MatchOrder(ord.getIdOrder(),p.getEmpresa(),p.getNumero(),p.getLetra());
            emMySQL.getTransaction().begin();
            emMySQL.persist(mo);
            emMySQL.getTransaction().commit();
            
            
            
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } */
    }
    
    
    private String buscaClient(int idCustomer) {
        try  {
            Query q = emMySQL.createQuery("select p.idEuro from MatchCustomer p where idPresta = " + idCustomer);
            String m = (String)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            return null;
        }
        
    }

    private String buscaSegNumero() {
        try {
            Query q = emSQLServer.createQuery("select max(numero)  from Pedido p ");
            String m = (String)q.getSingleResult();
            int n = Integer.parseInt(m.trim()) + 1 ;
            return n+"";
        }
        catch(Exception ex) {
            return null;
        }
        
    }

    private String buscaArticulo(int productId) {
        try  {
            Query q = emMySQL.createQuery("select p.idEuro from MatchProduct p where p.idPresta = " + productId);
            String m = (String)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
            return null;
        }
        
    }

    private String buscaFamilia(int productId) {
        try  {
            String qss = "select p.idCategoryDefault from Product p where p.idProducte = " + productId;
            Query q = emMySQL.createQuery(qss);
            int m = (int)q.getSingleResult();
            
            Category cat = emMySQL.find(Category.class, m);
            if (cat.getIdParent() != 2){
                Category pare = emMySQL.find(Category.class, cat.getIdParent());
                while (pare.getIdParent()!=2) {
                    pare = emMySQL.find(Category.class, pare.getIdParent());
                }
                m = pare.getIdCategory();
            }
            
            
            
            String qsss = "select p.idEuro from MatchCategory p where p.idPresta = " + m;
            Query qs = emMySQL.createQuery(qsss);
            String ms = (String)qs.getSingleResult();
            
            return ms;
        }
        catch(Exception ex) {
            return null;
        }
    }
    
}
