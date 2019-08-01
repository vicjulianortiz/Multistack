public class MultiStack2{
	private int M, N, L0;
	private String[] userInputSeparated = new String[2];
	private String[] stackCommand = new String[10];
	private String userInput, inputValue;

	private StackMain stack = new StackMain();
	private String[] buffer = new String[M*N];
    private int[] stackPointer = new int[N];

	public MultiStack2(int mem, int num, int base, String input){
		M = mem;
		N = num;
		L0 = base;
		userInput = input;
		stackCommand = userInput.split("");
		userInputSeparated = userInput.split(" ");
		inputValue = userInputSeparated[userInputSeparated.length - 1];
	}

	public String pop(int stackNum) throws Exception{
	        if(isEmpty(stackNum)) throw new Exception("Error: This stack's empty");
	        String popped = buffer[absTopOfStack(stackNum)];
	        stackPointer[stackNum]--;
	        return popped;
	    }


	public void inputToStack(){

			if(stackCommand[0].equalsIgnoreCase("i")){
				int stackNumber = Integer.parseInt(stackCommand[1]);
				try {
					if(stackPointer[stackNumber] + 1 >= M){
						System.out.println("ERROR!");
						System.out.println("BASE[" + stackNumber + "]: " + stackPointer[L0]);
						System.out.println("OLDTOP[" + stackNumber +"]: " + buffer[absTopOfStack(stackNumber)]);
						try {
							pop(stackNumber);
						}
						catch(Exception e){
							System.out.println("ERROR: " + e);
						}
						System.out.println("NEWTOP["+stackNumber+"]: " + inputValue);
					}
					stackPointer[stackNumber]++;
	        		buffer[absTopOfStack(stackNumber)] = inputValue;
				} catch(Exception e){
					System.out.println("There was an error inserting the value into the stack.");
				}
			}
			/**
			else if(stackCommand[0].equalsIgnoreCase("d")){
				int stackNumber = Integer.parseInt(stackCommand[1]);
				try {
					System.out.println(pop(stackNumber));
				} catch(Exception e){
					System.out.println("There was an error deleting the value from the stack.");
				}
			}**/
	}


	public boolean isEmpty(int stackNum){
	        return stackPointer[stackNum] == 0;
    }
	public int absTopOfStack(int stackNum){
	        return stackNum*M + (L0 + stackPointer[stackNum]);
    }
}