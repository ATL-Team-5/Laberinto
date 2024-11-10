//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[][] maze = {
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

        boolean solved = solveMaze(maze, 1, 1);

        if (solved) {
            System.out.println("Primer intento de laberinto!");
        } else {
            System.out.println("No se pudo solucionar");
        }

        showMaze(maze);
    }

    public static void showMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(" " + maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveMaze(char[][] maze, int row, int col) {
        // Comprobar si encontramos la salida
        if (maze[row][col] == 'E') {
            return true;
        }

        // Comprobar si estamos en una posición válida para movernos
        if (maze[row][col] != ' ' && maze[row][col] != 'S') {
            return false;
        }

        // Marcar la celda actual como parte del camino de la solución
        maze[row][col] = '.';

        // Intentar moverse en cada dirección: abajo, derecha, arriba, izquierda
        if (solveMaze(maze, row, col + 1)) return true; // Derecha
        if (solveMaze(maze, row + 1, col)) return true; // Abajo
        if (solveMaze(maze, row, col - 1)) return true; // Izquierda
        if (solveMaze(maze, row - 1, col)) return true; // Arriba

        // Si ninguna dirección funciona, retroceder (desmarcar la celda)
        maze[row][col] = ' ';
        return false;
    }
}