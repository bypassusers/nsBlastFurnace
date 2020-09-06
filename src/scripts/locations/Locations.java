package scripts.locations;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.api2007.types.RSTile;

public enum Locations implements Positionable {

    BLAST_FURNACE(new RSArea(new RSTile(1934, 4975, 0), new RSTile(1958, 4955, 0))),
    GRAND_EXCHANGE(new RSArea(new RSTile(3161, 3492, 0), new RSTile(3168, 3486, 0)));

    private final RSArea rsArea;


    Locations(RSArea rsArea) {
        this.rsArea = rsArea;
    }

    public boolean contains(RSTile rsTile) {
        return rsArea.contains(rsTile);

    }

    @Override
    public RSTile getPosition() {
        return null;
    }

    @Override
    public boolean adjustCameraTo() {
        return false;
    }

    @Override
    public RSTile getAnimablePosition() {
        return null;
    }
}
