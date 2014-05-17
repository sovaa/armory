/*
 * This software is the confidential and proprietary information of
 * Sigma Systems Innovation. ("Confidential Information"). You shall
 * not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sigma Systems Innovation.
 *
 * COPYRIGHT (C) 2014 SIGMA SYSTEMS INNOVATION AB.
 * All rights reserved.
 */
package org.eldslott.armory.entity;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/15/14
 */
public class CreatureEntity extends BaseEntity {
    private static final CreatureEntity UNKNOWN_ENTITY = new CreatureEntity(null, null, null, null, null, null, null);

    private String name;
    private Integer hp;
    private Double regen;
    private Integer damage;
    private Integer threat;
    private Integer maturity;

    private CreatureEntity(String backendId, String name, Integer hp, Double regen, Integer damage, Integer threat, Integer maturity) {
        this.backendId = backendId;
        this.name = name;
        this.hp = hp;
        this.regen = regen;
        this.damage = damage;
        this.threat = threat;
        this.maturity = maturity;
    }

    public static CreatureEntity create(String backendId, String name, Integer hp, Double regen, Integer damage, Integer threat, Integer maturity) {
        return new CreatureEntity(backendId, name, hp, regen, damage, threat, maturity);
    }


    @Override
    public String toString() {
        return "CreatureEntity{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", regen=" + regen +
                ", damage=" + damage +
                ", threat=" + threat +
                ", maturity=" + maturity +
                "} " + super.toString();
    }

    public static CreatureEntity unknown() {
        return UNKNOWN_ENTITY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Double getRegen() {
        return regen;
    }

    public void setRegen(Double regen) {
        this.regen = regen;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getThreat() {
        return threat;
    }

    public void setThreat(Integer threat) {
        this.threat = threat;
    }

    public Integer getMaturity() {
        return maturity;
    }

    public void setMaturity(Integer maturity) {
        this.maturity = maturity;
    }
}
