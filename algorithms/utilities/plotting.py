import time
import numpy as np
from algorithms.data_structures.adjacency_matrix import build_random_graph


def graph_size_test(functions, min_size, max_size,num_iter):
    # need to look at time growth over more complex graphs with set connectivity
    # graph = build_random_graph(m,low_weight = 1,high_weight = 20,p_edge = .6)
    all_data = [ [[],[]] for i in range(len(functions)) ]
    # [i][0].append means
    # [i][1].append sd
    for size in range(min_size, max_size+1):
        iters = [ [] for i in range(len(functions)) ]
        graph = build_random_graph(size,p_edge = .8)
        for j in range(num_iter): 
            for idx,function in enumerate(functions):
                #all functions must have graph,source call
                start = time.time()
                function(graph,0)
                elapsed = time.time()-start
                iters[idx].append(elapsed)

        for idx,data in enumerate(iters):
            all_data[idx][0].append(np.mean(data))
            all_data[idx][1].append(np.std(data))
    
    print(all_data)


def graph_connectivity_test(functions, min_p, max_p):
    # need to look at time growth over graph connectivity
    # graph = build_random_graph(50,low_weight = 1,high_weight = 20,p_edge = x)
    pass


def build_plots(funs,fun_names):
    pass
