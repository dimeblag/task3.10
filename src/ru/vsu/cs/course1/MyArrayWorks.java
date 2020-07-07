package ru.vsu.cs.course1;

import java.util.*;

public class MyArrayWorks {
/*
    public static Position findKnightAndFinish (int[][] field, int which) {
        Position figure = new Position();
        for(int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == which)
                    figure = new Position(j, i);
            }
        }
        return figure;
    }
    public static List<List<Position>> fillAdjacencyList(int sizeOfField) {
        List<List<Position>> edges = new ArrayList<>();

        for(int i = 0; i < sizeOfField; i++) {
            for(int j = 0; j < sizeOfField; j++) {
                Position edge = new Position(j , i);
                List<Position> adjacentEdges = new ArrayList<>();
                adjacentEdges.add(edge);
                if (edge.x < sizeOfField - 1 && edge.y > 1)
                    adjacentEdges.add(new Position(edge.x + 1, edge.y - 2));
                if (edge.x < sizeOfField - 2 && edge.y > 0)
                    adjacentEdges.add(new Position(edge.x + 2, edge.y - 1));
                if (edge.x < sizeOfField - 2 && edge.y < sizeOfField - 1)
                    adjacentEdges.add(new Position(edge.x + 2, edge.y + 1));
                if (edge.x < sizeOfField - 1 && edge.y < sizeOfField - 2)
                    adjacentEdges.add(new Position(edge.x + 1, edge.y + 2));
                if (edge.x > 0 && edge.y > 1)
                    adjacentEdges.add(new Position(edge.x - 1, edge.y - 2));
                if (edge.x > 1 && edge.y > 0)
                    adjacentEdges.add(new Position(edge.x - 2, edge.y - 1));
                if (edge.x > 1 && edge.y < sizeOfField - 1)
                    adjacentEdges.add(new Position(edge.x - 2, edge.y + 1));
                if (edge.x > 0 && edge.y < sizeOfField - 2)
                    adjacentEdges.add(new Position(edge.x - 1, edge.y + 2));
                edges.add(adjacentEdges);
            }
        }

        return edges;
    }
    public static MyStack<Position> findPathToFinish(int sizeOfField, Position knight, Position finish) {
        List<List<Position>> edges = MyArrayWorks.fillAdjacencyList(sizeOfField);
        MyQueue<Position> q = new MyQueue<>();
        MyStack<Position> stack = new MyStack<>();
        boolean[][] visited = new boolean[sizeOfField][sizeOfField];

        q.add(knight);
        visited[knight.y][knight.x] = true;
        while(q.size() > 0) {
            Position pos = q.poll();
            if(pos.x == finish.x && pos.y == finish.y) {
                stack.push(pos);
                while(pos.parent != null) {
                    pos = pos.parent;
                    stack.push(pos);
                }
                break;
            } else {
                for (List<Position> i: edges) {
                    if(i.size() > 0 && i.get(0).x == pos.x && i.get(0).y == pos.y) {
                        i.remove(0);
                        for(Position j : i) {
                            if(!visited[j.y][j.x]) {
                                j.parent = pos;
                                q.add(j);
                                visited[j.y][j.x] = true;
                            }
                        }
                    }
                }
            }
        }
        return stack;
    }
    public static int[][] showPathToFinish(MyStack<Position> stack, int sizeOfField) {
        int[][] outputArray = new int[sizeOfField][sizeOfField];

        for(int i = 1; !stack.empty(); i++) {
            outputArray[stack.peek().y][stack.peek().x] = i;
            stack.pop();
        }

        return outputArray;
    }
*/

    public static Position findKnightAndFinish (int[][] field, int which) {
        Position figure = new Position();
        for(int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == which)
                    figure = new Position(j, i);
            }
        }
        return figure;
    }
    public static List<Position> findPathToFinish(int w, int h, Position knight, Position finish) {
        Map<Position, List<Position>> edges = new HashMap<>();
        MyQueue<Position> q = new MyQueue<>();
        List<Position> list = new ArrayList<>();
        boolean[][] visited = new boolean[h][w];

        q.add(knight);
        visited[knight.y][knight.x] = true;
        while(q.size() > 0) {
            Position pos = q.poll();
            edges.put(pos, getAdj(pos, w, h));
            if(pos.x == finish.x && pos.y == finish.y) {
                list.add(pos);
                while(pos.getParent() != null) {
                    pos = pos.getParent();
                    list.add(pos);
                }
                break;
            } else {
                List<Position> i = edges.get(pos);
                for (Position j : i) {
                    if (!visited[j.y][j.x]) {
                        j.setParent(pos);
                        q.add(j);
                        visited[j.y][j.x] = true;
                    }
                }
            }
        }
        return list;
    }
    public static int[][] showPathToFinish(List<Position> list, int w, int h) {
        int[][] outputArray = new int[h][w];

        for(int i = list.size()-1; i >= 0; i--) {
            outputArray[list.get(i).y][list.get(i).x] = list.size() - i;
        }

        return outputArray;
    }
    private static List<Position> getAdj(Position from, int w, int h) {
        int[] dx = {1, 1,-1,-1, 2, 2,-2,-2};
        int[] dy = {2,-2, 2,-2, 1,-1, 1,-1};
        List<Position> lst = new ArrayList<>();
        for(int i = 0; i < dx.length; i++) {
            Position pos = new Position(from.x + dx[i], from.y + dy[i]);
            if(inside(pos, w, h))
                lst.add(pos);
        }

        return lst;
    }
    private static boolean inside(Position p, int w, int h) {
        return p.x >= 0 && p.x < w && p.y >= 0 && p.y < h;
    }
}
