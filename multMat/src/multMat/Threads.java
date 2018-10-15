package multMat;

public class Threads implements Runnable {
	private int linha, coluna;
	private int [][] A;
	private int [][] B;
	private int [][] C;
	
	private static int k=2; //num colunas da Matriz A e linhas da Matriz B
	
	public Threads(int linha, int[][] A, int[][] B, int[][] C){
		this.linha=linha;
		this.A=A;
		this.B=B;
		this.C=C;
	}
		//calcular elementos da linha de C
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<B[0].length;i++){
			for (int j=0;j<k;j++){
				C[linha][i]+=A[linha][j]*B[j][i];
			}
		}
		
	}
}
