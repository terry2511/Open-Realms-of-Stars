package org.openRealmOfStars.player.ship;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipComponentFactoryTest {

  @Test
  public void testEngines() {
    ShipComponent engine = ShipComponentFactory.createByName("Nuclear drive Mk4");
    assertEquals(3, engine.getSpeed());
    assertEquals(4, engine.getFtlSpeed());
    assertEquals(3, engine.getTacticSpeed());
    assertEquals(4, engine.getEnergyResource());
    assertEquals(0, engine.getEnergyRequirement());
    assertEquals(7, engine.getCost());
    assertEquals(7, engine.getMetalCost());
    engine = ShipComponentFactory.createByName("Impulse engine Mk4");
    assertEquals(3, engine.getSpeed());
    assertEquals(7, engine.getFtlSpeed());
    assertEquals(2, engine.getTacticSpeed());
    assertEquals(0, engine.getEnergyResource());
    assertEquals(2, engine.getEnergyRequirement());
    assertEquals(9, engine.getCost());
    assertEquals(8, engine.getMetalCost());
  }

  @Test
  public void testWeapons() {
    ShipComponent weapon = ShipComponentFactory.createByName("HE missile Mk2");
    assertEquals(4, weapon.getDamage());
    assertEquals(3, weapon.getWeaponRange());
    assertEquals(0, weapon.getEnergyRequirement());
    assertEquals(3, weapon.getCost());
    assertEquals(7, weapon.getMetalCost());
    weapon = ShipComponentFactory.createByName("Massdrive Mk1");
    assertEquals(6, weapon.getDamage());
    assertEquals(3, weapon.getWeaponRange());
    assertEquals(3, weapon.getEnergyRequirement());
    assertEquals(5, weapon.getCost());
    assertEquals(5, weapon.getMetalCost());
  }

  @Test
  public void testDefense() {
    ShipComponent defense = ShipComponentFactory.createByName("Shield Mk8");
    assertEquals(8, defense.getDefenseValue());
    assertEquals(3, defense.getEnergyRequirement());
    assertEquals(11, defense.getCost());
    assertEquals(3, defense.getMetalCost());
    defense = ShipComponentFactory.createByName("Armor plating Mk8");
    assertEquals(8, defense.getDefenseValue());
    assertEquals(0, defense.getEnergyRequirement());
    assertEquals(5, defense.getCost());
    assertEquals(11, defense.getMetalCost());
  }

  @Test
  public void testElectronics() {
    ShipComponent electronics = ShipComponentFactory.createByName("Cloaking device Mk3");
    assertEquals(60, electronics.getCloaking());
    assertEquals(2, electronics.getEnergyRequirement());
    assertEquals(4, electronics.getCost());
    assertEquals(2, electronics.getMetalCost());
    electronics = ShipComponentFactory.createByName("Orbital bombs Mk1");
    assertEquals(40, electronics.getDamage());
    assertEquals(0, electronics.getEnergyRequirement());
    assertEquals(6, electronics.getCost());
    assertEquals(3, electronics.getMetalCost());
  }

}