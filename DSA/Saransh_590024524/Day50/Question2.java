package DSA.Saransh_590024524.DAy50;

import java.util.ArrayList;

public class Question2 {

    public ArrayList<Integer> insertion(ArrayList<Integer> rocks) {
        int i, j, key;

        for (i = 1; i < rocks.size(); i++) {
            key = rocks.get(i);
            j = i - 1;

            while (j >= 0 && rocks.get(j) < key) {
                rocks.set(j + 1, rocks.get(j));
                j--;
            }

            rocks.set(j + 1, key);
        }

        return rocks;
    }

    int rocklets(ArrayList<Integer> rock) {

        insertion(rock);

        if (rock.size() == 0)
            return 0;

        if (rock.size() == 1)
            return rock.get(0);

        int heavy1 = rock.get(0);
        int heavy2 = rock.get(1);

        if (heavy1 == heavy2) {
            rock.remove(0);
            rock.remove(0);
        }
        else {
            int smash = heavy1 - heavy2;

            rock.remove(0);
            rock.remove(0);

            rock.add(smash);
        }

        return rocklets(rock);
    }
}