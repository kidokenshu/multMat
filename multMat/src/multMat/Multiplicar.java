package multMat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiplicar {
	
	// OS DADOS DAS MATRIZES SÃO PREENCHICAS AQUI
	
	public static int M=3; //num de linhas de A e C
	public static int K=2; //num de colunas de A e linhas de B
	public static int N=3; //num de colunas de B e C
	
	final static int numThread=3; //num de threads = M
	
	public static void main(String[] args) {
		int [][] A={{1,4},{2,5},{3,6}}; //Matriz A
		int [][] B={{8,7,6},{5,4,3}};  //Matriz B
		int [][] C= new int[M][N];    //Matriz C a ser preenchida
		
//		//GERAR MATRIZES MxN, onde M=N
//		for (int i=0;i<M; i++){ //percorrer linha
//			for(int j=0;j<N;j++){ //percorrer coluna
//				A[i][j]=i+j;
//				B[i][j]=i*j;
//			}
//		}
//		
//		//SEM TRHEADS
//		for(int i=0;i<M;i++){ //anda linha
//			for(int j=0;j<N;j++){ //anda coluna
//				int res=0;
//				for(int k=0; k<K;k++){
//					res+=A[i][k]*B[k][j];
//				}
//				C[i][j]=res;
//			}
//		}
		
		Thread[] thread=new Thread[numThread];
		int nT=0; //variavel auxiliar
		
		long start= System.currentTimeMillis();
		
		for(int i=0;i<M;i++){ //percorrer linha
			thread[nT]=new Thread(new Threads(i,A,B,C));//criar threads usando a classe Threads
			nT++; //incrementa indice de trhead
		}
		
		for(int i=0;i<numThread;i++){
			try {
				thread[i].join(); //pega resultado de cada trhead
			} catch (Exception e) {
				// TODO: handle exception
				Logger.getLogger(Multiplicar.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
		
		long stop=System.currentTimeMillis();
		
		for(int i=0;i<M;i++){ //anda linha
			for(int j=0;j<N;j++){ //anda coluna
				System.out.println(C[i][j]+ " ");
				}
				System.out.println();
			}
		System.out.println("\nDuração: "+ (stop-start));
		}
	
}
