package Retos2_3_1_y_2_3_2;

public class Cuenta {

    int numCuenta;
    double saldo;
    String nombreTitular;

    Cuenta(String nomTitular, int numeroCuenta, double saldoInicial) {
        nombreTitular = nomTitular;
        numCuenta = numeroCuenta;
        saldo = saldoInicial;
    }

    void depositar(double cantidad) {
        saldo = saldo + cantidad;

    }

    void retirar(double cantidad) {
        saldo = saldo - cantidad;

    }

    public double transferir1(double cantidad, Cuenta CuentaDestino) { //Versión 2: utiliza otros métodos de la clase Cuenta.

        this.retirar(cantidad);
        CuentaDestino.depositar(cantidad);
        return CuentaDestino.saldo;
    }

    public double transferir2(double cantidad, Cuenta CuentaDestino) { // Versión 1: no utiliza otros métodos de la clase
        saldo = saldo - cantidad;
        CuentaDestino.saldo = cantidad + CuentaDestino.saldo;
        return CuentaDestino.saldo;
    }

    public String cambiarTitular(String nombre) { // método que permite cambiar el titular de una cuenta, parte 2 del reto 2.3.
        nombreTitular = nombre.replaceAll(nombreTitular, nombre);
        return nombreTitular;
    }

    double retirar2(double cantidad) { //metodo retirar para objeto CuentaPrincipal en el main y mostrar el saldo restante de la cuenta principal no la de destino
        saldo = saldo - cantidad;
        return saldo;
    }

    /*double verSaldo() {
        return saldo;
    }*/
    @Override
    public String toString() {
        /*no le vamos a pasar ningun dato solo imprimir el metodo*/
        return "Nombre del Titular: " + nombreTitular + "\nNumero de Cuenta: " + numCuenta + "\nSaldo: " + saldo + "$";
    }
}
