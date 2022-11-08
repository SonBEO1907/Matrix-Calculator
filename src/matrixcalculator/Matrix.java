/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator;

import java.util.Scanner;

/**
 *
 * @author son75
 */
public class Matrix {
    
    private static int[][] matrix1;
    
    private static int[][] matrix2;
    
    int row1,row2,col1,col2;
            
    private static final Scanner sc = new Scanner(System.in);
    
    
    //Integer validator
    public static int checkInputInt(){
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Integer number not found");
            }
        }
    }
    //Matrix row and col >0
    private static int checkArrayElements(){
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (checkPositive(result)==true) return result;
                else System.out.println("The number of row/column must be higher than 0, please enter again: ");
            } catch (NumberFormatException e) {
                System.out.println("Integer not found, please enter again: ");
            }
        }
    }
    
    private static boolean checkPositive(int result){
        if (result>0) return true;
        return false;
    }
    
    
    //Arithmetic operator is sent to String op
    private void printMatrix(int[][] matrix3, int row, int col, String op){
        System.out.println("----------------Result-----------------");
        for (int i =0; i<row1;i++){
            for (int j = 0; j < col1; j++){
                System.out.print("["+matrix1[i][j]+"] ");
            }
            System.out.println();
        }
        System.out.println(op);
        for (int i =0; i<row2;i++){
            for (int j = 0; j < col2; j++){
                System.out.print("["+matrix2[i][j]+"] ");
            }
            System.out.println();
        }
        System.out.println("=");
        for (int i =0; i<row;i++){
            for (int j = 0; j < col; j++){
                System.out.print("["+matrix3[i][j]+"] ");
            }
            System.out.println();
        }
    }
      
    //Multiplication of Matrix
    private void mulMatrix(int[][] matrix1, int[][] matrix2){
        int[][] matrix3 = new int[row1][col2];
         for (int i =0; i<row1;i++){
            for (int j = 0; j < col2; j++){
                for (int k = 0; k<row2;k++){
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        printMatrix(matrix3, row1, col2, "*");
    }
    //Addition of Matrix
    private void addMatrix(int[][] matrix1,int[][] matrix2, int row,int col){
         int[][] matrix3 = new int[row][col];
         for (int i =0; i<row;i++){
             for (int j = 0; j < col; j++){
                 matrix3[i][j]=matrix1[i][j]+matrix2[i][j];
             }
         }
        printMatrix(matrix3, row, col, "+");
    }
    
    //Subtraction of Matrix
    private void subMatrix(int[][] matrix1,int[][] matrix2, int row,int col){
         int[][] matrix3 = new int[row][col];
         for (int i =0; i<row;i++){
             for (int j = 0; j < col; j++){
                 matrix3[i][j]=matrix1[i][j]-matrix2[i][j];
             }
         }
        printMatrix(matrix3, row, col, "-");
    }
    
    
    private void getMatrixForMulltiplication(){
        System.out.println("---------Multiplication-----------");
        System.out.print("Enter row matrix 1:");
        row1 = checkArrayElements();
        System.out.print("Enter column matrix 1:");
        col1 = checkArrayElements();
        matrix1 = new int[row1][col1];
        for (int i =0; i< row1;i++){
            for (int j=0; j<col1;j++){
                System.out.print("Enter Matrix 1 [" + (i+1) + "][ "+ (j+1) + "]:");
                matrix1[i][j]= checkInputInt();
            }
        }
        boolean isMatrixValid=false;
        while(!isMatrixValid){
            System.out.print("Enter row matrix 2:");
            row2 = checkArrayElements();
            if (row2!=col1) System.out.println("Invalid Matrix for multiplication, column of matrix 1 must equal row of matrix 2.");
            else isMatrixValid=true;
        }    
        System.out.print("Enter column matrix 2:");
        col2 = checkArrayElements();
        matrix2= new int[row2][col2];     
        for (int i =0; i< row2;i++){
            for (int j=0; j<col2;j++){
                System.out.print("Enter Matrix 2 [" + (i+1) + "][ "+ (j+1) + "]:");
                matrix2[i][j]= checkInputInt();
            }
        }
        mulMatrix(matrix1, matrix2);
    }
    
    private void getMatrixForAddition(){
        System.out.println("-------------Addition------------");
        System.out.print("Enter row matrix 1:");
        row1 = checkArrayElements();
        System.out.print("Enter column matrix 1:");
        col1 = checkArrayElements();
        matrix1 = new int[row1][col1];
        for (int i =0; i< row1;i++){
            for (int j=0; j<col1;j++){
                System.out.print("Enter Matrix 1 [" + (i+1) + "][ "+ (j+1) + "]:");
                matrix1[i][j]= checkInputInt();
            }
        }
        boolean isRowValid=false;
        boolean isColValid=false;
        while (!isRowValid){
            System.out.print("Enter row matrix 2:");
            row2=checkArrayElements();
            if (row1==row2) isRowValid=true;
            else System.out.println("Invalid Matrix for addition, both matrix must have the same number of row.");
        }
        while (!isColValid){
            System.out.print("Enter column matrix 2:");
            col2=checkArrayElements();
            if (col2==col1) isColValid=true;
            else System.out.println("Invalid Matrix for addition, both matrix must have the same number of column.");
        }
        matrix2=new int[row2][col2];
        for (int i =0; i< row2;i++){
            for (int j=0; j<col2;j++){
                System.out.print("Enter Matrix 2 [" + (i+1) + "][ "+ (j+1) + "]:");
                matrix2[i][j]= checkInputInt();
            }
        }
        addMatrix(matrix1, matrix2, row1, col1);
    }
    
    private void getMatrixForSubtraction(){
        System.out.println("-------------Addition------------");
        System.out.print("Enter row matrix 1:");
        row1 = checkArrayElements();
        System.out.print("Enter column matrix 1:");
        col1 = checkArrayElements();
        matrix1 = new int[row1][col1];
        for (int i =0; i< row1;i++){
            for (int j=0; j<col1;j++){
                System.out.print("Enter Matrix 1 [" + (i+1) + "][ "+ (j+1) + "]:");
                matrix1[i][j]= checkInputInt();
            }
        }
        boolean isRowValid=false;
        boolean isColValid=false;
        while (!isRowValid){
            System.out.print("Enter row matrix 2:");
            row2=checkArrayElements();
            if (row1==row2) isRowValid=true;
            else System.out.println("Invalid Matrix for subtraction, both matrix must have the same number of row.");
        }
        while (!isColValid){
            System.out.print("Enter column matrix 2:");
            col2=checkArrayElements();
            if (col2==col1) isColValid=true;
            else System.out.println("Invalid Matrix for subtraction, both matrix must have the same number of column.");
        }
        matrix2=new int[row2][col2];
        for (int i =0; i< row2;i++){
            for (int j=0; j<col2;j++){
                System.out.print("Enter Matrix 2 [" + (i+1) + "][ "+ (j+1) + "]:");
                matrix2[i][j]= checkInputInt();
            }
        }
        subMatrix(matrix1, matrix2, row1, col1);
    }
    
    public void getOperation(int n){
        switch(n){
            case 1:
                getMatrixForAddition();break;
            case 2:
                getMatrixForSubtraction();break;
            case 3:
                getMatrixForMulltiplication();break;
            default:
                System.out.println("Invalid command! Please enter again: ");
        }
    }
}
