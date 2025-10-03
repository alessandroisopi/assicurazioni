package it.onyx.assicurazioni.interceptor;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Text;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class AccessInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String filePath = "assicurazioni-springboot/src/main/resources/risultati/accessi/accessi.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(filePath));
        Document document = new Document(pdfDocument);
        //inserisce la data del log
        Text logDataText = new Text("Log " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")));
        //inserisce il nome del metodo
        if (handler instanceof HandlerMethod handlerMethod) {
            Text methodName = new Text("Nome del metodo: " + handlerMethod.getMethod().getName());
        }

        //controlla se ci sono parametri e li mette nel testo
        if (request.getParameterMap() != null) {
            for (String nomeParametro : request.getParameterMap().keySet()) {
                String[] valori = request.getParameterMap().get(nomeParametro);
                Text nomeParametroText = new Text(nomeParametro + ":");
                for (String valore : valori) {
                    nomeParametroText.setText(nomeParametroText.getText() + " " + valore);
                }
            }
        }

        //controllo se ci sono path variable
        Map<String, String> pathVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        if (pathVars != null) {
            Text pathVarText = new Text("PathVariable:\n");
            for (Map.Entry<String, String> entry : pathVars.entrySet()) {
                pathVarText.setText(pathVarText.getText() + entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }

        //controllo del body
        if (request instanceof ContentCachingRequestWrapper wrapper) {
            String body = new String(wrapper.getContentAsByteArray(), request.getCharacterEncoding());
            Text bodyText = new Text("Body: " + body);
        }
    }
}
