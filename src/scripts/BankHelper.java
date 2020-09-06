package scripts;

import org.tribot.api2007.Banking;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;

public class BankHelper {
    public static boolean findFirstContainingName(String itemName) {
        final RSItem[] items = Banking.find(a -> {
            final RSItemDefinition def = a.getDefinition();
        if (def == null ) {
            return false;
        }
        final String name = def.getName();
        return name != null && name.contains(itemName);
        });
        if (items.length == 0) {
            return false;
        }
        return false;
    }
}
