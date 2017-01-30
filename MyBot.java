import java.util.ArrayList;
import java.util.List;

public class MyBot {
    GameMap gameMap = new GameMap();
    public static void main(String[] args) throws java.io.IOException {

        final InitPackage iPackage = Networking.getInit();
        final int myID = iPackage.myID;
        final GameMap gameMap = iPackage.map;


        Networking.sendInit("JasonTheDestroyer");

        while (true) {
            List<Move> moves = new ArrayList<Move>();

            Networking.updateFrame(gameMap);

            for (int y = 0; y < gameMap.height; y++) {
                for (int x = 0; x < gameMap.width; x++) {
                    final Location location = gameMap.getLocation(x, y);
                    final Site site = location.getSite();
                    if (site.owner == myID) {
                        moves.add(new Move(location, moveToLocation(location,locationAfterDirection(weakestSite(location)))));
                      /*  if (nextToEnemy()) {
                            moves.add(new Move(location, moveToLocation(weakestSite(location))));
                        } else {
                            moves.add(new Move(location, );
                    }
                    moves.add(new Move(location, Direction.randomDirection()));  */
                    }
                }

                Networking.sendFrame(moves);
            }

        }
    }
    // Build a method that will identify the area that you control
    // Build a method that will help you identify

  /*  private Direction expandToArea(location) {

    }
    */
   /* private static boolean overStacking(Location location) {
        if(weakestSite(location) || ally(weakes))
        if(location.getSite.strength + locationAfterDirection(location, weakestSite(location)).strength <= 255) {
            return false;
        } else {
        return true;
    }
    }
    */

    private static Location locationAfterDirection(Location location, Direction direction) {
        Direction NORTH, SOUTH, WEST, EAST;
        if (direction.equals(NORTH)) {
            return Location(location.getX(),location.getY()+1);
        }
        if (direction.equals(SOUTH)) {
            return Location(location.getX(),location.getY()-1);
        }
        if (direction.equals(WEST)) {
            return Location(location.getX()-1);
        }
        if (direction.equals(EAST)) {
            return Location(location.getX()+1);
        }
        return location;
    }



    private static Direction weakestSite(Location location) {

            int[] t1 = {location.getX() + 1, location.getY().getSite().strength};
            int[] t2 = {location.getX() - 1, location.getY().getSite().strength};
            int[] t3 = {location.getX(), location.getY() + 1).getSite().strength};
            int[] t4 = {location.getX(), location.getY() - 1).getSite().strength};
            int[] t = {t1, t2, t3, t4};
            Direction direction, EAST, WEST, NORTH, SOUTH;
            Direction[] dir = {EAST, WEST, NORTH, SOUTH};
            int weakest = 255;
            for (int i = 0; i < 4; i++) {
                if (t[i] <= weakest) {
                    weakest = t[i];
                    direction = dir[i];
                }
            }
            return direction;



    }

    private boolean ally(Location location) {

        final int myID = iPackage.myID;
        return location.getSite().owner == myID;
    }

    private Location nearestEnemy(Location loc) {
        final int myID = iPackage.myID;
        Location EndOfTheMap = new Location(gameMap.height, gameMap.width);
        Location CornerOfMap = new Location(0, 0);
        distance = getDistance(CornerOfMap, EndOfTheMap);
        Location closest = loc;
            for (int y = 0; y < gameMap.height; y++) {
                for (int x = 0; x < gameMap.width; x++) {
                    final Location location = gameMap.getLocation(x, y);
                    final Site site = location.getSite();
                    if (distance <= getDistance(loc, location) && site.owner != myID) {
                        closest = direction;
                    }

                }
            }
        return closest;
    }
// combine the for loops
    private boolean nextToEnemy() {
        for (int y = 0; y < gameMap.height; y++) {
            for (int x = 0; x < gameMap.width; x++) {
                final Location location = gameMap.getLocation(x, y);
                final Site site = location.getSite();
                if (2 == getDistance(nearestEnemy(location))) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    private Direction directionOfEnemy() {


    }
    */

    /* This method identifies the direciton in which all of the blocks move, does not work if the positions are the same
       therefore a loop should be set up to end the direction when the positions or equal otherwise there would be an error */

    private static Direction moveToLocation(Location locationStart, Location locationFinish) {
        Direction WEST,EAST,SOUTH,NORTH;
        int[] x = {locationStart.getX, locationFinish.getX};
        int[] y = {locationStart.getY, locationFinish.getY};
        if (x[1] != x[2]) {
            if(x[1] > x[2]) {
                return WEST;
            } else {
                return EAST;
            }
        } else if (y[1] != y[2]) {
            if(y[1] > y[2]) {
                return SOUTH;
            } else {
                return NORTH;
            }
        } else {
            return NORTH; // Returns north if the values match
        }
    }

}
