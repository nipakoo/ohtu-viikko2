package ohtu;

import java.util.HashMap;

public class TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private HashMap<Integer, String> terms;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        initializeTerms();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2) {
            return getScoreOnTie();
        } else if (m_score1>=4 || m_score2>=4) {
            return getScoreOnAdvantage();
        } else {
            return getNormalScore();
        }
    }
    
    private String getScoreOnAdvantage() {
        int difference = m_score1-m_score2;
        if (difference==1) return "Advantage player1";
        else if (difference ==-1) return "Advantage player2";
        else if (difference>=2) return "Win for player1";
        else return "Win for player2";
    }
    
    private String getNormalScore() {
        return terms.get(m_score1) + "-" + terms.get(m_score2);
    }
    
    private String getScoreOnTie() {
        String term = terms.get(m_score1);
        if (term == null) {
            return "Deuce";
        }
        return term + "-All";
    }
    
    private void initializeTerms() {
        terms = new HashMap<>();
        terms.put(0, "Love");
        terms.put(1, "Fifteen");
        terms.put(2, "Thirty");
        terms.put(3, "Forty");
    }
}