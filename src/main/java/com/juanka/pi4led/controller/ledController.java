package com.juanka.pi4led.controller;


import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

public class ledController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting() {
        return " Hello World";
    }

    @RequestMapping("/light")
    public String light(){

        if (pin==null) {
            GpioController gpio = GpioFactory.getInstance();
            GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "RedLed", PinState.LOW);

        }

        pin.toggle();

        return "You're good";
    }

}
