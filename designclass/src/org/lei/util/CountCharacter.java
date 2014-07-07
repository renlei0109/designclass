package org.lei.util;

import java.util.ArrayList;
import java.util.List;

public class CountCharacter {
		public List<Integer>countSerialCharacter(List<String> str){
			List<Integer>characterCounts = new ArrayList<Integer>();
			int A = 0;
			int B = 0;
			int C = 0;
			int D = 0;
			int E = 0;
			int F = 0;
			int G = 0;
			int H = 0;
			int I = 0;
			int J = 0;
			int K = 0;
			int L = 0;
			int M = 0;
			int N = 0;
			int O = 0;
			int P = 0;
			int Q = 0;
			int R = 0;
			int S = 0;
			int T = 0;
			int U = 0;
			int V = 0;
			int W = 0;
			int X = 0;
			int Y = 0;
			int Z = 0;
			char []c = null;
			for(int i = 0;i<str.size();i++){
				c = str.get(i).toCharArray();
				for(int j = 0;j<c.length;j++){
					switch(c[j]){
						case 'A':
							A++;
							break;
						case 'B':
							B++;
							break;
						case 'C':
							C++;
							break;
						case 'D':
							D++;
							break;
						case 'E':
							E++;
							break;
						case 'F':
							F++;
							break;
						case 'G':
							G++;
							break;
						case 'H':
							H++;
							break;
						case 'I':
							I++;
							break;
						case 'J':
							J++;
							break;
						case 'K':
							K++;
							break;
						case 'L':
							L++;
							break;
						case 'M':
							M++;
							break;
						case 'N':
							N++;
							break;
						case 'O':
							O++;
							break;
						case 'P':
							P++;
							break;
						case 'Q':
							Q++;
							break;
						case 'R':
							R++;
							break;
						case 'S':
							S++;
							break;
						case 'T':
							T++;
							break;
						case 'U':
							U++;
							break;
						case 'V':
							V++;
							break;
						case 'W':
							W++;
							break;
						case 'X':
							X++;
							break;
						case 'Y':
							Y++;
							break;
						case 'Z':
							Z++;
							break;
					}
				}
			}
			characterCounts.add(A);
			characterCounts.add(B);
			characterCounts.add(C);
			characterCounts.add(D);
			characterCounts.add(E);
			characterCounts.add(F);
			characterCounts.add(G);
			characterCounts.add(H);
			characterCounts.add(I);
			characterCounts.add(J);
			characterCounts.add(K);
			characterCounts.add(L);
			characterCounts.add(M);
			characterCounts.add(N);
			characterCounts.add(O);
			characterCounts.add(P);
			characterCounts.add(Q);
			characterCounts.add(R);
			characterCounts.add(S);
			characterCounts.add(T);
			characterCounts.add(U);
			characterCounts.add(V);
			characterCounts.add(W);
			characterCounts.add(X);
			characterCounts.add(Y);
			characterCounts.add(Z);
			return characterCounts;
		}
}
