package it.onyx.assicurazioni.interceptor;

import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.entity.Utente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDate;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Utente utente = new Utente(
            request.getHeader("codiceFiscale"),
            request.getHeader("nome"),
            request.getHeader("cognome"),
            LocalDate.parse(request.getHeader("dataNascita"))
        );
        UserContext.setUtente(utente);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // Questo metodo viene eseguito ALLA FINE di tutto, dopo che la risposta è stata inviata.
        // È il posto OBBLIGATORIO dove fare pulizia.
        UserContext.clear();
    }
}
