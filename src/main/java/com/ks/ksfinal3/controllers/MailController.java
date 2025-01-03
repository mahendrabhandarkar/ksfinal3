package com.ks.ksfinal3.controllers;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.ks.ksfinal3.services.EmailService;
import jakarta.mail.Folder;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    // See application.properties for SMPT host and user configuration
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;

    private GreenMail greenMail = new GreenMail(ServerSetupTest.SMTP);

    @GetMapping("/sendtestmail")
    public void sendTestEmail() {
        // Send email via service class
        emailService.sendSimpleMessage("abc@gmail.com", "Test Mail", "Sent...");

        // Send email ...
        final String subject = "Hello Spring 3: testReceiveMailViaImap";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("foo@localhost");
        message.setTo("foo@localhost");
        message.setSubject(subject);
        message.setText("I'm a test");
        mailSender.send(message);

        // .. wait for delivery ...
        greenMail.waitForIncomingEmail(1);

        // ... verify by using IMAPx
        try (final Store store = greenMail.getImap().createStore()) {
            store.connect("foo", "foo-pwd");
            final Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
