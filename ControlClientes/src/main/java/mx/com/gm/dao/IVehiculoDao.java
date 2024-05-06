
package mx.com.gm.dao;

import mx.com.gm.domain.Vehiculo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian
 */
public interface IVehiculoDao extends CrudRepository<Vehiculo, String> {
    
}
