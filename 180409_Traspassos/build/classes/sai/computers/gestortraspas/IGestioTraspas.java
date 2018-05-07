/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.gestortraspas;

/**
 *
 * @author PROGRAMACIO3
 */
public interface IGestioTraspas {
    public void actualitzarPedidos(String vendedor) throws GestioTraspasException;
    public void actualitzarArticles()throws GestioTraspasException;
    public void actualitzarArticlesFiltrant(String f1a, String f1b, String f2a, String f2b, String f3a, String f3b, String almacen)throws GestioTraspasException;
    public void actualitzarClients()throws GestioTraspasException;
    public void actualitzarProveidors()throws GestioTraspasException;
    public void actualitzarMarques()throws GestioTraspasException;
    public void actualitzarFamilies()throws GestioTraspasException;
    public void actualitzarSubfamilies()throws GestioTraspasException;
    public void actualitzarPvps()throws GestioTraspasException;
    public void actualitzarDescomptes() throws GestioTraspasException;
    
    
    public void close();
}
