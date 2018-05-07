/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.traspas;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.commons.io.FileUtils;
import sai.persistence.ahora.Articulo;
import sai.persistence.Category.CategoryLang;
import sai.persistence.Category.CategoryProduct;
import sai.persistence.Manufacturer;
import sai.persistence.ahora.Configuracion;
import sai.persistence.ahora.ListaPrecioArt;
import sai.persistence.ahora.ObjetoImagen;
import sai.persistence.ahora.ReferenciaProveedor;
import sai.persistence.ahora.Stock;
import sai.persistence.comprovacio.ConArticulos;
import sai.persistence.matches.MatchCategory;
import sai.persistence.matches.MatchManufacturer;
import sai.persistence.matches.MatchProduct;
import sai.persistence.matches.MatchSupplier;
import sai.persistence.product.Accessory;
import sai.persistence.product.Image;
import sai.persistence.product.ImageLang;
import sai.persistence.product.ImageShop;
import sai.persistence.product.Product;
import sai.persistence.product.ProductLang;
import sai.persistence.product.ProductShop;
import sai.persistence.product.ProductSupplier;
import sai.persistence.product.StockAvailable;
import sai.persistence.tag.ProductTag;
import sai.persistence.tag.Tag;
import sai.persistence.tag.TagCount;

/**
 *
 * @author PROGRAMACIO3
 */
public class TraspasManagerArticulos {
    EntityManager emSQLServer;
    EntityManager emMySQL;
    private String rutaImg;
    private boolean ambImatges;
    private boolean comprovacions;
    private String rutaDefecte;
    private String rutaImgs;
    private int almacen;

    public TraspasManagerArticulos(EntityManager emSQLServer, EntityManager emMySQL) {
        this.emSQLServer = emSQLServer;
        this.emMySQL = emMySQL;
        this.rutaDefecte = "";
        
    }
    public void iniciarTraspas () {
        this.transferirArticles(1);
    }

