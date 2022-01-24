package Clases;

public class CuentaBancaria {
    private String nombreCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;

    //Constructor por defecto
    public CuentaBancaria() {

    }

    //Constructor con todos los parametros
    public CuentaBancaria(String nombreCliente, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
    }

    //Constructor copia
    public CuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.nombreCliente = cuentaBancaria.getNombreCliente();
        this.numeroCuenta = cuentaBancaria.getNumeroCuenta();
        this.tipoInteres = cuentaBancaria.getTipoInteres();
        this.saldo = cuentaBancaria.getSaldo();
    }

    //GETTER AND SETTER
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Metodo para ingresar dinero, yo pienso que introducir una
    //cantidad 0 o menor a 0 como resultado sea false
    public boolean ingresarDinero(double dinero) {
        boolean operacion = false;
        if (dinero > 0) {
            this.setSaldo(this.getSaldo() + dinero);
            operacion = true;
        }
        return operacion;
    }

    public boolean retirarDinero(double dinero) {
        boolean operacion = false;
        if (saldoSuficiente(dinero)) {
            setSaldo(getSaldo() - dinero);
            operacion = true;
        }
        return operacion;
    }

    public boolean transferencia(CuentaBancaria destino, double dinero){
        boolean operacion = false;
        if (this.retirarDinero(dinero)){
            destino.ingresarDinero(dinero);
            operacion = true;
        }
        return operacion;
    }

    private boolean saldoSuficiente(double dinero) {
        boolean operacion = false;
        if (getSaldo() - dinero >= 0) {
            operacion = true;
        }
        return operacion;
    }

}
