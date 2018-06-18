package com.Kharido.postgresAPI.services.impl;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.dto.UserLoginDetails;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import com.Kharido.postgresAPI.repository.UserDetailsRepository;
import com.Kharido.postgresAPI.services.UserDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private static String USER_NAME = "adarsh.spy";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "hizbolah@4"; // GMail password
    private static String RECIPIENT ;//"adarsh.spy@gmail.com";

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public Optional<UserDetailsEntity> findOne(String emailId) {
        return (userDetailsRepository.findById(emailId));
    }

    @Override
    public UserDetail save(UserDetail userDetail) {

        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
            BeanUtils.copyProperties(userDetail, userDetailsEntity);
            userDetailsRepository.save(userDetailsEntity);
            //Todo : Phani : remove system.out.println
            System.out.println(userDetailsEntity.getEmailId());
            //Todo : Phani : what is the need of this code?
            UserDetail response = new UserDetail();
            BeanUtils.copyProperties(userDetailsEntity, response);
            return response;
    }

    @Override
    public boolean exists(String emailId) {
       return userDetailsRepository.existsById(emailId);
    }

    @Override
    public List<UserDetailsEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<UserDetailsEntity> findAll(Iterable<String> userId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public void delete(UserDetailsEntity employee) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserDetailsEntity> getByFirstName(String fullName) {
        return null;
    }

   @Override
    public UserDetailsEntity getOneByEmailId(String emailId) {
     UserDetailsEntity userLoginDetailEntity = userDetailsRepository.findById(emailId).get();
        return userLoginDetailEntity;
    }

    @Override
    public String userLogin(UserLoginDetails userLoginDetails) {
        if(userDetailsRepository.existsById(userLoginDetails.getEmailId())==false){

            return ("Email is not registered...");
        }

       UserDetailsEntity userLoginDetailEntity = userDetailsRepository.findById(userLoginDetails.getEmailId()).get();
//        if (userLoginDetailEntity == null) {
//            //Todo : Phani : remove system.out.println, use logger instead
//            System.out.println("User Not Found...");
//            return ("Email is not registered...");
//        }
        boolean userPassWordCheck = userLoginDetailEntity.getPassword().equals(userLoginDetails.getPassword());
        System.out.println(userLoginDetailEntity.getPassword()+"\n"+userLoginDetails.getPassword());
        if(userPassWordCheck == false)
        {
            return ("Username/Password incorrect...");
        }
        return ("true");

    }



    @Override
    public int emailValidation(String emailId) {

        Random rand = new Random();
        int rand_int = rand.nextInt(1000);
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { emailId }; // list of recipient email addresses
        System.out.println(emailId);
        String subject = "Kharido welcomes you!!";
        String body = "Welcome to the fastest growing ecommerce website in india. Please verify your email by entering " +
                "the mentioned OTP in your mobile application!"+"\n OTP : "+rand_int +"\n Regards, \nKharido Team";

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }

    return  rand_int;
    }
    }


