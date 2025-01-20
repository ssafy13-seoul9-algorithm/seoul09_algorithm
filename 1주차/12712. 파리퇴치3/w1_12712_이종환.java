import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class w1_12712_이종환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int size = sc.nextInt();
			int spray = sc.nextInt();
			
			List<Integer>[] field = new ArrayList[size];
			for (int j = 0; j < size; j++) {
				field[j] = new ArrayList<Integer>();
			}
			
			for (int j = 0 ; j < size; j++) {
				for (int k = 0; k < size; k++) {
					field[j].add(sc.nextInt());
				}
			}
			
			int maxMos = 0;
			
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					int curMos = field[j].get(k);
					
					for (int l = 1; l < spray; l++) {
						if (l + k < size) {
							curMos += field[j].get( l+ k);
						} else break;
					}
					
					for (int l = 1; l < spray; l++) {
						if (k - l >= 0) {
							curMos += field[j].get(k - l);
						} else break;
					}

					for (int l = 1; l < spray; l++) {
						if (l + j < size) {
							curMos += field[j + l].get(k);
						} else break;
					}
					
					for (int l = 1; l < spray; l++) {
						if (j - l >= 0) {
							curMos += field[j - l].get(k);
						} else break;
					}
					
					maxMos = Math.max(maxMos, curMos);
					
					curMos = field[j].get(k);
					
					for (int l = 1; l < spray; l++) {
						if (l + k < size && l + j < size ) {
							curMos += field[j+l ].get( l+ k);
						} else break;
					}
					
					for (int l = 1; l < spray; l++) {
						if (k - l >= 0 && j - l >=0) {
							curMos += field[j-l].get(k - l);
						} else break;
					}

					for (int l = 1; l < spray; l++) {
						if ( k - l >= 0 && l + j < size) {
							curMos += field[j + l].get(k-l);
						} else break;
					}
					
					for (int l = 1; l < spray; l++) {
						if (l + k < size && j - l >= 0) {
							curMos += field[j - l].get(k+l);
						} else break;
					}
					
					maxMos = Math.max(maxMos, curMos);
					
				}
			}
			
			System.out.println("#"+ (i+1) + " " + maxMos);
			
			
		}
	}
} 