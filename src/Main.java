import java.util.ArrayList;
import java.util.List;

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

        while (x != end[0] || y != end[1]) {
            boolean moved = false;

            // Intentar cada dirección en orden
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Condiciones para moverse: dentro del laberinto, no es pared, no visitado
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols &&
                        maze[newX][newY] == 0 && !visited[newX][newY]) {
                    x = newX;
                    y = newY;
                    visited[x][y] = true;
                    path.add(new int[]{x, y});
                    moved = true;
                    break;
                }
            }

            // Si no se puede mover, retrocedemos
            if (!moved) {
                path.remove(path.size() - 1); // Eliminar el último paso
                int[] lastStep = path.get(path.size() - 1);
                x = lastStep[0];
                y = lastStep[1];
            }
        }

        return path;
    }

    public static void printMazeWithPath(int[][] maze, List<int[]> path) {
        int[][] mazeWithPath = new int[maze.length][maze[0].length];

        // Copiar el laberinto original
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                mazeWithPath[i][j] = maze[i][j];
            }
        }

        // Marcar el camino en el laberinto
        for (int[] step : path) {
            mazeWithPath[step[0]][step[1]] = 2; // Usar 2 para indicar el camino
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

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 0}; // Inicio
        int[] end = {4, 4};   // Fin

        List<int[]> solution = solveMaze(maze, start, end);

        if (solution != null) {
            System.out.println("Camino encontrado:");
            printMazeWithPath(maze, solution);
            printPathCoordinates(solution); // Imprimir coordenadas
        } else {
            System.out.println("No hay solución para el laberinto.");
        }
    }
}
