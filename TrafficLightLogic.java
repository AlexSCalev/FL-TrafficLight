package Source;

public class TrafficLightLogic {

    public void showArrayDates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public int getCounts(int between1, int number, int between2) {
//        Step between elements
        int countBetween1 = between1;
        while (countBetween1 < number) {
            countBetween1++;
        }
        countBetween1 = countBetween1 - between1;
        int countBetween2 = between2;
        while (countBetween2 > number) {
            countBetween2--;
        }
        countBetween2 = between2 - countBetween2;
        if (countBetween1 > countBetween2) {
            return between2;
        } else if (countBetween1 < countBetween2) {
            return between1;
        } else if (countBetween1 == countBetween2) {
            return between1;
        }
        return -1;
    }

    public int[] findBetween(int[] cars, int[] steps) {
        int[] belongCar = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < steps.length; j++) {

                if (cars[i] == steps[j]) {
                    belongCar[i] = steps[j];
                    break;
                }

                if (cars[i] == steps[j + 1]) {
                    belongCar[i] = steps[j + 1];
                    break;
                }

                if (cars[i] > steps[j] && cars[i] < steps[j + 1]) {
                    belongCar[i] = getCounts(steps[j], cars[i], steps[j + 1]);
                    break;
                }
            }
        }
//        Belong Cars to step is
        return belongCar;
    }

    TrafficLightLogic(int[] car_queue, int[] car_arrived, int[] steps,int[]car_to_time) {
        int[] belongCarQToStep = findBetween(car_queue, steps);
        int[] belongCarAToStep = findBetween(car_arrived, steps);

        int carOnCrossRoud[] = new int[car_queue.length];
//        Summ cars what we have in totaly
        for(int i = 0;i < carOnCrossRoud.length;i++){
                carOnCrossRoud[i] = belongCarQToStep[i] + belongCarAToStep[i];
        }
//        Show dates summary cars
        int time_sec_to_cross[] = new int[carOnCrossRoud.length];
        for(int i = 0; i < carOnCrossRoud.length;i++){
            for(int j = 0; j < car_to_time.length;j++){
                if(carOnCrossRoud[i] < car_to_time[0]){
                    time_sec_to_cross[i] = 0;
                    break;
                }
                if(carOnCrossRoud[i] > car_to_time[car_to_time.length-1]){
                    time_sec_to_cross[i] = car_to_time[car_to_time.length-1];
                    break;
                }
                if(carOnCrossRoud[i] == car_to_time[j]){
                    time_sec_to_cross[i] = car_to_time[j];
                    break;
                }
                if(carOnCrossRoud[i] == car_to_time[j+1]){
                    time_sec_to_cross[i] = car_to_time[j+1];
                    break;
                }
                if(carOnCrossRoud[i] > car_to_time[j] && carOnCrossRoud[i] < car_to_time[j+1]){
                    time_sec_to_cross[i] = getCounts(car_to_time[j],carOnCrossRoud[i],car_to_time[j+1]);
                    break;
                }
            }
        }
        System.out.println("Time green for 4 Cross Rouds:");
        for(int i = 0; i < time_sec_to_cross.length;i++){
            System.out.println("Cross Roud numb "+i+" will wait "+time_sec_to_cross[i]);
        }
    }
}
