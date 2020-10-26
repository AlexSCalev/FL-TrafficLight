package Source;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int number_crossRouds = 4;

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Input number max cars");
        int maxNumbCars = inputUser.nextInt();
        System.out.println("Input number min cars");
        int minNumbCars = inputUser.nextInt();
        if (maxNumbCars % minNumbCars != 0) throw new IllegalArgumentException("Please input right step");
        if (maxNumbCars / minNumbCars <= 2) throw new IllegalArgumentException("Inputs steps is very small");
        int numberSteps = maxNumbCars / minNumbCars;
//        Create array for steps
        int[] steps_array = new int[numberSteps];
//        initilize step arrays
        steps_array[0] = minNumbCars;
        for (int i = 1; i < numberSteps; i++) {
            steps_array[i] = steps_array[i - 1] + minNumbCars;
        }
//        Create array for queue and arriv cars
        int[] car_queue = new int[number_crossRouds];
        int[] car_arrived = new int[number_crossRouds];
//        Init arrays
        Random rand = new Random();
        for (int i = 0; i < number_crossRouds; i++) {
            car_queue[i] = rand.nextInt(maxNumbCars-minNumbCars)+minNumbCars;
            car_arrived[i] = rand.nextInt(maxNumbCars-minNumbCars)+minNumbCars;
        }
        int []car_to_time = new int[number_crossRouds];
        car_to_time[0] = 10;
        for(int i = 1;i < number_crossRouds; i++){
            car_to_time[i]+=10+car_to_time[i-1];
        }
        new TrafficLightLogic(car_queue,car_arrived,steps_array,car_to_time);
    }
}
