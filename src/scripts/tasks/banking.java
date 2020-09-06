package scripts.tasks;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.antiban.antiban;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.RunescapeBank;
import scripts.dax_api.shared.helpers.BankHelper;

import java.util.function.Predicate;

public class banking {
    private final Predicate<RSItem> BAR_PREDICATE = b -> b.getDefinition().getName().contains("bar");

    public banking() {
        if (!Banking.isBankScreenOpen()) {
            antiban.getBankPreference();
            if (Inventory.find(BAR_PREDICATE).length > 1) {
                DaxWalker.walkToBank(RunescapeBank.BLAST_FURNACE_BANK);

            }
        }
    }
}
