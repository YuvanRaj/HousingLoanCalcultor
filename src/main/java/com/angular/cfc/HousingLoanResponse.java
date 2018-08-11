package com.angular.cfc;

import java.util.List;

public class HousingLoanResponse {
	private List<HousingLoanInfo> gridResponse;
	private List<ChartInfo> chartInfo;

	public List<HousingLoanInfo> getGridResponse() {
		return gridResponse;
	}

	public void setGridResponse(List<HousingLoanInfo> gridResponse) {
		this.gridResponse = gridResponse;
	}

	public List<ChartInfo> getChartInfo() {
		return chartInfo;
	}

	public void setChartInfo(List<ChartInfo> chartInfo) {
		this.chartInfo = chartInfo;
	}

}
