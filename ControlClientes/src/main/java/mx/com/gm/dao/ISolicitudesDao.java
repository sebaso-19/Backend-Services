/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.dao;

import java.sql.Date;
import mx.com.gm.domain.Solicitudes;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian
 */
public interface ISolicitudesDao extends CrudRepository<Solicitudes, Date>{
    
}
