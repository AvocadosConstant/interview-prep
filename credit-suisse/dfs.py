
# Depth First Search
    # Iterative First
    # Recursively second

graph = {'A': ['B', 'C'],
         'B': ['A', 'D', 'E'],
         'C': ['A', 'F'],
         'D': ['B'],
         'E': ['B', 'D'],
         'F': ['C', 'E']
         }

def dfs_iter(graph, root):
    visited = []
    stack = [root, ]

    while stack:
        node = stack.pop()

        if node not in visited:
            visited.append(node)
                        # extend by all nodes by dictionary index
                        #if node not in visited
            stack.extend([x for x in graph[node] if x not in visited])

    return visited

def dfs(graph, root, visited = None):
    if visited is None:
        visited = []

    if root in visited:
        return

    visited.append(root)

    for each in [x for x in graph[root] if x not in visited]:
        dfs(graph, each, visited)

    return visited

print(dfs(graph, "B", visited = None))
print(dfs_iter(graph, "B"))

#path generator
def dfs_paths(graph, root, target, path=None):
    if path is None:
        path = [root]

    if root == target:
        yield path

    for vertex in [x for x in graph[root] if x not in path]:
        for each_path in dfs_paths(graph, vertex, target, path + [vertex]):
            yield each_path

print("__________")
print(list(dfs_paths(graph, "D", "F")))
