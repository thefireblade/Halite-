import java.util.ArrayList;
import java.util.List;

public class MyBot {
    public static void main(String[] args) throws java.io.IOException {

        final InitPackage iPackage = Networking.getInit();
        final int myID = iPackage.myID;
        final GameMap gameMap = iPackage.map;

        Networking.sendInit("MyJavaBot");
        boolean noOptionsLeft = false;

        while (noOptionsLeft) {
            List<Move> moves = new ArrayList<Move>();

            Networking.updateFrame(gameMap);

            for (int y = 0; y < gameMap.height; y++) {
                for (int x = 0; x < gameMap.width; x++) {
                    final Location location = gameMap.getLocation(x, y);
                    final Site site = location.getSite();
                    if (site.owner == myID) {

                        if (nextToEnemy)
                            moves.add(new Move(location, Direction.randomDirection()));
                    }
                }
            }

            Networking.sendFrame(moves);
        }

    }

    public String weakestSite(Location location) {
        boolean weakestFound = false;
        while (weakestFound) {
            int t1 = location(x + 1, y).getSite().strength;
            int t2 = location(x - 1, y).getSite().strength;
            int t3 = location(x, y + 1).getSite().strength;
            int t4 = location(x, y - 1).getSite().strength;
            int[] t = {t1, t2, t3, t4};
            Direction[] dir = {EAST, WEST, NORTH, SOUTH};
            Direction direction;
            int weakest = 255;
            for (int i = 0; i < 4; i++) {
                if (t[i] <= weakest) {
                    weakest = t[i];
                    direction = dir[i];
                }
            }
            return direction;


        }

    }

    public boolean ally(Location location) {
        return location.getSite().owner == myID;
    }

    public Location nearestEnemy(Location loc) {
        Location EndOfTheMap = new Location(gameMap.height, gameMap.width);
        Location CornerOfMap = new Location(0, 0);
        distance = getDistance(CornerOfMap, EndOfTheMap);
        Location closest = loc;
        for (int y = 0; y < gameMap.height) {
            for (int x = 0; x < gameMap.width) {
                final Location location = gameMap.getLocation(x, y);
                final Site site = location.getSite();
                if (distance <= getDistance(loc, location) && site.owner != myID) {
                    closest = direction;
                }

            }
        }
        return closest;
    }

    public boolean nextToEnemy() {
        for (int y = 0; y < gameMap.height) {
            for (int x = 0; x < gameMap.width) {
                final Location location = gameMap.getLocation(x, y);
                final Site site = location.getSite();
                if (2 == getDistance(nearestEnemy(location) {
                    return true;
                }
            }
        }
        return false;
    }
}
