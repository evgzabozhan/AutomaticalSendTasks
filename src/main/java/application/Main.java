package application;

import api.trello.TrelloApi;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TrelloApi api = new TrelloApi();
        System.out.println(Arrays.toString(api.getTrelloMap().get("Done")));
    }
}
