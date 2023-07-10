from collections import deque

def bfs(start, visited, graph):
    queue = deque([start])
    count = 1
    visited[start] = True
    while queue:
        now = queue.popleft()
        for i in graph[now]:
            if not visited[i]:
                count += 1
                queue.append(i)
                visited[i] = True
    return count

def solution(n, wires):
    answer = []
    graph = [[] for _ in range(n + 1)]
    for x, y in wires:
        graph[x].append(y)
        graph[y].append(x)

    for start, end in wires:
        visited = [False] * (n + 1)
        visited[end] = True
        result = bfs(start, visited, graph)
        answer.append(abs(result - (n - result)))
    answer.sort()
    return answer[0]