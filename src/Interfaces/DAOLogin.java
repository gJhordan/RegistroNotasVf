/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Informacion.Usuario;
/**
 *
 * @author ACER
 */
public interface DAOLogin {
     public int intentarlogin(Usuario usuario);
     public void sumarintentos(Usuario usuario);
}
