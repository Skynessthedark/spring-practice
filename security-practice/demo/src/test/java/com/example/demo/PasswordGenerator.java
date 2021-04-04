package com.example.demo;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    //Veritabanındaki şifreler için deneme
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String[] passwords = {
            "goksenin", "sabahat", "melih", "firat"
        };

        for(String password: passwords){
            System.out.println(encoder.encode(password));
        }
    }
}
