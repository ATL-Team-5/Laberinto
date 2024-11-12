public class SolveMaze {
    int steps = 0;

    public boolean backtracking(char[][] maze, int row, int col) {
        // Comprobar si encontramos la salida
        if (maze[row][col] == 'E') {
            System.out.println("Backtracking");
            return true;
        }

        // Comprobar si estamos en una posición válida para movernos
        if (maze[row][col] != ' ' && maze[row][col] != 'S') {
            return false;
        }

        // Marcar la celda actual como parte del camino de la solución
        maze[row][col] = '.';
        this.steps++;

        // Intentar moverse en cada dirección: abajo, derecha, arriba, izquierda
        if (backtracking(maze, row, col + 1)) return true; // Derecha
        if (backtracking(maze, row + 1, col)) return true; // Abajo
        if (backtracking(maze, row, col - 1)) return true; // Izquierda
        if (backtracking(maze, row - 1, col)) return true; // Arriba

        // Si ninguna dirección funciona, retroceder (desmarcar la celda)
        maze[row][col] = ' ';
        return false;
    }

    public boolean tremaux(char[][] maze, int row, int col) {
        // Verifica si la posición actual es la salida ('E')
        if (maze[row][col] == 'E') {
            System.out.println("Tremaux");
            return true;
        }

        // Si la posición no es válida o ya está marcada, retorna falso
        if (maze[row][col] != ' ' && maze[row][col] != 'S') {
            return false;
        }

        // Marca la posición actual como visitada
        maze[row][col] = '·';
        this.steps++;

        // Verifica todas las direcciones posibles: abajo, arriba, derecha, izquierda
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Si es un cruce (más de una opción), cambia la marca a 'X' cuando retroceda
            if (isCrossroad(maze, row, col) && maze[row][col] == '·') {
                maze[row][col] = 'X';  // Marca las celdas de retroceso en un cruce
            }

            // Intenta avanzar en cada dirección si el camino es libre o es la salida
            if (tremaux(maze, newRow, newCol)) {
                return true;
            }
        }

        // Si todas las direcciones fallan y estamos en un cruce, marca para retroceso
        if (maze[row][col] == 'X') {
            maze[row][col] = ' ';  // Borra marcas para otro intento
        }
        return false;
    }

    // Método para verificar si la posición actual es un cruce
    public static boolean isCrossroad(char[][] maze, int row, int col) {
        int paths = 0;

        // Verifica los cuatro posibles movimientos: arriba, abajo, izquierda, derecha
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Cuenta caminos sin marcas que no sean paredes o salidas
            if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == ' ') {
                paths++;
            }
        }
        return paths > 1;  // Un cruce tiene más de una opción para continuar
    }
}
