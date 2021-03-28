package application.logic;

import api.trello.Card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Report {

    public Map<String, String> getReport (Map<String, Card[]> trelloTasks)
    {
        Map<String, String> report = new HashMap<>();
        report.put("Today",getTodayTasks(trelloTasks.get("Done")));
        report.put("Tomorrow",getTomorrowTasks(trelloTasks.get("Testing"), trelloTasks.get("In Progress")));

        return report;
    }

    private String getTodayTasks (Card[] cards)
    {
        StringBuilder result = new StringBuilder();
        Date cardDate;
        try {
            for(Card card : cards) {
                cardDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(card.getDateLastActivity());
                if (isEquals(cardDate)) {
                    result.append("[").append(card.getName()).append("] ").append(card.getDesc()).append(" (Done)\n");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    private String getTomorrowTasks (Card[] testing, Card[] inProgress)
    {
        StringBuilder result = new StringBuilder();
        if (testing != null) {
            for (Card card : testing) {
                result.append("[Testing][").append(card.getName()).append("] ").append(card.getDesc()).append("\n");
            }
        }
        if (inProgress != null) {
            for (Card card : inProgress) {
                result.append("[").append(card.getName()).append("] ").append(card.getDesc()).append("\n");
            }
        }
       return result.toString();
    }

    private boolean isEquals (Date cardDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String today = dateFormat.format(new Date());
        String cardDateS = dateFormat.format(cardDate);
        return today.equals(cardDateS);
    }
}
