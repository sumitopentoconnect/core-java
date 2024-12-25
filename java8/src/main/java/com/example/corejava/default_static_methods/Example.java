package com.example.corejava.default_static_methods;


public class Example {

    public static void run() {
        defaultAndStaticMethod();
    }

    private static void defaultAndStaticMethod() {
        System.out.println("4.1 Static Methods in Interfaces ========================================== ");
        String producer = Vehicle.producer();
        System.out.println("Static Method -> producer = " + producer);
        String overview = new VehicleImpl().getOverview();
        System.out.println("Default Method -> overview = " + overview);
    }


    interface Vehicle {
        static String producer() {
            return "N&F Vehicles";
        }

        default String getOverview() {
            return "ATV made by " + producer();
        }
    }

    static class VehicleImpl implements Vehicle {}
}
