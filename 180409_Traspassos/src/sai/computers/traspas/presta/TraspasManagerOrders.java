/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas.presta;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sai.computers.traspas.TraspasManagerClient;
import sai.persistence.ahora.Articulo;
import sai.persistence.Category.Category;
import sai.persistence.ahora.Cliente;
import sai.persistence.ahora.Pedido;
import sai.persistence.ahora.PedidoLinea;
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
    
    int dempresa;
    int dempleat;
    int drepr;
    int ddept;
    int dlista;
//    public void iniciarTraspas () {
//        
//        this.transferirOrder(1); //seria bo guardar info en fitxer de propietats
//    }

    
    public TraspasManagerOrders(EntityManager emSQLServer, EntityManager emMySQL) {
        
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
        
        //eliminar  i afegir el tema de parametres en cpaçalera i linies del pedido a l'ahora
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

    public void actualitzarOrders (int shop, String vendedor, String idLista, String idDept, String idEmpresa, String idEmpleat, String idRepr) {
        try {
            venedor = vendedor;
            dlista = Integer.parseInt(idLista);
            ddept = Integer.parseInt(idDept);
            dempleat = Integer.parseInt(idEmpleat);
            dempresa = Integer.parseInt(idEmpresa);
            drepr = Integer.parseInt(idRepr);
            
            
            
            
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
        try {
             //per trobar el seg. id
            /*IF @IdPedido=0 BEGIN
		SELECT @IdPedido=ISNULL(MAX(IdPedido)+1,1) FROM	Pedidos_Cli_Cabecera
            END
            String numero = buscaSegNumero();*/
            
            int nidped = buscaSegNumero();
            if (nidped == -1) {
                nidped = 1;
            }
            Date avui = new Date();
            //empresa definida en CONF
            short idemp;
            
            int anio = avui.getYear();
            
            //ARXIU CONF
            int serie = 1;
            
            Date data = ord.getDateAdd();
            
            //S'ha de cercar el client
            String ncli = buscaClient(ord.getIdCustomer());
            
            if (ncli == null) {
                //s'haurà de crear client
                ncli = creaClient(ord.getIdCustomer());
            }
            
            
            Cliente c = emSQLServer.find(Cliente.class, ncli);
            //S'ha de cerca en SQLSERVER, el que tingui per defecte el client
            int contacte = c.getIdContacto();
            int nlista = dlista; //parametre
            int nempl = dempleat; //parametre
            short ndept = (short) ddept; //parametre
            int nfpago = trobaFormaPagament(ord.getPayment()); //ve de pedido -> s'haurà de gestionar mes endavant, en principi es posara per defecte
            BigDecimal ndes = BigDecimal.ZERO;
            int nrepr = drepr; //parametre
            int niddoc = calculaIdDoc(); //s'ha de calcular
            String nuser = "ahora";
            
            
            
            //S'ha de donar valor a totes les variables per tal que al constructor hi arribin amb algun valor
            //Alguns seran parametres que es definiran a l'arxiu de configuració
            //I d'altres s'hauran de calcular o vindran definits pel prestashop
            
            //int idPedido, Short idEmpresa, Integer anoNum, Integer seriePedido, Integer numPedido, Date fecha, 
            //String idCliente, Integer idContacto, Integer idContactoA, Integer idContactoF, Integer idLista, 
            //Integer idEmpleado, Short idDepartamento, Integer formaPago, BigDecimal descuento,
            //Date fechaSalida, Integer representante, Short eCommerce, Integer idDoc, String usuario,
            //Date fechaInsertUpdate) {
      
            
            Pedido ped = new Pedido(nidped, (short)dempresa, anio, serie, 1, data, ncli, contacte, contacte, contacte,
            nlista, nempl, (short)ndept, nfpago, ndes, data, nrepr, (short)1, niddoc, nuser, avui);
            
            
            emSQLServer.getTransaction().begin();
            emSQLServer.persist(ped);
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
        } 
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

    private int buscaSegNumero() {
        try {
            //SELECT @IdPedido=ISNULL(MAX(IdPedido)+1,1) FROM	Pedidos_Cli_Cabecera
            Query q = emSQLServer.createQuery("select ISNULL(MAX(p.idPedido)+1,1) from Pedido p");
            String m = (String)q.getSingleResult();
            int n = Integer.parseInt(m.trim()) + 1 ;
            return n;
        }
        catch(Exception ex) {
            return -1;
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

    private int CalculaSegPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int trobaFormaPagament(String payment) {
        //per parametres i segons què hi hagi donat d'alta en el prestashop
        return 27; //actualment és targeta(27)
    }

    private int calculaIdDoc() {
        try {
            //SELECT @IdPedido=ISNULL(MAX(IdPedido)+1,1) FROM	Pedidos_Cli_Cabecera
            Query q = emSQLServer.createQuery("select ISNULL(MAX(p.idDoc)+1,1) from Pedido p");
            String m = (String)q.getSingleResult();
            int n = Integer.parseInt(m.trim());
            return n;
        }
        catch(Exception ex) {
            return -1;
        }
    }

    private String creaClient(int idCustomer) {
        try {
            TraspasManagerClient tmc = new TraspasManagerClient(emSQLServer, emMySQL);
            return tmc.creaClient(idCustomer);
        }
        catch (Exception ex) {
            return "";
        }
    }
    
}
