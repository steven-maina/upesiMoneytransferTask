package com.TransferJavaTask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        // Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        // Set Mail Credentials:
        emailConfig.setHost("smtp.mailtrap.io");
        emailConfig.setPort(2525);
        emailConfig.setUsername("9515222433b24d");
        emailConfig.setPassword("92dc008d9956bb");

        return emailConfig;
    }
    // End Of Email Config Method.
}
