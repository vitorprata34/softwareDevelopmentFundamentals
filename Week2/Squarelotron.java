package Week2;

public class Squarelotron {
    int size;
    int[][] squarelotron;
    
    public Squarelotron(int x)
    {
	this.size = x;
	squarelotron = new int [x] [x];
	
	    for(int i = 0; i < size; i++)
	    {
	        for(int j = 0; j < size; j++) 
	        {
		    squarelotron[i][j] = (size * i)+j+1;
	        }
	    }
    }
    //Display
    
    public void square()
    {
	    for(int i = 0; i < this.squarelotron.length; i++)
	    {
	        for(int j = 0; j < squarelotron.length; j++) 
	        {
		    System.out.printf("%2d ", this.squarelotron[i][j]);
	        }
	        System.out.println();
	        System.out.println();
	    }
    }
   //Max Rings
    
    public int findRings()
    {
	return (this.size % 2 ==0) ? (size/2) : (size/2) + 1;
    }
    
    public static void viewArr(int [] [] n)
    {
	    for(int i = 0; i < n.length; i++)
	    {
	        for(int j = 0; j < n.length; j++) 
	        {
		    System.out.printf("%2d ", n[i][j]);
	        }
	    }
	    System.out.println();
    }
    
    public void swap(Squarelotron x)
    {
	    for(int i = 0; i < size; i++)
	    {
	        for(int j = 0; j < size; j++) 
	        {
		    x.squarelotron[i][j] = this.squarelotron[i][j];
	        }
	    }
    }
    //Squarelotron Methods
    
    public Squarelotron upsideDownFlip(int ring) throws NumberFormatException{
	
	    if(ring < 1  || ring > this.findRings() )
	    {
	    throw new NumberFormatException();
	    }
	
	Squarelotron x = new Squarelotron(size);
	this.swap(x);
	
	int first = ring - 1;
	int last = size - ring;
	
	for(int i = 0 ; i <= size-1 ; i++)
	{
	    for(int j = 0 ; j <= size-1 ; j++) 
	    {
		    if (i == first || i == last) 
		    {
                if(j >= first && j <= last)
                {
              x.squarelotron[i][j] = this.squarelotron[size -1 -i] [j];  
                }
                else 
                {
		        }
		    }
		    else if( i > first && i < last)
		    {
		        if (j == first || j == last)
		        {
			    x.squarelotron[i][j] = this.squarelotron[size -1 -i] [j];
		        }
		    }
	    }	
	}
	return x;
    }
    //flip top to bottom
    public Squarelotron mainDiagonalFlip(int ring) throws NumberFormatException{
	
	    if(ring < 1  || ring > this.findRings() )
	    {
	    throw new NumberFormatException();
	    }
	
	Squarelotron x = new Squarelotron(size);
	this.swap(x);
	
	int first = ring - 1;
	int last = size - ring;
	
        for(int i = 0 ; i < size ; i++)
        {
            for(int j = 0 ; j < size ; j++) 
            {
                if (i == first || i == last)
                {
                     if  (j >= first && j <= last)
                    {    
                    x.squarelotron[i][j] = this.squarelotron[j] [i];
                    }
                }  
                else if( i > first && i < last)
                {
                    if (j == first || j == last)
                    {
                    x.squarelotron[i][j] = this.squarelotron[j] [i];
                    }
                }
            }   
	    }	
	    return x;
    }
    
    public void rotateRight(int numberOfTurns) {
	
	int maxRing = findRings();
	int ring;
	boolean r = true;
	
	int [] [] tmpArr = new int [size] [size];
	for(int i = 0 ; i < size ; i++)
	{
	    for(int j = 0 ; j < size ; j++) 
	    {
		tmpArr[i] [j] = this.squarelotron[i] [j];
	    }
	}
	if (numberOfTurns < 0)
	{
	    r = false;
	    numberOfTurns *= -1;
	}
	//rotate the entire square
	for(int a = 0; a < numberOfTurns; a++)
	{
	    for(int b = 1; b <= maxRing; b++)
	    {
		ring = b ;
		int first = ring - 1;
		int last = size - ring;
		
		    for(int i = 0 ; i < size; i++)
		    {
		        for(int j = 0 ; j < size; j++) 
		        {
			        if (i == first && j >= first && j <= last)
			        {
			         this.squarelotron[i][j] = (r) ? tmpArr[size -1 -j] [first] :
				        tmpArr[j][last];
			        }
			        else if (i == last && j >= first && j <= last)
			        {
			        this.squarelotron[i][j] = (r) ? tmpArr[size -1 -j] [last] :
				    tmpArr[j][first];
			        }
			        else if( i > first && i < last)
			        {
			            if (j == last) 
			            {
				        this.squarelotron[i][j] = (r) ?  tmpArr[first] [i] :
					    tmpArr[last][size -1 -i];
			            }
			            else if(j == first) 
			            {
				        this.squarelotron[i][j] = (r) ?  tmpArr[last] [i] :
					    tmpArr[first][size -1 -i];
			            }
			        }
		        }
		    }   
	    }
	  //temp array
		    for(int i = 0 ; i < size ; i++)
		    {
		        for(int j = 0 ; j < size ; j++) 
		        {
			    tmpArr[i] [j] = this.squarelotron[i] [j];
		        }
		    }    
	    }
    }
    
    public static void main(String[] args) {
	
	    Squarelotron x = new Squarelotron(4); 
	    x.square();
    }  
}
