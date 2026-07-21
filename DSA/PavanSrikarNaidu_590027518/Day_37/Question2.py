from collections import deque

def printer_queue(priorities, location):
    """
    Simulates a priority printer queue.
    
    Rule: Take the document at the front of the queue.
    - If there is a document with HIGHER priority anywhere else in the queue,
      move the front document to the back of the queue (don't print it yet).
    - Otherwise, print it (remove it).
    
    Returns the order (1-indexed) in which the document at `location` gets printed.
    """
    q = deque((priority, idx) for idx, priority in enumerate(priorities))
    
    order = 0  
    while q:
        current = q.popleft()
        
        # If any remaining document has higher priority, requeue current
        if any(current[0] < other[0] for other in q):
            q.append(current)
        else:
            order += 1
            if current[1] == location:
                return order
    
    return -1  

if __name__ == "__main__":
    priorities = [2, 1, 3, 2]
    location = 2
    print(printer_queue(priorities, location))  