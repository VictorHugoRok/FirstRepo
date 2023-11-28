/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;

public class ConexionController {
    public static Connection getConnectionController(){
        return Modelo.ConexionH2.getConnection();
    }
}

