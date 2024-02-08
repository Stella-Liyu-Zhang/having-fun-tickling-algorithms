class ParkingSystem {
    int[] empty = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        empty = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if(empty[carType - 1] > 0){
            empty[carType - 1] --;
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */