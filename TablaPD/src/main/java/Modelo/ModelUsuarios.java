/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ModelUsuarios {
    public static ResultSet cargarRegistros(){
        PreparedStatement ps;
        Connection con;
        try{
            con = ConexionH2.getConnection();
            ps = con.prepareStatement("SELECT * FROM TablaBase");
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
    public static boolean RegistrarUsuario(String Nombre, String tipo, int NoOrden){
        PreparedStatement ps;
        boolean retorno = false;
        try{
            Connection con = ConexionH2.getConnection();
            ps = con.prepareStatement("INSERT INTO TablaBase(nombre, tipo, NoOrden) VALUES(?,?,?)");
            ps.setString(1, Nombre); 
            ps.setString(2, tipo); 
            ps.setInt(3, NoOrden); 
            retorno = Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null,"producto registrado correctamente");
            return retorno;
        }catch(Exception e){
            return retorno;
        } 
    }
}