/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public class Townie extends Game{

    public Townie(int health) {
        super(health);
    }

    @Override
    public boolean winCondition(int pirateId, int townieId) {
        return (pirateId != townieId);
    }

}
