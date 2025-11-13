package com.example.rest_with_spring_boot_and_java_erudio.controllers;

import com.example.rest_with_spring_boot_and_java_erudio.math.SimpleMath;
import com.example.rest_with_spring_boot_and_java_erudio.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable("number1") String number1, @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) throw new UnsupportedOperationException ("Please provide a numeric value");
        return math.sum(NumberConverter.converToDouble(number1), NumberConverter.converToDouble(number2));
    }

    @RequestMapping("subtraction/{number1}/{number2}")
    public Double subtract(@PathVariable("number1") String number1, @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) throw new UnsupportedOperationException ("Please provide a numeric value");
        return math.subtract(NumberConverter.converToDouble(number1), NumberConverter.converToDouble(number2));
    }
    @RequestMapping("multiplication/{number1}/{number2}")
    public Double multiplication(@PathVariable("number1") String number1, @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) throw new UnsupportedOperationException ("Please provide a numeric value");
        return math.multiplication(NumberConverter.converToDouble(number1), NumberConverter.converToDouble(number2));
    }

    @RequestMapping("division/{number1}/{number2}")
    public Double division(@PathVariable("number1") String number1, @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) throw new UnsupportedOperationException ("Please provide a numeric value");
        if (NumberConverter.isNotPossibleToDivide(NumberConverter.converToDouble(number2))) throw new UnsupportedOperationException ("Please provide a positive number");
        return math.division(NumberConverter.converToDouble(number1), NumberConverter.converToDouble(number2));
    }

    @RequestMapping("average/{number1}/{number2}")
    public Double average(@PathVariable("number1") String number1, @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) throw new UnsupportedOperationException ("Please provide a numeric value");
        return math.average(NumberConverter.converToDouble(number1), NumberConverter.converToDouble(number2));
    }

    @RequestMapping("sqrt/{number1}")
    public Double sqrt(@PathVariable("number1") String number1
    ) throws Exception {
        if (!NumberConverter.isNumeric(number1) ) throw new UnsupportedOperationException ("Please provide a numeric value");
        if (!NumberConverter.isPossibleToSqrt(NumberConverter.converToDouble(number1))) throw new UnsupportedOperationException ("Please provide a positive number");
        return math.sqrt(NumberConverter.converToDouble(number1));
    }




}
