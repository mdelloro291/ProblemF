import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int starVariety;
        int starRequirement;
        int starCountNeeded;

        starVariety = input.nextInt();
        starRequirement = input.nextInt();
        starCountNeeded = input.nextInt();
        input.nextLine();
        
        String[][] starCost = new String[starVariety][2];
        String[][] starRecipe = new String[starRequirement][3];
        String[] starTypeNeeded = new String[starCountNeeded];
        for(int x = 0; x < starVariety; x++){
            starCost[x][0] = input.next();
            starCost[x][1] = input.next();
        }
        /*
        for(int y = 0; y < starVariety; y++){
            System.out.println("\nStar Type: " + starCost[y][0]);
            System.out.println("Cost: " + starCost[y][1]);
        }
        */
        for(int x = 0; x < starRequirement; x++){
            starRecipe[x][0] = input.next();
            starRecipe[x][1] = input.next();
            starRecipe[x][2] = input.next();
        }
        input.nextLine();
        for(int x = 0; x < starCountNeeded; x++){
            starTypeNeeded[x] = input.nextLine();
        }
        int individualCost = 0;
        int totalCost = 0;
        String[][] calculatedCost = new String[starCountNeeded][2];
        for(int x = 0; x < starCountNeeded; x++){
            calculatedCost[x][0] = starTypeNeeded[x];
        }
        /*
        for(String[] recipe : starRecipe){
            System.out.print("Recipes : ");
            System.out.print(" " + recipe[0]);
            System.out.print(" " + recipe[1]);
            System.out.print(" " + recipe[2]);
            System.out.println();
        }
        for (String star : starTypeNeeded) {
            System.out.println("Required : " + star);
        }
        */
        for (String star : starTypeNeeded) {
            for(int x = 0; x < starRequirement; x++){
                if(x == starRequirement - 1 && starRecipe[x][0].equals(star) == false){
                    //System.out.println("No Recipe! Fuse from Scratch");
                    break;
                }
                if(starRecipe[x][0].equals(star)){
                    //System.out.println("Recipe Found! Calculating...");
                    for(int y = 0; y < starVariety; y++){
                        if(starCost[y][0].equals(starRecipe[x][1])){
                            individualCost = Integer.parseInt(starCost[y][1]);
                            individualCost *= Integer.parseInt(starRecipe[x][2]);
                            int z;
                            for (z = 0; z < starCountNeeded; z++) {
                                if(calculatedCost[z][0].equals(star)){
                                    //System.out.println("Match found!");
                                    break;
                                }
                                //else{
                                    
                                //}
                            }
                            try {
                                //if(){
                                if(calculatedCost[z][1] == null){
                                    calculatedCost[z][1] = String.valueOf(individualCost);
                                }
                                else{
                                    calculatedCost[z][1] = String.valueOf(Integer.parseInt(calculatedCost[z][1]) + individualCost);
                                }
                                //}
                            } catch (Exception e) {
                                // TODO: handle exception
                            }
                            
                            
                            //System.out.println(individualCost);
                        }
                    }
                }
            }
            
        }
        for(String[] fusionCost : calculatedCost){
            System.out.println(fusionCost[1]);
        }
        input.close();
    }
}
