package game.util;

import game.unit.Unit;

public class DamageCalculator {

	public static Integer calculatePhysicalDamage(Unit attacker, Unit defender) {
		Double calculatedAttack;
		Double damage;
		calculatedAttack = (Math.random() * (attacker.getMaxAttack() - attacker.getMinAttack() + 1));
		damage = attacker.getMinAttack() + calculatedAttack - defender.getDefense();
		if (damage < 1.0) {
			damage = 1.0;
		}

		return new Integer(Math.max(0, damage.intValue()));
	}
}
