import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[][] maze1 = {
                {'#', 'S', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', '#'},
                {'#', '#', ' ', ' ', ' '},
                {'#', '#', 'E', '#', '#'},

        };
        char[][] maze2 = {
                {'#', 'S', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', '#', ' ', ' ', '#', '#'},
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
        } else {
            System.out.println("No se pudo solucionar");
        }

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
        // Verificar si estamos fuera de los límites del laberinto
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }

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
        maze[row][col] = '*';
        return false;
    }
}