package scripts.locations;

import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSItem;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.RunescapeBank;
import scripts.tasks.buyFromGE;
import java.util.function.Predicate;

public class walkToBF {
    private Predicate<RSItem> ORE_PREDICATE = o -> o.getDefinition().getName().contains("ore") || o.getDefinition().getName().contains("Coal");

    public walkToBF() {
        if (!Locations.BLAST_FURNACE.contains(Player.getPosition())) {
            General.println("[Script] Walking to Blast Furnace area.");
            DaxWalker.walkTo(Locations.BLAST_FURNACE);

        }
    }

}
