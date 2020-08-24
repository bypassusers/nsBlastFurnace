package scripts.tasks;

import com.sun.jdi.Location;
import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.GrandExchange;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSItem;
import scripts.antiban.antiban;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.RunescapeBank;
import scripts.dax_api.walker_engine.navigation_utils.GnomeGlider;
import scripts.locations.Locations;

import java.util.function.Predicate;

public class buyFromGE {

    private Predicate<RSItem> ORE_PREDICATE = o -> o.getDefinition().getName().contains("ore") || o.getDefinition().getName().contains("Coal");
    private Predicate<RSItem> COINS_PREDICATE = c -> c.getDefinition().getName().contains("Coins");
    private Predicate<RSItem> BAR_PREDICATE = b -> b.getDefinition().getName().contains("bars");
    buyFromGE() {
        if (!Locations.GRAND_EXCHANGE.contains(Player.getPosition()) && Banking.find(ORE_PREDICATE).length < 1) {
            DaxWalker.walkToBank(RunescapeBank.GRAND_EXCHANGE);

        }
        if (Locations.GRAND_EXCHANGE.contains(Player.getPosition()) && !Banking.isBankScreenOpen() || Banking.isBankLoaded()) {
            General.sleep(antiban.getWaitingTime());
            antiban.getBankPreference();
            General.sleep(antiban.getWaitingTime());
            if (Banking.isBankLoaded()) {
                if (Banking.find(COINS_PREDICATE).length < 1_000_000) {
                    General.sleep(antiban.getWaitingTime());
                    Banking.withdraw(999999, "Coins");


                }
                if (Banking.find(COINS_PREDICATE).length > 1_000_000 && Inventory.find(BAR_PREDICATE).length < 200) {
                    General.sleep(antiban.getWaitingTime());
                    Banking.close();
                    General.sleep(antiban.getWaitingTime());





                }

            }





        }

    }
}
