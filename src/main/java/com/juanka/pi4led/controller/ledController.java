package com.juanka.pi4led.controller;


import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*RestController
public class ledController {

    @RequestMapping("/")
    public String greeting() {
        return " APp is up and running";
    }

    public static void right (GpioPinDigitalOutput a, GpioPinDigitalOutput b, GpioPinDigitalOutput c, GpioPinDigitalOutput d, GpioPinDigitalOutput e) throws InterruptedException {

        a.high();
        Thread.sleep(600);
        a.low(); b.high();
        Thread.sleep(400);
        b.low(); c.high();
        Thread.sleep(400);
        c.low(); d.high();
        Thread.sleep(400);
        d.low(); e.high();
        Thread.sleep(600);

    }

    public static void left (GpioPinDigitalOutput a, GpioPinDigitalOutput b, GpioPinDigitalOutput c, GpioPinDigitalOutput d, GpioPinDigitalOutput e) throws InterruptedException {

        e.high();
        Thread.sleep(600);
        e.low(); d.high();
        Thread.sleep(400);
        d.low(); c.high();
        Thread.sleep(400);
        c.low(); b.high();
        Thread.sleep(400);
        b.low(); a.high();
        Thread.sleep(600);
    }

    public static void shutdown (){


    }
    @RequestMapping("/blink")
    public String light() throws InterruptedException {

        int i=0;
        GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Led2", PinState.LOW);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Led3", PinState.LOW);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Led4", PinState.LOW);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Led5", PinState.LOW);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Led6", PinState.LOW);

        while (i<=5) {

            right(pin1, pin2, pin3, pin4, pin5);
            left(pin1, pin2, pin3, pin4, pin5);

            i++;
        }
        pin1.low();
        gpio.shutdown();

        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);

        return "program was executed without errors";

    }

}*/
@RestController
public class motorController {

    @RequestMapping("/")
    public String start () {

        return "app is running ok.";
    }

    @RequestMapping("/drive")
    public String drive () throws InterruptedException{

        GpioController gpio = GpioFactory.getInstance();

        GpioPinDigitalOutput leftMotor = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Motor Izquierda", PinState.LOW);
        GpioPinDigitalOutput rightMotor = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Motor Derecha", PinState.LOW);


        leftMotor.high();
        rightMotor.high();
        Thread.sleep(3000);

        gpio.shutdown();
        gpio.unprovisionPin(leftMotor);
        gpio.unprovisionPin(rightMotor);

        System.out.println("Motors worked");

        return "Program was executed correctly";

    }
}

