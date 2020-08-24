package scripts.antiban;

import com.sun.tools.javah.Gen;
import org.tribot.api.General;
import org.tribot.api.util.abc.ABCProperties;
import org.tribot.api.util.abc.ABCUtil;
import org.tribot.api.util.abc.preferences.OpenBankPreference;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Player;

public class antiban {
    private static ABCUtil abc = new ABCUtil();


    public antiban() {

        final int waiting_time = getWaitingTime();
        final boolean hovering = abc.shouldHover();
        final boolean openMenu = abc.shouldOpenMenu();
        final ABCProperties properties = abc.getProperties();
        properties.setHovering(hovering);
        properties.setMenuOpen(openMenu);
        properties.setWaitingFixed(false);

        final int reaction_time = abc.generateReactionTime();
        try {
            abc.sleep(reaction_time);
        } catch (final InterruptedException e) {
            e.printStackTrace();
            General.println("[Antiban] Unexpected error when generating a reaction time");
        }

    }
    public static int getWaitingTime() {
        General.println("[Antiban] Generating a reaction time...");
        final int generated_reaction_time = abc.generateReactionTime();
        General.println("[Antiban] Generated a reaction time: " + generated_reaction_time + "ms");
        return generated_reaction_time;


    }

    public static OpenBankPreference getBankPreference() {
        final OpenBankPreference preference = abc.generateOpenBankPreference();
        switch (preference) {
            case BOOTH:
                Banking.openBankBooth();
                break;
            case BANKER:
                Banking.openBankBanker();
                break;
            default:
                throw new RuntimeException("[Antiban] Unexpected error while generating bank preference");

        }
        return preference;

    }

}

