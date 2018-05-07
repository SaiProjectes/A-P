/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.gestortraspas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sai.computers.traspas.TraspasManagerArticulos;
import sai.computers.traspas.TraspasManagerClient;
import sai.computers.traspas.TraspasManagerConexiones;
import sai.computers.traspas.TraspasManagerDescuentos;
import sai.computers.traspas.TraspasManagerFamilies;
import sai.computers.traspas.TraspasManagerMarcas;
import sai.computers.traspas.TraspasManagerProveedores;
import sai.computers.traspas.presta.TraspasManagerOrders;
import sai.persistence.ahora.Articulo;
import sai.persistence.ahora.Familia;

/**
 *
 * @author PROGRAMACIO3
 */
public class GestorTraspas implements IGestioTraspas{
    EntityManagerFactory emfSQLServer;
    EntityManager emSQLServer;
    EntityManagerFactory emfMySQL;
    EntityManager emMySQL;
    private int shop;
    
    private String ip;
    private String bd1;
    private String usr1;
    private String pwd1;
    private String ip2;
    private String bd2;
    private String usr2; 
    private String pwd2;
    private String rutaimg;
    private boolean imatges;
    private boolean comprovacions;
    private String rutaDefecte;
    
    //constructor fake
    public GestorTraspas(int i) {
        i = 0;
    }
    
