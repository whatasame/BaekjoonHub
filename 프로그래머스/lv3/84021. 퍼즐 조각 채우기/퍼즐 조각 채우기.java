import java.util.*;
import java.io.*;

/* 문제 요약
 * 퍼즐 조각을 빈 공간에 하나씩 채워넣는데, 하나를 넣었을 때 넣은 곳과 인접한 곳이 비어있으면 안된다.
 * 즉, 빈 칸의 사이즈에 딱 맞는 퍼즐을 넣어야한다.
 * 퍼즐 조각은 회전은 가능하지만 뒤집을 수 없다.
 * 퍼즐 조각을 모두 넣을 필요는 없다. 따라서 조건을 만족할 수 있는만큼 최대로 넣는다.
 */

/* 입출력 요약
 * 게임판과 테이블은 모두 크기가 같은 정사각형 형태이다. (3 ~ 50)
 * 게임판의 빈 칸은 1칸짜리가 최대 6개까지 연결된 형태로 주어진다.
 * 퍼즐 조각 또한 1칸짜리가 최대 6개 연결된 형태로 주어진다.
 */

class Solution {

    private static int N;
    private static boolean[][] isVisited;
    private static int[] offsetX = {0, 0, 1, -1};
    private static int[] offsetY = {1, -1, 0, 0};

    public int solution(int[][] game_board, int[][] table) {
        N = table.length;

        /* game_board에서 빈 공간[][]을 찾아서 empty_list에 저장한다 -> O(게임판길이^2)*/
        List<int[][]> emptyList = new LinkedList<>();
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0 && !isVisited[i][j]) {
                    emptyList.add(bfs(game_board, i, j, 0));
                }
            }
        }

        /* table에서 퍼즐 조각[][]을 찾아서 puzzle_list에 저장한다 -> O(table길이^2) */
        List<int[][]> puzzleList = new LinkedList<>();
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1 && !isVisited[i][j]) {
                    puzzleList.add(bfs(table, i, j, 1));
                }
            }
        }

        /* 딱 맞는 공간에 퍼즐을 넣어본다 -> O(빈칸 개수 x 퍼즐 조각 개수 x 회전 경우의 수)*/
        int answer = 0;
        for (int[][] empty : emptyList) {
            for (int i = 0; i < puzzleList.size(); i++) {
                if (check(empty, puzzleList.get(i))) { // 퍼즐을 돌려보면서 빈칸에 넣기 시도
                    answer += getEmptySize(empty); // 빈 칸 크기만큼 answer 증가
                    puzzleList.remove(i);
                    break;
                }
            }
        }

        /* 계산값 반환 (최종 시간 복잡도: O(게임판길이^2)*/
        return answer;
    }

    private static int getEmptySize(int[][] arr) {
        int size = 0;
        for (int[] row : arr) {
            for (int data : row) {
                if (data == 0) {
                    size++;
                }
            }
        }
        return size;
    }

    private static int[][] bfs(int[][] arr, int startX, int startY, int targetNum) {
        // targetNum: 0-> 빈 칸에 대하여 bfs, 1-> 조각에 대하여 bfs
        // nodeList: node가 이어진 빈칸 혹은 퍼즐
        List<Node> nodeList = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(startX, startY);

        queue.offer(start);
        isVisited[startX][startY] = true;

        nodeList.add(start);
        int minX = startX, minY = startY; // minX, minY -> 빈칸 배열의 가장 왼쪽 위
        int maxX = startX, maxY = startY; // maxX, maxX -> 빈칸 배열의 가장 오른쪽 아래

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < offsetX.length; i++) {
                int newX = now.x + offsetX[i];
                int newY = now.y + offsetY[i];

                if (isVaild(newX, newY) && arr[newX][newY] == targetNum
                        && !isVisited[newX][newY]) {

                    Node neighbor = new Node(newX, newY);

                    queue.offer(neighbor);
                    isVisited[newX][newY] = true;

                    nodeList.add(neighbor);
                    minX = Math.min(minX, newX); // min, max 갱신
                    minY = Math.min(minY, newY);
                    maxX = Math.max(maxX, newX);
                    maxY = Math.max(maxY, newY);

                }
            }

        }

        /* 빈칸 혹은 퍼즐 배열 만들기 */
        int[][] nodeArr = new int[maxX - minX + 1][maxY - minY + 1];
        for (int[] row : nodeArr) { // 배열 초기화
            int data = targetNum == 0 ? 1 : 0; // 빈칸 -> 1로 초기화, 퍼즐 -> 0으로 초기화
            Arrays.fill(row, data);
        }
        for (Node node : nodeList) { // 배열 채우기
            nodeArr[node.x - minX][node.y - minY] = targetNum; // 0 or 1
        }

        return nodeArr;
    }

    private static boolean isVaild(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static boolean check(int[][] empty, int[][] puzzle) {
        int repeat = 4;
        while (repeat-- > 0) {
            if (isFit(empty, puzzle)) {
                return true;
            }
            puzzle = rotate90(puzzle); // 90도 회전
        }

        return false;
    }

    private static int[][] rotate90(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n - 1 - j][i];
            }
        }

        return rotate;
    }

    private static boolean isFit(int[][] empty, int[][] puzzle) {


        if (empty.length != puzzle.length
                || empty[0].length != puzzle[0].length) {
            return false;
        }


        for (int i = 0; i < empty.length; i++) {
            for (int j = 0; j < empty[0].length; j++) {
                if (empty[i][j] == puzzle[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}