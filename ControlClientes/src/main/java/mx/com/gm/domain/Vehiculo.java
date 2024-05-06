package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {
    

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "placa", length = 10)
    private String placa;

    @NotEmpty
    @Column(name = "marca", length = 45)
    private String marca;

    @NotEmpty
    @Column(name = "modelo", length = 45)
    private String modelo;

    @NotEmpty
    @Column(name = "capacidad_carga", length = 45)
    private String capacidadCarga;

    @NotEmpty
    @Column(name = "tipo_carroceria", length = 45)
    private String tipoCarroceria;
}
