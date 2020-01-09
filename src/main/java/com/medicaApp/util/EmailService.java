package com.medicaapp.util;

import java.nio.charset.StandardCharsets;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
// VIEJA IMPORT: spring4.SpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public void sendEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = 
            		new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
            				StandardCharsets.UTF_8.name());

            Context context = new Context();
            
            //ahi hay llave valor, lo que se necesita MAPA!
            context.setVariables(mail.getModel());
            //directamente en carpeta templates
            String html = templateEngine.process("email/email-template", context);

            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());

            emailSender.send(message);			
		} catch (Exception e) {
            throw new RuntimeException(e);
		}
	}
}
