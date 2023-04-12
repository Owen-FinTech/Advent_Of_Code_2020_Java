public class HandheldHaltingPt1 {
    public static String inputString = """
        
    """; // Insert your puzzle input between the triple quotes

    public static String[] getStringArray(String inputString) {
        String[] instructions = inputString.split("\n", 0);

        return instructions;
    }

    public static int runInstructions(String[] instructions) {
        int currIndex = 0;
        boolean[] visited = new boolean[instructions.length];
        int accumulator = 0;

        while (!visited[currIndex]) {
            int prevIndex;

            if (instructions[currIndex].substring(0, 3).equals("nop")) {
                prevIndex = currIndex;
                currIndex = (currIndex + 1) % instructions.length;
                visited[prevIndex] = true;
            }
            else if (instructions[currIndex].substring(0, 3).equals("acc")) {
                
                for (int i = 0; i < instructions[currIndex].length(); ++i) {
                    
                    if (instructions[currIndex].substring(i, i + 1).equals("+")) {
                        accumulator += Integer.parseInt(instructions[currIndex].substring(i + 1));
                    } 
                    else if (instructions[currIndex].substring(i, i + 1).equals("-")) {
                        accumulator -= Integer.parseInt(instructions[currIndex].substring(i + 1));
                    }
                }
                prevIndex = currIndex;
                currIndex = (currIndex + 1) % instructions.length;
                visited[prevIndex] = true;
            }
            else {
                int jumpAmount = 0;

                for (int i = 0; i < instructions[currIndex].length(); ++i) {
                    
                    if (instructions[currIndex].substring(i, i + 1).equals("+")) {
                        jumpAmount = Integer.parseInt(instructions[currIndex].substring(i + 1));
                    } 
                    else if (instructions[currIndex].substring(i, i + 1).equals("-")) {
                        jumpAmount = -1 * (Integer.parseInt(instructions[currIndex].substring(i + 1)));
                    }
                }
                prevIndex = currIndex;
                currIndex = (currIndex + jumpAmount) % instructions.length;
                visited[prevIndex] = true;
            }
        }

        return accumulator;
    }
    public static void main(String[] args) {
        System.out.println(runInstructions(getStringArray(inputString)));

    }
}