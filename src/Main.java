import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SolveMaze sm = new SolveMaze();

        char[][] maze1 = {
                {'#', 'S', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', '#'},
                {'#', '#', ' ', ' ', ' '},
                {'#', '#', 'E', '#', '#'},

        char[][] maze2 = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', ' ', '#', '#', ' ', ' ', '#', '#'},
                {'#', '#', '#', ' ', '#', '#', '#', ' ', ' ', 'E'},
                {'#', '#', ' ', ' ', ' ', '#', '#', ' ', '#', '#'},
                {'#', '#', ' ', '#', '#', ' ', ' ', ' ', '#', '#'},
                {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', ' ', ' ', '#', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };
        char[][] maze3 = {
                {'#', 'S', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', '#', ' ', ' ', '#', '#', ' ', ' ', '#', '#', '#'},
                {'#', '#', '#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#'},
                {'#', '#', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#'},
                {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
                {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' ', '#', ' ', ' '},
                {'#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', ' '},
                {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#', ' ', ' '},
                {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
                {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' ', '#', ' ', ' '},
                {'#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', 'E'},
        };

        Scanner menu = new Scanner(System.in);
        System.out.println("Elija 1, 2 o 3 para el nivel de laberinto que desea jugar");
        System.out.println("1 : nivel fácil \n 2: nivel intermedio \n 3: nivel avanzado");
        int entrada = menu.nextInt();
        boolean solved = true;
        if (entrada == 1){
            solved = solveMaze(maze1, 1, 1);
            showMaze(maze1);
        } else if (entrada ==2) {
            solved = solveMaze(maze2, 1, 1);
            showMaze(maze2);
        } else if (entrada ==3) {
            solved = solveMaze(maze3, 1, 1);
            showMaze(maze3);
        }else {
            System.out.println("Ingresó una opción incorrecta");
        }

        if (solved) {
            System.out.println("El laberinto se resolvió correctamente!");
        boolean solved = sm.backtracking(maze, 1, 1);

        if (solved) {
            System.out.println("Laberinto solucionado!");
            System.out.println("Pasos: " + sm.steps);
        } else {
            System.out.println("No se pudo solucionar");
        }
    }
}

class TarryMazeSolver {
    public static List<int[]> solveMaze(int[][] maze, int[] start, int[] end) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<int[]> path = new ArrayList<>();

        // Direcciones: Derecha, Abajo, Izquierda, Arriba
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = start[0], y = start[1];
        visited[x][y] = true;
        path.add(new int[]{x, y});
    }

    public static void printMazeWithPath(int[][] maze, List<int[]> path) {
        int[][] mazeWithPath = new int[maze.length][maze[0].length];

        // Copiar el laberinto original
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                mazeWithPath[i][j] = maze[i][j];
            }
        }

        // Imprimir el laberinto
        for (int i = 0; i < mazeWithPath.length; i++) {
            for (int j = 0; j < mazeWithPath[0].length; j++) {
                if (mazeWithPath[i][j] == 1) {
                    System.out.print("# "); // Pared
                } else if (mazeWithPath[i][j] == 2) {
                    System.out.print(". "); // Camino
                } else {
                    System.out.print("  "); // Espacio vacío
                }
            }
            System.out.println();
        }
    }
   
    public static void printPathCoordinates(List<int[]> path) {
        System.out.println("\nCoordenadas del camino:");
        for (int[] step : path) {
            System.out.println("[" + step[0] + ", " + step[1] + "]");
        }
    }
}
