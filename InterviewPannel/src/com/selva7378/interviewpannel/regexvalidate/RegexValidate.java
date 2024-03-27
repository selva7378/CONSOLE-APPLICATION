package com.selva7378.interviewpannel.regexvalidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidate {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);

    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{5,20}$";
    private static final Pattern userNamePattern = Pattern.compile(USERNAME_REGEX);

    private static final String PHONENO_REGEX = "^[7-9]\\d{9}$";
    private static final Pattern phoneNoPattern = Pattern.compile(PHONENO_REGEX);

    private static final String ADDRESS_REGEX = "^[0-9]+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+),\\s*([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+),\\s*([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+),\\s*[0-9]+";
    private static final Pattern addressPattern = Pattern.compile(ADDRESS_REGEX);

    private static final String PUBLICATION_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final Pattern publicationPattern = Pattern.compile(PUBLICATION_REGEX);



    private static RegexValidate regexValidate;
    private RegexValidate(){

    }

    public static RegexValidate getInstance(){
        if(regexValidate == null){
            regexValidate = new RegexValidate();
        }
        return regexValidate;
    }

    public boolean isValidateName(String name){
        Matcher matcher = userNamePattern.matcher(name);
        return matcher.matches();
    }

    public boolean isValidatePassword(String password){
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public boolean isValidatePhoneNumber(String phoneNumber){
        Matcher matcher = phoneNoPattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public boolean isValidateEmailId(String email){
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidateAddress(String address){
        Matcher matcher = addressPattern.matcher(address);
        return matcher.matches();
    }

    public boolean isValidatePublication(String publication){
        Matcher matcher = publicationPattern.matcher(publication);
        return matcher.matches();
    }
}
