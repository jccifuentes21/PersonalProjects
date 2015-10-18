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

    public static void right (GpioPinDigitalOutput a, GpioPinDigitalOutput b, GpioPinDigitalOutput c, GpioPinDigitalOutput d, GpioPinDigitalOutput e, GpioPinDigitalOutput f) throws InterruptedException {

        a.high();
        Thread.sleep(100);
        a.low();
        b.high();
        Thread.sleep(100);
        b.low();
        c.high();
        Thread.sleep(100);
        c.low();
        d.high();
        Thread.sleep(100);
        d.low();
        e.high();
        Thread.sleep(100);
        e.low();
        f.high();
        Thread.sleep(100);
        f.low();
    }

    public static void left (GpioPinDigitalOutput a, GpioPinDigitalOutput b, GpioPinDigitalOutput c, GpioPinDigitalOutput d, GpioPinDigitalOutput e, GpioPinDigitalOutput f) {


    }

    public static void shutdown (){


    }
    @RequestMapping("/blink")
    public String light() throws InterruptedException {

        GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Led1", PinState.LOW);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Led2", PinState.LOW);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Led3", PinState.LOW);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Led4", PinState.LOW);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Led5", PinState.LOW);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Led6", PinState.LOW);

        right(pin1,pin2,pin3,pin4,pin5,pin6);

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
