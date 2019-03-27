package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import model.CarroM;

@Named(value = "carC")
@SessionScoped
public class carC implements Serializable {

    private ArrayList<CarroM> lstCar = new ArrayList<>();
    private CarroM car = new CarroM();
    private List<CarroM> lstCarModelo;
    private List<CarroM> lstmenorKilometraje = new ArrayList<>();
    private List<Integer> lstKilometraje = new ArrayList<Integer>();
    private ArrayList<CarroM> lstorderbyKilometraje = new ArrayList<>();
    private List<CarroM> lstMayorKilometraje = new ArrayList<>();
    private int max, min;

    public void agregarCar() {
        try {
            car.setMarca(car.getMarca().toUpperCase());
            lstCar.add(car);
            car = new CarroM();

        } catch (Exception e) {
            throw e;
        }
    }

    public void filterCarMarca() {
        lstCarModelo = lstCar.stream().filter(car -> car.getMarca().contains("A")).collect(Collectors.toList());
    }

    public void menorKilometraje() {
        int i = 0;
        for (CarroM mKilometraje : lstCar) {
            lstmenorKilometraje.add(mKilometraje);
            lstKilometraje.add(Integer.parseInt(mKilometraje.getKilometraje()));
            min = lstKilometraje.get(i);
            for (i = 0; i < lstKilometraje.size(); i++) {
                System.out.println(lstKilometraje.get(i));
                if (min > lstKilometraje.get(i)) {
                    min = lstKilometraje.get(i);
                }
            }

        }
        lstmenorKilometraje = lstCar.stream().filter(car -> car.getKilometraje().contains(String.valueOf(min))).collect(Collectors.toList());

    }


    public void mayorKilometraje() {
        int i = 0;
        for (CarroM mKilometraje : lstCar) {
            lstMayorKilometraje.add(mKilometraje);
            lstKilometraje.add(Integer.parseInt(mKilometraje.getKilometraje()));
            max = lstKilometraje.get(i);
            for (i = 0; i < lstKilometraje.size(); i++) {
                System.out.println(lstKilometraje.get(i));
                if (max < lstKilometraje.get(i)) {
                    max = lstKilometraje.get(i);
                }
            }
        }
        lstMayorKilometraje = lstCar.stream().filter(car -> car.getKilometraje().contains(String.valueOf(max))).collect(Collectors.toList());
    }

    public void ordenadosKilometrajeDesc() {
        for (CarroM order : lstCar) {
            lstorderbyKilometraje.add(order);
        }
        Collections.sort(lstorderbyKilometraje, Collections.reverseOrder());
    }

    public List<CarroM> getLstCar() {
        return lstCar;
    }

    public void setLstCar(ArrayList<CarroM> lstCar) {
        this.lstCar = lstCar;
    }

    public CarroM getCar() {
        return car;
    }

    public void setCar(CarroM car) {
        this.car = car;
    }

    public List<CarroM> getLstCarModelo() {
        return lstCarModelo;
    }

    public void setLstCarModelo(List<CarroM> lstCarModelo) {
        this.lstCarModelo = lstCarModelo;
    }

    public List<CarroM> getLstmenorKilometraje() {
        return lstmenorKilometraje;
    }

    public void setLstmenorKilometraje(List<CarroM> lstmenorKilometraje) {
        this.lstmenorKilometraje = lstmenorKilometraje;
    }

    public List<Integer> getLstKilometraje() {
        return lstKilometraje;
    }

    public void setLstKilometraje(List<Integer> lstKilometraje) {
        this.lstKilometraje = lstKilometraje;
    }

    public List<CarroM> getLstMayorKilometraje() {
        return lstMayorKilometraje;
    }

    public void setLstMayorKilometraje(List<CarroM> lstMayorKilometraje) {
        this.lstMayorKilometraje = lstMayorKilometraje;
    }

    public ArrayList<CarroM> getLstorderbyKilometraje() {
        return lstorderbyKilometraje;
    }

    public void setLstorderbyKilometraje(ArrayList<CarroM> lstorderbyKilometraje) {
        this.lstorderbyKilometraje = lstorderbyKilometraje;
    }
}
