var myfirstApp=angular.module("MyFirstApp",['ngGrid','gridshore.c3js.chart']);



//Controller Configuration
myfirstApp.controller('myFirstAppController',['$scope','$http',function($scope,$http){


$scope.filterOptions = {
	filterText: ''
};




$scope.loanDetailList =[];


var selectedTaskIds = [];

$scope.selectedItems =[];

$scope.datapoints=[];
$scope.datacolumns=[];
$scope.datacolumns=[{"id":"yCoordinate","type":"bar"}];


$scope.getHousingLoan=function(requestParam) {
	$http({
    method: 'POST',
    url: "https://housingloancalcultor.herokuapp.com/services/housingloan/getHousingLoanInfo",
    data: requestParam,
    headers: {'Content-Type': 'application/json'}
}).success(function (data, status, headers, config) {
	$scope.constantEmi = data.gridResponse[0].constantEmi;
	$scope.loanDetailList = data.gridResponse;
	$scope.datapoints= data.chartInfo;
	var year;
	var keepGoing = true;
	angular.forEach(data.gridResponse, function(value, key) {
	  if(keepGoing){
		  if(value.interestDecreaseYear > 0) {
			  console.log('value '+value.interestDecreaseYear);
			  year = value.interestDecreaseYear;
			  keepGoing = false;
		  }
	  }
	});
	var infoValue = 'Most of the EMI payment goes towards interest till '+ year + ' years. This shifts towards principal after ' + year + ' years.';
	$scope.information = infoValue;
}).error(function (data, status, headers, config) {
    $scope.status = status;
});
};

$scope.gridOptions = {
	data: 'loanDetailList',
	filterOptions: $scope.filterOptions,
	selectedItems: [],
	showFilter: true,
	showSelectionCheckbox:true,
	columnDefs: [{
		field: 'year',
		displayName: 'Year'
	},{
		field: 'emi',
		displayName: 'EMI Paid By Year'
	},{
		field: 'openingBalance',
		displayName: 'Opening Balance'
	}, {
		field: 'interest',
		displayName: 'Interest Paid By Year'
	}, {
		field: 'principle',
		displayName: 'Principle Paid By Year'
	},{
		field: 'closingBalance',
		displayName: 'Closing Balance'
	}],
	enablePaging: true,
	showFooter: true,
	enablePinning: true
};



}]);