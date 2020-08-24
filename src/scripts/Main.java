package scripts;
import com.sun.tools.javah.Gen;
import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.GrandExchange;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSItem;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.antiban.antiban;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;
import scripts.locations.Locations;

import java.util.function.Predicate;


@ScriptManifest(
        authors = "notsmile" ,
        category = "Minigames" ,
        name = "nsBlastFurnace Account Creator (PRIVATE)")

public class Main extends Script {
    private Predicate<RSItem> COINS_PREDICATE = c -> c.getDefinition().getName().contains("Coins");

    public static void main(String[] args) {
    }

    public void onStart() {
        General.println("[Start] Starting nsBlastFurnace");
        class setDaxCreds {
            public setDaxCreds() {
                DaxWalker.setCredentials(new DaxCredentialsProvider() {
                    @Override
                    public DaxCredentials getDaxCredentials() {
                        return new DaxCredentials("sub_DPjcfqN4YkIxm8", "sub_DPjXXzL5DeSiPf");
                    }
                });
            }
        }
    }
    @Override
    public void run() {
        DaxWalker.getInstance();
        if (Locations.GRAND_EXCHANGE.contains(Player.getPosition())) {
            antiban.getBankPreference();
            General.sleep(antiban.getWaitingTime());
            Banking.withdraw(999_999_999, "Coins");



        }






    }
}
