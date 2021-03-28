package application;

import api.google.SheetsApi;
import api.trello.TrelloApi;
import application.logic.Report;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        TrelloApi api = new TrelloApi();
        Report report = new Report();
        Map<String, String> result = report.getReport(api.getTrelloMap());
        SheetsApi sheetsApi = new SheetsApi();
        if (sheetsApi.setDataToTable(result)) {
            System.out.println("Программа успешно завершена");
        } else {
            System.out.println("Программа завершена с ошибками");
        }
    }
}
