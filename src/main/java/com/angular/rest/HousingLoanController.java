package com.angular.rest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.angular.cfc.ChartInfo;
import com.angular.cfc.HousingLoanInfo;
import com.angular.cfc.HousingLoanResponse;
import com.angular.cfc.RequestParam;
import com.angular.cfc.SqrtResponse;

/**
 * Controller used to calculate the housing loan for given tenure, principle,
 * interest rate
 * 
 * @author Yuvaraj
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Path("/housingloan")
public class HousingLoanController {

	/*@Path("getHousingLoanInfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public static HousingLoanResponse getHousingLoanInfoList(RequestParam requestParam) {
		HousingLoanResponse housingLoanResponse = new HousingLoanResponse();
		Double p = requestParam.getPrinciple();
		Double r = (requestParam.getInterestRate() / 100) / 12;
		Double n = requestParam.getTenure() * 12;

		Double numerator = Math.pow(1 + r, n);
		Double denominator = numerator - 1;
		Double emi = (p * r * numerator) / denominator;

		List<HousingLoanInfo> housingInfoList = new ArrayList<HousingLoanInfo>();
		HousingLoanInfo housingLoanInfo = new HousingLoanInfo();

		housingLoanInfo.setEmi(emi);
		housingLoanInfo.setInterest(p * r);
		housingLoanInfo.setPrinciple(emi - (p * r));
		housingLoanInfo.setOpeningBalance(p);
		housingLoanInfo.setConstantEmi(emi);
		housingInfoList.add(housingLoanInfo);

		for (int i = 1; i <= n; i++) {
			housingLoanInfo = housingInfoList.get(i - 1);

			Double openBalance = housingLoanInfo.getOpeningBalance();
			Double principle = housingLoanInfo.getPrinciple();
			Double closeBalance = openBalance - principle;

			housingLoanInfo = new HousingLoanInfo();
			housingLoanInfo.setInterest(closeBalance * r);
			housingLoanInfo.setEmi(emi);
			housingLoanInfo.setOpeningBalance(closeBalance);
			housingLoanInfo.setClosingBalance(closeBalance);
			housingLoanInfo.setPrinciple(emi - (closeBalance * r));
			housingLoanInfo.setConstantEmi((double) Math.round(emi));
			housingInfoList.add(housingLoanInfo);
		}

		List<ChartInfo> chartInfoList = new ArrayList<ChartInfo>();
		List<HousingLoanInfo> yearlyInfoList = getYearlyInfoList(housingInfoList, chartInfoList);

		housingLoanResponse.setGridResponse(yearlyInfoList);
		housingLoanResponse.setChartInfo(chartInfoList);

		return housingLoanResponse;

	}*/

	@Path("getHousingLoanInfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public static Response  getHousingLoanInfoList(RequestParam requestParam) {
		HousingLoanResponse housingLoanResponse = new HousingLoanResponse();
		Double p = requestParam.getPrinciple();
		Double r = (requestParam.getInterestRate() / 100) / 12;
		Double n = requestParam.getTenure() * 12;

		Double numerator = Math.pow(1 + r, n);
		Double denominator = numerator - 1;
		Double emi = (p * r * numerator) / denominator;

		List<HousingLoanInfo> housingInfoList = new ArrayList<HousingLoanInfo>();
		HousingLoanInfo housingLoanInfo = new HousingLoanInfo();

		housingLoanInfo.setEmi(emi);
		housingLoanInfo.setInterest(p * r);
		housingLoanInfo.setPrinciple(emi - (p * r));
		housingLoanInfo.setOpeningBalance(p);
		housingLoanInfo.setConstantEmi(emi);
		housingInfoList.add(housingLoanInfo);

		for (int i = 1; i <= n; i++) {
			housingLoanInfo = housingInfoList.get(i - 1);

			Double openBalance = housingLoanInfo.getOpeningBalance();
			Double principle = housingLoanInfo.getPrinciple();
			Double closeBalance = openBalance - principle;

			housingLoanInfo = new HousingLoanInfo();
			housingLoanInfo.setInterest(closeBalance * r);
			housingLoanInfo.setEmi(emi);
			housingLoanInfo.setOpeningBalance(closeBalance);
			housingLoanInfo.setClosingBalance(closeBalance);
			housingLoanInfo.setPrinciple(emi - (closeBalance * r));
			housingLoanInfo.setConstantEmi((double) Math.round(emi));
			housingInfoList.add(housingLoanInfo);
		}

		List<ChartInfo> chartInfoList = new ArrayList<ChartInfo>();
		List<HousingLoanInfo> yearlyInfoList = getYearlyInfoList(housingInfoList, chartInfoList);

		housingLoanResponse.setGridResponse(yearlyInfoList);
		housingLoanResponse.setChartInfo(chartInfoList);

		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(housingLoanResponse)
	            .build();

	}
	
	private static List<HousingLoanInfo> getYearlyInfoList(List<HousingLoanInfo> housingInfoList,
			List<ChartInfo> chartInfoList) {
		List<HousingLoanInfo> yearlyList = new ArrayList<HousingLoanInfo>(10);
		int counter = -1;
		Double cumulativeInterest = 0.0;
		Double cumulativePrinciple = 0.0;
		Double openingBalance = 0.0;
		Double emi = 0.0;
		HousingLoanInfo yearlyInfo = null;
		int yearCounter = 1;
		List<Integer> xCoordinateList = new ArrayList<Integer>();
		List<Double> yCoordinateList = new ArrayList<Double>();
		for (HousingLoanInfo housingLoanInfo : housingInfoList) {
			counter++;
			if (counter > 0 && counter % 12 == 0) {
				ChartInfo<Integer, Double> chartInfo = new ChartInfo<Integer, Double>();
				yearlyInfo = new HousingLoanInfo();
				yearlyInfo.setInterest((double) Math.round(cumulativeInterest));
				yearlyInfo.setPrinciple((double) Math.round(cumulativePrinciple));
				yearlyInfo.setOpeningBalance((double) Math.round(openingBalance));
				yearlyInfo.setClosingBalance((double) Math.round(housingLoanInfo.getClosingBalance()));
				yearlyInfo.setYear(yearCounter);
				yearlyInfo.setEmi((double) Math.round(emi * 12));
				yearlyInfo.setConstantEmi(housingLoanInfo.getConstantEmi());
				cumulativeInterest = housingLoanInfo.getInterest();
				cumulativePrinciple = housingLoanInfo.getPrinciple();

				chartInfo.setxCoordinate(yearCounter);
				chartInfo.setyCoordinate(cumulativeInterest);
				chartInfoList.add(chartInfo);

				counter = 0;
				int yearValue = yearCounter++;
				if (yearlyInfo.getInterest() < yearlyInfo.getPrinciple()) {
					yearlyInfo.setInterestDecreaseYear(yearValue--);
				}
				yearlyList.add(yearlyInfo);
			} else {
				openingBalance = housingLoanInfo.getOpeningBalance();
				emi = housingLoanInfo.getEmi();
				cumulativeInterest += housingLoanInfo.getInterest();
				cumulativePrinciple += housingLoanInfo.getPrinciple();
			}
		}
		return yearlyList;
	}

	@Path("getSqrt")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public static Response  getSqrt(RequestParam requestParam) {
		SqrtResponse sqrtResponse = new SqrtResponse();
		
		DecimalFormat df = new DecimalFormat("#.####");
		double value = Double.parseDouble(df.format(Math.pow(10, (Math.log10(requestParam.getInput()))/2)));
		sqrtResponse.setSqrtValue(value);
		
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(sqrtResponse)
	            .build();

	}
	
	public static void main(String str[]) {
		/*
		 * RequestParam reqParam = new RequestParam();
		 * reqParam.setPrinciple(100000.00); reqParam.setInterestRate(8.4);
		 * reqParam.setTenure(120.0);
		 * 
		 * List<HousingLoanInfo> list = getHousingLoanInfoList(reqParam);
		 * 
		 * int i = 1; for (HousingLoanInfo housingLoanInfo : list) {
		 * System.out.println(i + "Year" + "  Opening Balance :: " + "\t" +
		 * housingLoanInfo.getOpeningBalance() + "  Principle ::" + "\t" +
		 * housingLoanInfo.getPrinciple() + "  Interest ::" + "\t" +
		 * housingLoanInfo.getInterest() + " Closing Balance ::" + "\t" +
		 * housingLoanInfo.getClosingBalance()); i++; }
		 */}
}
