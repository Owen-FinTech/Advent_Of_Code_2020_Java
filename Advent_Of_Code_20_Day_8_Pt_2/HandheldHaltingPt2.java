public class HandheldHaltingPt2 {
    public static String inputString = """
        
    """; // Insert your puzzle inputs between the triple quotes

    public static String[] getStringArray(String inputString) {
        String[] instructions = inputString.split("\n", 0);

        return instructions;
    }

    public static int runInstructions(String[] instructions) {
        int accumulator = 0;

        for (int i = 0 ; i < instructions.length; ++i) {
            accumulator = 0;

            if ((instructions[i].substring(0, 3).equals("nop")) ||
            (instructions[i].substring(0, 3).equals("jmp"))) {
                
                if (instructions[i].substring(0, 3).equals("nop")) {
                    instructions[i] = "jmp" + instructions[i].substring(3);
                }
                else {
                    instructions[i] = "nop" + instructions[i].substring(3);
                }

                int currIndex = 0;
                int prevIndex = 0;
                boolean[] visited = new boolean[instructions.length];
                
                while (!visited[currIndex]) {
                    

                    if (instructions[currIndex].substring(0, 3).equals("nop")) {
                        prevIndex = currIndex;
                        currIndex = (currIndex + 1) % instructions.length;
                        visited[prevIndex] = true;
                    }
                    else if (instructions[currIndex].substring(0, 3).equals("acc")) {
                        
                        for (int j = 0; j < instructions[currIndex].length(); ++j) {
                            
                            if (instructions[currIndex].substring(j, j + 1).equals("+")) {
                                accumulator += Integer.parseInt(instructions[currIndex].substring(j + 1));
                            } 
                            else if (instructions[currIndex].substring(j, j + 1).equals("-")) {
                                accumulator -= Integer.parseInt(instructions[currIndex].substring(j + 1));
                            }
                        }
                        prevIndex = currIndex;
                        currIndex = (currIndex + 1) % instructions.length;
                        visited[prevIndex] = true;
                    }
                    else {
                        int jumpAmount = 0;

                        for (int j = 0; j < instructions[currIndex].length(); ++j) {
                            
                            if (instructions[currIndex].substring(j, j + 1).equals("+")) {
                                jumpAmount = Integer.parseInt(instructions[currIndex].substring(j + 1));
                            } 
                            else if (instructions[currIndex].substring(j, j + 1).equals("-")) {
                                jumpAmount = -1 * (Integer.parseInt(instructions[currIndex].substring(j + 1)));
                            }
                        }
                        prevIndex = currIndex;
                        currIndex = (currIndex + jumpAmount) % instructions.length;
                        visited[prevIndex] = true;
                    }

                    if (prevIndex == instructions.length - 1) {
                        break;
                    }
                }

                if (prevIndex == instructions.length - 1) {
                    break;
                }

                if (instructions[i].substring(0, 3).equals("nop")) {
                    instructions[i] = "jmp" + instructions[i].substring(3);
                }
                else {
                    instructions[i] = "nop" + instructions[i].substring(3);
                }
            }
        }

        return accumulator;
    }
    public static void main(String[] args) {
        System.out.println(runInstructions(getStringArray(inputString)));

    }
}