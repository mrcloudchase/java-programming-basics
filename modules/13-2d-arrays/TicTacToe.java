/**
 * TicTacToe.java
 * Complete Tic-Tac-Toe game using 2D arrays
 * Demonstrates 2D array manipulation, game logic, and win checking
 */
import java.util.Scanner;

public class TicTacToe {
    // Game board as 2D array
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Tic-Tac-Toe Game ===");
        System.out.println("Players take turns placing X and O");
        System.out.println("Enter row and column (1-3) to place your mark\n");
        
        boolean playAgain = true;
        
        while (playAgain) {
            // Initialize board
            initializeBoard();
            
            // Game loop
            boolean gameOver = false;
            int moves = 0;
            
            while (!gameOver && moves < 9) {
                // Display board
                printBoard();
                
                // Get player move
                System.out.println("\nPlayer " + currentPlayer + "'s turn");
                
                boolean validMove = false;
                while (!validMove) {
                    System.out.print("Enter row (1-3): ");
                    int row = scanner.nextInt() - 1;  // Convert to 0-based index
                    System.out.print("Enter column (1-3): ");
                    int col = scanner.nextInt() - 1;  // Convert to 0-based index
                    
                    // Validate move
                    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                        if (board[row][col] == ' ') {
                            // Place mark
                            board[row][col] = currentPlayer;
                            validMove = true;
                            moves++;
                        } else {
                            System.out.println("That position is already taken!");
                        }
                    } else {
                        System.out.println("Invalid position! Use 1-3 for row and column.");
                    }
                }
                
                // Check for win
                if (checkWin()) {
                    printBoard();
                    System.out.println("\n🎉 Player " + currentPlayer + " wins! 🎉");
                    gameOver = true;
                } else if (moves == 9) {
                    printBoard();
                    System.out.println("\n🤝 It's a draw! 🤝");
                    gameOver = true;
                } else {
                    // Switch players
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
            
            // Ask to play again
            scanner.nextLine();  // Clear buffer
            System.out.print("\nPlay again? (yes/no): ");
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
            
            if (playAgain) {
                currentPlayer = 'X';  // Reset to X starting
            }
        }
        
        // Demonstrate 2D array concepts
        demonstrate2DArrays();
        
        System.out.println("\nThanks for playing!");
        scanner.close();
    }
    
