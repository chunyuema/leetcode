class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> outgoingCities = new HashSet<>();
        for (List<String> path : paths) {
            outgoingCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!outgoingCities.contains(dest))
                return dest;
        }

        return null;
    }
}