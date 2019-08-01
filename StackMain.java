import java.util.*;

public class StackMain{
    public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int M, N, L0;
		String userCommand = "";
		String inputValue;
		String[] commandSplit = new String[3];
		String[] stackCommand = new String[3];

		System.out.println("Enter the total amount of memory to allocate for all stacks: ");
		M = sc.nextInt();

		System.out.println("Enter the value of L0: ");
		L0 = sc.nextInt();

		System.out.println("Enter the number of stacks: ");
		N = sc.nextInt();

		MultiStack userMultiStack = new MultiStack(N, M, L0);
		userMultiStack.setStackPointer(N);
		userMultiStack.setBasePointers(N);

		System.out.println("Enter a command: ");

		do{
				sc.nextLine();

				userCommand = sc.nextLine();
				stackCommand = userCommand.split("");
				commandSplit = userCommand.split(" ");
				inputValue = commandSplit[commandSplit.length - 1];

				if(stackCommand[0].equalsIgnoreCase("i")){
					int stackNum = Integer.parseInt(stackCommand[1]);
					userMultiStack.push(stackNum, inputValue, userMultiStack);
				}
				else if(stackCommand[0].equalsIgnoreCase("d")){
					int stackNum = Integer.parseInt(stackCommand[1]);
					userMultiStack.pop(stackNum);
				}
				else{
					System.out.println(" ");
				}
		}while(!(stackCommand[0].equalsIgnoreCase("q")));
    }
}