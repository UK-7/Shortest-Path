import time

def run_timer():
    #arrays to old average run time and run time standard dev
    std = []
    std_dev = []
    heap = []
    heap_dev = []

    #look at graphs with 5 to 70 nodes
    for i in range(5,70):
        #arrays for run time of a single matrix
        iterations_std = []
        iterations_heap = []
        #print(i)
        
        #TODO(jg): I know this is not the best way of timing. Implement a more accurate solution
        for j in range(100):
            graph = build_random_graph(i) #build graph

            #linear shortest path
            start = time.time()
            find_all_paths_standard(graph)
            iterations_std.append(time.time()-start)
            
            #heap shorests path
            start = time.time()
            find_all_paths_heap(graph)
            iterations_heap.append(time.time()-start)

        #calculate statistics from individual trials
        std.append(np.mean(iterations_std))
        heap.append(np.mean(iterations_heap))
        std_dev.append(np.std(iterations_std))
        heap_dev.append(np.std(iterations_heap))


    #write results to a tab deliminated text file
    with open('heap.txt','wt') as f:
        for i in range(len(std)):
            print('{0}\t{1}\t{2}\t{3}'.format(std[i],heap[i],std_dev[i],heap_dev[i]),file = f)