
public class IsMagic {
	public static void main(String[] args) {
	   int[][]square = {
				{4, 9, 2},
				{3, 5, 7},
				{8, 1, 6},
		};

        System.out.println(magic_square(square));
    }
    public static boolean magic_square(int [] [] square)
    {
        // test if two dimensions are the same        
        if (square.length != square[ 0 ].length)
    
        {    
            return false;  // not n x n    
        }
        
        // test that all integers are represented  
        boolean found = false; 
        int sum =1;
        while(sum < square.length*square.length)    
        {        
            for (int i =  0 ; i < square.length && found == false; i++)    
            {    
                for (int j = 0  ; j < square.length; j++)    
                {    
                    if (square[i][j] == sum)    
                    {    
                        found = true;    
                        break;  // out of inner for loop    
                    }    
                }    
            }    
            if (found == false) // number not in array        
            {    
                return false;    
            }
            found = false;
            sum ++;
        }
        // test that the sums of rows, columns, and diagonals are same        
        if (row(square) != column(square) && firstDiag(square) != secondDiag(square))        	
        {    
            return false;    
        }
    
        // it is a magic square    
        return true;
    }
	public static int column (int [][] square)
	{
		int sumCol  = 0;	    
        for (int i = 0  ; i < square.length; i++)	    
        {	    
            for (int j = 0  ; j < square.length; j++)	    
            {	    
                sumCol += square [j] [i];
            }
        }
        return sumCol;
	}
	public static int row (int [][] square)
	{
		int sumRow  = 0;	    
        for (int i = 0  ; i < square.length; i++)	    
        {	    
            for (int j = 0  ; j < square.length; j++)	    
            {	    
                sumRow += square [i] [j];
            }
        }
        return sumRow;
	}
	public static int firstDiag(int [] []square)
	{
		int firstDiagSum = 0;
        for (int i = 0  ; i < square.length; i++)            
        {
        	firstDiagSum += square [i] [i];

        }
        
        return firstDiagSum;
	}
	public static int secondDiag(int [] []square)
	{
		int secondDiagSum = 0;
        for (int i = 0  ; i < square.length; i++)            
        {
        	secondDiagSum += square [i] [(square.length - 1) -i];

        }
        
        return secondDiagSum;
	}

}

