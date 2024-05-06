package mx.com.gm.servicio;

import javax.mail.Session;
import java.util.List;
import java.util.Properties;
import mx.com.gm.dao.IPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private IPersonaDao personaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
       return (List<Persona>)personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
       return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
    @Override
    public Persona enviarMsg(Persona persona) {
    String destinatario = persona.getEmail();
    String asunto = "Registro exitoso";
    String mensaje = "Felicitaciones te has registrado exitosamente en la plataforma";

    String remitente = "yeison202431@gmail.com";
    String contraseña = "SoyYeison2024"; 

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remitente, contraseña);
                }
            });

    try {
        Message mailMessage = new MimeMessage(session);
        mailMessage.setFrom(new InternetAddress(remitente));
        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mailMessage.setSubject(asunto);
        mailMessage.setText(mensaje);

        Transport.send(mailMessage);
    } catch (MessagingException e) {
        e.printStackTrace();
    }

    return persona;
}
 
}
