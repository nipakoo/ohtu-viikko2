/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package statistics.matcher;

/**
 *
 * @author albis
 */
public class Query {
    Matcher matcher;
    
    public Query() {
    }
    
    public Query and(Matcher... matchers) {
        matcher = new And(matchers);
        return this;
    }
    
    public Query or(Matcher... matchers) {
        matcher = new Or(matchers);
        return this;
    }
    
    public Query not(Matcher... matchers) {
        matcher = new Not(matchers);
        return this;
    }
    
    public Query hasAtLeast(int value, String category) {
        matcher = new HasAtLeast(value, category);
        return this;
    }
    
    public Query hasFewerThan(int value, String category) {
        matcher = new HasFewerThan(value, category);
        return this;
    }
    
    public Query playsIn(String team) {
        matcher = new PlaysIn(team);
        return this;
    }
    
    public Matcher build() {
        return matcher;
    }
}
