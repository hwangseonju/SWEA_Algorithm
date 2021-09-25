package com.ssafy.algo;

import java.util.Scanner;

public class swea_1954 {

	public static void main(String[] args) {
		// 달팽이 숫자
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			int N = scan.nextInt();

			int[][] num = new int[N][N];
			int s = 1; // 데이터 시작값
			int f = N; // N값이 변하기 때문에 f변수에 담아둠.
			int r = 0; // num 배열의 행
			int c = 0; // num 배열의 열

			while (true) {
				for (int i = 0; i < N; i++) { // 오른쪽방향
					num[r][c++] = s++;
				}
				N--;
				c--;
				if (Out(s, f))
					break;
				for (int i = 0; i < N; i++) { // 아래방향
					num[++r][c] = s++;
				}
				if (Out(s, f))
					break;
				for (int i = 0; i < N; i++) { // 왼쪽방향
					num[r][--c] = s++;
				}
				N--;
				if (Out(s, f))
					break;
				for (int i = 0; i < N; i++) { // 위쪽방향
					num[--r][c] = s++;
				}
				c++;
			}

			System.out.println("#" + (t + 1));
			for (int i = 0; i < f; i++) {
				for (int j = 0; j < f; j++) {
					System.out.print(num[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static boolean Out(int s, int f) { // break문 선언 필요성 확인
		if (s > f * f) {
			return true;
		} else {
			return false;
		}
	}

}
