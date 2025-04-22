import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        limpiarpantalla();
        int [] numeros = new int[10];
        boolean validacionDatosIngresados = false;


        do{
            limpiarpantalla();

            System.out.println("---Menú---");
            System.out.println("1. Ingresar Datos");
            System.out.println("2. Mostrar Datos Ingresados");
            System.out.println("3. Calcular Suma De Datos Ingresados");
            System.out.println("4. Mostrar Dato Mínimo y Máximo Ingresado");
            System.out.println("5. Invertir Orden");
            System.out.println("6. Salir");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); 
                continuarEnter(scanner);
                continue;
            }



            switch (opcion) {
                case 1:
                    limpiarpantalla();
                    ingresoDatos(numeros, scanner);
                    validacionDatosIngresados = true;
                    break;

                case 2:
                    limpiarpantalla();  
                    if (validacionDatosIngresados) {
                        mostrarDatos(numeros);
                        
                    } else { 
                        System.out.println("Por favor, primero ingrese 10 números en la opción 1");
                        continuarEnter(scanner);
                    }
                    break;

                case 3:
                    limpiarpantalla();   
                    if (validacionDatosIngresados)
                    {
                        System.out.println("La Suma De Los Números Ingresados Es: " + calcularSuma(numeros));
                        
                    } else {
                        System.out.println("Por favor, primero ingrese 10 números en la opción 1");
                        
                    }  
                    continuarEnter(scanner);       
                    break;

                case 4:
                    limpiarpantalla(); 
                    if (validacionDatosIngresados)
                    {
                        calcularMinimoMaximo(numeros);
                                               
                    }  else{
                        System.out.println("Por favor, primero ingrese 10 números en la opción 1");
                    }
                    continuarEnter(scanner); 
                    break;

                case 5:
                    limpiarpantalla();      
                    if (validacionDatosIngresados) 
                    {
                        invertirOrden(numeros);
                        
                    }else{
                        System.out.println("Por favor, primero ingrese 10 números en la opción 1");
                    } 
                    continuarEnter(scanner);
                    break;

                case 6:
                    limpiarpantalla(); 
                    System.out.println("Saliendo del programa....");                 
                    break;
            
                default:
                    System.out.println("Opción no válida, intente nuevamente");
                    continuarEnter(scanner);

            }
            if (opcion != 6) {
                continuarEnter(scanner);
            }
        } while (opcion != 6);
        scanner.close();
    }

    //LIMPIAR PANTALLA
    public static void limpiarpantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    //------------------------------------

    //PRESIONAR ENTER PARA CONTINUAR

    public static void continuarEnter(Scanner scanner) {
        System.out.println("Presione Enter....");
        scanner.nextLine();
    }
    //--------------------------------------

    //INGRESO DE LOS NÚMEROS
    public static void ingresoDatos(int[] numeros, Scanner scanner){
         System.out.println("Ingrese 10 números, escoja los que usted quiera");
        for (int i = 0; i < numeros.length; i++) {
            while (true) {
                try {
                    System.out.print("Número " + (i + 1) + ": ");
                    numeros[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error! por favor ingrese un número");
                    scanner.nextLine();
                }
            }
        }
    }
    //---------------------------------------

    //MOSTRAR LOS DATOS INGRESADOS
    public static void mostrarDatos(int[] numeros) {
        System.out.println("Números ingresados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
    //--------------------------------------

    //SUMA DE LAS 10 POSICIONES INGRESADAS

    public static int calcularSuma(int[] numeros) {
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        return suma;
    }

    //------------------------------------

    //MOSTRAR MÍNIMO Y MÁXIMO

    public static void calcularMinimoMaximo(int[] numeros) {
        int min = numeros[0];
        int max = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < min) {
                min = numeros[i];
            }
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        System.out.println("El Número Mínimo Ingresado Es: " + min + ", El número Máximo Ingresado Es: " + max);
    }
    //----------------------------------------

    //INVERTIR EL ORDEN DE INGRESO

    public static void invertirOrden(int[] numeros) {
        System.out.println("A continuación se mostrarán los datos en orden inverso al ingresado: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }

}
