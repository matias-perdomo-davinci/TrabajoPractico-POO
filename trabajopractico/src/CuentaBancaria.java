import java.util.Scanner;

public class CuentaBancaria {
    // ATRIBUTOS
    String nombreCliente;
    String dniCliente;
    double saldo;
    double ultimoMovimiento;

    // CONSTRUCTORES
    public CuentaBancaria(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }
    public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.saldo = saldo;
    }

    // METODOS
    public void depositar(double cantidad){
        this.saldo=this.saldo + cantidad;
        this.ultimoMovimiento=cantidad;
    }
    public void retirar(double cantidad){
        this.saldo=this.saldo - cantidad;
        this.ultimoMovimiento= - cantidad;
    }
    public void consultarUltimoMovimiento(){
        if (ultimoMovimiento > 0){
            System.out.println("ULTIMO MOVIMIENTO:");
            System.out.println("Deposito: $" + ultimoMovimiento);
        }
        else if (ultimoMovimiento < 0){
            System.out.println("ULTIMO MOVIMIENTO:");
            System.out.println("Retiro: $" + ultimoMovimiento);
        }
        else {
            System.out.println("No se han realizado transacciones");
        }
    }
    public void mostrarMenu(){
        System.out.println("Bienvenido " + this.nombreCliente);
        int num;
        do {
        System.out.println("=====================");
        System.out.println("Ingrese una opción: \n 1:Consultar Saldo. \n 2:Depositar. \n 3:Retirar. \n 4:Consultar ultimo movimiento. \n 5:Salir");
        System.out.println("=====================");
        Scanner teclado=new Scanner(System.in);
        num=teclado.nextInt();
        int cant;
        switch (num){
            case 1:
                System.out.println("Su saldo es de: $" + this.saldo);
                break;
            case 2:
                System.out.println("Ingrese monto a depositar: ");
                cant= teclado.nextInt();
                depositar(cant);
                break;
            case 3:
                System.out.println("Ingrese monto a retirar: ");
                cant= teclado.nextInt();
                retirar(cant);
                break;
            case 4:
                consultarUltimoMovimiento();
                break;
            case 5:
                System.out.println("Muchas gracias!!! Saliendo...");
                break;
            default:
                System.out.println("Opción inválida, intente de nuevo");
        }
        }while (num != 5);
    }
}
