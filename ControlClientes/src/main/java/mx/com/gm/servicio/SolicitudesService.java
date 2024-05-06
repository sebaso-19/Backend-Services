/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Solicitudes;
/**
 *
 * @author Sebastian
 */
public interface SolicitudesService {
    public List<Solicitudes> listarSolicitudes();
    
    public void guardar(Solicitudes solicitudes);
    
    public void eliminar(Solicitudes solicitudes);
    
    public Solicitudes encontrarSolicitud(Solicitudes solicitudes);
}
