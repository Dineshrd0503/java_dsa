package graphs;

import java.util.*;

/**
 * Problem Statement:
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * merge accounts belonging to the same person. Two accounts belong to the same person
 * if they share at least one common email. Return merged accounts with emails sorted.
 */
public class AccountsMerge {
    public static void main(String[] args) {
        // Test Case 1
        ArrayList<ArrayList<String>> accounts1 = new ArrayList<>();
        accounts1.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts1.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts1.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts1.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        System.out.println(accountsMerge(accounts1));
        /* Output:
        [
            ["John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"],
            ["Mary", "mary@mail.com"],
            ["John", "johnnybravo@mail.com"]
        ]
        */

        // Test Case 2
        ArrayList<ArrayList<String>> accounts2 = new ArrayList<>();
        accounts2.add(new ArrayList<>(Arrays.asList("Gabe","Gabe00@m.co","Gabe3@m.co","Gabe1@m.co")));
        accounts2.add(new ArrayList<>(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co")));
        accounts2.add(new ArrayList<>(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co")));
        accounts2.add(new ArrayList<>(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co")));
        accounts2.add(new ArrayList<>(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")));
        System.out.println(accountsMerge(accounts2));
        /* Output:
        [
            ["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],
            ["Gabe","Gabe00@m.co","Gabe1@m.co","Gabe3@m.co"],
            ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
            ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
            ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]
        ]
        */
    }

    public static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        UnionFind uf = new UnionFind();

        // Link all emails in each account to the first email
        for (ArrayList<String> acc : accounts) {
            String name = acc.get(0);
            if (acc.size() < 2) continue;
            String firstEmail = acc.get(1);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                uf.union(firstEmail, email);
            }
        }

        // Group emails by their root parent using TreeSet for sorting
        Map<String, TreeSet<String>> groups = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        // Build the result with sorted emails
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : groups.entrySet()) {
            ArrayList<String> merged = new ArrayList<>();
            merged.add(emailToName.get(entry.getKey())); // Add name
            merged.addAll(entry.getValue()); // Add sorted emails
            result.add(merged);
        }

        return result;
    }

    static class UnionFind {
        private Map<String, String> parent = new HashMap<>();

        public String find(String x) {
            parent.putIfAbsent(x, x);
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x))); // Path compression
            }
            return parent.get(x);
        }

        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootY, rootX); // Merge y's tree into x's
            }
        }
    }
}
