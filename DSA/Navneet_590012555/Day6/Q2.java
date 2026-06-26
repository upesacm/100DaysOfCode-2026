List<Integer> union(int[] a, int[] b) {
    List<Integer> r = new ArrayList<>();
    int i = 0, j = 0;

    while (i < a.length && j < b.length) {
        int x = a[i] < b[j] ? a[i++] : a[i] > b[j] ? b[j++] : a[i++];
        if (a[i - 1] == b[j - 1]) j++;
        if (r.isEmpty() || r.get(r.size() - 1) != x)
            r.add(x);
    }

    while (i < a.length)
        if (r.isEmpty() || r.get(r.size() - 1) != a[i])
            r.add(a[i++]);
        else i++;

    while (j < b.length)
        if (r.isEmpty() || r.get(r.size() - 1) != b[j])
            r.add(b[j++]);
        else j++;

    return r;
}