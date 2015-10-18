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

        int i = 0;

        GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Led1", PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Led2", PinState.LOW);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Led3", PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Led4", PinState.LOW);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Led5", PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Led6", PinState.LOW);

        if (i!=0) {
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


        }
        gpio.shutdown();
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        return "program was executed without errors";

    }

}
