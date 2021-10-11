package com.ssafy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_7 {

	static int T = 1;
	static int N;
	static char[] p;
	static int result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Character> stack = new Stack<Character>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 괄호 짝짓기
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 배열 길이
			p = new char[N];
			String str = br.readLine();
			if (N % 2 == 1) {	// 괄호는 기본적으로 짝수개수가 있어야지 검사 필요성이 있다.
				result = 0;
			} else {
				for (int i = 0; i < N; i++) {
					p[i] = str.charAt(i);
				}
				for (int n = 0; n < N; n++) {
					if (p[n] == 41 || p[n] == 62 || p[n] == 93 || p[n] == 125) { // 아스키코드 : >=62, ]=93, }=125, )=41
						if (stack.isEmpty()) {
							result = 0;
							break;
						} else if (p[n] - stack.peek() == 1 || p[n] - stack.peek() == 2) { // 아스키코드 : <=60, [=93, {=123, (=40
							stack.pop();
							result = 1;
						} else {
							result = 0;
							break;
						}
					} else {
						stack.push(p[n]);
					}
				}
			}
			sb.append("#").append(t + 1).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
}
