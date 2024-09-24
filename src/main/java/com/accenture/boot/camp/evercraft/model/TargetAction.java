package com.accenture.boot.camp.evercraft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetAction {
    protected CharacterSheet subject;
    protected CharacterSheet target;
    protected int damage;

    /**
     *
     * @param subject
     * @param target
     */
    public TargetAction(CharacterSheet subject, CharacterSheet target) {
        setSubject(subject);
        setTarget(target);
        setDamage(1);
    }

    /**
     *
     * @param dieRoll
     * @return
     */
    public boolean isSuccessful(int dieRoll) {
        return getSubject().roll(dieRoll) >= getTarget().getArmorClass();
    }

    /**
     *
     * @param dieRoll
     * @return
     */
    public int dealDamage(int dieRoll) {
        if(dieRoll == 20) {
            setDamage(this.damage * 2);
        }

        if(isSuccessful(dieRoll)) {
            target.takeDamage(getDamage());
        }

        return target.getHitPoints();
    }
}