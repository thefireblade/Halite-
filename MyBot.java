import java.util.ArrayList;
import java.util.List;

public class MyBot {

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
                        moves.add(new Move(location, moveToLocation(location,locationAfterDirection(location, weakestSite(location), gameMap))));
                      /*  if (nextToEnemy()) {
                            moves.add(new Move(location, moveToLocation(weakestSite(location))));
                        } else {
                            moves.add(new Move(location, );
                    }
                    moves.add(new Move(location, Direction.randomDirec=tion()));  */
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

    private static Location locationAfterDirection(Location location, Direction direction, GameMap gameMap) {
        if (Direction.NORTH.equals(direction)) {
            return gameMap.getLocation(location.getX(),location.getY()+1);
        }
        if (Direction.SOUTH.equals(direction)) {
            return gameMap.getLocation(location.getX(),location.getY()-1);
        }
        if (Direction.WEST.equals(direction)) {
            return gameMap.getLocation((location.getX()-1), location.getY());
        }
        if (Direction.EAST == direction) {
            return gameMap.getLocation(location.getX()+1, location.getY());
        }
        return location;
    }



    private static Direction weakestSite(Location location) {

        int[] t1 = {(location.getX() + 1), location.getSite().strength};
        int[] t2 = {(location.getX() - 1), location.getSite().strength};
        int[] t3 = {location.getY() + 1, location.getSite().strength};
        int[] t4 = {location.getY() - 1, location.getSite().strength};
        int[][] t = {t3, t1, t4, t2};
        int weakest = 255;

        for (int i = 0; i < 4; i++) {
            if (t[i][0] <= weakest) {
                weakest = t[i][0];
            }
        }
        return direction.get(0);
    }



    private boolean ally(Location location, int myID) {
        return location.getSite().owner == myID;
    }

    private Location nearestEnemy(Location loc, int myID, GameMap gameMap) {
        Location EndOfTheMap = new gameMap.getLocation(gameMap.height, gameMap.width);
        Location CornerOfMap = new gameMap.getLocation(0, 0);
        int distance = getDistance(CornerOfMap, EndOfTheMap);
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
    private boolean nextToEnemy(int myID, GameMap gameMap) {
        for (int y = 0; y < gameMap.height; y++) {
            for (int x = 0; x < gameMap.width; x++) {
                final Location location = gameMap.getLocation(x, y);
                final Site site = location.getSite();
                if (2 == getDistance(nearestEnemy(location, myID, gameMap))) {
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

        int[] x = {locationStart.getX, locationFinish.getX};
        int[] y = {locationStart.getY, locationFinish.getY};
        if (x[0] != x[1]) {
            if(x[0] > x[1]) {
                return Direction.WEST;
            } else {
                return Direction.EAST;
            }
        } else if (y[0] != y[1]) {
            if(y[0] > y[1]) {
                return Direction.SOUTH;
            } else {
                return Direction.NORTH;
            }
        } else {
            return Direction.NORTH; // Returns north if the values match
        }
    }

}
