package mx.com.gm.web;

import jakarta.validation.Valid;
import java.sql.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Solicitudes;
import mx.com.gm.domain.Vehiculo;
import mx.com.gm.servicio.PersonaService;
import mx.com.gm.servicio.SolicitudesService;
import mx.com.gm.servicio.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Sebastian
 */
@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @Autowired
    private SolicitudesService solicitudesService;
    
    @GetMapping("/")        
    
    public String inicio(Model model ){
        var personas = personaService.listarPersonas();
        var vehiculos = vehiculoService.listarVehiculos();
        var solicitudes = solicitudesService.listarSolicitudes();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("solicitudes", solicitudes);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agegar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors())
            return "modificar";
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona,Model model){
       persona = personaService.encontrarPersona(persona);
       model.addAttribute("persona", persona);
       return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
     @GetMapping("/enviarMsg")
    public String enviarMsg(Persona persona, Model model) {
        personaService.enviarMsg(persona);
        model.addAttribute("persona", persona);
        return "redirect:/";
    }
    
    
    @GetMapping("/agregarVehiculo")
    public String agregarVehiculo(Vehiculo vehiculo, Model model) {
    model.addAttribute("vehiculo", new Vehiculo());
    return "formVehiculo";
    }
    
    @GetMapping("/editarVehiculo/{placa}")
    public String editarVehiculo(Vehiculo vehiculo, Model model) {
    vehiculo = vehiculoService.encontrarVehiculo(vehiculo);
    model.addAttribute("vehiculo", vehiculo);
    return "formVehiculoEdit    "; 
}

    @GetMapping("/eliminarVehiculo/{placa}")
    public String eliminarVehiculo(Vehiculo vehiculo){
    vehiculoService.eliminar(vehiculo);
    return "redirect:/";
}
    @PostMapping("/guardarVehiculo")
    public String guardar(@Valid Vehiculo vehiculo, Errors errores){
        if(errores.hasErrors())
            return "formVehiculo";
        vehiculoService.guardar(vehiculo);
        return "redirect:/";
    } 
    
    @GetMapping("/agregarSolicitud")
    public String agregarSolicitud(Model model) {
    List<Solicitudes> solicitudes = solicitudesService.listarSolicitudes();    
    model.addAttribute("solicitudes", solicitudes);
    return "index"; // Corregir el nombre de la vista
}

    
    @GetMapping("/editarSolicitud/{fecha}")
    public String editarSolicitud(Solicitudes solicitudes, Model model) {
    solicitudes = solicitudesService.encontrarSolicitud(solicitudes);
    model.addAttribute("solicitudes", solicitudes);
    return "formSolicitudes"; 
}

    @GetMapping("/eliminarSolicitud/{propietarioCarga}")
    public String eliminarSolicitud(Solicitudes solicitudes){
    solicitudesService.eliminar(solicitudes);
    return "redirect:/";
}


    @PostMapping("/guardarSolicitud")
    public String guardar(@Valid Solicitudes solicitudes, Errors errores){
        if(errores.hasErrors())
            return "formSolicitudes";
        solicitudesService.guardar(solicitudes);
        return "redirect:/";
    }
    
    
    
    
}
