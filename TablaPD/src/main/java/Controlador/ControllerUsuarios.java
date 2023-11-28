/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionH2;
import Modelo.ModelUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ControllerUsuarios {
    public static int idUsuario;
    public static String Nombre;
    public static String tipo;
    public static int NoOrden;
    
    public ControllerUsuarios(String pNombre, String pTipo, int pNoOrden){
        Nombre = pNombre;
        tipo = pTipo;
        NoOrden = pNoOrden;
    }

    public static ResultSet CargarUsuarios(){
        return Modelo.ModelUsuarios.cargarRegistros();
    } 
    
    public static boolean RegistrarUsuario(){
        return ModelUsuarios.RegistrarUsuario(Nombre, tipo, NoOrden);
    }
    
    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        ControllerUsuarios.idUsuario = idUsuario;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        ControllerUsuarios.Nombre = Nombre;
    }

    public static String gettipo() {
        return tipo;
    }

    public static void settipo(String tipo) {
        ControllerUsuarios.tipo = tipo;
    }

    public static int getNoOrden() {
        return NoOrden;
    }

    public static void setNoOrden(int NoOrden) {
        ControllerUsuarios.NoOrden = NoOrden;
    }
    

    public static ResultSet buscarUsuariosPorNombre(String nombreUsuario) {
    try {
        Connection con = ConexionH2.getConnection();
        String sql = "SELECT * FROM TablaBase WHERE nombre LIKE ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + nombreUsuario + "%");
        return ps.executeQuery();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return null;
    }
}
}