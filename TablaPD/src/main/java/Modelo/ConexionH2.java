/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexionH2 {
    
    public static Connection getConnection(){
        Connection con;
        try{
            String url = "jdbc:h2:~/Tablas;DB_CLOSE_DELAY=-1";
            
            Class.forName("org.h2.Driver");

            con = DriverManager.getConnection(url, "sa", "Camaleon12");
            return con;
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(); 
            return null;
        }
    }
     public static void crearTabla(Connection con) {
        // Crea tabla
        String sql = "CREATE TABLE IF NOT EXISTS TablaBase ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(255),"
                + "tipo VARCHAR(255),"
                + "NoOrden INT)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
