
# Breadth First Search

graph = {
	1 : [4, 2, 18, 6],
	6 : [8, 7, 12],
	2 : [9, 10],
	3 : [11, 1],
	7 : [7, 17, 11]
}


def bfs(graph, start_node, end_node):
	que = []
	# put first path into que
	que.append([start_node])

	while que:
		path = que.pop(0)
		# get last node in path
		node = path[-1]
		if node == end_node:
			return path

		# run through all adjacent nodes
		# construct new path
		# push path to que
		for adj in graph.get(node, []):
			new_path = list(path)
			new_path.append(adj)
			que.append(new_path)

print(bfs(graph, 6, 17))
