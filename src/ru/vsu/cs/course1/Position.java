package ru.vsu.cs.course1;

public class Position {
    private Position parent;
    public int x;
    public int y;
    public Position() {}
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getParent() {
        return parent;
    }
    public void setParent(Position parent) {
        this.parent = parent;
    }
}
