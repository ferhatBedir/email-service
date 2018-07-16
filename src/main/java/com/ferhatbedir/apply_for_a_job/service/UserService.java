package com.ferhatbedir.apply_for_a_job.service;

import com.ferhatbedir.apply_for_a_job.entity.UserInfo;
import com.ferhatbedir.apply_for_a_job.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class UserService {

    private UserInfoRepository userInfoRepository;
    private JavaMailSender javaMailSender;

    @Autowired
    public UserService(UserInfoRepository userInfoRepository, JavaMailSender javaMailSender) {
        this.userInfoRepository = userInfoRepository;
        this.javaMailSender = javaMailSender;
    }

    public void addUserInfo(UserInfo userInfo) throws MessagingException {
        UserInfo user = userInfoRepository.findByUserVatNum(userInfo.getUserVatNum());
        if (user != null) {
            System.out.println("User already register in Database.");
        } else {
            userInfoRepository.save(userInfo);
            sendMailToUserInfo(userInfo);
        }
    }

    private String sendMailToUserInfo(UserInfo user) throws MessagingException {
        /*
        For Only Message;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Apply To Job");
        message.setText("Merhaba" +
                "\nBligileriniz incelenmek üzere sistemimize kayıt edilmiştir." +
                "\nAranılan pozisyona uygun olmanız durumunda sizinle irtibata geçilecektir." +
                "\n" +
                "\nBaşarılar.");
        javaMailSender.send(message);
        return "Mail send."; */

        //--------------------------------------------------------------------------------
        //For Message and Attachment
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(user.getUserEmail());
        helper.setSubject("Apply To Job");
        helper.setText("Merhaba " + user.getUserFirstName() +
                "\nBligileriniz incelenmek üzere sistemimize kayıt edilmiştir." +
                "\nAranılan pozisyona uygun olmanız durumunda sizinle irtibata geçilecektir." +
                "\n" +
                "\nBaşarılar.");

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\ferhat\\Desktop\\apply_for_a_job\\picture\\Attachment.jpg"));
        helper.addAttachment("Attachment", file);

        javaMailSender.send(message);


        return "Ok.";

    }

}
