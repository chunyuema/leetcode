class Spreadsheet {
    private Map<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] parts = formula.split("\\+");
        int left =  Character.isUpperCase(parts[0].charAt(0)) ? 
                    map.getOrDefault(parts[0], 0) :
                    Integer.parseInt(parts[0]); 
        int right = Character.isUpperCase(parts[1].charAt(0)) ? 
                    map.getOrDefault(parts[1], 0) :
                    Integer.parseInt(parts[1]);
        return left + right;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */