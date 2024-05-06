package mx.com.gm.servicio;

import java.util.List;

import mx.com.gm.dao.ISolicitudesDao;
import mx.com.gm.domain.Solicitudes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Sebastian
 */

@Service
public class SolicitudesServiceImpl implements SolicitudesService{

    @Autowired
    private ISolicitudesDao solicitudesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Solicitudes> listarSolicitudes() {
        return (List<Solicitudes>) solicitudesDao.findAll();
    }

    @Override
    public void guardar(Solicitudes solicitudes) {
        solicitudesDao.save(solicitudes);
    }

    @Override
    public void eliminar(Solicitudes solicitudes) {
        solicitudesDao.delete(solicitudes);
    }

    @Override
    @Transactional(readOnly = true)
    public Solicitudes encontrarSolicitud(Solicitudes solicitudes) {
        return solicitudesDao.findById(solicitudes.getFecha()).orElse(null);
    }
    
}
