//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SolveMaze sm = new SolveMaze();

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

        boolean solved = sm.backtracking(maze, 1, 1);

        if (solved) {
            System.out.println("Laberinto solucionado!");
            System.out.println("Pasos: " + sm.steps);
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
}