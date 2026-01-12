                          Iterable
                              |
                        ----------------
                        |              |
                     Collection        Map   (NOT a child of Collection)
                        |
          ------------------------------------------
          |                  |                     |
         List                Set                  Queue
          |                  |                     |
   ----------------      ----------------       ----------------
|      |     |        |              |        |              |
ArrayList LinkedList  HashSet        LinkedHashSet   PriorityQueue  Deque
|                  |
|               TreeSet
|
Vector
|
Stack


                   Map
                    |
       ---------------------------------
       |               |               |
    HashMap         Hashtable        TreeMap
       |
LinkedHashMap
|
ConcurrentHashMap
