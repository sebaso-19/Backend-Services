package mx.com.gm.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Sebastian
 */

@Data
@Entity
@Table(name = "solicitudescarga")
public class Solicitudes implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    @Column(name = "fecha")
    private Date fecha;
    @Id   
    @Column(name = "propietario_carga", length = 45)
    private String propietarioCarga;
     
    @NotEmpty
    @Column(name = "origen", length = 45)
    private String origen;
     
    @NotEmpty
    @Column(name = "destino", length = 45)
    private String destino;
    
    @NotEmpty
    @Column(name = "dimensiones", length = 45)
    private String dimensiones;

    @NotEmpty
    @Column(name = "peso", length = 45)
    private String peso;

    @NotEmpty
    @Column(name = "valor_asegurado", length = 45)
    private String valorAsegurado;

    @NotEmpty
    @Column(name = "empaque", length = 45)
    private String empaque;
}
