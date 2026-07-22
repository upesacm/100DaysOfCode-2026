class Solution:
    def countStudents(self, students, sandwiches):
        from collections import deque
        
        queue = deque(students)
        stack = sandwiches
        sand_idx = 0
        attempts = 0
        
        while queue and attempts < len(queue):
            student = queue.popleft()
            
            if student == stack[sand_idx]:
                sand_idx += 1
                attempts = 0
            else:
                queue.append(student)
                attempts += 1
        
        return len(queue)