    private void transferirArticles(int shop){
        String up = "UP-SQLServer";
        String sdelete = "(";
        try {
            //Recorregut sobre les marques, per cada una d'elles, creem
            //l'equivalen per a la BD de MySQL
            Query q = emSQLServer.createQuery("select p from Articulo p");
            List<Articulo> articulos = q.getResultList();
            for (Articulo art:articulos) {
                /*MatchProduct mp = emMySQL.find(MatchProduct.class, art.getCodigo().trim());
                if (mp==null) {
                    crearArticle(art,shop);
                }
                if (mp!=null && comprovacions) {
                    checkArticle(art,mp);
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }*/
                System.out.println(art);
            }
            if (comprovacions && sdelete.length()>2) {
                //comrpovar
                /*sdelete += ")";
               
                String qryDel = "delete from MatchProduct where idPresta not in " + sdelete;
                String qryDel1 = "delete from Product where idProduct not in " + sdelete;
                String qryDel2 = "delete from ProductSupplier where idProduct not in " + sdelete;
                String qryDel3 = "delete from ProductTag where idProduct not in " + sdelete;
                String qryDel4 = "delete from ProductLang where idProduct not in " + sdelete;
                String qryDel5 = "delete from ProductShop where idProduct not in " + sdelete;
                String qryDel6 = "delete from CategoryProduct where idProduct not in " + sdelete;
                String qryDel7 = "delete from StockAvailable where idProduct not in " + sdelete;
                String qryDel8 = "delete from Image where idProduct not in " + sdelete;
                String qryDel9 = "delete from ImageShop where idProduct not in " + sdelete;
                
                
                emMySQL.getTransaction().begin();
                
                Query qm = emMySQL.createQuery(qryDel);
                Query q1 = emMySQL.createQuery(qryDel1);
                Query q2 = emMySQL.createQuery(qryDel2);
                Query q3 = emMySQL.createQuery(qryDel3);
                Query q4 = emMySQL.createQuery(qryDel4);
                Query q5 = emMySQL.createQuery(qryDel5);
                Query q6 = emMySQL.createQuery(qryDel6);
                Query q7 = emMySQL.createQuery(qryDel7);
                Query q8 = emMySQL.createQuery(qryDel8);
                Query q9 = emMySQL.createQuery(qryDel9);
                
                int i = qm.executeUpdate();
                System.out.println("Deleted qm: " + i);
                i = q1.executeUpdate();
                System.out.println("Deleted q1: " + i);
                i = q2.executeUpdate();
                System.out.println("Deleted q2: " + i);
                i = q3.executeUpdate();
                System.out.println("Deleted q3: " + i);
                i = q4.executeUpdate();
                System.out.println("Deleted q4: " + i);
                i = q5.executeUpdate();
                System.out.println("Deleted q5: " + i);
                i = q6.executeUpdate();
                System.out.println("Deleted q6: " + i);
                i = q7.executeUpdate();
                System.out.println("Deleted q7: " + i);
                i = q8.executeUpdate();
                System.out.println("Deleted q8: " + i);
                i = q9.executeUpdate();
                System.out.println("Deleted q9: " + i);
                
                emMySQL.getTransaction().commit();*/
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
    }
    
    public void actualitzarArticles(int shop, String rutaImg, boolean ambImatges, boolean comprovacions) {
        /*this.rutaImg = rutaImg;
        this.ambImatges = ambImatges;
        this.comprovacions = comprovacions;
        String sdelete = "(";
        
        try {
            Query q;
            if (comprovacions) {
                q = emSQLServer.createQuery("select p from Articulo p where internet = 1");
            }
            else {
                q = emSQLServer.createQuery("select p from Articulo p where internet = 1 and p.estado = 0");
            }
            
            List<Articulo> articulos = q.getResultList();
            int cont = 0;
            for (Articulo art:articulos) {
                MatchProduct mp = emMySQL.find(MatchProduct.class, art.getCodigo().trim());
//                System.out.println("Article: " + art.getCodigo().trim() + " -  "+ art.getNombre().trim());
//                System.out.println(mp==null?"NO EXISTEIX":"SI EXISTEIX");
                if (mp==null) {
                    crearArticle(art,shop);
                    emSQLServer.getTransaction().begin();
                    art.setEstado(1);
                    emSQLServer.persist(art);
                    emSQLServer.getTransaction().commit();
                }
                if (mp!=null && comprovacions) {
                    checkArticle(art,mp);
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                cont++;
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                System.out.println("ACTUALITZATS: " + cont + " ---------- ");
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
            
            
            
            
            System.out.println("ACTUALITZATS: " + cont + " ---------- ");
            if (comprovacions && sdelete.length()>2) {
                //comrpovar
                sdelete += ")";
               
                String qryDel = "delete from MatchProduct where idPresta not in " + sdelete;
                String qryDel1 = "delete from Product where idProducte not in " + sdelete;
                String qryDel2 = "delete from ProductSupplier where idProduct not in " + sdelete;
                String qryDel3 = "delete from ProductTag where idProduct not in " + sdelete;
                String qryDel4 = "delete from ProductLang where idProduct not in " + sdelete;
                String qryDel5 = "delete from ProductShop where idProducte not in " + sdelete;
                String qryDel6 = "delete from CategoryProduct where idProduct not in " + sdelete;
                String qryDel7 = "delete from StockAvailable where idProduct not in " + sdelete;
                String qryDel8 = "delete from Image where idProduct not in " + sdelete;
                String qryDel9 = "delete from ImageShop where idProduct not in " + sdelete;
                
                
                emMySQL.getTransaction().begin();
                
                Query qm = emMySQL.createQuery(qryDel);
                Query q1 = emMySQL.createQuery(qryDel1);
                Query q2 = emMySQL.createQuery(qryDel2);
                Query q3 = emMySQL.createQuery(qryDel3);
                Query q4 = emMySQL.createQuery(qryDel4);
                Query q5 = emMySQL.createQuery(qryDel5);
                Query q6 = emMySQL.createQuery(qryDel6);
                Query q7 = emMySQL.createQuery(qryDel7);
                Query q8 = emMySQL.createQuery(qryDel8);
                Query q9 = emMySQL.createQuery(qryDel9);
                
                int i = qm.executeUpdate();
                System.out.println("Deleted qm: " + i);
                i = q1.executeUpdate();
                System.out.println("Deleted q1: " + i);
                i = q2.executeUpdate();
                System.out.println("Deleted q2: " + i);
                i = q3.executeUpdate();
                System.out.println("Deleted q3: " + i);
                i = q4.executeUpdate();
                System.out.println("Deleted q4: " + i);
                i = q5.executeUpdate();
                System.out.println("Deleted q5: " + i);
                i = q6.executeUpdate();
                System.out.println("Deleted q6: " + i);
                i = q7.executeUpdate();
                System.out.println("Deleted q7: " + i);
                i = q8.executeUpdate();
                System.out.println("Deleted q8: " + i);
                i = q9.executeUpdate();
                System.out.println("Deleted q9: " + i);
                
                
                
                emMySQL.getTransaction().commit();
                
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } */
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
    private void crearArticle(Articulo art, int shop) {
        try {
            Date now = new Date();
            int codi = maxIdArticle() +1;
            if (codi == -1  || codi == 0) {
                //No existeix encara cap article, posem codi 1
                codi = 1;
            }
            
            //trobaManufacturer busca la marca si està traspassada, i si no és així la crea
            int idManufacturer = trobaManufacturer(art.getIdMarcaArticulo(), shop);
            if (idManufacturer == -1) {
                //posar marca x defecte
                idManufacturer = 1;
            }
            int idCategory;
            //buscar la categoria en el prestashop
            idCategory = trobaCategory(art.getIdFamilia(),shop);
            if (idCategory < 0) {
                //posarem una categoria per defecte
                idCategory=2;
            }
            
            
            List<ReferenciaProveedor> ref  = trobaRefProv(art.getIdArticulo());
            BigDecimal pvp = trobaPvp(art.getIdArticulo(),0);
            if (pvp == null || pvp.equals(BigDecimal.ZERO)) {
                pvp = BigDecimal.ZERO;
            }
            String first;
            if (ref == null || ref.size() == 0) {
                first = "none";
                ref = null;
            }
            else {
                first = ref.get(0).getArticulo().trim();
            }
            Product p = new Product(codi,0,idManufacturer,idCategory,1,pvp,BigDecimal.ZERO,first);
            
            
            emMySQL.getTransaction().begin();
            emMySQL.persist(p);
            
            
            
            
            
            String srefs = "";
            if (ref != null) {
                
                
                for (ReferenciaProveedor sr : ref) {
                    srefs += sr.getArticulo().trim() + " ";
                    String refFilt = sr.getArticulo().trim();
                    int codiProdSup = maxIdProductSupplier() +1;
                    
                    if (codiProdSup == -1  || codiProdSup == 0) {
                        codiProdSup = 1;
                    }
                    
                    int idProv = trobaProv(sr.getIdProveidor().trim());
                    if (idProv == -1) {
                        idProv = 1;
                    }
                    ProductSupplier pss = new ProductSupplier(codiProdSup,p.getIdProducte(),0,idProv,refFilt,BigDecimal.ZERO,1);
                    emMySQL.persist(pss);
                    
                    
                    
                    String ref1 = Normalizer.normalize(refFilt, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                    ref1 = ref1.replaceAll("[^a-zA-Z0-9]", "");
                    refFilt = ref1;
                    
                    
                    int tagid = tagExist(refFilt);
                    
                    if (tagid>0) {
                        //tag existeix
                        ProductTag ptgm = null;
                        try {
                            
                            String qry = "SELECT c from ProductTag c where idProduct =" + p.getIdProducte()+ " and idTag = " + tagid;
                            Query qm = emMySQL.createQuery(qry);
                            ptgm = (ProductTag)qm.getSingleResult();
                            
                        }
                        catch(Exception ex) {
//                            System.out.println("Algun error, repe ---------------------------------");
                        }
                        if (ptgm == null) {
                                ProductTag ptag = new ProductTag(p.getIdProducte(),tagid,1);
                                emMySQL.persist(ptag);

//                                Query q = emMySQL.createQuery("update TagCount tc\n" +
//                                                            " set tc.counter = (select COUNT(pt.idProduct)\n" +
//                                                            " from ProductTag pt\n" +
//                                                            " where pt.idTag = tc.idTag)");
//                                int res = q.executeUpdate();
//                                System.out.println("RESULTATS EN UPDATE: " + res + "   ---------------------------");
                        }
                        
                    }
                    if (tagid==-1) {
                        //no existeix, creem un de nou
                        int codiTag = maxIdTag() +1;
                        if (codiTag == 0 || codiTag==-1) {
                            codiTag = 1;
                        }
                        Tag tag = new Tag(codiTag,1,refFilt);
                        emMySQL.persist(tag);
                        ProductTag ptag = new ProductTag(p.getIdProducte(),codiTag,1);
                        emMySQL.persist(ptag);
                        //hem de crear un tag_count nou
                        for(int i = 0; i<4; i++) {
                            //int idGroup, int idTag, int idLang, int idShop, int counter
                            TagCount tgc = new TagCount(i,codiTag,1,shop,1);
                            emMySQL.persist(tgc);
                        }
                    }
                    
                }
                
            }
            
            
            String nom = art.getDescrip().trim();
            if (nom.length()>127) {
                nom = nom.substring(0,125);
            }
            
            String nomNop = Normalizer.normalize(nom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            
            String s = nomNop.replaceAll("[^a-zA-Z0-9]", "");
            
            for (int i=1;i<5;i++) {
                ProductLang pl = new ProductLang(p.getIdProducte(),shop,i, "<p> "+art.getDescrip().trim()+ " </p>",s,s,"","","",nom,"En stock","");
               
                pl.setDescriptionShort("<p>" +art.geteDescripCorta()+ "</p>");
                pl.setDescription(art.geteDescrip());
                pl.setMetaTitle(art.geteMetaTitulo());
                pl.setMetaDescription(art.geteMetaDescripcion());
                pl.setMetaKeywords(art.geteMetaKeywords());
                emMySQL.persist(pl);
            }

            ProductShop psh = new ProductShop (p.getIdProducte(), shop, p.getIdCategoryDefault(),p.getPrice(),p.getWholesalePrice());
            
            emMySQL.persist(psh);
            
            String ruta = null;
            boolean isFile;
            String path = trobaPath(art.getIdDoc());
            if (path == null || path.trim().equals("")) {
                isFile = false;
            }
            
            try  {
                if (path != null && path.length()>0) {
                    path = rutaImgs + "\\" + path;
                }
                File fpr = new File(path);
                isFile = fpr.isFile();
                ruta = path;
            }
            catch(Exception ex){
                isFile = false;
            }
            if (!isFile && ambImatges) {
                /*try  {
                    File fpr = new File(rutaDefecte);
                    isFile = fpr.isFile();
                    ruta = rutaDefecte;
                }
                catch(Exception ex){
                    isFile = false;
                }*/
            }
            if (ambImatges  && isFile) {
                try {
                    
                    String desti = rutaImg + "\\p";
                    //desglossar id del producte per fer la ruta de la imatge
                    //ex, id 234 ha d'anar a \\img\\p\\2\\3\\4\\234.jpg
                    String num = ""+p.getIdProducte();
                    for(int j = 0; j<num.length();j++) {
                        desti+= "\\" + num.charAt(j);
                    }
                    String destiImg = desti + "\\" + p.getIdProducte() + ".jpg";
                    //desti += p.getIdProducte() + ".jpg";
                    
                    File file = new File(ruta);
                    File destinationDir = new File(destiImg);
                    //utilitzant Apache IOCommons
                    FileUtils.copyFile(file, destinationDir);

                    file = new File(rutaImg+"\\p\\index.php");

                    
                    destinationDir = new File(desti);
                    //utilitzant Apache IOCommons
                    FileUtils.copyFileToDirectory(file, destinationDir);

                    file = new File(rutaImg+"\\p\\fileType");

                    destinationDir = new File(desti);
                    //utilitzant Apache IOCommons
                    
                    FileUtils.copyFileToDirectory(file, destinationDir);

                    int codiImatge = maxIdImatge() +1;

                    if (codiImatge==-1 || codiImatge == 0) {
                        codiImatge = 1;
                    }

                    Image im = new Image(codiImatge, p.getIdProducte(),(short)1,(short)1);
                    ImageShop ims = new ImageShop(p.getIdProducte(), codiImatge,shop,(short)1);
                    emMySQL.persist(im);
                    emMySQL.persist(ims);

                    for (int i = 1;i<5; i++) {
                        ImageLang iml = new ImageLang(codi,i,nomNop);
                        emMySQL.persist(iml);
                    }

                }
                catch(Exception e) {
//                    System.out.println(e);
                    int m = 0;
                }
            }
            
            
            
//            emMySQL.persist(psp);
            MatchProduct match = new MatchProduct(art.getIdArticulo().trim(),p.getIdProducte());
            emMySQL.persist(match);
            
            //tot ok en Ahora, defecte només en prestashop.
            if (p.getIdCategoryDefault() != 2) {
                int posicio = buscaPosicio(p.getIdCategoryDefault()) + 1;
                CategoryProduct cp = new CategoryProduct (p.getIdCategoryDefault(), p.getIdProducte(),posicio);
                emMySQL.persist(cp);
            
            }
            int posicio2 = buscaPosicio(2) + 1;
            CategoryProduct cp2 = new CategoryProduct (2, p.getIdProducte(),posicio2);
            
            emMySQL.persist(cp2);
            int idStock = maxIdStockAvailable() +1;
            int stockdisponible = trobaStockArticle(art.getIdArticulo().trim());
            if (stockdisponible < 0) {
                stockdisponible = 0;
            }
            
            StockAvailable sa = new StockAvailable(idStock,p.getIdProducte(),0,shop,0,stockdisponible);
            emMySQL.persist(sa);
            emMySQL.getTransaction().commit();
            
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
        }
    }
    
    private int maxIdArticle () {
        try {
            Query q = emMySQL.createQuery("select max(p.idProducte) from Product p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    private boolean addArticle(Articulo m, int shop) {
        try {
            crearArticle(m,shop);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }
    
    public boolean newArticle(String id, int shop){
        try {
            Articulo m = emSQLServer.find(Articulo.class, id.trim());
            return addArticle(m,shop);
        }
        catch(Exception ex) {
            return false;
        }
    }

    private int maxIdProductAtribut() {
        try {
            Query q = emMySQL.createQuery("select max(p.idProductAttribute) from ProductAttribute p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int maxIdAtribut() {
        try {
            Query q = emMySQL.createQuery("select max(p.idAttribute) from Attribute p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int trobaManufacturer(Integer marca, int shop) {
        //Podria ser que aquest article no tingui cap marca assignada
        //Si és així, directament no es torna cap marca
        if (marca == null) {
            return -1;
        }
        try {
            //tenir en compte que la marca (existent en eurowin) és donés el cas que no existís encara en prestashop
            MatchManufacturer manu = emMySQL.find(MatchManufacturer.class, marca);
            if (manu == null) {
                //Creació de la marca en prestashop
                TraspasManagerMarcas tmm = new TraspasManagerMarcas(emSQLServer, emMySQL);
                return tmm.newMarca(marca, shop);
            }
            else {
                return manu.getIdPresta();
            }
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int trobaCategory(String familia, int shop) {
        
        if (familia.trim().equals("")) {
            return -1;
        }
        try {
            MatchCategory manu = emMySQL.find(MatchCategory.class, familia);
            if (manu == null) {
                TraspasManagerFamilies tmf = new TraspasManagerFamilies(emSQLServer,emMySQL);
//                tmf.actualitzarFamilies(shop, false);
                int idfam = tmf.creaCate(familia.trim());
                return idfam;
            }
            else {
                return manu.getIdPresta();
            }
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

   

    private BigDecimal trobaPvp(String codigo, int codiPreu) {
        try {
            //9/4/18
            String qs = "select p from ListaPrecioArt p where p.idLista = " + codiPreu + " and p.idArticulo = '" + codigo + "'";
            Query q = emSQLServer.createQuery(qs);
            ListaPrecioArt m = (ListaPrecioArt)q.getSingleResult();
            return m.getPrecio();
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return null;
        }
    }

    private int maxIdProductSupplier() {
        try {
            Query q = emMySQL.createQuery("select max(p.idProductSupplier) from ProductSupplier p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int buscaPosicio(int cat) {
        try {
            String qs = "select max(position) from CategoryProduct where idCategory = " + cat;
            Query q = emMySQL.createQuery(qs);
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int maxIdStockAvailable() {
        try {
            Query q = emMySQL.createQuery("select max(p.idStockAvailable) from StockAvailable p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int maxIdImatge() {
        try {
            Query q = emMySQL.createQuery("select max(p.idImage) from Image p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int trobaProv(String proveidor) {
        try {
            String qs = "select p.idPresta from MatchSupplier p where p.idEuro like " + proveidor;
            Query q = emMySQL.createQuery(qs);
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int maxIdTag() {
        try {
            Query q = emMySQL.createQuery("select max(p.idTag) from Tag p");
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private int tagExist(String tag) {
        try {
            String query = "select p.idTag from Tag p where p.name like '"+ tag+ "'";
            Query q = emMySQL.createQuery(query);
            int m = (int)q.getSingleResult();
            return m;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private void checkArticle(Articulo art, MatchProduct mp) {
        /*
        //buscar supplier
        Product prod = emMySQL.find(Product.class, mp.getIdPresta());
        
        //nom (lang)
        String qry = "select p from ProductLang p where p.idProduct = "+ mp.getIdPresta() + " and p.idLang = 1";
        Query q;
        q = emMySQL.createQuery(qry);
        ProductLang pl = (ProductLang) q.getSingleResult();
        
        
        //comprovacio nom
        
        String nombre = art.getNombre().trim();
        if (!nombre.equals(pl.getName())) {
            String nom = nombre;
            if (nom.length()>127) {
                nom = nom.substring(0,125);
            }
            String nomNop = Normalizer.normalize(nom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replace(" ", "-");
            
            emMySQL.getTransaction().begin();
            String alt;
            String query = "update ProductLang s\n" +
                                            " set s.description = '<p>" + nombre+"</p>'" +
                                            " , s.name = '" + nom+"'" +
                                            " , s.linkRewrite = '"+ nomNop+"'" +
                                            " where s.idProduct = " + mp.getIdPresta();
            Query qm = emMySQL.createQuery(query);
            int res = qm.executeUpdate();
//            System.out.println("Updated ProductLang: " + res);
            emMySQL.getTransaction().commit();
        }
        
        //comprovacio price
        //pvp (prod) -> (shop)
        BigDecimal pvp = trobaPvp(art.getCodigo());
        if (!pvp.equals(prod.getPrice())) {
            String qrycat = "select p from ProductShop p where idProducte = " + mp.getIdPresta() + " and idShop = 1";
            Query qm = emMySQL.createQuery(qrycat);
            ProductShop psh =  (ProductShop) qm.getSingleResult();
//            System.out.println("PVP:  " + pvp);
//            System.out.println("PRICE:  "+ prod.getPrice());
            emMySQL.getTransaction().begin();
            prod.setPrice(pvp);
            psh.setPrice(pvp);
            emMySQL.persist(prod);
            emMySQL.persist(psh);
            emMySQL.getTransaction().commit();
        }
        
        
        // ref prov BUCLE ProductSupplier, ProductTag
        //per cada ref comprovar prov i la seva ref a ProductSupplier
        //si no es aixi, afegir-lo
        
        List<ReferenciaProveedor> ref  = trobaRefProv(art.getCodigo());
        for(ReferenciaProveedor rp: ref) {
            String refere = rp.getReferencia().trim();
            String prov  = rp.getProveedor();
            int idProv = trobaProv(prov);
            boolean exs1 = existeixRef(mp.getIdPresta(),idProv,refere);
            if (!exs1) {

                emMySQL.getTransaction().begin();
                
                int codiProdSup = maxIdProductSupplier() +1;
                if (codiProdSup == -1  || codiProdSup == 0) {
                    codiProdSup = 1;
                }
                ProductSupplier pss = new ProductSupplier(codiProdSup,mp.getIdPresta(),0,idProv,refere,BigDecimal.ZERO,1);
                 emMySQL.persist(pss);
                int tagid = tagExist(refere);
                if (tagid>0) {
                    //tag existeix
                    ProductTag ptgm = null;
                    try {

                        String qrya = "SELECT c from ProductTag c where idProduct =" + mp.getIdPresta()+ " and idTag = " + tagid;
                        Query qm = emMySQL.createQuery(qrya);
                        ptgm = (ProductTag)qm.getSingleResult();

                    }
                    catch(Exception ex) {
//                        System.out.println("Algun error, repe ---------------------------------");
                    }
                    if (ptgm == null) {
                        ProductTag ptag = new ProductTag(mp.getIdPresta(),tagid,1);
                        emMySQL.persist(ptag);
                        Query qc = emMySQL.createQuery("update TagCount tc\n" +
                                                                " set tc.counter = (select COUNT(pt.idProduct)\n" +
                                                                " from ProductTag pt\n" +
                                                                " where pt.idTag = tc.idTag)");
                        int res = qc.executeUpdate();
//                        System.out.println("RESULTATS EN UPDATE: " + res + "   ---------------------------");
                    }
                }
                if (tagid==-1) {
                    //no existeix, creem un de nou
                    int codiTag = maxIdTag() +1;
                    if (codiTag == 0 || codiTag==-1) {
                        codiTag = 1;
                    }
                    Tag tag = new Tag(codiTag,1,refere);
                    emMySQL.persist(tag);
                    ProductTag ptag = new ProductTag(mp.getIdPresta(),codiTag,1);
                    emMySQL.persist(ptag);
                    //hem de crear un tag_count nou
                    for(int i = 0; i<4; i++) {
                        //int idGroup, int idTag, int idLang, int idShop, int counter
                        TagCount tgc = new TagCount(i,codiTag,1,1,1);
                        emMySQL.persist(tgc);
                    }
                }
                emMySQL.getTransaction().commit();
            }
        }
        
        //category BUCLE -> subfamilia CategoryProduct, Product
        //necessitem match amr ART
        //I COMPROVAR si aquest match existeix en CategoryProduct, sino eliminar tots de Category Product
        //i entrar aquest.
        String subfamilia = art.getSubfamilia().trim();
        int idCategory = trobaCategory(subfamilia,1);
        boolean exist = existeixCatProd(mp.getIdPresta(),idCategory);
        if (!exist) {
            
            emMySQL.getTransaction().begin();
            String deletes = "delete from CategoryProduct where idProduct = " + mp.getIdPresta() + " and idCategory>2";
            Query qm = emMySQL.createQuery(deletes);
            int res = qm.executeUpdate();
//            System.out.println("Deleted CategoryProduct: " + res);
            
            int pos = buscaPosicio(idCategory) + 1;
            CategoryProduct cp = new CategoryProduct(idCategory,mp.getIdPresta(),pos);
            emMySQL.persist(cp);
            
            emMySQL.getTransaction().commit();
        }
        
        
        //marca Product
        String marca = art.getMarca().trim();
        if (!marca.equals("")) {
           int idManufacturer = trobaManufacturer(marca, 1);
            if (idManufacturer != prod.getIdManufacturer()) {
                emMySQL.getTransaction().begin();
                prod.setIdManufacturer(idManufacturer);
                emMySQL.persist(prod);
                emMySQL.getTransaction().commit();
            } 
        }
        
        
        //imatge Image, ImageShop ... nomes caldria canvi de foto (?)
        */
    }

    private boolean existeixCatProd(int idPresta, int idCategory) {
        try {
            String qrycat = "select p from CategoryProduct p where p.idProduct = " + idPresta + " and p.idCategory = "+idCategory;
            Query q = emMySQL.createQuery(qrycat);
            CategoryProduct cp =  (CategoryProduct)q.getSingleResult();
            return true;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return false;
        }
        
    }

    private boolean existeixRef(int idPresta, int idProv, String refere) {
        try {
            String qrycat = "select p from ProductSupplier p where idProduct = " + idPresta + " and idSupplier = "+idProv;
            Query q = emMySQL.createQuery(qrycat);
            ProductSupplier cp =  (ProductSupplier) q.getSingleResult();
            return true;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return false;
        }
    }

    
    
    public void actualitzarArticles(int shop, String rutaimg, boolean imatges, boolean comprovacions, String f1a, String f1b, String f2a, String f2b, String f3a, String f3b, String rutaDefecte, int almacen) {
        try {
            String queryC = "select p from Articulo p where p.eActivo = 1";
            Query q;
            q = emSQLServer.createQuery(queryC);
            List<Articulo> articulos = q.getResultList();
            for (Articulo art:articulos) {
                System.out.println(art);
                
                
                
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        boolean f1, f2, f3;
        f1 = f1a.trim().length()>0 || f1b.trim().length()>0;
        f2 = f2a.trim().length()>0 || f2b.trim().length()>0;
        f3 = f3a.trim().length()>0 || f3b.trim().length()>0;
        
        String up = "UP-SQLServer";
        this.rutaImg = rutaimg;
        this.ambImatges = imatges;
        this.comprovacions = comprovacions;
        this.rutaDefecte = rutaDefecte;
        this.almacen = almacen;
        
        
        
        
        try {
            String queryC = "select p from Articulo p where p.eActivo = 1";
            Query q;
            q = emSQLServer.createQuery(queryC);
            
            //agafariem la ruta de les imatges definides per l'Ahora
            
            String sqlruta = "select u from Configuracion u where u.parametro = 'PATHIMAGENES'";
            Query qruta = emSQLServer.createQuery(sqlruta);
            Configuracion cnf = (Configuracion) qruta.getSingleResult();
            rutaImgs = cnf.getValor();
            
            List<Articulo> articulos = q.getResultList();
            int cont = 0;
            int contnou = 0;
            for (Articulo art:articulos) {
                MatchProduct mp = emMySQL.find(MatchProduct.class, art.getIdArticulo().trim());
//                System.out.println("Article: " + art.getCodigo().trim() + " -  "+ art.getNombre().trim());
//                System.out.println(mp==null?"NO EXISTEIX":"SI EXISTEIX");
                if (mp==null) {
                    crearArticle(art,shop);
                    /*emSQLServer.getTransaction().begin();
                    art.setEstado(1);
                    emSQLServer.persist(art);
                    emSQLServer.getTransaction().commit();*/
                    
                    /*emSQLServer.getTransaction().begin();
                    String deleteCon = "delete from ConArticulos where codigo = '" + art.getCodigo().trim()+"'";
                    Query dCon = emSQLServer.createQuery(deleteCon);
                    int result = dCon.executeUpdate();
                    emSQLServer.getTransaction().commit();*/
                    
                    contnou ++;
                    
                }
                cont++;
            }
            System.out.println("ACTUALITZATS: " + cont + " ---------- ");
            System.out.println("CREATS: " + contnou + " ---------- ");
//            actualitzarRelatedProducts();
            if (comprovacions) {
                //comprovarArticles();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.print(ex.getCause() != null ? "Caused by:" + ex.getCause().getMessage() + "\n" : "");
            System.out.println("Traça:");
            ex.printStackTrace();
        } 
        
    }

    private void comprovarArticles() {
        String sdelete = "(";
        
        String query = "select p from ConArticulos p";
        Query qc = emSQLServer.createQuery(query);
        List<ConArticulos> conections = qc.getResultList();
        String scodis = "(";
        
        for (ConArticulos cart:conections) {
            MatchProduct mp = emMySQL.find(MatchProduct.class, cart.getCodigo().trim());
            if (mp!=null) {
                if (cart.getAccio() == 2) {
                    if (sdelete.length()>1) {
                        sdelete += ", " + mp.getIdPresta();
                    }
                    else {
                        sdelete += mp.getIdPresta() +"";
                    }
                }
                if (cart.getAccio() == 1) {
                    Articulo article = emSQLServer.find(Articulo.class, cart.getCodigo());
                    if (article!= null) {
                        checkArticle(article,mp);
                    }
                    if (scodis.length()>2) {
                        scodis += ", '" + cart.getCodigo().trim()+ "'";
                    }
                    else {
                        scodis += " '" + cart.getCodigo().trim() +"";
                    }
                }
            }
            emSQLServer.getTransaction().begin();
            emSQLServer.remove(cart);
            emSQLServer.getTransaction().commit();
            
        }
        scodis += ")";
        
        sdelete += ")";
       
        if (sdelete.length()>2) {
            String qryDel = "delete from MatchProduct where idPresta  in " + sdelete;
            String qryDel1 = "delete from Product where idProducte  in " + sdelete;
            String qryDel2 = "delete from ProductSupplier where idProduct  in " + sdelete;
            String qryDel3 = "delete from ProductTag where idProduct  in " + sdelete;
            String qryDel4 = "delete from ProductLang where idProduct  in " + sdelete;
            String qryDel5 = "delete from ProductShop where idProducte  in " + sdelete;
            String qryDel6 = "delete from CategoryProduct where idProduct  in " + sdelete;
            String qryDel7 = "delete from StockAvailable where idProduct  in " + sdelete;
            String qryDel8 = "delete from Image where idProduct  in " + sdelete;
            String qryDel9 = "delete from ImageShop where idProduct  in " + sdelete;
            String qryDel10 = "delete from Accessory where product1  in " + sdelete + " or product2 in " + sdelete;


            emMySQL.getTransaction().begin();

            Query qm = emMySQL.createQuery(qryDel);
            Query q1 = emMySQL.createQuery(qryDel1);
            Query q2 = emMySQL.createQuery(qryDel2);
            Query q3 = emMySQL.createQuery(qryDel3);
            Query q4 = emMySQL.createQuery(qryDel4);
            Query q5 = emMySQL.createQuery(qryDel5);
            Query q6 = emMySQL.createQuery(qryDel6);
            Query q7 = emMySQL.createQuery(qryDel7);
            Query q8 = emMySQL.createQuery(qryDel8);
            Query q9 = emMySQL.createQuery(qryDel9);
            Query q10 = emMySQL.createQuery(qryDel10);

            int i = qm.executeUpdate();
            System.out.println("Deleted qm: " + i);
            i = q1.executeUpdate();
            System.out.println("Deleted q1: " + i);
            i = q2.executeUpdate();
            System.out.println("Deleted q2: " + i);
            i = q3.executeUpdate();
            System.out.println("Deleted q3: " + i);
            i = q4.executeUpdate();
            System.out.println("Deleted q4: " + i);
            i = q5.executeUpdate();
            System.out.println("Deleted q5: " + i);
            i = q6.executeUpdate();
            System.out.println("Deleted q6: " + i);
            i = q7.executeUpdate();
            System.out.println("Deleted q7: " + i);
            i = q8.executeUpdate();
            System.out.println("Deleted q8: " + i);
            i = q9.executeUpdate();
            System.out.println("Deleted q9: " + i);
            i = q10.executeUpdate();
            System.out.println("Deleted q10: " + i);

            emMySQL.getTransaction().commit();
        }
              
    }
    
    public void actualitzarRelatedProducts () {
        /*try {
            String consulta = "select p\n" +
                        "FROM Articulo p\n" +
                        "WHERE trim(p.abrev) not like '' and p.estado = 1 \n" +
                        "ORDER BY p.abrev, p.codigo";
            
            Query q = emSQLServer.createQuery(consulta);
            List<Articulo> articulos = q.getResultList();
            List<Integer> ids = new ArrayList<Integer>();
            String ultimabrev = "";
            for (Articulo art:articulos) {
                if (!art.getAbrev().trim().equals(ultimabrev)) {
                    int i = 0;
                    int len = ids.size();
                    if (len > 1) {
                        try {
                            emMySQL.getTransaction().begin();
                            for(Integer id: ids) {
                                for (int j = 0; j< len; j++) {
                                    if (id!=ids.get(j)) {
                                        Accessory as = new Accessory(id,ids.get(j));
                                        emMySQL.persist(as);
                                    }

                                }
                            }
                            emMySQL.getTransaction().commit();
                        }
                        catch(Exception ex) {
                            System.out.println("NO ES TRASPASSA RELATED PRODUCT");
                            if (emMySQL.getTransaction().isActive()) {
                                emMySQL.getTransaction().rollback();
                            }
                        }

                    }
                    ultimabrev = art.getAbrev().trim();
                    ids.clear();
                }

                MatchProduct mp = emMySQL.find(MatchProduct.class, art.getCodigo());
                ids.add(mp.getIdPresta());
            }
            int len = ids.size();
            if (len > 1) {
                try {
                    emMySQL.getTransaction().begin();
                    for(Integer id: ids) {
                        for (int j = 0; j< len; j++) {
                            if (id!=ids.get(j)) {
                                Accessory as = new Accessory(id,ids.get(j));
                                emMySQL.persist(as);
                            }
                        }
                    }
                    emMySQL.getTransaction().commit();
                }
                catch(Exception ex) {
                    System.out.println("NO ES TRASPASSA RELATED PRODUCT");
                    if (emMySQL.getTransaction().isActive()) {
                        emMySQL.getTransaction().rollback();
                    }
                }

            }


        }
        catch (Exception ex) {
            System.out.println("ERROR ..................................... !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause().getMessage());
            if (emMySQL.getTransaction().isActive()) {
                emMySQL.getTransaction().rollback();
            }
        }*/
    }
    
    private void tractarRelatedProducts(String codigos) {
        /*if (codigos.length()>2) {
            try {
                String consulta = "select p\n" +
                            "FROM Articulo p\n" +
                            "WHERE trim(p.abrev) not like '' and p.estado = 1 and p.codigo in" + codigos +"\n" +
                            "ORDER BY p.abrev, p.codigo";
                
                Query q = emSQLServer.createQuery(consulta);
                List<Articulo> articulos = q.getResultList();
                List<Integer> ids = new ArrayList<Integer>();
                String ultimabrev = "";
                for (Articulo art:articulos) {
                    if (!art.getAbrev().trim().equals(ultimabrev)) {
                        int i = 0;
                        int len = ids.size();
                        if (len > 1) {
                            try {
                                emMySQL.getTransaction().begin();
                                for(Integer id: ids) {
                                    for (int j = 0; j< len; j++) {
                                        if (id!=ids.get(j)) {
                                            Accessory as = new Accessory(id,ids.get(j));
                                            emMySQL.persist(as);
                                        }

                                    }
                                }
                                emMySQL.getTransaction().commit();
                            }
                            catch(Exception ex) {
                                System.out.println("NO ES TRASPASSA RELATED PRODUCT");
                                if (emMySQL.getTransaction().isActive()) {
                                    emMySQL.getTransaction().rollback();
                                }
                            }

                        }
                        ultimabrev = art.getAbrev().trim();
                        ids.clear();
                    }

                    MatchProduct mp = emMySQL.find(MatchProduct.class, art.getCodigo());
                    ids.add(mp.getIdPresta());
                }
                int len = ids.size();
                if (len > 1) {
                    try {
                        emMySQL.getTransaction().begin();
                        for(Integer id: ids) {
                            for (int j = 0; j< len; j++) {
                                if (id!=ids.get(j)) {
                                    Accessory as = new Accessory(id,ids.get(j));
                                    emMySQL.persist(as);
                                }
                            }
                        }
                        emMySQL.getTransaction().commit();
                    }
                    catch(Exception ex) {
                        System.out.println("NO ES TRASPASSA RELATED PRODUCT");
                        if (emMySQL.getTransaction().isActive()) {
                            emMySQL.getTransaction().rollback();
                        }
                    }

                }


            }
            catch (Exception ex) {
                System.out.println("ERROR ..................................... !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause().getMessage());
                if (emMySQL.getTransaction().isActive()) {
                    emMySQL.getTransaction().rollback();
                }
            }
        }
*/
        
        
    }

    public List<Articulo> getArticulos(int i) {
        try {
            String queryC = "select p from Articulo p where p.eActivo = 1";
            Query q;
            q = emSQLServer.createQuery(queryC);
            List<Articulo> articulos = q.getResultList();
            return articulos;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    private List<ReferenciaProveedor> trobaRefProv(String idArticulo) {
        List<ReferenciaProveedor> refs = new ArrayList<ReferenciaProveedor>();
        try {
            String query = "select p from ReferenciaProveedor p where p.idArticulo='" +idArticulo +"'";
            Query q = emSQLServer.createQuery(query);
            refs =  q.getResultList();
            return refs;
        }
        catch(Exception ex) {
//            System.out.println(ex.getMessage());
            return null;
        }
    }

    private String trobaPath(int idDoc) {
        try {
            String sqnomfoto = "select p from ObjetoImagen p where p.principal = 1 and  p.idDocObjeto = '" + idDoc + "'";
            Query q = emSQLServer.createQuery(sqnomfoto);
            ObjetoImagen oi = (ObjetoImagen) q.getSingleResult();
            return oi.getNombreFichero();
        }
        catch (Exception ex) {
            return "";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int trobaStockArticle(String art) {
        String sql = "select p from Stock p where p.idArticulo = '" + art + "' and p.idAlmacen = " +  almacen;
        try {
            Query q = emSQLServer.createQuery(sql);
            Stock s = (Stock) q.getSingleResult();
            return s.getStock().intValue();
        }
        catch(Exception ex) {
            return -1;
        }
    }
    
}
