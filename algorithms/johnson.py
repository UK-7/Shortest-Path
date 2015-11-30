from bellman_ford import bellman_ford_less_naive
from dijkstra import dijkstra_naive
from data_structures.adjacency_matrix import print_nice

def add_node_graph(graph):
    for i in range(len(graph)):
        graph[i].append(0)
    graph.append([0]*(len(graph)+1))
    return graph

def remove_node(graph):
    for i in range(len(graph)):
        graph[i].pop()
    graph.pop()
    return graph
def graph_reweight(graph,h):
    for i in range(len(graph)):
        for j in range(len(graph)):
            if i != j:
                graph[i][j] = graph[i][j]+h[i]-h[j]
    return graph

def johnson(graph):
    size = len(graph)
    graph = add_node_graph(graph)
    
    h_v = bellman_ford_less_naive(graph,size-1)
    if not h_v:
        return False
    else:
        h_v = h_v[0]
    # next the edges of the original graph are reweighted using the values computed
    # weight(u,v) = weight(u,v) +h(u) - h(v)
    
    print_nice(graph)
    graph = graph_reweight(graph,h_v)
    graph = remove_node(graph)
    print_nice(graph)
    sol = [dijkstra_naive(graph,i)[0] for i in range(size)]    
    return sol
    
    
