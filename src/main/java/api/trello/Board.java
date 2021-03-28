package api.trello;

import java.util.Objects;

public class Board {

    private String id;
    private String name;
    private String idBoard;

    public Board(String id, String name, String idBoard) {
        this.id = id;
        this.name = name;
        this.idBoard = idBoard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id) && Objects.equals(name, board.name) && Objects.equals(idBoard, board.idBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idBoard);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idBoard='" + idBoard + '\'' +
                '}';
    }
}
