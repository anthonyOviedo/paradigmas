package ejercicios.java;

import java.util.Arrays;

public class calcpromedios {

    // mi approach, bien feo sin paradigma funcional
    public static int promedioCuadradosMio(int[] numeros) {
        int total = 0;
        for (int i = 0; i < numeros.length; i++) {

            total = total + (numeros[i] * numeros[i]);

        }
        return total / numeros.length;
    }

    // a) Estilo imperativo
    public static double promedioCuadradosImp(int[] nums) {
        long suma = 0;
        for (int n : nums) {
            suma += (long) n * n;
        }
        return suma / (double) nums.length; // lista no vacía asumida
    }

    // b) Estilo funcional (Streams)
    public static double promedioCuadradosFun(int[] nums) {
        return Arrays.stream(nums)
                .mapToLong(n -> (long) n * n)
                .average() // funcion commun, esto debo de memorizar
                .orElseThrow(); // lista no vacía
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 3 };
        System.out.println("Promedio : " + promedioCuadradosMio(nums));
    }
}
