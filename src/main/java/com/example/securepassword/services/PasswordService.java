package com.example.securepassword.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    
    public List<String> validatePass(String pass){
        List<String> failures = new ArrayList<>();

        validateLength(pass, failures);

        validateUppercase(pass, failures);

        validateLowercase(pass, failures);

        validateNumber(pass, failures);

        validateSpecialCharacter(pass, failures);

        return failures;
        

    }

    private void validateLength(String pass, List<String> failures){
        if(pass != null && pass.length() < 8){
            failures.add("A senha deve possui pelo menos 08 caracteres.");
        }
    }

    public void validateUppercase(String pass, List<String> failures){
        if(!Pattern.matches(".*[A-Z].*", pass)){
            failures.add("A senha deve conter pelo menos uma letra maiúscula.");
        }
    }

    public void validateLowercase(String pass, List<String> failures){
        if(!Pattern.matches(".*[a-z].*", pass)){
            failures.add("A senha deve conter pelo menos uma letra minúscula.");
        }
    }

    public void validateNumber(String pass, List<String> failures){
        if(!Pattern.matches(".*[0-9].*", pass)){
            failures.add("A senha deve conter pelo menos um dígito numérico.");
        }
    }

    public void validateSpecialCharacter(String pass, List<String> failures){
        if(!Pattern.matches(".*[\\W].*", pass)){
            failures.add("A senha deve conter pelo menos um caractere especial (e.g, !@#$%).");
        }
    }
}
