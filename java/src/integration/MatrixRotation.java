/**
 * 矩阵的旋转。给定一个N*N的矩阵，按顺时针方向旋转90度。
 * 例如，给定矩阵
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 旋转后得到
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 解题思路：
 * 1、首先将矩阵的行列进行交换，交换后的矩阵如下：
 *  [1,4,7],
 *  [2,5,8],
 *  [3,6,9]
 * 2、然后将矩阵的左右两头的元素进行交换，交换后的矩阵如下：
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 */
package integration;

public class MatrixRotation {
    public static void main(String[] args){
        // int[][] matrix = new int[][]{
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9},
        // };
        int[][] matrix = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        //输出原始内容
        print("原始矩阵:",matrix);
        //旋转
        //step1:行列交换
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //step2:左右交换
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                int temp = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
            
        }
        //输出旋转后的内容
        print("旋转后的矩阵:",matrix);
        
    }
    private static void print(String title,int[][] matrix){
        System.out.println(title);
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
                if (j != matrix.length-1) {
                    System.out.print(",");
                }
            }
            System.out.print("\n");
        }
    }
}