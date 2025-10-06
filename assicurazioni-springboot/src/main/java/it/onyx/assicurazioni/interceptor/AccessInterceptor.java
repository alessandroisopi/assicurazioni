package it.onyx.assicurazioni.interceptor;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class AccessInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String filePath = "assicurazioni-springboot/src/main/resources/risultati/accessi/accessi.pdf";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream(filePath, true)));
        Document document = new Document(pdfDocument);
        //inserisce la data del log
        Text logDataText = new Text("Log " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + "\n");
        //inserisce il nome del metodo
        Text methodName = null;
        if (handler instanceof HandlerMethod handlerMethod) {
            methodName = new Text("Nome del metodo: " + handlerMethod.getMethod().getName() + "\n");
        }

        //controlla se ci sono parametri e li mette nel testo
        Text nomeParametroText = null;
        if (request.getParameterMap() != null && !request.getParameterMap().isEmpty()) {
            nomeParametroText = new Text("Parametri passati\n");
            for (String nomeParametro : request.getParameterMap().keySet()) {
                String[] valori = request.getParameterMap().get(nomeParametro);
                nomeParametroText.setText(nomeParametroText.getText() + nomeParametro + ": ");
                for (String valore : valori) {
                    nomeParametroText.setText(nomeParametroText.getText() + valore + "\n");
                }
            }
        }

        //controllo se ci sono path variable
        Map<String, String> pathVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Text pathVarText = null;
        if (pathVars != null && !pathVars.isEmpty()) {
            pathVarText = new Text("Variabili nel path\n");
            for (Map.Entry<String, String> entry : pathVars.entrySet()) {
                pathVarText.setText(pathVarText.getText() + entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }

        //controllo del body
        Text bodyText = null;
        if (request instanceof ContentCachingRequestWrapper wrapper) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                String body = new String(buf, request.getCharacterEncoding());
                bodyText = new Text("Body ricevuto:\n" + body);
            }
        }

        Paragraph paragraph = new Paragraph();

        paragraph.add(logDataText);
        if (methodName != null) {
            paragraph.add(methodName);
        }
        if (nomeParametroText != null) {
            paragraph.add(nomeParametroText);
        }
        if (pathVarText != null) {
            paragraph.add(pathVarText);
        }
        if (bodyText != null) {
            paragraph.add(bodyText);
        }
        document.add(paragraph);
        document.close();
    }
}