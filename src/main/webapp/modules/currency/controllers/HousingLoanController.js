var myfirstApp=angular.module("MyFirstApp",['ngGrid']);



//Controller Configuration
myfirstApp.controller('myFirstAppController',['$scope','$http',function($scope,$http){

	
$scope.filterOptions = {
	filterText: ''
};




$scope.loanDetailList =[];


var selectedTaskIds = [];

$scope.selectedItems =[];



$scope.getHousingLoan=function(requestParam) {
	$http({
    method: 'POST',
    url: "http://localhost:8080/MyAngularApp/services/housingloan/getHousingLoanInfo",
    data: requestParam,
    headers: {'Content-Type': 'application/json'}
}).success(function (data, status, headers, config) {
	$scope.constantEmi = data[0].constantEmi;
	$scope.loanDetailList = data;
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