    // Initialize board with empty spaces
    public static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }
    
    // Print the game board
    public static void printBoard() {
        System.out.println("\n  1   2   3");
        System.out.println("  ---------");
        
        for (int row = 0; row < 3; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            
            if (row < 2) {
                System.out.println("  ---------");
            }
        }
    }
    
    // Check if current player has won
    public static boolean checkWin() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == currentPlayer && 
                board[row][1] == currentPlayer && 
                board[row][2] == currentPlayer) {
                return true;
            }
        }
        
        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == currentPlayer && 
                board[1][col] == currentPlayer && 
                board[2][col] == currentPlayer) {
                return true;
            }
        }
        
        // Check main diagonal (top-left to bottom-right)
        if (board[0][0] == currentPlayer && 
            board[1][1] == currentPlayer && 
            board[2][2] == currentPlayer) {
            return true;
        }
        
        // Check anti-diagonal (top-right to bottom-left)
        if (board[0][2] == currentPlayer && 
            board[1][1] == currentPlayer && 
            board[2][0] == currentPlayer) {
            return true;
        }
        
        return false;
    }
    
    // Demonstrate 2D array concepts
    public static void demonstrate2DArrays() {
        System.out.println("\n\n=== 2D Array Concepts ===");
        
        // Creating 2D arrays
        System.out.println("\n1. CREATING 2D ARRAYS:");
        
        // Method 1: Declare size
        int[][] grid1 = new int[3][4];  // 3 rows, 4 columns
        System.out.println("Created 3x4 grid");
        
        // Method 2: Initialize with values
        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Created and initialized 3x3 grid");
        
        // Accessing elements
        System.out.println("\n2. ACCESSING ELEMENTS:");
        System.out.println("grid2[0][0] = " + grid2[0][0]);  // First element
        System.out.println("grid2[1][1] = " + grid2[1][1]);  // Middle element
        System.out.println("grid2[2][2] = " + grid2[2][2]);  // Last diagonal
        
        // Traversing 2D arrays
        System.out.println("\n3. TRAVERSING 2D ARRAYS:");
        System.out.println("Row by row:");
        for (int row = 0; row < grid2.length; row++) {
            for (int col = 0; col < grid2[row].length; col++) {
                System.out.print(grid2[row][col] + " ");
            }
            System.out.println();
        }
        
        // Column-wise traversal
        System.out.println("\nColumn by column:");
        for (int col = 0; col < grid2[0].length; col++) {
            for (int row = 0; row < grid2.length; row++) {
                System.out.print(grid2[row][col] + " ");
            }
            System.out.println();
        }
        
        // Jagged arrays (rows of different lengths)
        System.out.println("\n4. JAGGED ARRAYS:");
        int[][] jagged = new int[3][];
        jagged[0] = new int[2];  // First row has 2 elements
        jagged[1] = new int[4];  // Second row has 4 elements
        jagged[2] = new int[3];  // Third row has 3 elements
        
        // Fill with values
        int value = 1;
        for (int row = 0; row < jagged.length; row++) {
            for (int col = 0; col < jagged[row].length; col++) {
                jagged[row][col] = value++;
            }
        }
        
        // Print jagged array
        System.out.println("Jagged array:");
        for (int row = 0; row < jagged.length; row++) {
            System.out.print("Row " + row + ": ");
            for (int col = 0; col < jagged[row].length; col++) {
                System.out.print(jagged[row][col] + " ");
            }
            System.out.println();
        }
        
        // Practical example: Grade table
        System.out.println("\n5. PRACTICAL EXAMPLE - Grade Table:");
        String[] students = {"Alice", "Bob", "Charlie"};
        String[] subjects = {"Math", "Science", "English"};
        int[][] grades = {
            {95, 88, 92},  // Alice's grades
            {87, 91, 85},  // Bob's grades
            {90, 94, 89}   // Charlie's grades
        };
        
        // Print grade table
        System.out.print("         ");
        for (String subject : subjects) {
            System.out.printf("%-10s", subject);
        }
        System.out.println();
        
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%-9s", students[i]);
            for (int j = 0; j < subjects.length; j++) {
                System.out.printf("%-10d", grades[i][j]);
            }
            
            // Calculate average for this student
            int sum = 0;
            for (int grade : grades[i]) {
                sum += grade;
            }
            double avg = (double) sum / grades[i].length;
            System.out.printf("  Avg: %.1f", avg);
            System.out.println();
        }
        
        // FRC Example: Field grid
        System.out.println("\n6. FRC FIELD GRID:");
        // Represent field as grid (simplified)
        char[][] field = new char[5][5];
        
        // Initialize field
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                field[r][c] = '.';  // Empty space
            }
        }
        
        // Place game elements
        field[0][0] = 'R';  // Red alliance
        field[0][4] = 'R';
        field[4][0] = 'B';  // Blue alliance
        field[4][4] = 'B';
        field[2][2] = 'G';  // Game piece
        
        // Display field
        System.out.println("Field Layout:");
        System.out.println("R = Red, B = Blue, G = Game piece");
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                System.out.print(field[r][c] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\n=== Key 2D Array Points ===");
        System.out.println("• Declaration: type[][] name = new type[rows][cols]");
        System.out.println("• Access: array[row][col]");
        System.out.println("• Rows: array.length");
        System.out.println("• Columns: array[0].length");
        System.out.println("• Nested loops for traversal");
        System.out.println("• Can be jagged (different row lengths)");
        System.out.println("• Perfect for grids, tables, game boards");
    }
}
