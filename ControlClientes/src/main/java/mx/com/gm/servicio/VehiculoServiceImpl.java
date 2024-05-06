package mx.com.gm.servicio;

import java.util.List;

import mx.com.gm.dao.IVehiculoDao;
import mx.com.gm.domain.Vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastian
 */
@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private IVehiculoDao vehiculoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> listarVehiculos() {
        return (List<Vehiculo>) vehiculoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    @Override
    @Transactional
    public void eliminar(Vehiculo vehiculo) {
        vehiculoDao.delete(vehiculo);
    }

    @Override
    @Transactional(readOnly = true)
    public Vehiculo encontrarVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getPlaca()).orElse(null);
    }
}
