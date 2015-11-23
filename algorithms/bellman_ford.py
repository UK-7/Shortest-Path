from utilities.profiler import do_profile

MAX_INT = 10000

@do_profile()
def bellman_ford_naive(graph,source):
    ##initialize arrays as before
    size = len(graph)
    pred = [None]*size
    min_dist = [MAX_INT]*size
    min_dist[source] = 0

    #relax edges V-1 times to find all shorest paths
    for i in range(1,size-1):
        for v in range(size):
            for x in adj_check(graph,v):
                if min_dist[x] > min_dist[v] + graph[v][x]:
                    min_dist[x] = min_dist[v] + graph[v][x]
                    pred[x] = v


    #are there cycles?
    for v in range(size):
        for x in adj_check(graph,v):
            if min_dist[x] > min_dist[v] + graph[v][x]:
                print 'negative cycle found'
                return False

    return (min_dist,pred)

def adj_check(G,v):
    result = []
    for x in range(len(G)):
        if G[v][x] != MAX_INT:
            result.append(x)
    return result



