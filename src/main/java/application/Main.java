package application;

import api.trello.TrelloApi;
import application.logic.Report;

import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        TrelloApi api = new TrelloApi();
        Report report = new Report();
        Map<String, String> result = report.getReport(api.getTrelloMap());
        System.out.println(result);
    }
}
