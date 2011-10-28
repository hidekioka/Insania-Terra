package game.util;

import game.unit.Unit;

public class FightController {

	public static String fight(Unit player, Unit enemy) {
		String fightLog = "";
		fightLog = fightLog.concat("Fight against: " + enemy.getName() + "\n");
		while (enemy.getActualHitPoints() > 0 && player.getActualHitPoints() > 0) {
			Integer damageTakenByPlayer = DamageCalculator.calculatePhysicalDamage(enemy, player);
			Integer damageTakenByEnemy = DamageCalculator.calculatePhysicalDamage(player, enemy);
			player.takeDamage(damageTakenByPlayer);
			enemy.takeDamage(damageTakenByEnemy);
			// fightLog = fightLog.concat(player.getName() + " gets " +
			// damageTakenByPlayer + " damage." + "\n");
			// fightLog = fightLog.concat(enemy.getName() + " gets " +
			// damageTakenByEnemy + " damage." + "\n");
		}
		if (player.getActualHitPoints() <= 0) {
			fightLog = fightLog.concat(player.getName() + " has died.\n");
		}
		if (enemy.getActualHitPoints() <= 0) {
			fightLog = fightLog.concat(enemy.getName() + " has died.\n");
			fightLog = fightLog.concat(player.addExperience(enemy.getExperienceGiven()));
			enemy.fullHeal();
		}
		return fightLog;
	}
}
