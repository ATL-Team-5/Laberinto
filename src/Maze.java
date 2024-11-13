import java.util.Scanner;

public class Maze {
    SolveMaze sm = new SolveMaze();

    char[][] maze1 = {
            {'#', '#', '#', '#', '#'},
            {'#', 'S', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', 'E', '#', '#'},
    };

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
            {'#', 'S', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', '#', ' ', ' ', '#', '#', ' ', ' ', '#', '#', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#'},
            {'#', '#', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#'},
            {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#', ' ', '#', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#', '#', ' ', '#', '#'},
            {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' ', '#', 'E', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };

    public void showMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(" " + maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void selectMaze() {
        Scanner menu = new Scanner(System.in);
        char[][] currentMaze;

        System.out.println("Elija 1, 2 o 3 para el nivel de laberinto que desea jugar");
        System.out.println(" 1: nivel fácil \n 2: nivel intermedio \n 3: nivel avanzado");

        int entrada = menu.nextInt();
        boolean solved = false;

        if (entrada == 1){
            currentMaze = maze1;
        } else if (entrada == 2) {
            currentMaze = maze2;
        } else if (entrada == 3) {
            currentMaze = maze3;
        } else {
            System.out.println("Ingresó una opción incorrecta, se selecciono automaticamente el nivel intermedio");
            currentMaze = maze2;
        }

        solved = sm.solve(currentMaze, 1, 1);

        if (solved) {
            System.out.println("Laberinto resulto!");
        } else {
            System.out.println("No se pudo resolver el laberinto");
        }

        showMaze(currentMaze);
    }
}
