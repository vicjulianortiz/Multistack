public class MultiStack {
	private StackMain stack ;
	private int N;
	private int M;
	private int L0;
	private String[] stackSpace;
    private int[] stackPointer, basePointers, newBasePointers;

    public MultiStack(int n, int m, int base) {
        StackMain stack = new StackMain();

        N = n;
        M = m;
        L0 = base;
        stackSpace = new String[M];
        stackPointer = new int[N];
    }
    public void push(int stackNum, String value, MultiStack stack){
        if(getTopPointer(stackNum) >= getBasePointer(stackNum + 1)){
            System.out.println("Error overflow has occured...");
            System.out.println("BASE[" + stackNum + "]: " + stackSpace[getBasePointer(stackNum)]);
            System.out.println("OLDTOP[" + stackNum + "]: " + stackSpace[stackPointer[stackNum]]);

        	AlgorithmReallocate newStack = new AlgorithmReallocate(M, N, L0, stackPointer, basePointers);
        	newBasePointers = newStack.getNewBasePointers();

        	stack.pop(stackNum, value);
            System.out.println("\nNEWTOP[" + stackNum + "]: " + value);
            stackSpace[stackPointer[stackNum-1]] = value;

            System.out.println("CONETENTS AFTER REALLOCATION\n");
            printContents();
        }
        stackPointer[stackNum - 1]++;
        stackSpace[stackPointer[stackNum - 1]] = value;
    }

    public void pop(int stackNum, String value){
        if(isEmpty(stackNum))
        	System.out.println("This stack is empty");
        String popped = stackSpace[stackPointer[stackNum - 1]];
    }

	public void setBasePointers(int stackCount){
		basePointers = new int[stackCount];
		for(int i = 0; i < stackCount; i++){
			basePointers[i] = getBasePointer(i + 1);
		}
	}

    public void setStackPointer(int stackCount){
		for(int i = 0; i < stackCount; i++){
			stackPointer[i] = getBasePointer(i + 1);
		}
	}

    public int getTopPointer(int stackNum){
        return (stackPointer[stackNum - 1]);
    }

    public int getBasePointer(int stackNum){
		int base = (int)((stackNum - 1) / (float)(N) * M) + L0;
		return base;
	}

	public boolean isEmpty(int stackNum){
		if (stackPointer[stackNum - 1] == getBasePointer(stackNum)){
			return true;
		}
		else{
			return false;
		}
    }

    public void printContents()
    {
		for(int i = 0; i <= M; i++){
			System.out.print("LOCATION[" + i + "]: ");
			if(i < M)
				if(stackSpace[i] != null)
					System.out.print(stackSpace[i]);
			for(int j = 0; j < N; j++){
				if(i == basePointers[j])
					System.out.print("\tBase(" + (j+1)+ ")");
				if(i == stackPointer[j])
					System.out.print("\tTop("+ (j+1)+ ")");
			}
			System.out.println();
		}
	}
}