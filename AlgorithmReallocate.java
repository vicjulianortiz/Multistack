public class AlgorithmReallocate{
	int availSpace;
	int totalInc;
	int M, J, N, L0;
	double alpha, tau, beta, sigma;
	double growthAllocate = 0.8;
	double equalAllocate = 0.2;
	int[] top, oldTop, growth, newBase;

	public AlgorithmReallocate(int m, int n, int base, int[] t, int[] b){
		M = m;
		L0 = base;
		J = n - 1;
		N = n;

		totalInc = 0;
		availSpace = M - L0;
		top = t;
		oldTop = b;
		growth = oldTop;
		newBase = oldTop;

		while(J >= 0){
			availSpace = availSpace - (top[J] - oldTop[J]);
			if(top[J] > oldTop[J]){
				growth[J] = top[J] - oldTop[J];
				totalInc += growth[J];
			}
			else{
				growth[J] = 0;
			}
			J--;
		}

		alpha = equalAllocate * availSpace / n;
		beta = growthAllocate * availSpace / totalInc;
		newBase[0] = oldTop[0];
		sigma = 0;

		for(int i = 1; i < N; i++){
			tau = sigma + alpha + growth[i-1] * beta;
			newBase[i] = newBase[i-1] + (top[i-1] - oldTop[i-1]) + (int)tau - (int)sigma;
			sigma = tau;
		}
	}

	public int[] getNewBasePointers(){
		return newBase;
	}
}