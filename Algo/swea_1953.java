package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

	static int T;	// 테스트 케이스
	static int N;	// 세로 크기
	static int M;	// 가로 크기
	static int[][] map;	// 지하 터널 지도
	static boolean[][] visited;	// 방문한 곳 확인
	static int xhole;	// 맨홀 행
	static int yhole;	// 맨홀 열
	static int L;	// 소요시간
	static int space;	// 탈주범이 위치할 수 있는 장소의 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 탈주범 검거
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			xhole = Integer.parseInt(st.nextToken());
			yhole = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]==0) {	// 아예 못가는 곳은 미리 방문처리하기
						visited[r][c] = true;
					}
				}
			}
			
			space = 1;	// 맨홀 위치도 탈주범이 위치할 수 있는 장소에 들어가기 때문에 1부터 시작
			Search(xhole, yhole, map[xhole][yhole]);	// 맨홀 위치부터 시작
			sb.append("#").append(t).append(" ").append(space).append("\n");
		}
		System.out.print(sb);
	}
	
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1},{-1,0}};	// 상우하좌상
	static int[][] type = {{},{0,4}, {0,3}, {1,4}, {0,2}, {1,3},{2,4},{3,5}};	// 터널 구조물 종류에 따른 방향 범위 지정
	
	// 터널 이동하기
	static void Search(int r, int c, int pipe){
		Queue<XY> queue = new LinkedList<>();
		queue.offer(new XY(r, c, pipe));
		visited[r][c] = true;
		L = L-1;	// 맨홀 장소가 포함되면 1초 흐름
		
		while(L-->0) {
			int size = queue.size();
			while(size-->0) {
				XY head = queue.poll();
				r = head.x;
				c = head.y;
				pipe = head.d;
				int sd = type[pipe][0];
				int fd = type[pipe][1];
				
				if(pipe==2 || pipe==3) {
					for(int d=sd; d<fd; d=d+2) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						
						if(isIn(nr,nc) && check(nr, nc, d) && !visited[nr][nc]) {
							queue.offer(new XY(nr,nc,map[nr][nc]));
							visited[nr][nc]=true;
							space++;
						}
					}
				}else {
					for(int d=sd; d<fd; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						
						if(isIn(nr,nc) && check(nr, nc, d) && !visited[nr][nc]) {
							queue.offer(new XY(nr,nc,map[nr][nc]));
							visited[nr][nc]=true;
							space++;
						}
					}
				}
			}
		}
		return;
	}
	
	// 다음 터널로 이동 가능여부 판단
	static boolean check(int nr, int nc, int d) {
		if(d==0 || d==4) {	// 방향=상 -> 구조물 1,2,5,6만 가능
			if(map[nr][nc]==3 ||map[nr][nc]==4||map[nr][nc]==7) {
				return false;
			}
		}else if(d==1) {	// 방향=우 -> 구조물 1,3,6,7만 가능
			if(map[nr][nc]==2 ||map[nr][nc]==4||map[nr][nc]==5) {
				return false;
			}
		}else if(d==2) {	// 방향=하 -> 구조물 1,2,4,7만 가능
			if(map[nr][nc]==3 ||map[nr][nc]==5||map[nr][nc]==6) {
				return false;
			}
		}else if(d==3) {	// 방향=좌 -> 구조물 1,3,4,5만 가능
			if(map[nr][nc]==2 ||map[nr][nc]==6||map[nr][nc]==7) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	static class XY{
		int x, y, d;

		public XY(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
