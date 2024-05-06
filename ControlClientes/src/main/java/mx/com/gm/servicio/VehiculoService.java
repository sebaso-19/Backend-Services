package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Vehiculo;

/**
 *
 * @author Sebastian
 */
public interface VehiculoService {
    public List<Vehiculo> listarVehiculos();
    
    public void guardar(Vehiculo vehiculo);
    
    public void eliminar(Vehiculo vehiculo);
    
    public Vehiculo encontrarVehiculo(Vehiculo vehiculo);
}
