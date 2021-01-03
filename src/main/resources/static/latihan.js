var aplikasiLatihan=angular.module('aplikasiLatihan',[]);

aplikasiLatihan.controller('controllerBinding', function ($scope){
	$scope.daftarEmail=[
		'elisaseptianilubis1009@gmail.com',
		'elisa123@yahoo.com',
		'elisa1009@gmail.com'
	];

	$scope.tambahEmail= function(){
		$scope.daftarEmail.push($scope.email);
	};

	$scope.hapusEmail= function(x){
		var lokasiIndex=$scope.daftarEmail.indexOf(x);
		if (lokasiIndex > -1) {
			$scope.daftarEmail.splice(lokasiIndex, 1);
		}
	};
});






aplikasiLatihan.controller('EmployeeController', function ($http, $scope){
	$scope.dataEmployee = {};

	$scope.simpanMateri = function(){
		$http.post('/api/employee', $scope.employee).then(sukses,gagal);

		function sukses (response){
			$scope.updateDataEmployee();
		};

		function gagal (response){
			console.log(response);
			alert('Error :', +response);
		};
	};

	$scope.hapusEmployee = function(x){
		$http.delete('/api/employee/'+x.id).then(sukses,gagal);

		function sukses (response){
			$scope.updateDataEmployee();
		};

		function gagal (response){
			console.log(response);
			alert('Error :', +response);
		};
	};

	$scope.editEmployee = function(x){

	};

	$scope.updateDataEmployee = function(){
		$http.get('/api/employee').then(sukses,gagal);

		function sukses (response){
			$scope.dataEmployee =response.data;
			console.log($scope.dataEmployee);
		};

		function gagal (response){
			console.log(response);
			alert('Error :', +response);
		};
	};

	$scope.editEmployee = function(x){
		$http.delete('/api/employee/tampil/'+x.id).then(sukses,gagal);

		function sukses (response){
			$scope.updateDataEmployee();
		};

		function gagal (response){
			console.log(response);
			alert('Error :', +response);
		};
	};

	$scope.editEmployee = function(x){

	};

	$scope.updateDataEmployee ();

});









aplikasiLatihan.controller('CobaController', function ($scope){

	$scope.dataPosition = {};

	$scope.daftarPosition=[
		'Programmer',
		'Analys Sistem',
		'Tester',
		'PM'
	];

	$scope.items = [{
	  id: 1,
	  label: 'a',
	  subItem: { name: 'aSubItem' }
	}, {
	  id: 2,
	  label: 'b',
	  subItem: { name: 'bSubItem' }
	},
	{
		id:3,
		label:'c',
		subItem: {name: 'cSubItem' }
	}];

	$scope.simpanMateri = function(){
		$http.post('/api/employee', $scope.employee).then(sukses,gagal);

		function sukses (response){
			$scope.updateDataEmployee();
		};

		function gagal (response){
			console.log(response);
			alert('Error :', +response);
		};
	};

	

	
});