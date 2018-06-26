/**
 * 
 */
package com.maroy.random.probs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author MaRoy
 *
 */
public class FormulaOneRace {

	public static void main(String[] args) {

		calculateRaceMetrics(20, 10000);
	}

	private static void calculateRaceMetrics(int noOfCars, int lenOfTrack){

		List<Car> listOfCars = initCars(noOfCars);

		startRace(listOfCars, lenOfTrack);

	}

	private static List<Car> initCars(int noOfCars){

		List<Car> listOfCars = new ArrayList<Car>();
		double startThreshold = 0;
		for(int i = 1;i<=noOfCars;i++){

			double topSpeed = (150 + 10*i)*5/18;
			double acceleration = 2*i;
			startThreshold = startThreshold+200*(i-1);
			Car c = new Car(topSpeed, acceleration, startThreshold);
			listOfCars.add(c);
		}
		return listOfCars;
	}
	private static void startRace(List<Car> listOfCars, int lenOfTrack){

		boolean race = true;
		int i = 2;
		while(race){

			Collections.sort(listOfCars, new CarsComparator(i));

			Car lastCar = listOfCars.get(listOfCars.size()-1);
			if(checkEndCondition(lastCar, lenOfTrack)){
				printResults(listOfCars,i);
				break;
			}
			lastCar.applyNitro();
			i = i+2;
		}
	}

	private static boolean checkEndCondition(Car lastCar, int lenOfTrack){

		if(lastCar.getDistanceTrav() >= lenOfTrack){
			return true;
		}
		return false;
	}

	private static void printResults(List<Car> listOfCars, int time){

		int i = 1;
		for(Car c: listOfCars){

			System.out.println("Car - "+i+" Speed : "+Math.round(c.getDistanceTrav()/time));
			i++;
		}
	}
}

class CarsComparator implements Comparator<Car>{

	private int time;

	public CarsComparator(int time){
		this.time = time;
	}

	@Override
	public int compare(Car c1, Car c2) {

		double distTravel1 = Math.abs(c1.getAcceleration()*time*time-c1.getStartThreshold());
		c1.setDistanceTrav(distTravel1);
		c1.setCurrentSpeed(distTravel1/time);
		c1.checkCompetitor();

		double distTravel2 = Math.abs(c2.getAcceleration()*time*time-c2.getStartThreshold());
		c2.setDistanceTrav(distTravel2);
		c2.setCurrentSpeed(distTravel2/time);
		c2.checkCompetitor();

		if(distTravel1 < distTravel2)
			return 1;
		else if(distTravel1 > distTravel2)
			return -1;
		else
			return 0;
	}
}

class Car{

	private double topSpeed;
	private double currentSpeed;
	private double acceleration;
	private double startThreshold;
	private double distanceTrav;

	public Car(double topSpeed, double acceleration, double startThreshold) {
		super();
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
		this.startThreshold = startThreshold;
	}

	public double getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public double getAcceleration() {
		return acceleration;
	}
	public double getStartThreshold() {
		return startThreshold;
	}
	public void setStartThreshold(double startThreshold) {
		this.startThreshold = startThreshold;
	}
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	public void recalculateSpeed(int time){

		this.currentSpeed = this.currentSpeed + this.acceleration*time;
	}
	public void applyNitro(){
		this.currentSpeed = Math.min(this.topSpeed, this.currentSpeed*2);
	}
	public void checkCompetitor(){
		this.currentSpeed = 0.8*this.currentSpeed;
	}

	public double getDistanceTrav() {
		return distanceTrav;
	}

	public void setDistanceTrav(double distanceTrav) {
		this.distanceTrav = distanceTrav;
	}


}

