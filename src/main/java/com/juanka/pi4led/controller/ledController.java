package com.juanka.pi4led.controller;


import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ledController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting() {
        return " APp is up and running";
    }

    @RequestMapping("/blink")
    public String light() throws InterruptedException {

        GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Led4", PinState.HIGH);

        Thread.sleep(1000);
        pin.low();
        Thread.sleep(1000);
        pin.high();
        Thread.sleep(1000);
        pin.low();
        Thread.sleep(500);
        pin.high();
        Thread.sleep(500);
        pin.low();
        Thread.sleep(500);
        pin.high();
        Thread.sleep(500);
        pin.low();

        return "program was executed without errors";

    }

}
