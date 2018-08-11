package com.angular.cfc;

public class ChartInfo<X, Y> {

	private X xCoordinate;
	private Y yCoordinate;

	public X getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(X xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Y getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Y yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
