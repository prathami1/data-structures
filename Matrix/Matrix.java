import java.io.*;

public class Matrix
{
    private int[][] firstMatrix, secondMatrix;
    public Matrix()
    {
    File name = new File("MatrixInput.txt");
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text;
            while((text = input.readLine()) != null)
            {
                String pieces[] = text.split("\t");
                firstMatrix = makeMatrix(pieces[0]);
                secondMatrix = makeMatrix(pieces[1]);
                printMatrix(firstMatrix, 1);
                printMatrix(secondMatrix, 2);
                function("Sum");
                function("Difference");
                function("Product");
                System.out.println("_____________________________\n");
            }
        }
        catch(IOException io)
        {
            System.err.println("File Not Found");
        }
    }

    public int[][] makeMatrix(String str)
    {
        str = str.substring(2, str.length() - 2);
        String rows[] = str.split("},\\{");
        int numCols = rows[0].split(",").length;
        int matrix[][] = new int[rows.length][numCols];

        for(int r = 0; r < rows.length; r++) 
        {
            for(int c = 0; c < numCols; c++) 
            {
                matrix[r][c] = Integer.parseInt(rows[r].split(",")[c]);
            }
        }
        return matrix;
    }
    public void printMatrix(int[][] matrix, int matrixNum) 
    {
        System.out.println("Matrix #" + matrixNum + ":");
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[0].length; c++)
            {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void function(String operation) 
    {
        System.out.println(operation + ":");
        if(operation.equals("Sum") || operation.equals("Difference"))
        {
            if(firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length)
            {
                int newMatrix[][] = new int[firstMatrix.length][firstMatrix[0].length];
                for(int r = 0; r < firstMatrix.length; r++)
                {
                    for(int c = 0; c < firstMatrix[0].length; c++)
                    {
                        if(operation.equals("Sum"))
                        {
                            newMatrix[r][c] = firstMatrix[r][c] + secondMatrix[r][c];
                        }
                        else
                        {
                            newMatrix[r][c] = firstMatrix[r][c] - secondMatrix[r][c];
                        }
                        System.out.print(newMatrix[r][c] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            else
            {
                System.out.println(operation + " is not possible\n");
            }
        }
        else
        {
            if(firstMatrix[0].length == secondMatrix.length)
            {
                int newMatrix[][] = new int[firstMatrix.length][secondMatrix[0].length];
                for(int r = 0; r < newMatrix.length; r++)
                {
                    for(int c = 0; c < newMatrix[0].length; c++)
                    {
                        for(int i = 0; i < firstMatrix[0].length; i++) 
                        {
                            newMatrix[r][c] += firstMatrix[r][i] * secondMatrix[i][c];
                        }
                        System.out.print(newMatrix[r][c] + " ");
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.println(operation + " is not possible");
            }
        }
    }
    public static void main(String args[])
    {
        Matrix matrix = new Matrix();
    }
}