    /**
     * En el constructor de GestorTraspas se li passen com a paràmetres les diverses opcions que el client pot 
     * configurar des de l'interfície gràfica.
     * Aquests paràmetres són:
     * 
     * @param shop
     * Botiga a on es duu a terme la connexió a Prestashop. Si no es treballa amb múltiples
     * botigues, sempre serà 1. **** acabar de filtrar bé en els mètodes de sota
     * @param ip
     * @param bd1
     * @param usr1
     * @param pwd1
     * @param ip2
     * @param bd2
     * @param usr2
     * @param pwd2
     * Ip's, bases de dades, usuaris d'accés i contrasenyes per a establir correctament la 
     * connexió amb les Bd's de prestashop (sufix 1) i eurowin (sufix 2)
     * @param rutaimg
     * Si s'escau, una ruta relativa o absoluta d'on s'emmagatzemarà les imatges dels productes
     * Hauria de ser la ruta a img/p d'on es trobi el prestashop
     * @param imatges
     * Booleà per indicar si es vol que es traspassin imatges
     * @param comprovacions
     * Booleà per saber si caldrà comprovar les dades modificades o esborrades i actualizar-les
     * @param rutaDefecte
     * En cas que es vulguin traspassar les imatges, i un article no en tingui, es pot
     * indicar en aquesta ruta una imatge per defecte que tindrà el producte en 
     * mostrar-se al prestashop.
     * @throws GestioTraspasException 
     */
    public GestorTraspas(int shop, String ip, String bd1, String usr1, String pwd1, String ip2, String bd2, String usr2, String pwd2, String rutaimg, boolean imatges, boolean comprovacions, String rutaDefecte) throws GestioTraspasException {
        
        
        if (shop <0) {
            throw new GestioTraspasException ();
        }
        
        this.shop = shop;
        this.ip = ip;
        this.bd1 = bd1;
        this.usr1 = usr1;
        this.pwd1 = pwd1;
        this.ip2 = ip2;
        this.bd2 = bd2;
        this.usr2 = usr2;
        this.pwd2 = pwd2;
        this.rutaimg  = rutaimg;
        this.imatges = imatges;
        this.comprovacions = comprovacions;
        this.rutaDefecte = rutaDefecte;
        
        //Creació de les connexions a les BDs mitjançant un HashMap
        // amb les dades proporcionades
        Map<String, String> persistenceMapMySQL = new HashMap<String, String>();
        String urlMySQL = "jdbc:mysql://" +ip + ":3306/" +bd1;
        persistenceMapMySQL.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        persistenceMapMySQL.put("javax.persistence.jdbc.url", urlMySQL);
        persistenceMapMySQL.put("javax.persistence.jdbc.user", usr1);
        persistenceMapMySQL.put("javax.persistence.jdbc.password", pwd1);
        System.out.println("CONNEXIÓ MYSQL: ");
        System.out.println(urlMySQL);
        System.out.println("User: " + usr1 + " --- PWD: " + pwd1);
        System.out.println("_________________________________________________________");
        Map<String, String> persistenceMapSQLServer = new HashMap<String, String>();
        String urlSQLServer = "jdbc:sqlserver://"+ ip2 +":1433;databaseName=" +bd2;
        persistenceMapSQLServer.put("javax.persistence.jdbc.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        persistenceMapSQLServer.put("javax.persistence.jdbc.url", urlSQLServer);
        persistenceMapSQLServer.put("javax.persistence.jdbc.user", usr2);
        persistenceMapSQLServer.put("javax.persistence.jdbc.password", pwd2);
        System.out.println("CONNEXIÓ SQLSERVER: ");
        System.out.println(urlSQLServer);
        System.out.println("User: " + usr2 + " --- PWD: " + pwd2);
        System.out.println("_________________________________________________________");
        
        //prova de la connexió per aconseguir els EntityManager corresponents
        try {
            emfSQLServer = Persistence.createEntityManagerFactory("UP-SQLServer", persistenceMapSQLServer);
            emSQLServer = emfSQLServer.createEntityManager();
            emfMySQL = Persistence.createEntityManagerFactory("UP-MySQL", persistenceMapMySQL);
            emMySQL = emfMySQL.createEntityManager();
            System.out.println("CONNECXIONS ESTABLERTES --------------------------------");
        }
        catch (Exception ex) {
            System.out.println("Exception " + ex);
            throw new GestioTraspasException(ex.toString());
        }
        
    }
    
    /**
     * Mètode que retorna una cadena amb els noms dels clients que han
     * establit connexions a la botiga i el nombre de connexions que
     * consta a la base de dades
     * @return 
     */
    public String getConnexiones() {
        TraspasManagerConexiones tmc = new TraspasManagerConexiones(emMySQL);
        String result = tmc.getConexiones();
        return result;
    }
    
    @Override
    public void actualitzarPedidos(String vendedor) throws GestioTraspasException {
        TraspasManagerOrders tmo = new TraspasManagerOrders(emSQLServer, emMySQL);
        tmo.actualitzarOrders(shop, vendedor);
    }

    @Override
    public void actualitzarArticles() throws GestioTraspasException {
        TraspasManagerArticulos tmm = new TraspasManagerArticulos (emSQLServer, emMySQL);
        tmm.actualitzarArticles(shop, rutaimg, imatges,comprovacions);
        
    }

    @Override
    public void actualitzarClients() throws GestioTraspasException {
        TraspasManagerClient tmm = new TraspasManagerClient (emSQLServer, emMySQL);
        tmm.actualitzarClients(shop,comprovacions);
    }

    @Override
    public void actualitzarProveidors() throws GestioTraspasException {
        TraspasManagerProveedores tmm = new TraspasManagerProveedores (emSQLServer, emMySQL);
        tmm.actualitzarProveedores(shop, comprovacions);
        
    }

    @Override
    public void actualitzarMarques() throws GestioTraspasException {
        TraspasManagerMarcas tmm = new TraspasManagerMarcas (emSQLServer, emMySQL);
        tmm.actualitzarMarques(shop, comprovacions);
    }

    @Override
    public void actualitzarFamilies() throws GestioTraspasException {
        TraspasManagerFamilies tmm = new TraspasManagerFamilies (emSQLServer, emMySQL);
        tmm.actualitzarFamilies(shop,comprovacions);
    }

    @Override
    public void actualitzarSubfamilies() throws GestioTraspasException {
        TraspasManagerFamilies tmm = new TraspasManagerFamilies (emSQLServer, emMySQL);
        //tmm.actualitzarSubfamilies(shop);
    }

    @Override
    public void actualitzarPvps() throws GestioTraspasException {
        
    }

    

    @Override
    public void close() {
        if (emSQLServer != null) {
            emSQLServer.close();
            System.out.println("EntityManager closed");
        }
        if (emfSQLServer != null) {
            emfSQLServer.close();
            System.out.println("EntityManagerFactory closed");
        }
        if (emMySQL != null) {
            emMySQL.close();
            System.out.println("EntityManagerFactory closed");
        }
        if (emfMySQL != null) {
            emfMySQL.close();
            System.out.println("EntityManager closed");
        }
    }

    @Override
    public void actualitzarArticlesFiltrant(String f1a, String f1b, String f2a, String f2b, String f3a, String f3b, String almacen) throws GestioTraspasException {
        int alm = 0;
        try {
            alm = Integer.parseInt(almacen);
        }
        catch (Exception ex) {
            alm = 0;
        }
        
        TraspasManagerArticulos tmm = new TraspasManagerArticulos (emSQLServer, emMySQL);
        tmm.actualitzarArticles(shop, rutaimg, imatges,comprovacions, f1a, f1b,  f2a,  f2b,  f3a,  f3b, rutaDefecte, alm);
    }

    @Override
    public void actualitzarDescomptes() throws GestioTraspasException {
        TraspasManagerDescuentos tmd = new TraspasManagerDescuentos(emSQLServer, emMySQL);
        //tmd.actualitzarDtos(shop, comprovacions);
        //tmd.actualitzarDtosOk(shop, comprovacions);
        tmd.actualitzarDescuentos(shop, comprovacions);
    }

    public List<Familia> getFamilies() {
        TraspasManagerFamilies tmm = new TraspasManagerFamilies (emSQLServer, emMySQL);
        return tmm.getFamilies();
    }

    public List<Articulo> getArticulos(int i) {
        TraspasManagerArticulos tmm = new TraspasManagerArticulos (emSQLServer, emMySQL);
        return tmm.getArticulos(i);
    }

    
    
}
