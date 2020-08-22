package com.sda.javagda34.students;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        final String password = bCryptPasswordEncoder.encode("password");

        System.out.println(password);
    }


}
