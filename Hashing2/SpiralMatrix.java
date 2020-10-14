//https://leetcode.com/problems/spiral-matrix/submissions/

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;

        int firstRow = 0;
        int lastRow = matrix.length - 1;
        
        int firstCol = 0;
        int lastCol = matrix[0].length - 1;
        
        while(firstRow <= lastRow || firstCol <= lastCol) {
            
            for(int i = firstCol; i <= lastCol; i++) {
                result.add(matrix[firstRow][i]);
            }
            firstRow++;  
            if(result.size() == matrix.length*matrix[0].length) return result;
            
            for(int i = firstRow; i <= lastRow ; i++) {
                result.add(matrix[i][lastCol]);
            }
            lastCol--;
            if(result.size() == matrix.length*matrix[0].length) return result;
            
            for(int i = lastCol; i >= firstCol; i--) {
                result.add(matrix[lastRow][i]);
            }
            lastRow--;
            if(result.size() == matrix.length*matrix[0].length) return result;
            
            for(int i = lastRow; i>= firstRow; i--) {
                result.add(matrix[i][firstCol]);
            }
            firstCol++;
            
            if(result.size() == matrix.length*matrix[0].length) return result;
        }
        
        return result;
        
    }
}
