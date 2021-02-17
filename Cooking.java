import java.util.*;

public class cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int liquid : liquids) {
            liquidsQueue.offer(liquid);
        }

        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }

        Map<String,Integer> materials=new TreeMap<>();
        materials.put("Bread",0);
        materials.put("Cake",0);
        materials.put("Fruit Pie",0);
        materials.put("Pastry",0);

        while (!liquidsQueue.isEmpty()){
            if(ingredientsStack.isEmpty()){
                break;
            }
            int currLiquid=liquidsQueue.poll();
            int currIngredient=ingredientsStack.pop();

            int totalValue=currLiquid+currIngredient;

            switch (totalValue){
                case 25:
                    int increasedAmount=materials.get("Bread")+1;
                    materials.put("Bread",increasedAmount);
                    break;
                case 50:
                    increasedAmount=materials.get("Cake")+1;
                    materials.put("Cake",increasedAmount);
                    break;
                case 75:
                    increasedAmount=materials.get("Pastry")+1;
                    materials.put("Pastry",increasedAmount);
                    break;
                case 100:
                    increasedAmount=materials.get("Fruit Pie")+1;
                    materials.put("Fruit Pie",increasedAmount);
                    break;
                default:
                    currIngredient+=3;
                    ingredientsStack.push(currIngredient);

            }
        }

        boolean everythingCooked=true;
        for (Map.Entry<String, Integer> stringIntegerEntry : materials.entrySet()) {
            if(stringIntegerEntry.getValue() == 0){
                everythingCooked=false;
                break;
            }
        }

        if(everythingCooked){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if(!liquidsQueue.isEmpty()){
            System.out.print("Liquids left: ");
            String result=String.join(",", liquidsQueue.toString());
            String r=result.replace("[","");
            String finalString=r.replace("]","");
            System.out.println(finalString);
        }else {
            System.out.println("Liquids left: none");
        }

        if(!ingredientsStack.isEmpty()){
            System.out.print("Ingredients left: ");
            String result=String.join(",", ingredientsStack.toString());
            String r=result.replace("[","");
            String finalString=r.replace("]","");
            System.out.println(finalString);
        }else {
            System.out.println("Ingredients left: none");
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : materials.entrySet()) {
            System.out.printf("%s: %d%n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }

    }
}
