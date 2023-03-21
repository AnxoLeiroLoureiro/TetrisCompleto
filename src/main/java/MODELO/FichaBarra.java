/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.awt.Color;

/**
 *
 * @author thicc
 */
public class FichaBarra extends Ficha {

    Cadrado c1 = new Cadrado(250, -50, Color.RED);
    Cadrado c2 = new Cadrado(250, 0, Color.RED);
    Cadrado c3 = new Cadrado(250, 50, Color.RED);
    Cadrado c4 = new Cadrado(250, 100, Color.RED);
    private int posicion = 0;

    public FichaBarra(Xogo xogo) {
        super(xogo);
        cadrados.add(c1);
        cadrados.add(c2);
        cadrados.add(c3);
        cadrados.add(c4);
    }

    @Override
    public boolean rotar() {
        boolean rotar = true;
        switch (posicion) {
            case 0 -> {
                if (super.xogo.ePosicionValida(posicion, posicion) && c1.x < 0 && c2.x < 0 && c2.x < 400 && c3.x > 450 && c4.x > 450) {
                    rotar0();
                } else if (super.xogo.ePosicionValida(posicion, posicion) && c1.x != 0 && c2.x != 0 && c2.x != 400 && c3.x != 450 && c4.x != 450) {
                    rotar0();
                }
            }
            case 1 -> {
                rotar1();
            }

        }
        if (posicion == 2) {
            posicion = 0;
        }
        return rotar;
    }

    private void rotar0() {
        c1.lblCadrado.setLocation(c1.x - xogo.LADOCADRADO, c1.y + xogo.LADOCADRADO);
        c1.x -= xogo.LADOCADRADO;
        c1.y += xogo.LADOCADRADO;
        c3.lblCadrado.setLocation(c3.x + xogo.LADOCADRADO, c3.y - xogo.LADOCADRADO);
        c3.x += xogo.LADOCADRADO;
        c3.y -= xogo.LADOCADRADO;
        c4.lblCadrado.setLocation(c4.x + (xogo.LADOCADRADO * 2), c4.y - (xogo.LADOCADRADO * 2));
        c4.x += (xogo.LADOCADRADO * 2);
        c4.y -= (xogo.LADOCADRADO * 2);
        posicion++;
    }

    private void rotar1() {
        c1.lblCadrado.setLocation(c1.x + xogo.LADOCADRADO, c1.y - xogo.LADOCADRADO);
        c1.x += xogo.LADOCADRADO;
        c1.y -= xogo.LADOCADRADO;
        c3.lblCadrado.setLocation(c3.x - xogo.LADOCADRADO, c3.y + xogo.LADOCADRADO);
        c3.x -= xogo.LADOCADRADO;
        c3.y += xogo.LADOCADRADO;
        c4.lblCadrado.setLocation(c4.x - (xogo.LADOCADRADO * 2), c4.y + (xogo.LADOCADRADO * 2));
        c4.x -= (xogo.LADOCADRADO * 2);
        c4.y += (xogo.LADOCADRADO * 2);
        posicion++;
    }
}
