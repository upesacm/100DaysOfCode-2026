class Solution:
    def copyStack(self, st):

        newStack = []

        def copy():
            if not st:
                return

            x = st.pop()

            copy()

            st.append(x)
            newStack.append(x)

        copy()
        return newStack