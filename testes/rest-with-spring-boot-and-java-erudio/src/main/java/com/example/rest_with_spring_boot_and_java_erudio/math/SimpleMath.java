package com.example.rest_with_spring_boot_and_java_erudio.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {
    public Double sum(Double number1, Double number2){
        return number1 + number2;
    }
    public Double subtract(Double number1, Double number2){
        return number1 - number2;
    }
    public Double multiplication(Double number1, Double number2){
        return number1 * number2;
    }
    public Double division(Double number1, Double number2){
        return number1 / number2;
    }
    public Double average(Double number1, Double number2){
        return (number1 + number2)/2;
    }
    public Double sqrt(Double number1){
        return Math.sqrt(number1);
    }

}
