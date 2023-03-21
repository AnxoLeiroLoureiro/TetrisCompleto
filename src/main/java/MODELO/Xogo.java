/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import IU.VentanaPrincipal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author a22hugorp
 */
public class Xogo {

    public final int LADOCADRADO = 50;
    private int MAX_X = 450;
    private int MAX_Y = 650;
    private boolean pausa;
    public int numeroLineas = 0;
    private Ficha fichaActual;
    private ArrayList<Cadrado> cadradosChan = new ArrayList();
    private VentanaPrincipal ventanaPrincipal;

    public Xogo(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void moverFichaDereita() {
        if (fichaActual.moverDereita() && !pausa) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext() && ePosicionValida(MAX_X, MAX_Y)) {
                if (ePosicionValida(MAX_X, MAX_Y)) {
                    Cadrado item = iter.next();
                    item.lblCadrado.setLocation(item.x + LADOCADRADO, item.y);
                    item.x += LADOCADRADO;
                }
                System.out.println("Mover cadrado dereita");
            }
            actualizarGraf();
        }
    }

    public void moverFichaEsquerda() {

        if (fichaActual.moverEsquerda() && !pausa) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext()) {
                if (ePosicionValida(MAX_X, MAX_Y)) {
                    Cadrado item = iter.next();
                    item.lblCadrado.setLocation(item.x - LADOCADRADO, item.y);
                    item.x -= LADOCADRADO;
                }
            }
            System.out.println("mover cadrado esquerda");
        }
        actualizarGraf();
    }

    public void rotarFicha() {
        if (ePosicionValida(MAX_X, MAX_Y) && !pausa) {
            fichaActual.rotar();
            actualizarGraf();
        }
    }

    public boolean ePosicionValida(int x, int y) {
        boolean posicionValida = true;
        if (x > MAX_X || x < 0 || y > MAX_Y || y < -LADOCADRADO) {
            posicionValida = false;
            System.out.println("non se rotou");
        } else {
            Iterator<Cadrado> iter = cadradosChan.iterator();
            while (iter.hasNext()) {
                Cadrado chan = iter.next();
                if ((chan.getX() == x && chan.getY() == y)) {
                    posicionValida = false;
                }
            }

        }
        return posicionValida;
    }

    public void xenerarNovaFicha() {
        fichaActual = fichaAleatoria();
        Iterator<Cadrado> its = fichaActual.cadrados.iterator();
        while (its.hasNext()) {
            Cadrado c = its.next();
            ventanaPrincipal.pintarCadrado(c.getLblCadrado());
            System.out.println("nova ficha creada");
        }
    }

    private Ficha fichaAleatoria() {
        int aleatorio = (int) Math.floor(Math.random() * 4 + 1);
        Ficha fichaleatoria = null;
        switch (aleatorio) {
            case 1 -> {
                fichaleatoria = new FichaBarra(this);

            }
            case 2 -> {
                fichaleatoria = new FichaCadrada(this);

            }
            case 3 -> {
                fichaleatoria = new FichaL(this);

            }
            case 4 -> {
                fichaleatoria = new FichaT(this);

            }
        }
        return fichaleatoria;
    }

    public void engadirFichaAoChan() {
        for (int i = 0; i < 4; i++) {
            this.cadradosChan.add(this.fichaActual.cadrados.get(i));
        }

        this.xenerarNovaFicha();    //Consider changing this call to other position
        this.borrarLinasCompletas();
    }

    public void borrarLinasCompletas() {
        boolean eliminarFila;
        for (int contador = 0; contador < cadradosChan.size(); contador++) {
            eliminarFila = true;
            for (int posicion = 0; posicion < 10 && eliminarFila; posicion++) {
                if (!comprobarCadradosChan(posicion * LADOCADRADO, cadradosChan.get(contador).getY())) {
                    eliminarFila = false;
                } else if (posicion == 9) {
                    borrarLina(cadradosChan.get(contador).getY());
                    numeroLineas++;
                }
            }
        }
    }

    public void borrarLina(int y) {
        for (int contador = 0; contador < getCadradosChan().size(); contador++) {
            if (getCadradosChan().get(contador).getY() == y) {
                getVentanaPrincipal().borrarCadrado(getCadradosChan().get(contador).getLblCadrado());
                getCadradosChan().remove(getCadradosChan().get(contador));
                contador--;
            }
        }
        moverAbaixoChan(y);
    }

    public boolean chocaFichaCoChan() {
        boolean tocaChan = false;
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if (item.getY() == MAX_Y || comprobarCadradosChan(item.getY(), item.getX())) {
                tocaChan = true;
                System.out.println("Ficha chocou co chan");
            }
        }

        return tocaChan;
    }

    private boolean comprobarCadradosChan(int y, int x) {
        boolean chocaCoChan = false;
        Iterator<Cadrado> iter = cadradosChan.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if ((item.getY() == (y + LADOCADRADO)) && (item.getX() == x)) {
                chocaCoChan = true;
            }
        }
        return chocaCoChan;
    }

    public void moverFichaAbaixo() {
        if(!pausa){
        fichaActual.moverAbaixo();
        actualizarGraf();
        }
    }

    private void actualizarGraf() {
        if (chocaFichaCoChan()) {
            engadirFichaAoChan();
            xenerarNovaFicha();
        }
    }

    private void moverAbaixoChan(int y) {
        for (int i = 0; i < cadradosChan.size(); i++) {
            if (cadradosChan.get(i).y < MAX_Y) {

                ventanaPrincipal.borrarCadrado(cadradosChan.get(i).lblCadrado);
                cadradosChan.get(i).y = cadradosChan.get(i).y + 30;
                cadradosChan.get(i).lblCadrado.setLocation(cadradosChan.get(i).lblCadrado.getX(), cadradosChan.get(i).lblCadrado.getY() + 30);
                ventanaPrincipal.pintarCadrado(cadradosChan.get(i).lblCadrado);

            }
        }
    }

    public ArrayList<Cadrado> getCadradosChan() {
        return cadradosChan;
    }

    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }

    public int getLADOCADRADO() {
        return LADOCADRADO;
    }

    public boolean isPausa() {
        return pausa;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public Ficha getFichaActual() {
        return fichaActual;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }
}
