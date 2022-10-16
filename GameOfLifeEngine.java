package gameoflife;

public class GameOfLifeEngine {
    private char [][] _matrix;
    private final int SIZE = 28;
    private final char DEAD = 0x2591;
    private final char ALIVE = 0x2588;

    public GameOfLifeEngine()
    {
        _matrix = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                _matrix[i][j] = DEAD;
    }

    public void initialize()
    {
        _matrix[14][13] = ALIVE;
        _matrix[14][14] = ALIVE;
        _matrix[14][15] = ALIVE;
    }

    public void initialize2()
    {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                _matrix[i][j] = DEAD;
        _matrix[13][12] = ALIVE;
        _matrix[13][17] = ALIVE;
        _matrix[14][10] = ALIVE;
        _matrix[14][11] = ALIVE;
        _matrix[14][13] = ALIVE;
        _matrix[14][14] = ALIVE;
        _matrix[14][15] = ALIVE;
        _matrix[14][16] = ALIVE;
        _matrix[14][18] = ALIVE;
        _matrix[14][19] = ALIVE;
        _matrix[15][12] = ALIVE;
        _matrix[13][17] = ALIVE;
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                s = s + _matrix[i][j] + " ";
            s = s + "\n";
        }
        return s;
    }

    public void next()
    {
        char [][] temp = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
            {
                int n = countNeighbors(i, j);
                if ((_matrix[i][j] == ALIVE && (n == 2 || n == 3)) || (_matrix[i][j] == DEAD && n == 3))
                    temp[i][j] = ALIVE;
                else
                    temp[i][j] = DEAD;
            }
            _matrix = temp;
    }

    private int countNeighbors(int row, int col)
    {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++)
            for (int j = col - 1; j <=col + 1; j++)
                if (_matrix[(i + SIZE) % SIZE][(j + SIZE) % SIZE] == ALIVE)
                    count++;
        if (_matrix[row][col] == ALIVE)
            count--;
        return count;
    }

    private boolean isValid(int i, int j)
    {
        return i >= 0 && j >= 0 && i < SIZE && j < SIZE;
    }
}