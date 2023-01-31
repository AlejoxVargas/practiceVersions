package For;

import java.util.Scanner;

public class Clase_For_Alejandro_Vargas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Clase_For_Alejandro_Vargas.requestExercise();
    }

    //Desde el main se pedirá al usuario qué ejercicio quiere ejecutar. Utilizar para ello switch-case. Este proceso se deberá repetir 12 veces.
    public static void requestExercise() {
        System.out.println("Escriba ejercicio a ejecutar: ");
        String caracter = sc.nextLine();
        while (!".".equals(caracter)) {
            switch (caracter) {
                case "1" ->
                    Clase_For_Alejandro_Vargas.number100to7();
                case "2" ->
                    Clase_For_Alejandro_Vargas.numTotalCount();
                case "3" ->
                    Clase_For_Alejandro_Vargas.productNumber();
                case "4" ->
                    Clase_For_Alejandro_Vargas.factorialNumber();
                case "5" ->
                    Clase_For_Alejandro_Vargas.requestSalary();
                case "6" ->
                    Clase_For_Alejandro_Vargas.averageNumbers();
                case "7" ->
                    Clase_For_Alejandro_Vargas.sumSalaries();
                case "8" ->
                    Clase_For_Alejandro_Vargas.studentsClass();
                case "9" ->
                    Clase_For_Alejandro_Vargas.multiplicationTables();
                case "10" ->
                    Clase_For_Alejandro_Vargas.clientReceipt();
                case "11" ->
                    Clase_For_Alejandro_Vargas.studentScores();
                case "12" ->
                    Clase_For_Alejandro_Vargas.negativeNumbers();
            }
            System.out.println("\nEscriba otro ejercicio a ejecutar: ");
            caracter = sc.nextLine();
        }
        System.out.println("Proceso Final Acabado");
    }

    //1. Escribir todos los números del 100 al 0 de 7 en 7.
    public static void number100to7() {
        System.out.println("1. Escribir todos los números del 100 al 0 de 7 en 7.\n");
        for (int i = 100; i >= 0; i -= 7) {
            System.out.println(i);
        }
    }

    //2. Pedir 15 números y escribir la suma total.
    public static void numTotalCount() {
        System.out.println("2. Pedir 15 números y escribir la suma total.\n");
        int numGet = 0;
        for (int i = 0; i < 15; i++) {
            System.out.println("Escriba un numero a sumar: ");
            numGet += sc.nextInt();
        }
        System.out.println("Suma total de los 15 números: " + numGet);
        sc.nextLine();
    }

    //3. Diseñar un programa que muestre el producto de los 10 primeros números impares.
    public static void productNumber() {
        System.out.println("3. Diseñar un programa que muestre el producto de los 10 primeros números impares.\n");
        int product = 1;
        for (int i = 1; i <= 19; i += 2) {
            product *= i;
        }
        System.out.println("Producto: " + product);
    }

    //4. Pedir un número y calcular su factorial. //que se ejecute mas veces
    public static void factorialNumber() {
        int factorial = 1;
        System.out.println("4. Pedir un número y calcular su factorial.\n");
        System.out.println("Escriba un numero: ");
        for (int j = sc.nextInt(); j != 0; j--) {
            factorial *= j;
        }
        System.out.println("Factorial: " + factorial);
        sc.nextLine();
    }

    //5. Pedir un número N, introducir N sueldos, y mostrar el sueldo máximo.
    public static void requestSalary() {
        int salaryN, maxSalary = 0, salaryQuantity;
        System.out.println("5. Pedir un número N, introducir N sueldos, y mostrar el sueldo máximo.\n");
        System.out.println("¿Cuantos sueldos quiere introducir?: ");
        salaryQuantity = sc.nextInt();
        for (int i = 0; i < salaryQuantity; i++) {
            System.out.println("Escriba sueldo: ");
            salaryN = sc.nextInt();
            if (salaryN > maxSalary) {
                maxSalary = salaryN;
            }
        }
        System.out.println("Sueldo Maximo: " + maxSalary);
        sc.nextLine();
    }

    //6. Pedir 10 números. Mostrar la media de los números positivos, la media de los números negativos y la cantidad de ceros. //ojo falta arreglar porque negativo init error
    public static void averageNumbers() {
        System.out.println("6. Pedir 10 números. Mostrar la media de los números positivos, la media de los números negativos y la cantidad de ceros.\n");
        int numberAsk, positiveNumber = 0, countSum = 0, negativeNumber = 0, countRest = 0, countCero = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Escribir 10 numeros: ");
            numberAsk = sc.nextInt();
            if (numberAsk > 0) {
                positiveNumber += numberAsk;
                countSum++;
            } else if (numberAsk < 0) {
                negativeNumber += numberAsk;
                countRest++;
            } else if (numberAsk == 0) {
                countCero++;
            }
        }
        System.out.println("Media de numeros positivos: " + positiveNumber / countSum);
        System.out.println("Media de numeros negativos: " + negativeNumber / countRest);
        System.out.println("Cantidad de ceros: " + countCero);
        sc.nextLine();
    }

    //7. Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 1000€.
    public static void sumSalaries() {
        System.out.println("7. Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 1000€.");
        int maximum = 0, sumSalaries = 0;
        for (int i = 0, salary; i < 10; i++) {
            System.out.println("Escriba 10 sueldos: ");
            salary = sc.nextInt();
            if (salary >= 1000) {
                maximum++;
            }
            sumSalaries += salary;
        }
        System.out.println("Suma Total:\n" + sumSalaries + "\nSalarios Mayores a 1000:\n" + maximum);
        sc.nextLine();
    }

    //8. Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media, la cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden más de 1.75.
    public static void studentsClass() {
        int age, averageAge = 0, countAge = 0, countMaxAge = 0, countMaxHeight = 0;
        double height, averageHeight = 0, countHeight = 0;
        System.out.println("8. Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media, la cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden más de 1.75.\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Escriba edad del alumno: ");
            age = sc.nextInt();
            averageAge += age;
            countAge++;
            if (age >= 18) {
                countMaxAge++;
            }
            System.out.println("Escriba altura del alumno: ");
            height = sc.nextDouble();
            averageHeight += height;
            countHeight++;
            if (height > 1.75) {
                countMaxHeight++;
            }
        }
        System.out.println("Edad promedio: " + averageAge / countAge);
        System.out.println("Altura promedio: " + averageHeight / countHeight);
        System.out.println("Alumnos mayores de 18 años: " + countMaxAge);
        System.out.println("Alumnos que miden más de 1.75: " + countMaxHeight);
        sc.nextLine();
    }

    //9. Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de multiplicar de dicho número.
    public static void multiplicationTables() {
        System.out.println("9. Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de multiplicar de dicho número.\n");
        System.out.println("Introduce una tabla del 0 al 10: ");
        int numberTable = sc.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(numberTable + "x" + i + " = " + numberTable * i);
        }
    }

    /*10. Una empresa que se dedica a la venta de desinfectantes necesita un programa para gestionar las facturas. 
    En cada factura figura: el código del artículo, la cantidad vendida en litros y el precio por litro. Se pide de 5 facturas introducidas: 
    Facturación total,cantidad en litros vendidos del artículo 1 y cuantas facturas se emitieron de más de 600 €.*/
    public static void clientReceipt() {
        System.out.println("10. Una empresa que se dedica a la venta de desinfectantes necesita un programa para gestionar las facturas. \n"
                + "    En cada factura figura: el código del artículo, la cantidad vendida en litros y el precio por litro. Se pide de 5 facturas introducidas: \n"
                + "    Facturación total,cantidad en litros vendidos del artículo 1 y cuantas facturas se emitieron de más de 600 €.\n");
        int codeArticle, clientReceiptMax = 0;
        double litersSold, literPrice, totalBilling = 0, quantityLitersSold = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Escriba código articulo: ");
            codeArticle = sc.nextInt();
            System.out.println("Escriba cantidad de litros vendida: ");
            litersSold = sc.nextDouble();
            if (codeArticle == 1) {
                quantityLitersSold += litersSold;
            }
            System.out.println("Escriba precio por litro: ");
            literPrice = sc.nextDouble();
            if (literPrice * litersSold > 600) {
                clientReceiptMax++;
            }
            totalBilling += literPrice * litersSold;
        }
        System.out.println("Facturación Total: " + totalBilling + "\nCantidad de litros vendidos 1 articulo: " + quantityLitersSold
                + "\nNumero de facturas mayores a 600€: " + clientReceiptMax);
        sc.nextLine();
    }

    //11. Dadas 6 notas (números enteros), escribir la cantidad de alumnos aprobados, condicionados (=4) y suspensos.
    public static void studentScores() {
        System.out.println("11. Dadas 6 notas (números enteros), escribir la cantidad de alumnos aprobados, condicionados (=4) y suspensos.\n");
        int approvedStudents = 0, reprovedStudents = 0, conditionedStudents = 0;
        for (int i = 1; i <= 6; i++) {
            System.out.println("Introducir una nota: ");
            int studentScore = sc.nextInt();
            if (studentScore >= 5) {
                approvedStudents++;
            }
            if (studentScore < 4) {
                reprovedStudents++;
            }
            if (studentScore == 4) {
                conditionedStudents++;
            }
        }
        System.out.println("Aprobados: " + approvedStudents + "\nCondicionados: " + conditionedStudents + "\nSuspensos: " + reprovedStudents);
        sc.nextLine();
    }

    //12. Pedir 10 números, y mostrar al final cuantos negativos se han introducido.
    public static void negativeNumbers() {
        System.out.println("12. Pedir 10 números, y mostrar al final cuantos negativos se han introducido.\n");
        int negativeCount = 0, stringCount = 10;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce " + stringCount + " numeros: ");
            int numberCount = sc.nextInt();
            stringCount--;
            if (numberCount <= -1) {
                negativeCount++;
            }
        }
        System.out.println("Numeros negativos: " + negativeCount);
        sc.nextLine();
    }
}
