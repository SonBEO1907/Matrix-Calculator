/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator;

/**
 *
 * @author son75
 */
public class MatrixCalculator {

    public void menu(){
        int choice =0;
        Matrix mat = new Matrix();
        while (choice!=4){
            System.out.println("===========Calculator Program=============");
            System.out.println("1.Addition Matrix.");
            System.out.println("2.Subtraction Matrix.");
            System.out.println("3.Multiplication Matrix.");
            System.out.println("4.Exit.");
            choice = Matrix.checkInputInt();
            mat.getOperation(choice);
        }        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MatrixCalculator mc = new MatrixCalculator();
        mc.menu();
    }
    
}
