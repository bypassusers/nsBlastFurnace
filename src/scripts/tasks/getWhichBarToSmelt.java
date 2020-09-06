package scripts.tasks;

import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.api2007.types.RSPlayerDefinition;
import scripts.BarToSmelt.SmithAdamantBars;
import scripts.BarToSmelt.SmithRuniteBars;
import scripts.BarToSmelt.SmithSteelBars;

public class getWhichBarToSmelt {
    public getWhichBarToSmelt() {
        if (Skills.SKILLS.SMITHING.getActualLevel() >= 69) {
            new SmithSteelBars();

        }
        if (Skills.SKILLS.SMITHING.getActualLevel() >= 84) {
            new SmithAdamantBars();
        }
        if (Skills.SKILLS.SMITHING.getActualLevel() <= 85) {
            new SmithRuniteBars();
        }
    }
}
