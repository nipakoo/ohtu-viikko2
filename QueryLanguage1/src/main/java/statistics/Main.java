package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        Query query = new Query();
        
        Matcher m = query.not(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(15, "assists").build(),

                        query.playsIn("EDM")
                             .hasAtLeast(50, "points").build()
                       ).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
