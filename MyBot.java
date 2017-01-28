import java.util.ArrayList;
import java.util.List;

public class MyBot {
    public static void main(String[] args) throws java.io.IOException {

        final InitPackage iPackage = Networking.getInit();
        final int myID = iPackage.myID;
        final GameMap gameMap = iPackage.map;

        Networking.sendInit("MyJavaBot");
        boolean noOptionsLeft = false;

        while(noOptionsLeft) {
            List<Move> moves = new ArrayList<Move>();

            Networking.updateFrame(gameMap);

            /* for (int y = 0; y < gameMap.height; y++) {
                for (int x = 0; x < gameMap.width; x++) {
                    final Location location = gameMap.getLocation(x, y);
                    final Site site = location.getSite();
                    if(site.owner == myID) {
                        moves.add(new Move(location, Direction.randomDirection()));
                    }
                }
            }
            */
            Networking.sendFrame(moves);
        }

    }

    public static int myLocation() {

    }
    public static void int distanceFromTheEnemy(square) {
            boolean enemyPresent(Loa)
            while (enemyPresent) {
                for ( square.get(y) -
                        // x1 - x2 + y1 - y2 //


            }

    }
    public static void boolean enemyPresent(siteposition) {



    }

    public static void

}
