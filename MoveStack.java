public class MoveStack{
	private int N, M;
	private int[] newBase;
	private String[] stackSpace, newStackSpace;
	private String[] tempStackSpace;
	private int counter = 0;

	public MoveStack(int n, int m, int[] nb, String[] contents){
		N = n;
		M = m;
		newBase = nb;
		stackSpace = contents;
		tempStackSpace = new int[M];

		for( int i = 0; i < M; i++)
		{
			if(stackSpace[i] != null){
				tempStackSpace[counter] = stackSpace[i];
				counter++;
			}
		}



	}



	public String[] getStackContent(){
		return stackSpace;
	}

}